package ss4_object_class.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    public float a, b, c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public float getA(){
        return this.a;
    }
    public float getB(){
        return this.b;
    }
    public float getC(){
        return this.c;
    }

    public  double getDiscriminant() {
        return this.getB() * this.getB() - 4 * this.getA() * this.getC();
    }
    public double getRoot1(){
        return  (-this.getB() + Math.sqrt(this.getDiscriminant()))/(2*this.getA());
    }
    public double getRoot2(){
        return  (-this.getB() - Math.sqrt(this.getDiscriminant()))/(2*this.getA());
    }
    public double getRoot3(){
        return (-this.getB())/(2*this.getA());
    }
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
