package ss15_exception.bai_tap.check_triangle;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int a , b , c ;
        Triangle triangle = null;
        try {
            System.out.println("Nhập cạnh a: ");
            a = Integer.parseInt(scanner.nextLine());

            System.out.println("Nhập cạnh b: ");
            b = Integer.parseInt(scanner.nextLine());

            System.out.println("Nhập cạnh c: ");
            c = Integer.parseInt(scanner.nextLine());

            if (a <= 0 || b <= 0 || c <= 0) {
                throw new IllegalTriangleException("Cạnh tam giác phải > 0");
            }
            if (a + b <= c || a + c <= b || b + c <= a) {
                throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại");
            }
            triangle=new Triangle(a,b,c);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi nhập dữ liệu: Vui lòng nhập số nguyên!");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi tam giác: " + e.getMessage());
        }
        if(triangle!=null){
            System.out.println(triangle);
        }
    }
}
