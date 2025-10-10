package bai_4_Zoo.repository;

import Furama.util.ReadAndWriteFile;
import bai_4_Zoo.entity.Bird;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BirdRepository implements IAnimalRepository<Bird> {
    private final String ANIMAL_FILE = "D:\\CodeGym\\Module2\\src\\bai_4_Zoo\\data\\animal.csv";

    @Override
    public List<Bird> findAll() {
        List<Bird> birds = new ArrayList<>();
        try {
            List<String> lines = ReadAndWriteFile.readFileCSVToList(ANIMAL_FILE);
            for (String line : lines) {
                String[] array = line.split(",");
                try {
                    if (array[0].equalsIgnoreCase("bird")) {
                        Bird bird = new Bird(array[1], array[2], Integer.parseInt(array[3]), array[4],
                                Double.parseDouble(array[5]), Boolean.parseBoolean(array[6]));
                        birds.add(bird);
                    }
                }catch (Exception e){
                    System.out.println("lỗi");
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return birds;
    }

    @Override
    public boolean add(Bird bird) {
        try {
            ReadAndWriteFile.writeListStringToCSV(ANIMAL_FILE,
                    List.of(bird.getInforToCSV()), true);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
    public boolean writeAll(List<Bird> birds) {
        try {
            List<String> lines = new ArrayList<>();
            for (Bird b : birds) lines.add(b.getInforToCSV());
            ReadAndWriteFile.writeListStringToCSV(ANIMAL_FILE, lines, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
}

