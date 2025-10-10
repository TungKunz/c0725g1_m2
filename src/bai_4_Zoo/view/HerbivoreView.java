package bai_4_Zoo.view;

import bai_4_Zoo.entity.Carnivore;
import bai_4_Zoo.entity.Herbivore;

import java.util.List;
import java.util.Scanner;

public class HerbivoreView extends AnimalView{
    private static final Scanner scanner = new Scanner(System.in);
    public static Herbivore inputData(String action, Herbivore herbivore) {
        if (action.equals("add")) {
            herbivore.setId(inputId());
        }
        herbivore.setName(inputName());
        herbivore.setBirthYear(inputBirthYear());
        herbivore.setCage(inputCage());
        herbivore.setFavoriteGrass(inputFavoriteGrass());
        return herbivore;
    }
    public static String inputFavoriteGrass(){
        System.out.println("Nhập loại cỏ mà động vật yêu thích");
        return scanner.nextLine();
    }
    public static void showList(List<Herbivore> herbivoreList) {
        if (herbivoreList.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------");

        for (Herbivore herbivore : herbivoreList) {
            System.out.println(herbivore);
        }
    }
}
