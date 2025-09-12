package menuManager.menuManager.menuManager;

import java.util.Scanner;

public class Menu {
    static StudentManager studentManager= new StudentManager();
    static Student[] student = studentManager.getStudents();
    static int count=1;
    public static void main(String[] args) {
        display();

    }
    public static void display(){
        boolean flag=true;
        Scanner scanner = new Scanner(System.in);

        while (flag){
            System.out.println("-----Quản lý sinh viên-----" +
                                "\n 1. Hiển thị danh sách sinh viên."+
                                "\n 2. Thêm sinh viên."+
                                "\n 3. Xóa sinh viên"+
                                "\n 4. Thoát.");
            System.out.println("---Chọn yêu cầu---");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("hiển thị danh sách");
                    if (count == 1) {
                        System.out.println("Danh sách trống!!!");
                        break;
                    }
                    for (int i = 0; i < student.length; i++) {
                        if(student[i] != null){
                            System.out.println(student[i]);
                        }else {
                            break;
                        }
                        
                    }
                    break;
                case 2:
                    if (count >= student.length) {
                        System.out.println("Danh sách đã đầy!");
                        break;
                    }
                    System.out.println("Thêm sinh viên");
                    System.out.println("Nhập tên: ");
                    String name=scanner.nextLine();
                    System.out.println("Nhập tuổi: ");
                    byte age = Byte.parseByte(scanner.nextLine());
                    System.out.println("Nhập địa chỉ: ");
                    String address=scanner.nextLine();
                    Student newStudent = new Student(count,name,age,address);
                    count++;
                    studentManager.addStudent(newStudent);
                    System.out.println(" Đã thêm sinh viên!");
                    break;
                case 3:
                    System.out.println("Xóa sinh viên");
                    System.out.println("Nhập id người dùng bạn muốn xóa: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (student[i] != null && student[i].getId() == deleteId) {
                            for (int j = i; j < count - 1; j++) {
                                student[j] = student[j + 1];
                            }
                            student[count - 1] = null;
                            count--;
                            found = true;
                            System.out.println("Đã xóa thành công!");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên có id = " + deleteId);
                    }
                    break;
                default:
                    flag=false;
                    break;
            }
        }
    }
}

