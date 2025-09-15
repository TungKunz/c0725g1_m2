package ss6_inheritance.bai_tap.classpoint_moveablePoint;

import ss6_inheritance.bai_tap.classpoint2D_classpoint3D.Point3D;

public class Point {
    private float x=0.0f;
    private float y=0.0f;
    Point(){}
    Point(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
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
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
