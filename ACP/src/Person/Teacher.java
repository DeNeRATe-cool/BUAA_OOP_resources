package Person;

import Course.Course;
import Database.Database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Teacher extends Person {
    private List<Course> courses = new ArrayList<>();

    public Teacher() {}
    public Teacher(String id, String name, String password, String type) {
        super(id, name, password, type);
    }

    public void addCourse(Course course) {
        course.setTeacher(this);
        courses.add(course);
        Collections.sort(courses);
    }

    public void removeCourse(String course) {
        for(Course c : courses) {
            if(c.getId() == Integer.valueOf(course.substring(2))) {
                courses.remove(c);
                break;
            }
        }
        Collections.sort(courses);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getCourseCount() {
        return courses.size();
    }

    private List<String> getNameList() {
        List<String> result = new ArrayList<>();
        for(Course course : courses) {
            result.add(course.getName());
        }
        return result;
    }

    /**
     * check if reaches course limit
     * */
    public boolean checkCourseCount() {
        boolean judge = (courses.size() < 10);
        if(!judge) System.out.println("Course count reaches limit");
        return judge;
    }

    /**
     * check if course has existed already for the current teacher
     * print Course name exists if exists
     * @param course to be checked course name
     * */
    public boolean checkCourseExistence(String course, boolean extra) {
        boolean judge = (getNameList().contains(course));
        if(judge) {
            if(!extra) System.out.println("Course name exists");
            else System.out.println("Course name already exists");
        }
        return judge;
    }

    /**
     * translate course of the teacher to String
     * WITHOUT the teacher's name
     * */
    public String courseInfoWithoutName() {
        StringBuilder result = new StringBuilder();
        for(Course course : courses) {
            result.append(course.toString());
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * translate course of the teacher to String
     * WITH the teacher's name
     * */
    public String courseInfoWithName() {
        StringBuilder result = new StringBuilder();
        for(Course course : courses) {
            result.append(super.getName());
            result.append(" ");
            result.append(course.toString());
            result.append("\n");
        }
        return result.toString();
    }

}
