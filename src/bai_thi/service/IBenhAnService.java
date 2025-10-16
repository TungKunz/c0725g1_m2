package bai_thi.service;

import java.util.List;

public interface IBenhAnService <T>{
    List<T> findAll();
    boolean add(T t);
    boolean remove(T t);
    T findById(String id);
}
