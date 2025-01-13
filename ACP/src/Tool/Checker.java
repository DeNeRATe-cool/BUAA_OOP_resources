package Tool;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import Database.Database;
import MyType.Pair;
import Course.Course;

public class Checker {

    private static List<String> legalCommand = Arrays.asList("quit", "register", "login", "logout", "printInfo", "createCourse", "listCourse", "selectCourse", "cancelCourse", "switch", "inputCourseBatch", "outputCourseBatch", "listStudent", "removeStudent", "listCourseSchedule");
    private static List<String> legalIdentity = Arrays.asList("Student", "Teacher", "Administrator");
    private static Map<String, Pair> legalDataNumber = Map.ofEntries(
            Map.entry("quit", new Pair(0, 0)),
            Map.entry("register", new Pair(5, 5)),
            Map.entry("login", new Pair(2, 2)),
            Map.entry("logout", new Pair(0, 1)),
            Map.entry("printInfo", new Pair(0, 1)),
            Map.entry("createCourse", new Pair(4, 4)),
            Map.entry("listCourse", new Pair(0, 1)),
            Map.entry("selectCourse", new Pair(1, 1)),
            Map.entry("cancelCourse", new Pair(1, 1)),
            Map.entry("switch", new Pair(1, 1)),
            Map.entry("inputCourseBatch", new Pair(1, 1)),
            Map.entry("outputCourseBatch", new Pair(1, 1)),
            Map.entry("listStudent", new Pair(1, 1)),
            Map.entry("removeStudent", new Pair(1, 2)),
            Map.entry("listCourseSchedule", new Pair(0, 1))
    );
    private static Map<String, Pattern> idPattern = Map.ofEntries(
            Map.entry("Student", Pattern.compile("^((19|20|21|22|23|24)(0[1-9]|[1-3][0-9]|4[0-3])[1-6](?!000)[0-9]{3}|(SY|ZY)(21|22|23|24)(0[1-9]|[1-3][0-9]|4[0-3])[1-6](?!00)[0-9]{2}|BY(19|20|21|22|23|24)(0[1-9]|[1-3][0-9]|4[0-3])[1-6](?!00)[0-9]{2})$")),
            Map.entry("Teacher", Pattern.compile("^(?!00000)[0-9]{5}$")),
            Map.entry("Administrator", Pattern.compile("^(AD)(?!000)[0-9]{3}$"))
    );
    private static Pattern namePattern = Pattern.compile("^[A-Za-z][A-Za-z_]{3,15}$");
    private static Pattern passwordPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@_%$])[a-zA-Z0-9@_%$]{6,16}$");

    private static Pattern courseNamePattern = Pattern.compile("^(?=.*[a-zA-Z])[a-zA-Z][a-zA-Z0-9_-]{0,19}$");
    private static Pattern coursePeriodPattern = Pattern.compile("^[1-7]_(1[0-4]|[1-9])-(1[0-4]|[1-9])$");
    private static Pattern courseIdPattern = Pattern.compile("^C-\\d+$");
    private static Pattern courseScorePattern = Pattern.compile("^\\d+(\\.\\d+)?$");
    private static Pattern courseHourPattern = Pattern.compile("^\\d+");

    /**
     * whether the new command is legal
     * print Not Found if illegal
     * @param args command data
     * */
    public static boolean checkNotFoundCommand(String[] args) {
        boolean judge = legalCommand.contains(args[0]);
        if(!judge) System.out.println("Command \'" + args[0] + "\' not found");
        return judge;
    }

    /**
     * whether the argument count is legal
     * print Illegal argument count if illegal
     * @param args command data
     * */
    public static boolean checkCommandDataNumber(String[] args) {
        boolean judge = (legalDataNumber.get(args[0]).first() <= args.length - 1 && legalDataNumber.get(args[0]).second() >= args.length - 1);
        if(!judge) System.out.println("Illegal argument count");
        return judge;
    }

    /**
     * Whether nobody select the course
     * print Student does not select course if true
     * */
    public static boolean checkNoSelectedStudent(String arg) {
        Course course = Course.loopUpCourse(arg);
        boolean judge = (course.getSelectedCount() == 0);
        if(judge) System.out.println("Student does not select course");
        return judge;
    }

    /**
     * whether the id matches the teacher pattern
     * print User id does not belong to a Teacher
     * @param arg command data
     * */
    public static boolean checkStudentIdNumber(String arg) {
        boolean judge = idPattern.get("Student").matcher(arg).matches();
        if(!judge) System.out.println("User id does not belong to a Student");
        return judge;
    }

    /**
     * whether the id matches the pattern
     * print Illegal user id if illegal
     * @param arg command data
     * */
    public static boolean checkIdNumber(String arg) {
        boolean judge = (idPattern.get("Student").matcher(arg).matches() || idPattern.get("Teacher").matcher(arg).matches() || idPattern.get("Administrator").matcher(arg).matches());
        if(!judge) System.out.println("Illegal user id");
        return judge;
    }

    /**
     * whether the id matches the teacher pattern
     * print User id does not belong to a Teacher
     * @param arg command data
     * */
    public static boolean checkTeacherIdNumber(String arg) {
        boolean judge = idPattern.get("Teacher").matcher(arg).matches();
        if(!judge) System.out.println("User id does not belong to a Teacher");
        return judge;
    }

    /**
     * whether the name legal
     * print Illegal username if illegal
     * @param args command data
     * */
    public static boolean checkName(String[] args) {
        boolean judge = namePattern.matcher(args[2]).matches();
        if(!judge) System.out.println("Illegal user name");
        return judge;
    }

    /**
     * whether the password legal
     * print Illegal password otherwise
     * @param args command data
     * */
    public static boolean checkPassword(String[] args) {
        boolean judge = passwordPattern.matcher(args[3]).matches();
        if(!judge) System.out.println("Illegal password");
        return judge;
    }

    /**
     * check similarity of the password
     * print Passwords do not match otherwise
     * @param args command data
     * */
    public static boolean checkPasswordMatch(String[] args) {
        boolean judge = args[3].equals(args[4]);
        if(!judge) System.out.println("Passwords do not match");
        return judge;
    }

    /**
     * check identity
     * print Illegal identity is illegal
     * @param args command data
     * */
    public static boolean checkIdentity(String[] args) {
        boolean judge = legalIdentity.contains(args[5]);
        if(!judge) System.out.println("Illegal identity");
        return judge;
    }

    /**
     * check legality of course name
     * print Illegal course name otherwise
     * @param course to be checked course
     * */
    public static boolean checkCourseName(String course) {
        boolean judge = courseNamePattern.matcher(course).matches();
        if(!judge) System.out.println("Illegal course name");
        return judge;
    }

    /**
     * check course total id
     * print Illegal course id if the id greater than TotalCount
     * @param course to be checked id
     * */
    public static boolean checkCourseId(String course) {
        boolean judge = (courseIdPattern.matcher(course).matches() && Integer.valueOf(course.substring(2)) > 0);
        if(!judge) System.out.println("Illegal course id");
        return judge;
    }

    /**
     * check if the selected course has been cancelled
     * print Course does not exist if none
     * @param course to be checked id
     * */
    public static boolean checkAllCourseCancelled(String course) {
        boolean judge = true;
        for(Course x: Course.courseList) {
            if(x.getId() == Integer.valueOf(course.substring(2))) {
                judge = false;
                break;
            }
        }
        if(judge) System.out.println("Course does not exist");
        return judge;
    }

    /**
     * check legality of the course period
     * print Illegal course time otherwise
     * @param args command data
     * */
    public static boolean checkCourseTime(String[] args) {
        boolean judge = coursePeriodPattern.matcher(args[2]).matches();
        if(!judge) System.out.println("Illegal course time");
        else {
            int l = CommonMethod.courseTime2Pair(args[2]).first();
            int r = CommonMethod.courseTime2Pair(args[2]).second();
            if(l > r) { judge = false; System.out.println("Illegal course time"); }
        }
        return judge;
    }

    /**
     * only for the current user is a TEACHER
     * check whether conflict about the period by Teacher
     * print Course time conflicts otherwise
     * @param args command data
     * */
    public static boolean checkTeacherTimeConflict(String[] args) {
        int weekdayNow = CommonMethod.getWeekday(args[2]);
        Pair periodNow = CommonMethod.courseTime2Pair(args[2]);

        for(Course course: Database.teachers.get(Database.currentUser).getCourses()) {
            if(CommonMethod.periodConflict(weekdayNow, periodNow, course.getWeekday(), course.getTime())) {
                System.out.println("Course time conflicts");
                return true;
            }
        }
        return false;
    }

    /**
     * only for the current user is a STUDENT
     * check whether conflict about the period by Student
     * print Course time conflicts otherwise
     * @param args command data
     * */
    public static boolean checkStudentTimeConflict(String[] args) {
        Course course = Course.loopUpCourse(args[1]);
        int weekdayNow = course.getWeekday();
        Pair periodNow = course.getTime();

        for(Course x: Database.students.get(Database.currentUser).getCourses()) {
            if(CommonMethod.periodConflict(weekdayNow, periodNow, x.getWeekday(), x.getTime())) {
                System.out.println("Course time conflicts");
                return true;
            }
        }
        return false;
    }

    /**
     * check if the selected course has enough space
     * print Course capacity is full otherwise
     * */
    public static boolean checkCourseAvailable(String arg) {
        Course course = Course.loopUpCourse(arg);
        boolean judge = (course.getSelectedCount() < 30);
        if(!judge) System.out.println("Course capacity is full");
        return judge;
    }


    /**
     * check the score legality
     * print Illegal course credit if illegal
     * @param arg the given score
     * */
    public static boolean checkCourseScore(String arg) {
        if(!courseScorePattern.matcher(arg).matches()) {
            System.out.println("Illegal course credit");
            return false;
        }
        double currentScore = Double.parseDouble(arg);
        boolean judge = (currentScore > 0 && currentScore <= 12);
        if(!judge) System.out.println("Illegal course credit");
        return judge;
    }

    /**
     * check the class hour
     * print Illegal course period otherwise
     * @param arg given course hour
     * */
    public static boolean checkCourseHour(String arg) {
        if(!courseHourPattern.matcher(arg).matches()) {
            System.out.println("Illegal course period");
            return false;
        }
        int currentHour = Integer.parseInt(arg);
        boolean judge = (currentHour > 0 && currentHour <= 1280);
        if(!judge) System.out.println("Illegal course period");
        return judge;
    }

}
