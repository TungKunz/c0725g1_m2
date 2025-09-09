package ss3_array.bai_tap;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi kí tự:");
        String string = scanner.nextLine();
        System.out.println("Nhập kí tự muốn đếm:");
        String charWord = scanner.nextLine();
        char targetChar = charWord.charAt(0);
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == targetChar) {
                count++;
            }
        }

        System.out.println("Số lần xuất hiện của ký tự '" + targetChar + "' là: " + count);
    }
}
