package ss6_inheritance.bai_tap.classpoint_moveablePoint;

public class MoveablePoint extends Point{
    private float xSpeed=0.0f;
    private float ySpeed=0.0f;
    MoveablePoint(){
    }
    MoveablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x, y);
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    MoveablePoint(float xSpeed, float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed() {
        return new float[]{getXSpeed(), getYSpeed()};
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "), speed=(" + xSpeed + "," + ySpeed + ")";
    }
    public MoveablePoint move() {
        super.setX(getX() + xSpeed);
        super.setY(getY() + ySpeed);
        return this;
    }

}

