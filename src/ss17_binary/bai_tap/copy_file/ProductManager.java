package ss17_binary.bai_tap.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final String FILE_PATH = "D:\\CodeGym\\Module2\\src\\ss17_binary\\bai_tap\\copy_file\\products.dat";

    public static void writeProducts(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static List<Product> readProducts() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }


    public static void addProduct(Product product) {
        List<Product> products = readProducts();
        products.add(product);
        writeProducts(products);
    }


    public static void displayProducts() {
        List<Product> products = readProducts();
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public static Product searchById(String id) {
        List<Product> products = readProducts();
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}
