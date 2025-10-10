package bai_4_Zoo.view;

import bai_4_Zoo.entity.Bird;
import bai_4_Zoo.entity.Herbivore;
import bai_4_Zoo.exception.ZooException;

import java.util.List;
import java.util.Scanner;

public class BirdView extends AnimalView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Bird inputData(String action, Bird bird) {
        if (action.equals("add")) {
            bird.setId(inputId());
        }
        bird.setName(inputName());
        bird.setBirthYear(inputBirthYear());
        bird.setCage(inputCage());
        bird.setWingspan(inputWingspan());
        bird.setCanTalk(inputCanTalk());
        return bird;
    }

    public static Double inputWingspan() {
        double wingSpan;
        while (true) {
            try {
                System.out.println("Nhập chiều dài sải cánh");
                wingSpan = Double.parseDouble(scanner.nextLine());
                if (wingSpan > 0) {
                    return wingSpan;
                } else {
                    throw new ZooException("Chiều dài sải cánh bạn nhập < 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không chính xác chiều dài sải cánh, mời bạn nhập lại");
            }
        }
    }

    public static boolean inputCanTalk() {
        String input;
        while (true) {
            System.out.print("Chim có biết nói không? (true/false): ");
            input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            } else {
                System.out.println("Giá trị không hợp lệ! Vui lòng nhập lại (true hoặc false).");
            }
        }
    }

    public static void showList(List<Bird> birdList) {
        if (birdList.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------");

        for (Bird bird : birdList) {
            System.out.println(bird);
        }
    }
}
