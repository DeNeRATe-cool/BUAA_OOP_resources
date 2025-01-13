import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        char t = '\041';
        System.out.println(t);
        File f = new File("hello.txt");
        byte[] a = "我是中国人".getBytes();
        try {
            FileOutputStream out = new FileOutputStream(f);
            out.write(a);
            out.close();
            FileInputStream in = new FileInputStream(f);
            byte[] tom = new byte[2];
            // Part 1
            int m = in.read(tom, 0, 2);
            System.out.println(m);
            String s = new String(tom, 0, 2);
            System.out.println(s);
            // Part 2
            m = in.read(tom, 0, 2);
            System.out.println(m);
            s = new String(tom, 0, 2);
            System.out.println(s);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}