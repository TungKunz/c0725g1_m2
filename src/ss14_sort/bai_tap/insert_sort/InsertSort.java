package ss14_sort.bai_tap.insert_sort;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            int pos = i - 1;
            while (pos >= 0 && x < array[pos]) {
                array[pos + 1] = array[pos];
                pos--;
            }
            array[pos + 1] = x;


            System.out.println("Bước " + i + ": " + Arrays.toString(array));
        }
    }

}
