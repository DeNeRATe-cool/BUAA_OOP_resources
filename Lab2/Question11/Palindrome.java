import java.util.Scanner;

public class Palindrome {

    public static StringBuilder reverse(String number) {
        StringBuilder res = new StringBuilder(100);
        for(int i = number.length() - 1; i >= 0; i--) {
            res.append(number.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入: ");
        String number = in.nextLine();

        if(number.length() == 0) {
            System.out.println("输入长度小于1!");
            System.exit(0);
        }

        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) < '0' || number.charAt(i) > '9') {
                System.out.println("含有数字以外的字符!");
                System.exit(0);
            }
        }

        if(number.length() == 1 && number.charAt(0) == '0') {
            System.out.println("无前导零!");
            System.out.println("是回文数!");
        } else {
            StringBuilder res = reverse(number);
            if(number.charAt(0) == '0') {
                System.out.println("存在前导零!");
            } else {
                System.out.println("无前导零!");
                if (number.contentEquals(res)) {
                    System.out.println("是回文数!");
                } else {
                    System.out.println("不是回文数!");
                }
            }
        }
    }
}
