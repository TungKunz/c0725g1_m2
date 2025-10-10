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
        return herbivoreRepository.add(herbivore);
    }

    @Override
    public boolean deleteById(Herbivore herbivore) {
        return herbivoreRepository.deleteById(herbivore);
    }

    @Override
    public boolean editById(Herbivore herbivore) {
        return herbivoreRepository.editById(herbivore);
    }

    @Override
    public Herbivore findById(String id) {
        return herbivoreRepository.findById(id);
    }
}
