package bai_4_Zoo.repository;

import Furama.util.ReadAndWriteFile;
import bai_4_Zoo.entity.Carnivore;
import bai_4_Zoo.entity.Herbivore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HerbivoreRepository implements IAnimalRepository<Herbivore> {
    private final String ANIMAL_FILE = "D:\\CodeGym\\Module2\\src\\bai_4_Zoo\\data\\animal.csv";
    @Override
    public List<Herbivore> findAll() {
        List<Herbivore> herbivoreList = new ArrayList<>();
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
                if(array[0].equalsIgnoreCase("herbivore")){
                    Herbivore herbivore = new Herbivore(array[1], array[2], Integer.parseInt(array[3]), array[4], array[5]);
                    herbivoreList.add(herbivore);
                }
            } catch (Exception e) {
                continue;
            }
        }
        return herbivoreList;
    }

    @Override
    public boolean add(Herbivore herbivore) {
        List<String> stringList = new ArrayList<>();
        stringList.add(herbivore.getInforToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(ANIMAL_FILE, stringList, true);
        } catch (IOException e) {
            System.out.println("lỗi ghi file");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Herbivore deleteHerbivore) {
        List<Herbivore> herbivoreList = findAll();
        for (int i = 0; i < herbivoreList.size(); i++) {
            if (herbivoreList.get(i).getId().equals(deleteHerbivore.getId())) {
                herbivoreList.remove(i);
                break;
            }
        }
        return writeFileList(herbivoreList);
    }

    @Override
    public boolean editById(Herbivore editHerbivore) {
        List<Herbivore> herbivoreList = findAll();
        for (int i = 0; i < herbivoreList.size(); i++) {
            if (herbivoreList.get(i).getId().equals(editHerbivore.getId())) {
                herbivoreList.set(i, editHerbivore);
                break;
            }
        }
        return writeFileList(herbivoreList);
    }

    @Override
    public Herbivore findById(String id) {
        List<Herbivore> herbivoreList = findAll();
        for (Herbivore herbivore : herbivoreList) {
            if (herbivore.getId().equals(id)) {
                return herbivore;
            }
        }
        return null;
    }
    public boolean writeFileList(List<Herbivore> herbivoreList) {
        List<String> stringList = new ArrayList<>();
        for (Herbivore herbivore : herbivoreList) {
            stringList.add(herbivore.getInforToCSV());
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
