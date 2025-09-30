package Furama.service;

import java.util.List;

public interface IService<T>{
    List<T> findAll();
    boolean add (T t);
    boolean deleteById(T t);
    boolean editById(T t);
    T findById(String idPerson);
}
