package menuManager;

import java.util.Scanner;


public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte count = 0;
        Student[] students = new Student[100];
        byte choice;
        do {
            System.out.println("Quản lý Sinh viên");
            System.out.println("1. Hiển thị sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Sửa thông tin");
            System.out.println("4. Xóa sinh viên theo id");
            System.out.println("5. Tìm");
            System.out.println("6. Thoát");
            try {
                choice = Byte.parseByte(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                choice = -1;
            }
            switch (choice) {
                case 1:
                    System.out.println("Danh sách sinh viên:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(students[i].id + " - " + students[i].name +
                                " - " + students[i].age + " tuổi - " + students[i].address);
                    }
                    break;
                case 2:
                    if (count >= students.length) {
                        System.out.println("Danh sách đã đầy!");
                        break;
                    }
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    byte age = Byte.parseByte(scanner.nextLine());
                    System.out.print("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    students[count] = new Student(count, name, age, address);
                    count++;
                    System.out.println(" Đã thêm sinh viên!");
                    break;
                case 3:
                    System.out.println("Nhập id thông tin người dùng mà bạn muốn sửa:");
                    byte editId = Byte.parseByte(scanner.nextLine());
                    if (editId >= 0 && editId < count && students[editId] != null) {
                        byte choiceEdit;
                        do {
                            System.out.println("Sửa thông tin");
                            System.out.println("1. Sửa tên");
                            System.out.println("2. Sửa tuổi");
                            System.out.println("3. Sửa địa chỉ");
                            System.out.println("4. Thoát");
                            choiceEdit = Byte.parseByte(scanner.nextLine());
                            switch (choiceEdit) {
                                case 1:
                                    System.out.print("Nhập tên bạn muốn sửa đổi: ");
                                    String newName = scanner.nextLine();
                                    students[editId] = new Student(editId, newName, students[editId].age, students[editId].address);
                                    System.out.println("Đã sửa thành công tên!");
                                    break;
                                case 2:
                                    System.out.print("Nhập tuổi bạn muốn sửa đổi: ");
                                    byte newAge = Byte.parseByte(scanner.nextLine());
                                    students[editId] = new Student(editId, students[editId].name, newAge, students[editId].address);
                                    System.out.println("Đã sửa thành công tuổi!");
                                    break;
                                case 3:
                                    System.out.print("Nhập địa chỉ bạn muốn sửa đổi: ");
                                    String newAddress = scanner.nextLine();
                                    students[editId] = new Student(editId, students[editId].name, students[editId].age, newAddress);
                                    System.out.println("Đã sửa thành công địa chỉ!");
                                    break;
                            }

                        } while (choiceEdit != 4);
                    } else {
                        System.out.println("Không tìm thấy id cần sửa");
                    }
                    break;
                case 4:
                    byte choiceDelete;
                    do {
                        System.out.println("Xóa thông tin");
                        System.out.println("1. Xóa theo Id");
                        System.out.println("2. Xóa theo Tên");
                        System.out.println("3. Xóa theo Tuổi");
                        System.out.println("4. Xóa theo Địa chỉ");
                        System.out.println("5. Thoát");
                        choiceDelete = Byte.parseByte(scanner.nextLine());
                        switch (choiceDelete) {
                            case 1:
                                System.out.println("Nhập id thông tin người dùng mà bạn muốn xóa:");
                                int deleteId = Integer.parseInt(scanner.nextLine());
                                if (deleteId >= 0 && deleteId < count && students[deleteId] != null) {
                                    for (int i = deleteId; i < count - 1; i++) {
                                        students[i] = students[i + 1];
                                        students[i].id = i;
                                    }
                                    students[count - 1] = null;
                                    count--;
                                    System.out.println("Đã xóa thành công!");
                                } else {
                                    System.out.println("Không tìm thấy id cần xóa");
                                }
                                break;
                            case 2:
                                System.out.println("Nhập tên người dùng bạn muốn xóa");
                                String deleteName = scanner.nextLine();
                                for (int i = 0; i < count; i++) {
                                    if (students[i] != null && deleteName.equals(students[i].name)) {
                                        for (int j = i; j < count - 1; j++) {
                                            students[j] = students[j + 1];
                                            if (students[j] != null) {
                                                students[j].id = j;
                                            }
                                        }
                                        students[count - 1] = null;
                                        count--;
                                    }
                                }
                                System.out.println("Đã xóa tên thành công ");
                                break;
                            case 3:
                                System.out.println("Nhập tuổi người dùng bạn muốn xóa");
                                int deleteAge = Integer.parseInt(scanner.nextLine());

                                int i = 0;
                                boolean found = false;
                                while (i < count) {
                                    if (students[i] != null && deleteAge == students[i].age) {
                                        for (int j = i; j < count - 1; j++) {
                                            students[j] = students[j + 1];
                                            if (students[j] != null) {
                                                students[j].id = j;
                                            }
                                        }
                                        students[count - 1] = null;
                                        count--;
                                        found = true;
                                    } else {
                                        i++;
                                    }
                                }

                                if (found) {
                                    System.out.println("Đã xóa tất cả sinh viên có tuổi " + deleteAge);
                                } else {
                                    System.out.println("Không tìm thấy sinh viên nào có tuổi " + deleteAge);
                                }
                                break;
                            case 4:
                                System.out.println("Nhập địa chỉ người dùng bạn muốn xóa");
                                String deleteAddress = scanner.nextLine();
                                for (int t = 0; t < count; t++) {
                                    if (students[t] != null && deleteAddress.equals(students[t].address)) {
                                        for (int j = t; j < count - 1; j++) {
                                            students[j] = students[j + 1];
                                            if (students[j] != null) {
                                                students[j].id = j;
                                            }
                                        }
                                        students[count - 1] = null;
                                        count--;
                                    }
                                }
                                System.out.println("Đã xóa địa chỉ thành công ");
                                break;

                        }
                    } while (choiceDelete != 5);


            }
        } while (choice != 6);
    }
}
