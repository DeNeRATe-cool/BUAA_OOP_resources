package Tool;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    private static String outPre = "./data/";

    static {
        File file = new File(outPre);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            for(File file : dir.listFiles()) {
                deleteDirectory(file);
            }
        }
        dir.delete();
    }

    public static void cleanDirectory() {
        File file = new File(outPre);
        deleteDirectory(file);
    }

    private static void makeFilePath(String filename) {
        File file = new File(filename);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> File2Courses(String filename) {
        filename = outPre + filename;
        makeFilePath(filename);
        List<String> courses = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename));) {
            String line;
            while((line = reader.readLine()) != null) {
                courses.add(line);
            }
        } catch(Exception err) {
            err.printStackTrace();
        }
        return courses;
    }

    public static void Courses2File(String filename, String courses) {
        filename = outPre + filename;
        makeFilePath(filename);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename));) {
            writer.write(courses);
        } catch(Exception err) {
            err.printStackTrace();
        }
    }

    /**
     * check if the file has not existed
     * print File does not exist otherwise
     * */
    public static boolean checkFileExist(String filename) {
        filename = outPre + filename;
        File file = new File(filename);
        boolean judge = (file.exists());
        if(!judge) System.out.println("File does not exist");
        return judge;
    }

    /**
     * check if the current path is pointing to a directory
     * print File is a directory if right
     * */
    public static boolean checkIsDir(String filename) {
        filename = outPre + filename;
        File file = new File(filename);
        boolean judge = (file.isDirectory());
        if(judge) System.out.println("File is a directory");
        return judge;
    }

    public static void main(String[] args) {
        Courses2File("a.txt", "C-1 OO 4_3-4 3.0 48\n" +
                "C-2 CO 5_3-4 4.5 72");
        Courses2File("a.txt", "3_3-4 CO 4.5 81 Tea_a\n" +
                "3_5-6 CO 4.5 81 Tea_b");

        List<String> result1 = File2Courses("a.txt");
        List<String> result2 = File2Courses("b.txt");
        System.out.println(result1);
        System.out.println(result2);
    }
}