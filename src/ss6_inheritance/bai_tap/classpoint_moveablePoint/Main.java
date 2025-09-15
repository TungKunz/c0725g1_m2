package ss6_inheritance.bai_tap.classpoint_moveablePoint;

public class Main {
    public static void main(String[] args) {
        MoveablePoint p = new MoveablePoint(2, 3, 1, 1);
        System.out.println(p);
        System.out.println(p.move());
        System.out.println(p.move());
    }
}
