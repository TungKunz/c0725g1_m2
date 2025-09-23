package ss12_map_tree.bai_tap.product_manager;

import Furama.entity.person.Employee;

import java.util.*;

public class ProductManager {
    private static final List<Product> productList = new ArrayList<>();
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
                    productList.add(product);
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
                        System.out.println(productList.get(index));
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
                            productList.sort(null);
                            System.out.println("Sắp xếp sản phẩm theo giá (giảm dần)");
                            showAllProducts();
                        }
                        case 2 -> {
                            productList.sort(null);
                            Stack<Product> stack = new Stack<>();
                            for (Product product : productList) {
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

        Product product = new Product(id, name, price);
        return product;


    }

    public static void showAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống!");
        } else {
            for (Product p : productList) {
                System.out.println(p);
            }
        }
    }
    public static void editProductById(){
        System.out.println("Nhập id mà bạn muốn sửa");
        int idEdit= Integer.parseInt(scanner.nextLine());
        int index=searchId(idEdit);
        if (index >= 0) {
            Product editProduct = addNewProduct();
            productList.set(index, editProduct);
            editProduct.setId(idEdit);
        }else {
            System.out.println("Mã id không tồn tại hoặc không đúng, mời nhập lại");
        }

    }

    public static int searchId(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()== id) {
                return i;
            }
        }
        return -1;
    }
    public static int searchName(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public static void deleteProductById(){
        System.out.println("Nhập id bạn muốn xóa");
        int idDelete=Integer.parseInt(scanner.nextLine());
        int index=searchId(idDelete);
        if (index>=0){
            productList.remove(index);
            System.out.println("Đã xóa");
        }else {
            System.out.println("Không tìm thấy id");
        }
    }
}
