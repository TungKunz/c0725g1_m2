package ss7_abstract_interface.bai_tap.colorable;

import ss7_abstract_interface.bai_tap.shape.Circle;
import ss7_abstract_interface.bai_tap.shape.Rectangle;
import ss7_abstract_interface.bai_tap.shape.Shape;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes= new Shape[2];
        shapes[0]=new Circle(5,"red",true);
        shapes[1]=new Rectangle(10.0,15.0,"blue",true);
        for (Shape shape : shapes) {
            System.out.println(shape.toString() + " -> area: " + shape.getArea());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
