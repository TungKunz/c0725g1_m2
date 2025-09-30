package Furama.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    boolean add (T t);
    boolean deleteById(T t);
    boolean editById(T t);
    T findById(String idPerson);
}
