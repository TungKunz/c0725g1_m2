package bai_4_Zoo.entity;

public abstract class Animal {
    String id;
    String name;
    int birthYear;
    String cage;

    public Animal() {
    }

    public Animal(String id, String name, int birthYear, String cage) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.cage = cage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", cage='" + cage + '\'' +
                '}';
    }
    public abstract String getInforToCSV();
}
