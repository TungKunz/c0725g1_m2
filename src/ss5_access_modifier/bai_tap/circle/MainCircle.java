package ss5_access_modifier.bai_tap.circle;

public class MainCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2);
        Circle circle2 = new Circle();
        System.out.println(circle1.getColor() + " " + circle1.getArea());
        System.out.println(circle2.getColor() + " " + circle2.getArea());

    }
}
