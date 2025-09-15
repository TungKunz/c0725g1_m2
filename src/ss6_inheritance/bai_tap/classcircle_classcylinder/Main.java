package ss6_inheritance.bai_tap.classcircle_classcylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1,"red");
        Cylinder cylinder = new Cylinder(1,"red",2);
        System.out.println(circle.area());
        System.out.println(circle.toString());
        System.out.println(cylinder.lateralArea());
        System.out.println(cylinder.toString());
        System.out.println(cylinder.totalArea());
    }
}
