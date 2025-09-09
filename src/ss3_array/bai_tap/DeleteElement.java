package ss3_array.bai_tap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {4, 12, 7, 8, 1, 6, 9};

        System.out.println("Nhập giá trị bạn muốn xóa: ");
        int element = Integer.parseInt(scanner.nextLine());

        int index = indexElement(arr, element);
        if (index != -1) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = 0;

            System.out.print("Mảng sau khi xóa: ");
            for (int x : arr) {
                System.out.print(x + " ");
            }
        } else {
            System.out.println("Trong mảng không có giá trị bạn muốn xóa");
        }
    }

    public static int indexElement(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) {
                return i;
            }
        }
        return -1;
    }
}
