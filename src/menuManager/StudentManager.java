package menuManager;

public class StudentManager {
    Student [] students=new Student[100];

    public Student[] getStudents() {
        return students;
    }
    public void addStudent(Student newStudents) {
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
