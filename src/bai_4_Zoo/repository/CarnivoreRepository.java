package bai_4_Zoo.repository;
import Furama.util.ReadAndWriteFile;
import bai_4_Zoo.entity.Carnivore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarnivoreRepository implements IAnimalRepository<Carnivore> {
    private final String ANIMAL_FILE = "D:\\CodeGym\\Module2\\src\\bai_4_Zoo\\data\\animal.csv";
    @Override
    public List<Carnivore> findAll() {
        List<Carnivore> carnivores = new ArrayList<>();
        try {
            List<String> lines = ReadAndWriteFile.readFileCSVToList(ANIMAL_FILE);
            for (String line : lines) {
                String[] array = line.split(",");
                try {
                    if (array[0].equalsIgnoreCase("carnivore")) {
                        Carnivore carnivore = new Carnivore(array[1], array[2], Integer.parseInt(array[3]), array[4],
                                array[5]);
                        carnivores.add(carnivore);
                    }
                }catch (Exception e){
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return carnivores;
    }
    @Override
    public boolean add(Carnivore carnivore) {
        try {
            ReadAndWriteFile.writeListStringToCSV(ANIMAL_FILE,
                    List.of(carnivore.getInforToCSV()), true);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
    public boolean writeAll(List<Carnivore> carnivores) {
        try {
            List<String> lines = new ArrayList<>();
            for (Carnivore b : carnivores) lines.add(b.getInforToCSV());
            ReadAndWriteFile.writeListStringToCSV(ANIMAL_FILE, lines, false);
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
    }
}
