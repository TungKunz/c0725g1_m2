package ss3_array.bai_tap;

import java.util.Scanner;

public class SumDuongCheo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng dòng + cột: ");
        int spanCol= Integer.parseInt(scanner.nextLine());
        int [][]arr= new int[spanCol][spanCol];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Nhập: ");
                arr[i][j]=Integer.parseInt(scanner.nextLine());
            }

        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][arr.length - i -1];
        }
        System.out.println("Tổng đường chéo chính " + sum1);
        System.out.println("Tổng đường chéo chính 2: " +sum2);
    }
}
