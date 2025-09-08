package ss1_java.bai_tap;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tien muon doi (USD): ");
        int money = scanner.nextInt();
        int changeMoney = money * 23000;
        System.out.println("Tien da doi: " + changeMoney);
    }
}
