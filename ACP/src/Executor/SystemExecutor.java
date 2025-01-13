package Executor;

import Tool.Checker;
import Database.Database;
import Person.*;
import Course.Course;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class SystemExecutor {

    /**
     * list the student schedule according to the permission
     * */
    public static boolean listCourseSchedule(String[] args) {
        if(!Database.checkAnyOnline()) return false;
        Student student;
        if(args.length == 1) {
            if(Database.notStudent(Database.currentUser)) return false;
            student = Database.students.get(Database.currentUser);
        } else {
            if(Database.notAdmin(Database.currentUser) ||
                !Checker.checkIdNumber(args[1]) ||
                Database.userNotExist(args[1]) ||
                !Checker.checkStudentIdNumber(args[1])) return false;
            student = Database.students.get(args[1]);
        }

        if(student.getCourses().isEmpty()) {
            System.out.println("Student does not select course");
            return false;
        }

        student.printSchedule();

        System.out.println("List course schedule success");
        return true;
    }

    /**
     * remove student from the courses according to the
     * current permission or the target course id
     * */
    public static boolean removeStudent(String[] args) {
        if(!Database.checkAnyOnline() ||
                Database.notTeacherOrAdmin(Database.currentUser) ||
                !Checker.checkIdNumber(args[1]) ||
                Database.userNotExist(args[1]) ||
                !Checker.checkStudentIdNumber(args[1])) return false;

        if(args.length == 2) {
            boolean judge = false;
            List<Course> courses = Database.isTeacher(Database.currentUser) ? Database.teachers.get(Database.currentUser).getCourses() : Course.courseList;
            for(Course course: courses) {
                if(course.hasStudent(args[1])) {
                    judge = true;
                    break;
                }
            }
            if(!judge) {
                System.out.println("Student does not select course");
                return false;
            }

            for(Course course: courses) {
                Database.removeStudentCourse(args[1], course);
            }

        } else {
            if(!Checker.checkCourseId(args[2]) ||
                    Database.userNoCourse(args[2]) ||
                    Database.studentNoTargetCourse(args[1], args[2])) return false;

            Database.removeStudentCourse(args[1], Course.loopUpCourse(args[2]));
        }
        System.out.println("Remove student success");
        return true;
    }

    /**
     * list the Student of a course
     * which can only be executed by Teacher and Admin
     * */
    public static boolean listStudent(String[] args) {
        if(!Database.checkAnyOnline() ||
            Database.notTeacherOrAdmin(Database.currentUser) ||
            !Checker.checkCourseId(args[1]) ||
            Database.userNoCourse(args[1]) ||
            Checker.checkNoSelectedStudent(args[1])) return false;

        String info = Course.loopUpCourse(args[1]).selectedStudentInfo();
        System.out.println(info + "List student success");

        return true;
    }

    /**
     * switch the current user
     * */
    public static boolean switchUser(String[] args) {
        if(!Checker.checkIdNumber(args[1]) ||
            Database.userNotExist(args[1]) ||
            Database.userNotOnline(args[1])) return false;

        Database.currentUser = args[1];
        System.out.println("Switch to " + args[1]);

        return true;
    }

    /**
     * only Teacher and Administrator can cancel course
     * and Student to cancel course list
     * @param args command data
     * */
    public static boolean cancelCourse(String[] args) {
        if(!Database.checkAnyOnline() ||
                !Checker.checkCourseId(args[1]) ||
                Database.userNoCourse(args[1])) return false;

        if(Database.isStudent(Database.currentUser)) {
            Database.students.get(Database.currentUser).removeCourse(args[1]);
        } else if(Database.isTeacher(Database.currentUser)) {
            Database.teachers.get(Database.currentUser).removeCourse(args[1]);
            Course.removeCourse(args[1]);
            for(Student s: Database.students.values())
                s.removeCourse(args[1]);
        } else {
            Course.removeCourse(args[1]);
            for(Teacher t: Database.teachers.values())
                t.removeCourse(args[1]);
            for(Student s: Database.students.values())
                s.removeCourse(args[1]);
        }

        System.out.println("Cancel course success (courseId: " + args[1] + ")");

        return true;
    }

    /**
     * print information according to the args
     * @param args command data
     * */
    public static boolean printInfo(String[] args) {
        if(!Database.checkAnyOnline()) return false;

        if(args.length != 1) {
            if(Database.notAdmin(Database.currentUser) ||
                    !Checker.checkIdNumber(args[1]) ||
                    Database.userNotExist(args[1])) return false;

            Database.printInfo(args[1]);
        } else
            Database.printInfo(Database.currentUser);

        return true;
    }

    /**
     * user logout
     * no extra data with admin try
     * else log out current user
     * @param args command data
     * */
    public static boolean userLogout(String[] args) {
        if(!Database.checkAnyOnline()) return false;

        if(args.length != 1) {
            if(Database.notAdmin(Database.currentUser) ||
                !Checker.checkIdNumber(args[1]) ||
                Database.userNotExist(args[1]) ||
                Database.userNotOnline(args[1])) return false;

            System.out.println(args[1] + " Bye~");
            Database.onlineList.remove(args[1]);
            if(Database.currentUser.equals(args[1]))
                Database.currentUser = "";
        } else {
            System.out.println(Database.currentUser + " Bye~");
            Database.onlineList.remove(Database.currentUser);
            Database.currentUser = "";
        }

        return true;
    }

    /**
     * user login
     * @param args command data
     * */
    public static boolean userLogin(String[] args) {
        if(!Checker.checkIdNumber(args[1]) ||
            Database.userNotExist(args[1]) ||
            Database.userIsOnline(args[1]) ||
            !Database.userPasswordMatch(args)) return false;

        Database.onlineList.add(args[1]);
        Database.currentUser = args[1];

        System.out.println("Welcome to ACP, " + args[1]);

        return true;
    }

    /**
     * user register
     * @param args command data
     * */
    public static boolean userRegister(String[] args) {
        if(!Checker.checkIdNumber(args[1]) ||
            Database.userExist(args[1]) ||
            !Checker.checkName(args) ||
            !Checker.checkPassword(args) ||
            !Checker.checkPasswordMatch(args) ||
            !Checker.checkIdentity(args)) return false;

        switch (args[5]) {
            case "Student":
                Student student = new Student(args[1], args[2], args[3], args[5]);
                Database.students.put(args[1], student);
                break;
            case "Teacher":
                Teacher teacher = new Teacher(args[1], args[2], args[3], args[5]);
                Database.teachers.put(args[1], teacher);
                break;
            case "Administrator":
                Admin admin = new Admin(args[1], args[2], args[3], args[5]);
                Database.admins.put(args[1], admin);
                break;
        }

        System.out.println("Register success");
        return true;
    }

    /**
     * list the course for looking up
     * different arguments with different permission
     * @param args command data
     * */
    public static boolean listCourse(String[] args) {
        if(!Database.checkAnyOnline()) return false;

        if(args.length == 1) {
            if(Database.systemNoCourse(Database.currentUser)) return false;

            if(Database.isTeacher(Database.currentUser)) {
                System.out.print(Database.teachers.get(Database.currentUser).courseInfoWithoutName());
            } else {
                for(Teacher teacher : Database.teachers.values()) {
                    System.out.print(teacher.courseInfoWithName());
                }
            }
        } else {
            if(Database.notAdmin(Database.currentUser) ||
                !Checker.checkIdNumber(args[1]) ||
                Database.userNotExist(args[1]) ||
                !Checker.checkTeacherIdNumber(args[1]) ||
                Database.systemNoCourse(args[1])) return false;
            System.out.print(Database.teachers.get(args[1]).courseInfoWithName());
        }

        System.out.println("List course success");
        return true;
    }

}
