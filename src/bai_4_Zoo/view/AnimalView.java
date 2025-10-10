package bai_4_Zoo.view;

import bai_4_Zoo.entity.Animal;
import bai_4_Zoo.exception.ZooException;

import java.util.List;
import java.util.Scanner;

public class AnimalView {
    private static final Scanner scanner = new Scanner(System.in);

    static String inputId() {
        System.out.print("Nhập id: ");
        return scanner.nextLine();
    }

    static String inputName() {
        System.out.print("Nhập tên: ");
        return scanner.nextLine();
    }

    static int inputBirthYear() {
        while (true) {
            try {
                System.out.print("Nhập năm sinh: ");
                int birthYear = Integer.parseInt(scanner.nextLine());
                if (birthYear > 0) {
                    return birthYear;
                } else {
                    throw new ZooException("Bạn đang nhập năm sinh < 0 , mời bạn nhập lại");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập sai năm sinh, mời bạn nhập lại");
            }
        }
    }

    static String inputCage() {
        System.out.print("Nhập chuồng nuôi: ");
        return scanner.nextLine();
    }
    public static String inputNameSearch(){
        System.out.println("Nhập tên động vật mà bạn muốn tìm");
        return scanner.nextLine();
    }
//    public static void showList(List<Animal> animalList) {
//        if (animalList.isEmpty()) {
//            System.out.println("Danh sách trống!");
//            return;
//        }
//        System.out.println("-------------------------------------------------------------------------------");
//
//        for (Animal animal : animalList) {
//            System.out.println(animal);
//        }
//    }
}
