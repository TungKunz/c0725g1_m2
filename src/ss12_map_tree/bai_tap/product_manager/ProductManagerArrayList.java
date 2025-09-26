package ss12_map_tree.bai_tap.product_manager;


import ss8_clean_code.bai_tap_lam_them_car.util.ReadAndWriteFile;

import java.io.*;
import java.util.*;

public class ProductManagerArrayList {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "D:\\CodeGym\\Module2\\src\\ss12_map_tree\\bai_tap\\product_manager\\products.csv";

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
                    6. Sắp xếp sản phẩm theo giá
                    7. Thoát
                   """);
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    Product product = inputInforProduct();
                    List<Product> newList = new ArrayList<>();
                    newList.add(product);
                    writeProductsToCSV(newList, true);
                    System.out.println("Thêm mới thành công");
                }
                case 2 -> {
                     List<Product> products = findAll();
                    if(editProductById()){
                        System.out.println("Cập nhật thành công!");
                    }else {
                        System.out.println("Không tìm thấy sản phẩm với id: ");
                    }


                }
                case 3 -> {
                    System.out.println("Nhập id mà bạn muốn xóa: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    boolean check = deleteProductById(deleteId);
                    if(check){
                        System.out.println("Đã xóa thành công!");
                    }
                }
                case 4 -> {
                    List<Product> products = readProductsFromCSV();
                    showAllProducts(products);
                }
                case 5 -> {
                    System.out.print("Nhập tên bạn muốn tìm kiếm: ");
                    String name = scanner.nextLine();
                    List<Product> products = readProductsFromCSV();
                    List<Product> result = searchName(products, name);
                    if (!result.isEmpty()) {
                        showAllProducts(result);
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                }
                case 6 -> {
                    System.out.println("""
                            Sắp xếp sản phẩm theo giá
                            1. Tăng dần
                            2. Giảm dần""");
                    byte sortChoice = Byte.parseByte(scanner.nextLine());
                    List<Product> products = readProductsFromCSV();
                    switch (sortChoice) {
                        case 1 -> {
                            products.sort(Comparator.comparingDouble(Product::getPrice));
                            showAllProducts(products);
                        }
                        case 2 -> {
                            products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
                            showAllProducts(products);
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
    public static List<Product> findAll() {

        List<Product> products = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        try {
            stringList = ReadAndWriteFile.readFileCSVToList(FILE_PATH);
        } catch (IOException e) {
            System.out.println("lỗi đọc file");
        }
        String[] array;
        for(String line : stringList){
            array=line.split(",");
            int id = Integer.parseInt(array[0]);
            String name = array[1];
            double price = Double.parseDouble(array[2]);
            Product product = new Product(id, name, price);
            products.add(product);
        }
        return products;
    }
    public static Product inputInforProduct() {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
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

    public static boolean editProductById() {
        List<Product> productList = findAll();
        System.out.print("Nhập id sản phẩm cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Product p : productList) {
            if (p.getId() == id) {
                System.out.print("Nhập tên mới: ");
                p.setName(scanner.nextLine());

                while (true) {
                    try {
                        System.out.print("Nhập giá mới: ");
                        p.setPrice(Double.parseDouble(scanner.nextLine()));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Sai định dạng giá, nhập lại!");
                    }
                }
                break;
            }
        }

        List<String> stringList = new ArrayList<>();
        for (Product product : productList) {
            stringList.add(product.getInforToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(FILE_PATH, stringList, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }


    public static List<Product> searchName(List<Product> products, String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                result.add(product);
            }
        }
        return result;
    }

    public static boolean deleteProductById(int id) {
        List<Product> productList= findAll();
        for (int i = 0; i <productList.size() ; i++) {
            if (productList.get(i).getId()==id){
                productList.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Product product : productList) {
            stringList.add(product.getInforToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(FILE_PATH,stringList,false);
        }catch (IOException e){
            System.out.println("Lỗi ghi file");
            return false;
        }
        return true;
    }

    private static void writeProductsToCSV(List<Product> products, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ProductManagerArrayList.FILE_PATH, append))) {
            for (Product p : products) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    private static List<Product> readProductsFromCSV() {
        List<Product> list = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return list;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        double price = Double.parseDouble(parts[2]);
                        list.add(new Product(id, name, price));
                    } catch (NumberFormatException ignored) {}
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return list;
    }
}
