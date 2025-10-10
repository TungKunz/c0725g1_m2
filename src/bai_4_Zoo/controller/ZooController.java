package bai_4_Zoo.controller;

import bai_4_Zoo.entity.Animal;
import bai_4_Zoo.entity.Bird;
import bai_4_Zoo.entity.Carnivore;
import bai_4_Zoo.entity.Herbivore;
import bai_4_Zoo.service.BirdService;
import bai_4_Zoo.service.CarnivoreService;
import bai_4_Zoo.service.HerbivoreService;
import bai_4_Zoo.service.IAnimalService;
import bai_4_Zoo.view.AnimalView;
import bai_4_Zoo.view.BirdView;
import bai_4_Zoo.view.CarnivoreView;
import bai_4_Zoo.view.HerbivoreView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooController {
    private static final IAnimalService<Carnivore> carnivoreService= new CarnivoreService();
    private static final IAnimalService<Herbivore> herbivoreService= new HerbivoreService();
    private static final IAnimalService<Bird> birdService= new BirdService();
    private static final ArrayList<Animal> arrayList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
            System.out.println("==== CHƯƠNG TRÌNH QUẢN LÝ ZOO ====");
            System.out.println("1. Creat new animal");
            System.out.println("2. Display animal   ");
            System.out.println("3. Delete by ID");
            System.out.println("4. Find anime by name");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1 -> creatNewAnimal();
                case 2 -> displayAnimal();
                case 3 -> deleteById();
                case 4 -> searchAnimalByName();
                case 5 -> {
                    System.out.println("Thoát chương trình...");
                    return;
                }
                default -> System.out.println("Vui lòng chọn lại!");
            }
        }
    }

    public static void creatNewAnimal() {
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add new Carnivore");
            System.out.println("2. Add new Herbivore");
            System.out.println("3. Add new Bird");
            int type;
            try {
                type = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            switch (type) {
                case 1 -> {
                    Carnivore carnivore = new Carnivore();
                    CarnivoreView.inputData("add", carnivore);
                    boolean check = carnivoreService.add(carnivore);
                    if (check) {
                        System.out.println("Thêm mới thành công");
                    } else {
                        System.out.println("Thêm mới không thành công");
                    }
                }
                case 2 -> {
                    Herbivore herbivore = new Herbivore();
                    HerbivoreView.inputData("add", herbivore);
                    boolean check = herbivoreService.add(herbivore);
                    if (check) {
                        System.out.println("Thêm mới thành công");
                    } else {
                        System.out.println("Thêm mới không thành công");
                    }
                }
                case 3 -> {
                    Bird bird = new Bird();
                    BirdView.inputData("add", bird);
                    boolean check = birdService.add(bird);
                    if (check) {
                        System.out.println("Thêm mới thành công");
                    } else {
                        System.out.println("Thêm mới không thành công");
                    }
                }
                default -> flag = false;
            }
        }
        }
        public static void displayAnimal(){
            System.out.println("Danh sách");
            CarnivoreView.showList(carnivoreService.findAll());

            HerbivoreView.showList(herbivoreService.findAll());

            BirdView.showList(birdService.findAll());
        }
    public static void deleteById() {
        System.out.print("Nhập ID cần xóa: ");
        String id = scanner.nextLine();

        var carnivore = carnivoreService.findById(id);
        if (carnivore != null) {
            carnivoreService.deleteById(carnivore);
            System.out.println("Đã xóa động vật ăn thịt.");
            return;
        }

        var herbivore = herbivoreService.findById(id);
        if (herbivore != null) {
            herbivoreService.deleteById(herbivore);
            System.out.println("Đã xóa động vật ăn cỏ.");
            return;
        }

        var bird = birdService.findById(id);
        if (bird != null) {
            birdService.deleteById(bird);
            System.out.println("Đã xóa chim.");
            return;
        }

        System.out.println("Không tìm thấy động vật có ID này!");
    }

    public static void searchAnimalByName() {
        String name = AnimalView.inputNameSearch().toLowerCase();
        List<Animal> resultList = new ArrayList<>();

        List<Animal> allAnimals = new ArrayList<>();
        allAnimals.addAll(carnivoreService.findAll());
        allAnimals.addAll(herbivoreService.findAll());
        allAnimals.addAll(birdService.findAll());

        for (Animal animal : allAnimals) {
            if (animal.getName().toLowerCase().contains(name)) {
                resultList.add(animal);
            }
        }

        if (resultList.isEmpty()) {
            System.out.println("Không tìm thấy động vật nào phù hợp với từ khóa: " + name);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Animal a : resultList) {
                System.out.println(a);
            }
        }
    }


}
