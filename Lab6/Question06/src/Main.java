import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("please input two integers:");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a / b;
        } catch (InputMismatchException e) {
            System.out.println("please input an integer");
        } catch (ArithmeticException e) {
            System.out.println("cannot divide by zero");
        } finally {
            System.out.println("done");
        }
    }
}