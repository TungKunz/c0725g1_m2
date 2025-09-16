package menuManager;

import java.util.Scanner;

public class Menu {
    static ProductManagement studentManager= new ProductManagement();
    static Product[] student = studentManager.getStudents();
    static int count=0;
    public static void main(String[] args) {
        display();

    }
    public static void display(){
        boolean flag=true;
        Scanner scanner = new Scanner(System.in);

        while (flag){
            System.out.println("""
                    -----Quản lý sinh viên-----\
                   \s
                     1. Hiển thị danh sách sản phẩm.\
                   \s
                     2. Thêm sản phẩm.\
                   \s
                     3. Xóa sản phẩm\
                    \s
                     4. Sửa thông tin sản phẩm\
                   \s
                     5. Thoát.""");
            System.out.println("---Chọn yêu cầu---");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("hiển thị danh sách");
                    if (count == 0) {
                        System.out.println("Danh sách trống!!!");
                        break;
                    }
                    for (Product value : student) {
                        if (value != null) {
                            System.out.println(value);
                        } else {
                            break;
                        }

                    }
                    break;
                case 2:
                    if (count >= student.length) {
                        System.out.println("Danh sách đã đầy!");
                        break;
                    }
                    System.out.println("Thêm sản phẩm");
                    System.out.println("Nhập tên: ");
                    String name=scanner.nextLine();
                    System.out.println("Nhập giá: ");
                    float price = Float.parseFloat(scanner.nextLine());
                    Product newStudent = new Product(count,name,price);
                    count++;
                    studentManager.addStudent(newStudent);
                    System.out.println(" Đã thêm sản phẩm!");
                    break;
                case 3:
                    System.out.println("Xóa sản phẩm");
                    System.out.println("Nhập id sản phẩm bạn muốn xóa: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (student[i] != null && student[i].getId() == deleteId) {
                            for (int j = i; j < count - 1; j++) {
                                student[j] = student[j + 1];
                                student[j].setId(i);
                            }
                            student[count - 1] = null;
                            count--;
                            found = true;
                            System.out.println("Đã xóa thành công!");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sản phẩm có id = " + deleteId);
                    }
                    break;
                case 4:
                    boolean flagCase4=true;
                    System.out.println("Nhập id thông tin sản phẩm");
                    int search = Integer.parseInt(scanner.nextLine());
                    while (!studentManager.checkId(search)){
                        System.out.println("Không tìm thấy id, mời bạn nhập lại");
                        search = Integer.parseInt(scanner.nextLine());
                    }
                    System.out.println("Thông tin sản phẩm bạn muốn sửa");
                    System.out.println("Tên: " + student[search].getName() + " Giá: " + student[search].getPrice());
                    while (flagCase4){
                        System.out.println("""
                                -----Sửa thông tin sản phẩm-----\
                                
                                 1. Sửa tên\
                                
                                 2. Sửa giá\
                                
                                 3. Thoát""");
                        System.out.println("Nhập yêu cầu");
                        byte choiceCase4 = Byte.parseByte(scanner.nextLine());
                        switch (choiceCase4){
                            case 1:
                                System.out.println("Nhập tên bạn muốn sửa:");
                                String newName = scanner.nextLine();
                                student[search].setName(newName);
                                System.out.println("Sửa đổi tên thành công");
                                break;
                            case 2:
                                System.out.println("Nhập giá bạn muốn sửa");
                                float newPrice = Float.parseFloat(scanner.nextLine());
                                student[search].setPrice(newPrice);
                                System.out.println("Sửa đổi giá thành công");
                                break;
                            default:
                                flagCase4=false;
                                break;
                        }


                    }
                    break;
                default:
                    flag=false;
                    break;
            }
        }
    }
}

