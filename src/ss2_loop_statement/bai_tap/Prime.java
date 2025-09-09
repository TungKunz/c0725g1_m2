package ss2_loop_statement.bai_tap;

import java.util.Scanner;
public class Prime {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập số lượng");
        int so = sc.nextInt();
        byte dem=0;
        byte i=2;
        while (dem!=so){
            if(checkPrime(i)){
                System.out.println(i);
                dem++;
            }
            i++;
        }

    }
    public static Boolean checkPrime(int d){
        if(d<2)  return false;
        else {
            for (int i = 2; i <= Math.sqrt(d); i++) {
                if (d%i==0){
                    return false;
                }
            }
            return true;
        }

    }
}
