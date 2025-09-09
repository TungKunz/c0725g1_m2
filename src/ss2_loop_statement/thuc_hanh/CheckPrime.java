package ss2_loop_statement.thuc_hanh;
import java.util.Scanner;
public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số mà bạn muốn kiểm tra");
        int so = sc.nextInt();
        boolean check= true;
        if(so < 2 ){
            System.out.println(so+ " Không phải là số nguyên tố");
        }else {

            for (int i = 2; i <= Math.sqrt(so) ; i++) {
                if (so % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check){
                System.out.println(so+ " là số nguyên tố");
            }else {
                System.out.println(so+ " Không phải là số nguyên tố");
            }

        }
    }
}
