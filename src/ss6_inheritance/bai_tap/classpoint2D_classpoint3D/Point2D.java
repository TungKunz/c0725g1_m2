package ss6_inheritance.bai_tap.classpoint2D_classpoint3D;

public class Point2D {
    private float x;
    private float y;
    Point2D(){}
    Point2D(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    public float[] getXY() {
        return new float[]{x, y};
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
