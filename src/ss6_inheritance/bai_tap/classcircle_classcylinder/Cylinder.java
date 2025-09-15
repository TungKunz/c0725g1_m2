package ss6_inheritance.bai_tap.classcircle_classcylinder;

public class Cylinder extends Circle{
    private double height;
    Cylinder(){}
    Cylinder(double radius, String color, double height){
        super(radius, color);
        this.height=height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double lateralArea(){
        return 2*this.getRadius() * this.getHeight() * Math.PI;
    }
    public double totalArea(){
        return 2*this.getRadius() * this.getHeight() * Math.PI + super.area();
    }
    @Override
    public String toString() {
        return "Cylinder{" + super.toString() +
                "height=" + height +
                '}';
    }
}
