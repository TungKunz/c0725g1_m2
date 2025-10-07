package Furama.repository;
import Furama.entity.Booking;
import Furama.entity.Contract;

import java.util.List;
import java.util.ArrayList;
public interface IContactRepository {
    boolean add(Contract contract);
    Contract findById(String id);
    boolean edit(Contract contract);
    List<Contract> findAll();
}
