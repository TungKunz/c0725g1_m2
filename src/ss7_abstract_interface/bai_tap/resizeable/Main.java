package ss7_abstract_interface.bai_tap.resizeable;

import ss7_abstract_interface.bai_tap.shape.Circle;
import ss7_abstract_interface.bai_tap.shape.Rectangle;

class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Rectangle rectangle = new Rectangle(5, 10);

        System.out.println("Before resize:");
        System.out.println(circle);
        System.out.println(rectangle);

        circle.resize(20);
        rectangle.resize(20);

        System.out.println("\nAfter resize (20%):");
        System.out.println(circle);
        System.out.println(rectangle);
    }
}
