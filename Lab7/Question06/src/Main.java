import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filename = "in.txt";
        String outputFileName = "out.txt";

        try {
            addLineNo(filename, outputFileName);
            System.out.println("success!");
        } catch (IOException e) {
            System.out.println("fail...");
        }
    }
    public static void addLineNo(String inputPath, String outputPath) throws IOException {
        // your implementation
        try(BufferedReader br = new BufferedReader(new FileReader(inputPath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            String line;
            int count = 1;
            while((line = br.readLine()) != null) {
                bw.write(count + ": " + line + "\n");
                count += 1;
            }
        }
    }
}