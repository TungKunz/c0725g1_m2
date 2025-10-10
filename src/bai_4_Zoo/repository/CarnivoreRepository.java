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
            List<Carnivore> carnivoreList = new ArrayList<>();
            List<String> stringList = new ArrayList<>();
            try {
                stringList = ReadAndWriteFile.readFileCSVToList(ANIMAL_FILE);
            } catch (IOException e) {
                System.out.println("Có lỗi xảy ra: " + e.getMessage());
            }
            String[] array;
            for (String line : stringList) {
                try {
                    array = line.split(",");
                    if(array[0].equalsIgnoreCase("carnivore")){
                        Carnivore carnivore = new Carnivore(array[1], array[2], Integer.parseInt(array[3]), array[4], array[5]);
                        carnivoreList.add(carnivore);
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            return carnivoreList;
    }

    @Override
    public boolean add(Carnivore carnivore) {
        List<String> stringList = new ArrayList<>();
        stringList.add(carnivore.getInforToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(ANIMAL_FILE, stringList, true);
        } catch (IOException e) {
            System.out.println("lỗi ghi file");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Carnivore deleteCarnivore) {
        List<Carnivore> carnivoreList = findAll();
        for (int i = 0; i < carnivoreList.size(); i++) {
            if (carnivoreList.get(i).getId().equals(deleteCarnivore.getId())) {
                carnivoreList.remove(i);
                break;
            }
        }
        return writeFileList(carnivoreList);
    }

    @Override
    public boolean editById(Carnivore editCarnivore) {
        List<Carnivore> carnivoreList = findAll();
        for (int i = 0; i < carnivoreList.size(); i++) {
            if (carnivoreList.get(i).getId().equals(editCarnivore.getId())) {
                carnivoreList.set(i, editCarnivore);
                break;
            }
        }
        return writeFileList(carnivoreList);
    }

    @Override
    public Carnivore findById(String id) {
        List<Carnivore> carnivoreList = findAll();
        for (Carnivore carnivore : carnivoreList) {
            if (carnivore.getId().equals(id)) {
                return carnivore;
            }
        }
        return null;
    }
    public boolean writeFileList(List<Carnivore> carnivoreList) {
        List<String> stringList = new ArrayList<>();
        for (Carnivore carnivore : carnivoreList) {
            stringList.add(carnivore.getInforToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(ANIMAL_FILE, stringList, false);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            return false;
        }
        return true;
    }
}
