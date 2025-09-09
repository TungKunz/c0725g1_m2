package ss3_array.bai_tap;

import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập phần tử arr[" + i + "]: ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Nhập giá trị X cần chèn: ");
        int x = scanner.nextInt();

        System.out.print("Nhập vị trí index cần chèn X vào: ");
        int index = scanner.nextInt();

        if (index < 0 || index > arr.length) {
            System.out.println("Không chèn được phần tử vào mảng!");
        } else {

            int[] newArr = new int[arr.length + 1];
            for (int i = 0; i < index; i++) {
                newArr[i] = arr[i];
            }
            newArr[index] = x;

            for (int i = index; i < arr.length; i++) {
                newArr[i + 1] = arr[i];
            }
            System.out.print("Mảng sau khi chèn: ");
            for (int value : newArr) {
                System.out.print(value + " ");
            }
        }
    }
}
