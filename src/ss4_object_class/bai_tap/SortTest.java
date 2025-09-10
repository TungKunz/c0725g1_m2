package ss4_object_class.bai_tap;

import java.util.Random;

public class SortTest {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int[] copyArray(int[] arr) {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] data = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) data[i] = rand.nextInt(1000000);

        int[] arr1 = copyArray(data);
        StopWatch sw1 = new StopWatch();
        sw1.start();
        selectionSort(arr1);
        sw1.stop();
        System.out.println("Selection Sort: " + sw1.getElapsedTime() + " ms");

        int[] arr2 = copyArray(data);
        StopWatch sw2 = new StopWatch();
        sw2.start();
        insertionSort(arr2);
        sw2.stop();
        System.out.println("Insertion Sort: " + sw2.getElapsedTime() + " ms");

        int[] arr3 = copyArray(data);
        StopWatch sw3 = new StopWatch();
        sw3.start();
        bubbleSort(arr3);
        sw3.stop();
        System.out.println("Bubble Sort: " + sw3.getElapsedTime() + " ms");
    }
}
