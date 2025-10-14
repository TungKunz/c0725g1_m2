package DemoThi.service;

import java.util.List;

public interface IElectricBillService<T>{
    List<T> findAll();
    boolean add (T t);
    boolean deleteById(T t);
    boolean editById(T t);
//    T findById(int id);
}
