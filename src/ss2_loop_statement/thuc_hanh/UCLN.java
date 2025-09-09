package ss2_loop_statement.thuc_hanh;
import java.util.Scanner;

public class UCLN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số a: ");
        int a = sc.nextInt();
        System.out.println("Nhập số b: ");
        int b = sc.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }
        while (a != b) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        System.out.println("Greatest common factor: " + a);
    }
}
