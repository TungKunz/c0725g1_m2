package bai_4_Zoo.service;

import bai_4_Zoo.entity.Bird;
import bai_4_Zoo.repository.BirdRepository;
import bai_4_Zoo.repository.IAnimalRepository;

import java.util.List;

public class BirdService implements IAnimalService<Bird> {
    public static final IAnimalRepository<Bird> birdRepository= new BirdRepository();
    @Override
    public List<Bird> findAll() {
        return birdRepository.findAll();
    }

    @Override
    public boolean add(Bird bird) {
        return birdRepository.add(bird);
    }

    @Override
    public boolean deleteById(Bird bird) {
        return birdRepository.deleteById(bird);
    }

    @Override
    public boolean editById(Bird bird) {
        return birdRepository.editById(bird);
    }

    @Override
    public Bird findById(String id) {
        return birdRepository.findById(id);
    }
}
