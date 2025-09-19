package ss10_dsa_list.bai_tap.array_list;

public class TestMyList {
    public static void main(String[] args) {
        // Tạo danh sách sinh viên
        MyList<Student> studentList = new MyList<>();

        studentList.add(new Student(1, "Nguyen Van A"));
        studentList.add(new Student(2, "Tran Thi B"));
        studentList.add(new Student(3, "Le Van C"));

        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }

        studentList.add( new Student(4, "Pham Van D"),1);

        System.out.println("\nSau khi thêm vào index 1:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        studentList.remove(2);
        System.out.println("\nSau khi xóa index 2:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }
}
