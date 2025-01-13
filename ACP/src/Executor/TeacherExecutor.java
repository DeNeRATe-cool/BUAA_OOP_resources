package Executor;

import Course.Course;
import Database.Database;
import Person.Teacher;
import Tool.Checker;
import Tool.CommonMethod;
import Tool.FileIO;

import java.util.List;

public class TeacherExecutor {

    /**
     * input with file existed to the current teacher
     * */
    public static boolean inputCourseBatch(String[] args) {
        if(!Database.checkAnyOnline() ||
            Database.notTeacher(Database.currentUser) ||
            !FileIO.checkFileExist(args[1]) ||
            FileIO.checkIsDir(args[1])) return false;

        List<String> result = FileIO.File2Courses(args[1]);

        Teacher teacher = Database.teachers.get(Database.currentUser);
        for(String s: result) {
            String[] command = s.split("\\s+");
            if(command[0].hashCode() == 0) continue;

            if(!teacher.checkCourseCount()) break;
            if(teacher.checkCourseExistence(command[1], true) || Checker.checkTeacherTimeConflict(command)) continue;

            Course course = new Course(command[1], CommonMethod.getWeekday(command[2]), CommonMethod.courseTime2Pair(command[2]), Double.parseDouble(command[3]), Integer.parseInt(command[4]));
            Course.insertCourse(course);

            teacher.addCourse(course);

            System.out.println("Create course success (courseId: C-" + course.getId() + ")");
        }
        System.out.println("Input course batch success");
        return true;
    }

    /**
     * output course batch only with permission Teacher
     * */
    public static boolean outputCourseBatch(String[] args) {
        if(!Database.checkAnyOnline() ||
            Database.notTeacher(Database.currentUser)) return false;

        FileIO.Courses2File(args[1], Database.teachers.get(Database.currentUser).courseInfoWithoutName());

        System.out.println("Output course batch success");

        return true;
    }

    /**
     * only Teacher can create course
     * @param args command data
     * */
    public static boolean createCourse(String[] args) {
        if(!Database.checkAnyOnline() ||
            Database.notTeacher(Database.currentUser) ||
            !Database.teachers.get(Database.currentUser).checkCourseCount() ||
            !Checker.checkCourseName(args[1]) ||
            Database.teachers.get(Database.currentUser).checkCourseExistence(args[1], false) ||
            !Checker.checkCourseTime(args) ||
            Checker.checkTeacherTimeConflict(args) ||
            !Checker.checkCourseScore(args[3]) ||
            !Checker.checkCourseHour(args[4])) return false;

        Course course = new Course(args[1], CommonMethod.getWeekday(args[2]), CommonMethod.courseTime2Pair(args[2]), Double.parseDouble(args[3]), Integer.parseInt(args[4]));
        Course.insertCourse(course);

        Database.teachers.get(Database.currentUser).addCourse(course);

        System.out.println("Create course success (courseId: C-" + course.getId() + ")");

        return true;
    }
}
