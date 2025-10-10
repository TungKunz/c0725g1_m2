package bai_4_Zoo.service;

import bai_4_Zoo.entity.Herbivore;

import bai_4_Zoo.repository.HerbivoreRepository;
import bai_4_Zoo.repository.IAnimalRepository;

import java.util.List;

public class HerbivoreService implements IAnimalService<Herbivore> {
    public static final IAnimalRepository<Herbivore> herbivoreRepository = new HerbivoreRepository();

    @Override
    public List<Herbivore> findAll() {
        return herbivoreRepository.findAll();
    }

    @Override
    public boolean add(Herbivore herbivore) {
        if (findById(herbivore.getId()) != null) {
            System.out.println("ID đã tồn tại!");
            return false;
        }
        return herbivoreRepository.add(herbivore);
    }

    @Override
    public boolean deleteById(Herbivore herbivore) {
        List<Herbivore> herbivores = herbivoreRepository.findAll();
        boolean removed = herbivores.removeIf(b -> b.getId().equals(herbivore.getId()));
        if (!removed) {
            System.out.println("Không tìm thấy chim cần xóa.");
            return false;
        }
        return ((HerbivoreRepository) herbivoreRepository).writeAll(herbivores);
    }

    @Override
    public boolean editById(Herbivore herbivore) {
        List<Herbivore> herbivores = herbivoreRepository.findAll();
        boolean found = false;
        for (int i = 0; i < herbivores.size(); i++) {
            if (herbivores.get(i).getId().equals(herbivore.getId())) {
                herbivores.set(i, herbivore);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy chim để sửa.");
            return false;
        }
        return ((HerbivoreRepository) herbivoreRepository).writeAll(herbivores);
    }

    @Override
    public Herbivore findById(String id) {
        for (Herbivore herbivore : herbivoreRepository.findAll()) {
            if (herbivore.getId().equalsIgnoreCase(id)) {
                return herbivore;
            }
        }
        return null;
    }
}
