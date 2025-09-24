package ss15_exception.bai_tap.check_triangle;

import java.util.Scanner;

public class Triangle {
    private static final Scanner scanner = new Scanner(System.in);

    public static void checkTriangle() {
        int a , b , c ;

        try {
            System.out.println("Nhập cạnh a: ");
            a = Integer.parseInt(scanner.nextLine());

            System.out.println("Nhập cạnh b: ");
            b = Integer.parseInt(scanner.nextLine());

            System.out.println("Nhập cạnh c: ");
            c = Integer.parseInt(scanner.nextLine());

            if (checkABC(a, b, c)) {
                System.out.println("Tam giác hợp lệ với các cạnh: " + a + ", " + b + ", " + c);
            }

        } catch (NumberFormatException e) {
            System.out.println("Lỗi nhập dữ liệu: Vui lòng nhập số nguyên!");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi tam giác: " + e.getMessage());
        }
    }

    public static boolean checkABC(int a, int b, int c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Cạnh tam giác phải > 0");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại");
        }
        return true;
    }
}
