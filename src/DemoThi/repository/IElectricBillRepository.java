package DemoThi.repository;

import java.util.List;

public interface IElectricBillRepository<T> {
    List<T> findAll();
    boolean add (T t);
}
