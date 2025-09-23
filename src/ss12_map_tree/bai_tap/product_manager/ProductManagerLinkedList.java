package ss12_map_tree.bai_tap.product_manager;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ProductManagerLinkedList {
    private static final LinkedList<Product> productLinked = new LinkedList<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        showMenu();
    }
    public static void showMenu() {
        while (true) {
            System.out.println("""
                    ==========Menu==========
                    1. Thêm sản phẩm
                    2. Sửa thông tin sản phẩm theo id
                    3. Xóa sản phẩm theo id 
                    4. Hiển thị danh sách sản phẩm
                    5. Tìm kiếm sản phẩm theo tên
                    6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá
                    """);
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    Product product = addNewProduct();
                    productLinked.add(product);
                    System.out.println("Thêm mới thành công");
                }
                case 2 -> {
                    System.out.println("Sửa thông tin sản phẩm theo id");
                    editProductById();
                }
                case 3 -> {
                    System.out.println("Xóa sản phẩm theo id");
                    deleteProductById();
                }
                case 4 -> {
                    System.out.println("Hiển thị danh sách sản phẩm");
                    showAllProducts();
                }
                case 5 -> {
                    System.out.println("Tìm kiếm sản phẩm theo tên");
                    System.out.println("Nhập tên bạn muốn tìm kiếm");
                    String name= scanner.nextLine();
                    int index = searchName(name);
                    if(index>=0){
                        System.out.println(productLinked.get(index));
                    }else {
                        System.out.println("Không tìm thấy");
                    }
                }
                case 6 -> {
                    System.out.println("""
            Sắp xếp sản phẩm theo giá
            1. Tăng dần
            2. Giảm dần""");
                    byte sortChoice = Byte.parseByte(scanner.nextLine());

                    switch (sortChoice) {
                        case 1 -> {
                            productLinked.sort(null);
                            System.out.println("Sắp xếp sản phẩm theo giá (giảm dần)");
                            showAllProducts();
                        }
                        case 2 -> {
                            productLinked.sort(null);
                            Stack<Product> stack = new Stack<>();
                            for (Product product : productLinked) {
                                stack.push(product);
                            }
                            System.out.println("Sắp xếp sản phẩm theo giá (tăng dần)");
                            while (!stack.isEmpty()) {
                                System.out.println(stack.pop());
                            }
                        }
                        default -> System.out.println("Lựa chọn không hợp lệ!");
                    }
                }

                case 7 -> {
                    System.out.println("Thoát chương trình...");
                    return;
                }
                default -> System.out.println("Vui lòng chọn lại!");
            }
        }
    }
    public static Product addNewProduct() {
        System.out.print("Nhập id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        return new Product(id, name, price);
    }
    public static void showAllProducts() {
        if (productLinked.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống!");
        } else {
            for (Product p : productLinked) {
                System.out.println(p);
            }
        }
    }
    public static void editProductById() {
        System.out.print("Nhập id sản phẩm cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Product p : productLinked) {
            if (p.getId() == id) {
                System.out.print("Nhập tên mới: ");
                p.setName(scanner.nextLine());
                System.out.print("Nhập giá mới: ");
                p.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với id: " + id);
    }
    public static void deleteProductById() {
        System.out.print("Nhập id sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Product p : productLinked) {
            if (p.getId() == id) {
                productLinked.remove(p);
                System.out.println("Xóa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với id: " + id);
    }
    public static int searchName(String name) {
        for (int i = 0; i < productLinked.size(); i++) {
            if (productLinked.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

}
