package Furama.service;

import Furama.entity.Booking;
import Furama.entity.Contract;
import Furama.repository.ContractRepository;
import Furama.repository.IContactRepository;

import java.util.List;
import java.util.Queue;

public class ContactService implements IContactService{
    private static final IContactRepository contractRepository = new ContractRepository();
    private static final IBookingService bookingService = new BookingService();

    @Override
    public Queue<Booking> getBookingQueue() {
        return bookingService.getBookingQueueByOrder();
    }

    @Override
    public boolean addContract(Contract contract) {
        return contractRepository.add(contract);
    }

    @Override
    public List<Contract> findAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public String getIdContract(Contract contract) {
        return contract.getContractId();
    }
}
