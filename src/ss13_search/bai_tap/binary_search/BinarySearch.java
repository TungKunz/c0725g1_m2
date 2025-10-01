package ss13_search.bai_tap.binary_search;

public class BinarySearch {

    public static void binarySearchDeQuy(int[] array, int left, int right, int value) {
        if (left > right) {
            System.out.println("Không tìm thấy " + value);
            return;
        }

        int mid = (left + right) / 2;

        if (array[mid] == value) {
            System.out.println("Tìm thấy: " + array[mid] + " tại vị trí " + mid);
        } else if (value > array[mid]) {
            binarySearchDeQuy(array, mid + 1, right, value);
        } else {
            binarySearchDeQuy(array, left, mid - 1, value);
        }
    }

}
