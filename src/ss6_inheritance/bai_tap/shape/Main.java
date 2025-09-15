package ss6_inheritance.bai_tap.shape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập cạnh 1: ");
        double side1 = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập cạnh 2: ");
        double side2 = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập cạnh 3: ");
        double side3 = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập màu: ");
        String color = sc.nextLine();
        System.out.print("Hình có được tô màu không? (true/false): ");
        boolean filled = sc.nextBoolean();
        Triangle triangle = new Triangle(side1, side2, side3, color, filled);
        System.out.println(triangle);
    }

}
