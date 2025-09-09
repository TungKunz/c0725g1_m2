package ss2_loop_statement.bai_tap;

public class isPrime {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (checkIsPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static Boolean checkIsPrime(int n) {
        if (n < 2) return false;
        else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
