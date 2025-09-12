package menuManager;

public class ProductManagement {
    Product[] students=new Product[100];

    public Product[] getStudents() {
        return students;
    }
    public boolean checkId(int id){
        for (int i = 0; i < students.length; i++) {
            if (students[i]!= null && students[i].getId()==id){
                return  true;
            }
        }
        return false;
    }
    public void addStudent(Product newStudents) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = newStudents;
                break;
            }
        }
    }
    public boolean checkAge(byte age){
        return age<0 || age > 120;
    }


}
