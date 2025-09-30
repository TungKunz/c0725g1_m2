package Furama.service;

import Furama.entity.person.Customer;
import Furama.repository.CustomerRepository;
import Furama.repository.IRepository;

import java.util.List;

public class CustomerService implements IService<Customer>{
    private final IRepository<Customer> customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean add(Customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public boolean deleteById(Customer customer) {
        Customer checkCustomer = customerRepository.findById(customer.getIdPerson());
        if(checkCustomer == null){
            return false;
        }
        return customerRepository.deleteById(customer);
    }

    @Override
    public boolean editById(Customer customer) {
        Customer checkCustomer= customerRepository.findById(customer.getIdPerson());
        if(checkCustomer!= null){
            return false;
        }
        return customerRepository.editById(customer);
    }

    @Override
    public Customer findById(String idPerson) {
        return customerRepository.findById(idPerson);
    }
}
