package bai_4_Zoo.view;

import Furama.entity.person.Employee;
import bai_4_Zoo.entity.Carnivore;

import java.util.List;
import java.util.Scanner;

public class CarnivoreView extends AnimalView{
    private static final Scanner scanner = new Scanner(System.in);
    public static Carnivore inputData(String action, Carnivore carnivore) {
        if (action.equals("add")) {
            carnivore.setId(inputId());
        }
        carnivore.setName(inputName());
        carnivore.setBirthYear(inputBirthYear());
        carnivore.setCage(inputCage());
        carnivore.setFavoritePrey(inputFavoritePrey());
        return carnivore;
    }
    public static String inputFavoritePrey(){
        System.out.println("Nhập loại thịt mà động vật yêu thích");
        return scanner.nextLine();
    }
    public static void showList(List<Carnivore> carnivoreList) {
        if (carnivoreList.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------");

        for (Carnivore carnivore : carnivoreList) {
            System.out.println(carnivore);
        }
    }
}
