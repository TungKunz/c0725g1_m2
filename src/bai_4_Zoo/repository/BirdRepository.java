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
        List<Bird> birdList = new ArrayList<>();
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
                if(array[0].equalsIgnoreCase("bird")){
                    Bird bird = new Bird(array[1], array[2], Integer.parseInt(array[3]), array[4], Double.parseDouble(array[5]),Boolean.parseBoolean(array[6]));
                    birdList.add(bird);
                }
            } catch (Exception e) {
                continue;
            }
        }
        return birdList;
    }

    @Override
    public boolean add(Bird bird) {
        List<String> stringList = new ArrayList<>();
        stringList.add(bird.getInforToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(ANIMAL_FILE, stringList, true);
        } catch (IOException e) {
            System.out.println("lỗi ghi file");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(Bird deleteBird) {
        List<Bird> birdList = findAll();
        for (int i = 0; i < birdList.size(); i++) {
            if (birdList.get(i).getId().equals(deleteBird.getId())) {
                birdList.remove(i);
                break;
            }
        }
        return writeFileList(birdList);
    }

    @Override
    public boolean editById(Bird editBird) {
        List<Bird> birdList = findAll();
        for (int i = 0; i < birdList.size(); i++) {
            if (birdList.get(i).getId().equals(editBird.getId())) {
                birdList.set(i, editBird);
                break;
            }
        }
        return writeFileList(birdList);    }

    @Override
    public Bird findById(String id) {
        List<Bird> birdList = findAll();
        for (Bird bird : birdList) {
            if (bird.getId().equals(id)) {
                return bird;
            }
        }
        return null;
    }
    public boolean writeFileList(List<Bird> birdList) {
        List<String> stringList = new ArrayList<>();
        for (Bird bird : birdList) {
            stringList.add(bird.getInforToCSV());
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
