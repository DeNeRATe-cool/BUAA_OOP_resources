package Executor;

import Database.Database;
import Tool.Checker;
import Course.Course;

public class StudentExecutor {

    /**
     * only Student can choose course
     * @param args command data
     * */
    public static boolean selectCourse(String[] args) {
        if(!Database.checkAnyOnline() ||
            Database.notStudent(Database.currentUser) ||
            !Checker.checkCourseId(args[1]) ||
            Checker.checkAllCourseCancelled(args[1]) ||
            Checker.checkStudentTimeConflict(args) ||
            !Checker.checkCourseAvailable(args[1])) return false;

        System.out.println("Select course success (courseId: " + args[1] + ")");

        Course course = Course.loopUpCourse(args[1]);
        Database.students.get(Database.currentUser).addCourse(course);

        return true;
    }
}
