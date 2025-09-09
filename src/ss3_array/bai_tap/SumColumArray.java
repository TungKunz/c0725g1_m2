package ss3_array.bai_tap;

import java.util.Scanner;

public class SumColumArray {
    public static void main(String[] args) {
        int [][] arr={
                {1,3,4,2,5},
                {3,5,6,7,10},
                {6,7,4,3,5,1,2,3}
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cột bạn muốn tính tổng");
        int colum=Integer.parseInt(scanner.nextLine());
        int sum=0;
        for (int i = 0; i < arr.length ; i++) {
            sum += arr[i][colum];
        }
        System.out.println("Tổng các cột "+colum+ " là: " + sum);
    }
}
