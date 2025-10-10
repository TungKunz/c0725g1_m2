package bai_4_Zoo.repository;

import java.util.List;

public interface IAnimalRepository<T>{
    List<T> findAll();
    boolean add (T t);
}
