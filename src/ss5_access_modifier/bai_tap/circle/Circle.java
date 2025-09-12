package ss5_access_modifier.bai_tap.circle;

public class Circle {
    private double radius;
    private String color;
    Circle(double radius){
        this.radius=radius;
        this.color="blue";
    }
    Circle(){
        this.radius=1.0;
        this.color="red";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea (){
        return Math.PI*getRadius()*getRadius();
    }
}
