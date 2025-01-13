public class Student {
    void study() {
        System.out.println("I am studying Java.");
    }
}

class Exam {
    public static void main(String[] args) {
        Student student = new Student();
        student.study();
    }
}