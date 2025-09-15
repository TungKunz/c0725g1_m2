package ss6_inheritance.bai_tap.classpoint2D_classpoint3D;

public class Point3D extends  Point2D{
    private float z;
    Point3D() {
        super();
        this.z = 0.0f;
    }
    Point3D(float x, float y, float z){
        super(x, y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ() {
        return new float[]{getX(), getY(), z};
    }

    public void setXYZ(float x, float y, float z) {
        super.setX(x);
        super.setY(y);
        this.z=z;
    }
    @Override
    public String toString() {
        return "Point3D{x=" + getX() + ", y=" + getY() + ", z=" + z + "}";
    }

}
