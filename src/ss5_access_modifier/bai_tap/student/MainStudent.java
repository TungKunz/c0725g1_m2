package ss5_access_modifier.bai_tap.student;

public class MainStudent {
    public static void main(String[] args) {
        Student student= new Student();
        System.out.println(student.toString());
        student.setName("Tung");
        student.setClasses("C07");
        System.out.println(student.toString());
    }
}
