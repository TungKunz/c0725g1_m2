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
        return carnivoreRepository.add(carnivore);
    }

    @Override
    public boolean deleteById(Carnivore carnivore) {
        return carnivoreRepository.deleteById(carnivore);
    }

    @Override
    public boolean editById(Carnivore carnivore) {
        return carnivoreRepository.editById(carnivore);
    }

    @Override
    public Carnivore findById(String id) {
        return carnivoreRepository.findById(id);
    }
}
