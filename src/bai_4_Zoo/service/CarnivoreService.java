package bai_4_Zoo.service;


import bai_4_Zoo.entity.Carnivore;

import bai_4_Zoo.repository.CarnivoreRepository;
import bai_4_Zoo.repository.IAnimalRepository;

import java.util.List;

public class CarnivoreService implements IAnimalService<Carnivore> {
    public static final IAnimalRepository<Carnivore> carnivoreRepository = new CarnivoreRepository();
    @Override
    public List<Carnivore> findAll() {
        return carnivoreRepository.findAll();
    }

    @Override
    public boolean add(Carnivore carnivore) {
        if (findById(carnivore.getId()) != null) {
            System.out.println("ID đã tồn tại!");
            return false;
        }
        return carnivoreRepository.add(carnivore);
    }

    @Override
    public boolean deleteById(Carnivore carnivore) {
        List<Carnivore> birds = carnivoreRepository.findAll();
        boolean removed = birds.removeIf(b -> b.getId().equals(carnivore.getId()));
        if (!removed) {
            System.out.println("Không tìm thấy chim cần xóa.");
            return false;
        }
        return ((CarnivoreRepository) carnivoreRepository).writeAll(birds);
    }

    @Override
    public boolean editById(Carnivore carnivore) {
        List<Carnivore> carnivores = carnivoreRepository.findAll();
        boolean found = false;
        for (int i = 0; i < carnivores.size(); i++) {
            if (carnivores.get(i).getId().equals(carnivore.getId())) {
                carnivores.set(i, carnivore);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy chim để sửa.");
            return false;
        }
        return ((CarnivoreRepository) carnivoreRepository).writeAll(carnivores);
    }

    @Override
    public Carnivore findById(String id) {
        for (Carnivore carnivore : carnivoreRepository.findAll()) {
            if (carnivore.getId().equalsIgnoreCase(id)) {
                return carnivore;
            }
        }
        return null;
    }
}
