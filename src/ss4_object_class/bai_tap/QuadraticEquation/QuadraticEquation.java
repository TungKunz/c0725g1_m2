package ss4_object_class.bai_tap.QuadraticEquation;

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

}
