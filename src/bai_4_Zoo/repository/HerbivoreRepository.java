package bai_4_Zoo.repository;

import Furama.util.ReadAndWriteFile;
import bai_4_Zoo.entity.Herbivore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HerbivoreRepository implements IAnimalRepository<Herbivore> {
    private final String ANIMAL_FILE = "D:\\CodeGym\\Module2\\src\\bai_4_Zoo\\data\\animal.csv";
    @Override
    public List<Herbivore> findAll() {
        List<Herbivore> herbivores = new ArrayList<>();
        try {
            List<String> lines = ReadAndWriteFile.readFileCSVToList(ANIMAL_FILE);
            for (String line : lines) {
                String[] array = line.split(",");
                try {
                    if (array[0].equalsIgnoreCase("herbivore")) {
                        Herbivore herbivore = new Herbivore(array[1], array[2], Integer.parseInt(array[3]), array[4],
                                array[5]);
                        herbivores.add(herbivore);
                    }
                }catch (Exception e){
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return herbivores;
    }

    @Override
    public boolean add(Herbivore herbivore) {
        try {
            ReadAndWriteFile.writeListStringToCSV(ANIMAL_FILE,
                    List.of(herbivore.getInforToCSV()), true);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
    public boolean writeAll(List<Herbivore> herbivores) {
        try {
            List<String> lines = new ArrayList<>();
            for (Herbivore b : herbivores) lines.add(b.getInforToCSV());
            ReadAndWriteFile.writeListStringToCSV(ANIMAL_FILE, lines, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
}
