import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = "MyNoteDir";
        String outputFileName = "YourNoteDir";

        try {
            copyDirectory(filename, outputFileName);
            System.out.println("success!");
        } catch (IOException e) {
            System.out.println("fail...");
        }
    }

    public static void copyDirectory(String sourceDir, String targetDir) throws IOException {
        // your implementation
        File sourceFolder = new File(sourceDir);
        File targetFolder = new File(targetDir);

        if(!targetFolder.exists()) {
            targetFolder.mkdirs();
        }

        File[] files = sourceFolder.listFiles();
        for(File file : files) {
            if(file.isDirectory()) {
                copyDirectory(file.getAbsolutePath(), targetFolder.getAbsolutePath() + File.separator + file.getName());
            } else {
                copyFile(file.getAbsolutePath(), targetFolder.getAbsolutePath() + File.separator + file.getName());
            }
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