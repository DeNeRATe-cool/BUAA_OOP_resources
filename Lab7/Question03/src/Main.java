import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // step1. add data into this array
        Student[] students = {
                new Student("2021001", "John Doe", 85.5),
                new Student("2021002", "Jane Smith", 90.0)
        };
        // step2. write this array into file
        String filename = "student.txt";
        try {
            Student.writeIntoFile(students, filename);
            System.out.println("written to " + filename);
        } catch (IOException e) {
            System.out.println("failed to write to " + filename);
        }
        // step3. read students from file and print
        try {
            Student[] result = Student.readFromFile(filename);
            System.out.println("read from " + filename);
            for(Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            System.out.println("failed to read from " + filename);
        }
    }
}

class Student {
    private String studentId;
    private String name;
    private double score;
    // constructor(s) and other methods ...
    public Student(String studentId, String name, double score) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }
    public static void writeIntoFile(Student[] students, String filename) throws IOException {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            for(Student student : students) {
                out.write(student.studentId + ", " + student.name + ", " + student.score);
                out.newLine();
            }
        }
    }
    public static Student[] readFromFile(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = in.readLine()) != null) {
                String[] part = line.split(",");
                if(part.length != 3) continue;
                students.add(new Student(part[0].trim(), part[1].trim(), Double.parseDouble(part[2])));
            }
        }
        return students.toArray(new Student[0]);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}