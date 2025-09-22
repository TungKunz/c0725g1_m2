package Furama.service;

import java.util.List;

public interface IService<T>{
    void add(T t);
    List<T> getList();
    void edit(T t, int index);
    int searchId(String numberPlate);
}
