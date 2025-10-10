package bai_4_Zoo.entity;

public class Bird extends Animal {
    double wingspan;
    boolean canTalk;

    public Bird() {
    }

    public Bird(String id, String name, int birthYear, String cage, double wingspan, boolean canTalk) {
        super(id, name, birthYear, cage);
        this.wingspan = wingspan;
        this.canTalk = canTalk;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public boolean isCanTalk() {
        return canTalk;
    }

    public void setCanTalk(boolean canTalk) {
        this.canTalk = canTalk;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", birthYear=" + super.getBirthYear() +
                ", cage='" + super.getCage() + '\'' +
                "wingspan=" + this.getWingspan()  + '\'' +
                ", canTalk=" + this.isCanTalk()  + '\'' +
                '}';
    }

    @Override
    public String getInforToCSV() {
        return "bird"+","+
                this.getId() + "," +
                this.getName() + "," +
                this.getBirthYear() +","+
                this.getCage() + "," +
                this.getWingspan()+ ","+
                this.isCanTalk()
                ;
    }
}
