package Person;

import Course.Course;
import MyType.Pair;

import java.util.*;

public class Student extends Person implements Comparable<Student> {
    public static Map<String, Integer> studentLevel = Map.ofEntries(
            Map.entry("BY", 3),
            Map.entry("SY", 2),
            Map.entry("ZY", 1)
    );
    private List<Course> courses = new ArrayList<>();

    public Student() {}
    public Student(String id, String name, String password, String type) {
        super(id, name, password, type);
    }

    public String getId() {
        return super.getId();
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.modifySelected(this, true);
        Collections.sort(courses);
    }

    public void removeCourse(String course) {
        for(Course c : courses) {
            if(c.getId() == Integer.valueOf(course.substring(2))) {
                courses.remove(c);
                c.modifySelected(this, false);
                Collections.sort(courses);
                break;
            }
        }
    }

    /**be removed forced*/
    public void beRemoved(Course course) {
        courses.remove(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    /**
     * print schedule through the sorted course
     * */
    public void printSchedule() {
        List<Course> result = new ArrayList<>(courses);
        Collections.sort(result, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                if(o1.getWeekday() != o2.getWeekday()) {
                    return o1.getWeekday() - o2.getWeekday();
                } else {
                    return o1.getTime().first() - o2.getTime().first();
                }
            }
        });
        StringBuilder answer = new StringBuilder();
        for(Course c : result) {
            answer.append(c.getWeekday() + "_" + c.getTime().first() + "-" + c.getTime().second() + " " + c.getName() + " " + String.format("%.1f", c.getScore()) + " " + c.getClassHour() + " " + c.getTeacher() + "\n");
        }
        System.out.print(answer.toString());
    }

    @Override
    public int compareTo(Student student) {
        String a = this.getId(), b = student.getId();
        int aLevel = Student.studentLevel.getOrDefault(a.substring(0, 2), 0);
        int bLevel = Student.studentLevel.getOrDefault(b.substring(0, 2), 0);
        if(aLevel != bLevel) return aLevel - bLevel;
        else return a.compareTo(b);
    }
}
