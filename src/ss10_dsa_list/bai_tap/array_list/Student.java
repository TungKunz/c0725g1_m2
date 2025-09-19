package ss10_dsa_list.bai_tap.array_list;

public class Student {
    private int id;
    private String name;

    public Student() {}

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString để in ra dễ nhìn
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}
