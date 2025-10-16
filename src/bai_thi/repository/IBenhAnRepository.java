package bai_thi.repository;

import java.util.List;

public interface IBenhAnRepository<T>{
    List<T> findAll();
    boolean add (T t);
}
