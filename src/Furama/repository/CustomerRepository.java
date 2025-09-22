package Furama.repository;
import Furama.entity.person.Customer;

import java.util.List;
import java.util.ArrayList;
public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customersList=new ArrayList<>();
    @Override
    public void add(Customer customer) {
        customersList.add(customer);
    }
    @Override
    public List<Customer> getList() {
        return customersList;
    }

    @Override
    public void edit(Customer customer, int index) {
        if(index>=0 && index <= customersList.size()){
            customersList.set(index,customer);
        }
    }

    @Override
    public int searchId(String numberPlate) {
        for (int i = 0; i < customersList.size(); i++) {
            if (customersList.get(i).getIdPerson().equals(numberPlate)){
                return i;
            }

        }
        return -1;
    }
}
