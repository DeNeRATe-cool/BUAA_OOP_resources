import java.math.BigInteger;
import java.util.Scanner;

public class BigNumberAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取两个大数
        BigInteger a, b;
        a = scanner.nextBigInteger();
        b = scanner.nextBigInteger();

        // 计算它们的和
        BigInteger sum = a.add(b);

        // 输出结果
//        System.out.println(a);
        System.out.println(sum);
    }
}