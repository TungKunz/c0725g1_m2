package ss12_map_tree.bai_tap.product_manager;

import java.io.*;
import java.util.*;

public class ProductManagerArrayList {
    private static final List<Product> productList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "D:\\CodeGym\\Module2\\src\\ss12_map_tree\\bai_tap\\product_manager\\products.csv";

    public static void main(String[] args) {
        productList.addAll(readProductsFromCSV());
        showMenu();
    }

    public static void showMenu() {
        while (true) {
            System.out.println("""
                    ==========Menu==========
                    1. Thêm sản phẩm
                    2. Sửa thông tin sản phẩm theo id
                    3. Xóa sản phẩm theo id\s
                    4. Hiển thị danh sách sản phẩm
                    5. Tìm kiếm sản phẩm theo tên
                    6. Lưu sản phẩm ra file CSV
                    7. Đọc sản phẩm từ file CSV
                    8. Sắp xếp sản phẩm tăng dần, giảm dần theo giá
                   \s""");
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
                    showAllProducts(productList);
                }
                case 5 -> {
                    System.out.println("Tìm kiếm sản phẩm theo tên");
                    System.out.println("Nhập tên bạn muốn tìm kiếm");
                    String name= scanner.nextLine();
                    List<Product> products;
                    products=searchName(name);
                    if(!products.isEmpty()){
                        showAllProducts(products);
                    }else {
                        System.out.println("Không tìm thấy");
                    }
                }
                case 6 -> writeProductsToCSV();
                case 7 -> {
                    productList.clear();
                    productList.addAll(readProductsFromCSV());
                    System.out.println("Đã nạp dữ liệu từ file CSV.");
                }
                case 8 -> {
                    System.out.println("""
            Sắp xếp sản phẩm theo giá
            1. Tăng dần
            2. Giảm dần""");
                    byte sortChoice = Byte.parseByte(scanner.nextLine());

                    switch (sortChoice) {
                        case 1 -> {
                            productList.sort(null);
                            System.out.println("Sắp xếp sản phẩm theo giá (giảm dần)");
                            showAllProducts(productList);
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

                case 9 -> {
                    System.out.println("Thoát chương trình...");
                    return;
                }
                default -> System.out.println("Vui lòng chọn lại!");
            }
        }
    }

    public static Product addNewProduct() {
        int id;
        double price;
        while (true) {
            try {
                System.out.print("Nhập id sản phẩm: ");
                id = Integer.parseInt(scanner.nextLine());

                if (searchId(id) != -1) {
                    System.out.println("Id đã tồn tại, mời bạn nhập lại!");
                    continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        while (true){
            try {
                System.out.print("Nhập giá sản phẩm: ");
                price = Double.parseDouble(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("Nhập đúng định dạng ");
            }
        }
        return new Product(id, name, price);
    }

    public static void showAllProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống!");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }
    public static void editProductById() {
        System.out.print("Nhập id sản phẩm cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Product p : productList) {
            if (p.getId() == id) {
                System.out.print("Nhập tên mới: ");
                p.setName(scanner.nextLine());
                while (true){
                    try{
                        System.out.print("Nhập giá mới: ");
                        p.setPrice(Double.parseDouble(scanner.nextLine()));
                        break;
                    }catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với id: " + id);
    }

    public static int searchId(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()== id) {
                return i;
            }
        }
        return -1;
    }
    public static List<Product> searchName(String name) {
        List<Product> productsListSearch = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                productsListSearch.add(product);
            }
        }
        return productsListSearch;
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
    private static void writeProductsToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Product p : productList) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getPrice());
                writer.newLine();
            }
            System.out.println("Đã lưu danh sách sản phẩm ra file " + FILE_PATH);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Product> readProductsFromCSV() {
        List<Product> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                list.add(new Product(id, name, price));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Chưa có file dữ liệu, bắt đầu với danh sách rỗng.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
