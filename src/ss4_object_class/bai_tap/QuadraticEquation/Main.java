package ss4_object_class.bai_tap.QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        float a,b,c;
        System.out.println("Nhập a: ");
        a=Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập b: ");
        b=Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập c: ");
        c=Float.parseFloat(scanner.nextLine());

        QuadraticEquation quadraticEquation = new  QuadraticEquation(a,b,c);
        if(quadraticEquation.getDiscriminant() > 0 ){
            System.out.println("Nghiệm 1: " + quadraticEquation.getRoot1() + " Nghiệm 2: "+ quadraticEquation.getRoot2());
        }else if (quadraticEquation.getDiscriminant() == 0){
            System.out.println("Nghiệm kép "+ quadraticEquation.getRoot3());
        }else {
            System.out.println("Vô nghiệm");
        }

    }
}
