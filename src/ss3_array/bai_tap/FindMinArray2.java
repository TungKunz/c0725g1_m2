package ss3_array.bai_tap;

import java.util.Scanner;

public class FindMinArray2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập số dòng");
        byte n= Byte.parseByte(scanner.nextLine());
        System.out.println("nhập số lượng cột");
        byte m=Byte.parseByte(scanner.nextLine());
        int [][]arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j]=Integer.parseInt(scanner.nextLine());
            }
        }
        int min=arr[0][0];
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt < min) {
                    min = anInt;
                }
            }
        }
        System.out.println("Min: " + min);
    }
}
