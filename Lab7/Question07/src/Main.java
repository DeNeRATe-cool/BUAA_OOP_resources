import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        String filename = "in.txt";
        String outputFileName = "out.txt";

        try {
            copyFile(filename, outputFileName);
            System.out.println("success!");
        } catch (IOException e) {
            System.out.println("fail...");
        }
    }

    public static void copyFile (String sourceFile, String targetFile) throws IOException {
        // your implementation
        try(FileInputStream in = new FileInputStream(sourceFile);
            FileOutputStream out = new FileOutputStream(targetFile)) {
            byte[] buffer = new byte[1024];
            int x;
            while((x = in.read(buffer)) != -1) {
                out.write(buffer, 0, x);
            }
        }
    }
}