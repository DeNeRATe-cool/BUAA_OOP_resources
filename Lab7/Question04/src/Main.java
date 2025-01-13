import java.io.*;

public class Main {
    public static void main(String[] args) {
        // step1. add data into this array
        Student[] students = {
                new Student("2021001", "John Doe", 85.5),
                new Student("2021002", "Jane Smith", 90.0)
        };
        // step2. write this array into file
        String filename = "student.ser";
        try {
            Student.serializeIntoFile(students, filename);
            System.out.println("written to " + filename);
        } catch (IOException e) {
            System.out.println("failed to write to " + filename);
        }
        // step3. read students from file and print
        try {
            Student[] result = Student.deserializeFromFile(filename);
            System.out.println("read from " + filename);
            for(Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            System.out.println("failed to read from " + filename);
        } catch (ClassNotFoundException e) {
            System.out.println("failed to deserialize from " + filename);
        }
    }
}

class Student implements Serializable {
    private String studentId;
    private String name;
    private double score;
    // constructor(s) and other methods ...
    public Student(String studentId, String name, double score) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }
    public static void serializeIntoFile(Student[] students, String filename) throws IOException {
        // your implementation
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        }
    }
    public static Student[] deserializeFromFile(String filePath) throws IOException, ClassNotFoundException {
        // your implementation
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Student[]) ois.readObject();
        }
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