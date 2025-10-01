package ss13_search.bai_tap.binary_search;

import java.util.List;

public class Binary {

    public static void binarySearch(int[] array, int left, int right, int value) {
        if (left > right) {
            System.out.println("Không tìm thấy " + value);
            return;
        }

        int mid = (left + right) / 2;

        if (array[mid] == value) {
            System.out.println("Tìm thấy: " + array[mid] + " tại vị trí " + mid);
        } else if (value > array[mid]) {
            binarySearch(array, mid + 1, right, value);
        } else {
            binarySearch(array, left, mid - 1, value);
        }
    }

}
