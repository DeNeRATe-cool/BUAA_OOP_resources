package Course;

import MyType.Pair;
import Person.Student;
import Person.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course implements Comparable<Course> {
    public static int courseTotalId = 0;

    public static List<Course> courseList = new ArrayList<>();
    private int id;
    private String name;
    private int weekday;
    private Pair time;
    private double score;
    private int classHour;
    private Teacher teacher;

    private List<Student> selectedStudents = new ArrayList<>();

    public Course() {}
    public Course(String name, int weekday, Pair time, double score, int classHour) {
        this.name = name;
        this.weekday = weekday;
        this.time = time;
        this.score = score;
        this.classHour = classHour;
    }

    public static int getCourseCount() {
        return courseList.size();
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public Pair getTime() { return time; }
    public int getWeekday() { return weekday; }
    public double getScore() { return score; }
    public int getClassHour() { return classHour; }
    public int getSelectedCount() { return selectedStudents.size(); }
    public void setId(int id) { this.id = id; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public String getTeacher() { return teacher.getName(); }

    public void modifySelected(Student student, boolean option) {
        if(option) selectedStudents.add(student);
        else selectedStudents.remove(student);
        Collections.sort(selectedStudents);
    }

    public static void insertCourse(Course course) {
        course.setId(++courseTotalId);
        courseList.add(course);
    }

    public static void removeCourse(String course) {
        for(Course c : courseList) {
            if(c.getId() == Integer.valueOf(course.substring(2))) {
                courseList.remove(c);
                break;
            }
        }
    }

    public boolean hasStudent(String id) {
        for(Student stu: selectedStudents) {
            if(stu.getId().equals(id))
                return true;
        }
        return false;
    }

    /**
     * loop up for the course according to the argument
     * @param course with format as "C-X"
     * */
    public static Course loopUpCourse(String course) {
        for(Course x: Course.courseList) {
            if(x.getId() == Integer.valueOf(course.substring(2))) {
                return x;
            }
        }
        return new Course();
    }

    /**
     * for the current course,
     * return the selected students info
     * */
    public String selectedStudentInfo() {
        StringBuilder sb = new StringBuilder();
        for(Student x: selectedStudents) {
            sb.append(x.getId() + ": " + x.getName() + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "C-" + this.id + " " + this.name + " " + this.weekday + "_" + this.time.first() + "-" + this.time.second() + " " + String.format("%.1f", this.score) + " " + this.classHour;
    }

    @Override
    public int compareTo(Course course) {
        return this.id - course.getId();
    }
}
