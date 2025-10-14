package DemoThi.repository;

import java.util.List;

public interface IPersonRepository<T>{
    List<T> findAll();
    boolean add (T t);
}
