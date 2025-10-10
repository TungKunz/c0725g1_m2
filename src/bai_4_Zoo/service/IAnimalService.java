package bai_4_Zoo.service;

import java.util.List;

public interface IAnimalService<T>{
    List<T> findAll();
    boolean add (T t);
    boolean deleteById(T t);
    boolean editById(T t);
    T findById(String id);
}
