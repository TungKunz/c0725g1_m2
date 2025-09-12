package menuManager;

public class StudentManager {
    Student [] students=new Student[100];

    public Student[] getStudents() {
        return students;
    }
    public boolean checkId(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void addStudent(Student newStudents) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = newStudents;
                break;
            }
        }
    }

}
