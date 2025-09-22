package Furama.service;

import Furama.entity.person.Customer;
import Furama.repository.CustomerRepository;
import Furama.repository.IRepository;

import java.util.List;

public class CustomerService implements IService<Customer>{
    private IRepository<Customer> customerIRepository = new CustomerRepository();

    @Override
    public void add(Customer customer) {
        customerIRepository.add(customer);
    }

    @Override
    public List<Customer> getList() {
        return customerIRepository.getList();
    }

    @Override
    public void edit(Customer customer, int index) {
        customerIRepository.edit(customer,index);
    }

    @Override
    public int searchId(String numberPlate) {
        return customerIRepository.searchId(numberPlate);
    }
}
