package ss3_array.bai_tap;

import java.util.Scanner;

public class ConcatArray {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập số lượng mảng 1: ");
        byte n= Byte.parseByte(scanner.nextLine());
        int [] arr1= new int[n];
        System.out.println("Nhập số lượng mảng 2: ");
        byte m= Byte.parseByte(scanner.nextLine());
        int [] arr2= new int[m];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập giá trị thứ n: ");
            arr1[i]=Byte.parseByte(scanner.nextLine());
        }
        for (int i = 0; i < m; i++) {
            System.out.println("Nhập giá trị thứ m: ");
            arr2[i]=Byte.parseByte(scanner.nextLine());
        }
        int [] arr3= new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i]=arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length+i]=arr2[i];
        }
        for (int value : arr3) {
            System.out.print(value + " ");
        }

    }
}
