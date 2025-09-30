package ss17_binary.bai_tap.copy_file;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    ===== Quản lý sản phẩm =====
                    1. Thêm sản phẩm
                    2. Hiển thị sản phẩm
                    3. Tìm kiếm sản phẩm theo mã
                    4. Thoát
                    """);
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> ProductManager.displayProducts();
                case 3 -> searchProduct();
                case 4 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();

        Product product = new Product(id, name, price, manufacturer, description);
        ProductManager.addProduct(product);
        System.out.println("Đã thêm sản phẩm thành công!");
    }

    private static void searchProduct() {
        System.out.print("Nhập mã sản phẩm cần tìm: ");
        String id = scanner.nextLine();
        Product result = ProductManager.searchById(id);
        if (result != null) {
            System.out.println("Tìm thấy: " + result);
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }
}
