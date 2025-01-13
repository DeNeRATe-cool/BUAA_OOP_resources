import java.util.Scanner;

public class NumberMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt(), number = 0;
        for(int i = 0; i < cnt; i++) {
            for(int j = 0; j < cnt; j++) {
                System.out.print(++number + " ");
            }
            System.out.println();
        }
    }
}
