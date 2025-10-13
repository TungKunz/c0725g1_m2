package bai_4_Zoo.service;

import bai_4_Zoo.entity.Bird;
import bai_4_Zoo.repository.BirdRepository;
import bai_4_Zoo.repository.IAnimalRepository;

import java.util.List;

public class BirdService implements IAnimalService<Bird> {
    private static final IAnimalRepository<Bird> birdRepository = new BirdRepository();

    @Override
    public List<Bird> findAll() {
        return birdRepository.findAll();
    }

    @Override
    public boolean add(Bird bird) {
        if (findById(bird.getId()) != null) {
            return false;
        }
        return birdRepository.add(bird);
    }

    @Override
    public boolean deleteById(Bird bird) {
        List<Bird> birds = birdRepository.findAll();
        boolean removed = birds.removeIf(b -> b.getId().equals(bird.getId()));
        if (!removed) {
            return false;
        }
        return ((BirdRepository) birdRepository).writeAll(birds);
    }

    @Override
    public boolean editById(Bird bird) {
        List<Bird> birds = birdRepository.findAll();
        boolean found = false;
        for (int i = 0; i < birds.size(); i++) {
            if (birds.get(i).getId().equals(bird.getId())) {
                birds.set(i, bird);
                found = true;
                break;
            }
        }
        if (!found) {
            return false;
        }
        return ((BirdRepository) birdRepository).writeAll(birds);
    }

    @Override
    public Bird findById(String id) {
        for (Bird bird : birdRepository.findAll()) {
            if (bird.getId().equals(id)) {
                return bird;
            }
        }
        return null;
    }
}

