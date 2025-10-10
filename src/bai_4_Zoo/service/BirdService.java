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
            System.out.println("ID đã tồn tại!");
            return false;
        }
        return birdRepository.add(bird);
    }

    @Override
    public boolean deleteById(Bird bird) {
        List<Bird> birds = birdRepository.findAll();
        boolean removed = birds.removeIf(b -> b.getId().equals(bird.getId()));
        if (!removed) {
            System.out.println("Không tìm thấy chim cần xóa.");
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
            System.out.println("Không tìm thấy chim để sửa.");
            return false;
        }
        return ((BirdRepository) birdRepository).writeAll(birds);
    }

    @Override
    public Bird findById(String id) {
        for (Bird bird : birdRepository.findAll()) {
            if (bird.getId().equalsIgnoreCase(id)) {
                return bird;
            }
        }
        return null;
    }
}

