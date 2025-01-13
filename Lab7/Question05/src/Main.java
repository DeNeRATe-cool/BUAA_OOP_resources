import java.io.*;

public class Main {
    public static void main(String[] args) {
        // you can call and test your method here
        String filename = "in.txt";
        String outputFileName = "out.txt";

        try {
            removeComments(filename, outputFileName);
            System.out.println("success!");
        } catch (IOException e) {
            System.out.println("fail...");
        }
    }

    public static void removeComments(String inputPath, String outputPath) throws IOException {
        // your implementation
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString().replaceAll("\\/\\/[^\\n]*", "")
                    .replaceAll("\\/\\*(\\s|.)*?\\*\\/", "");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
                bw.write(result);
            }
        }
    }
}