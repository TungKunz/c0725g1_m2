package DemoThi.service;

import java.util.List;

public interface IPersonService<T>{
    List<T> findAll();
    boolean add (T t);
    boolean deleteById(T t);
    boolean editById(T t);
    T findById(String id);
}
