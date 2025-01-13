package Database;

import Course.Course;
import Person.Admin;
import Person.Teacher;
import Person.Student;

import java.util.*;

public class Database {
    public static List<String> onlineList = new ArrayList<>();
    public static String currentUser = "";

    public static Map<String, Student> students = new HashMap<>();
    public static Map<String, Teacher> teachers = new TreeMap<>();
    public static Map<String, Admin> admins = new HashMap<>();

    public static boolean isStudent(String id) {
        return students.containsKey(id);
    }

    public static boolean isTeacher(String id) {
        return teachers.containsKey(id);
    }

    public static boolean isAdmin(String id) {
        return admins.containsKey(id);
    }

    public static void printInfo(String user) {
        if(students.containsKey(user)) System.out.println(students.get(user));
        else if(teachers.containsKey(user)) System.out.println(teachers.get(user));
        else if(admins.containsKey(user)) System.out.println(admins.get(user));
    }

    /**
     * check is the user has administrator permission
     * @param user to be checked id
     * */
    public static boolean notAdmin(String user) {
        boolean judge = (!Database.isAdmin(user));
        if(judge) System.out.println("Permission denied");
        return judge;
    }

    /**
     * check is the user has teacher permission
     * @param user to be checked id
     * */
    public static boolean notTeacher(String user) {
        boolean judge = (!Database.isTeacher(user));
        if(judge) System.out.println("Permission denied");
        return judge;
    }

    /**
     * check is the user has student permission
     * @param user to be checked id
     * */
    public static boolean notStudent(String user) {
        boolean judge = (!Database.isStudent(user));
        if(judge) System.out.println("Permission denied");
        return judge;
    }

    /**
     * check is the user has teacher permission or admin permission
     * @param user to be checked id
     * */
    public static boolean notTeacherOrAdmin(String user) {
        boolean judge = (!Database.isTeacher(user) && !Database.isAdmin(user));
        if(judge) System.out.println("Permission denied");
        return judge;
    }

    /**
     * check if anyone is online currently
     * */
    public static boolean checkAnyOnline() {
        boolean judge = !Database.currentUser.equals("");
        //        boolean judge = (Database.onlineList.size() != 0);
        if(!judge) System.out.println("No one is online");
        return judge;
    }

    /**
     * quit and print online user information
     * */
    public static void systemQuit() {
        for(String user: onlineList) {
            System.out.println(user + " Bye~");
        }
        onlineList.clear();
        currentUser = "";
        System.out.println("----- Good Bye! -----");
    }

    /**
     * check if user has existed
     * print User id exists
     * @param user to be checked username
     * */
    public static boolean userExist(String user) {
        boolean judge = (students.containsKey(user) || teachers.containsKey(user) || admins.containsKey(user));
        if(judge) System.out.println("User id exists");
        return judge;
    }

    /**
     * check if user has not existed
     * @param user to be checked username
     * */
    public static boolean userNotExist(String user) {
        boolean judge = !(students.containsKey(user) || teachers.containsKey(user) || admins.containsKey(user));
        if(judge) System.out.println("User does not exist");
        return judge;
    }

    /**
     * check if the user is online already
     * @param user to be checked username
     * */
    public static boolean userIsOnline(String user) {
        boolean judge = onlineList.contains(user);
        if(judge) System.out.println(user + " is online");
        return judge;
    }

    /**
     * check if the user is not online already
     * @param user to be checked username
     * */
    public static boolean userNotOnline(String user) {
        boolean judge = !onlineList.contains(user);
        if(judge) System.out.println(user + " is not online");
        return judge;
    }

    /**
     * check if the input password matched
     * @param args command data
     * */
    public static boolean userPasswordMatch(String[] args) {
        boolean judge;
        if(students.containsKey(args[1])) {
            judge = students.get(args[1]).getPassword().equals(args[2]);
        } else if(teachers.containsKey(args[1])) {
            judge = teachers.get(args[1]).getPassword().equals(args[2]);
        } else {
            judge = admins.get(args[1]).getPassword().equals(args[2]);
        }

        if(!judge) System.out.println("Wrong password");
        return judge;
    }

    /**
     * check if courses count more than zero differed by the user's permission
     * print Course does not exist otherwise
     * @param user the to be checked user
     * */
    public static boolean systemNoCourse(String user) {
        boolean judge = (isTeacher(user) ? (teachers.get(user).getCourseCount() == 0) : (Course.getCourseCount() == 0));
        if(judge) System.out.println("Course does not exist");
        return judge;
    }

    /**
     * check course not exist for the current user
     * print Course does not exist otherwise
     * @param course checked course
     * */
    public static boolean userNoCourse(String course) {
        boolean judge = true;
        List<Course> checkList = new ArrayList<>();
        if(isAdmin(Database.currentUser)) checkList = Course.courseList;
        else if(isTeacher(Database.currentUser)) checkList = Database.teachers.get(Database.currentUser).getCourses();
        else checkList = Database.students.get(Database.currentUser).getCourses();
        for(Course x: checkList) {
            if(x.getId() == Integer.valueOf(course.substring(2))) {
                judge = false;
                break;
            }
        }
        if(judge) System.out.println("Course does not exist");
        return judge;
    }

    /**
     * check if the student has not the target course
     * print Student does not select course otherwise
     * */
    public static boolean studentNoTargetCourse(String stu, String courseId) {
        Student student = Database.students.get(stu);
        courseId = courseId.substring(2);
        for(Course x: student.getCourses()) {
            if(x.getId() == Integer.valueOf(courseId)) {
                return false;
            }
        }
        System.out.println("Student does not select course");
        return true;
    }

    /**
     * remove student from the course
     * */
    public static void removeStudentCourse(String stu, Course course) {
        Student student = Database.students.get(stu);
        course.modifySelected(student, false);
        student.beRemoved(course);
    }

}
