package Furama.service;

import Furama.entity.Booking;
import Furama.entity.Contract;

import java.util.List;
import java.util.Queue;

public interface IContactService {
    Queue<Booking> getBookingQueue();

    boolean addContract(Contract contract);

    List<Contract> findAllContracts();

    String getIdContract(Contract contract);
}
