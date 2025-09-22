package Furama.repository;

import java.util.List;

public interface IRepository<T> {
    void add(T t);
    List<T> getList();
    void edit(T t, int index);
    int searchId(String numberPlate);
}
