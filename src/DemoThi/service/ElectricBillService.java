package DemoThi.service;

import DemoThi.entity.ElectricBill;
import DemoThi.entity.ForeignCustomer;
import DemoThi.entity.Person;
import DemoThi.entity.VietnameseCustomer;
import DemoThi.repository.*;

import java.util.ArrayList;
import java.util.List;

public class ElectricBillService implements IElectricBillService<ElectricBill>{
    private static final IElectricBillRepository<ElectricBill> electricBillRepository=new ElectricBillRepository();
    private static final IForeignCustomerRepository<ForeignCustomer> foreignCustomerRepository = new ForeignCustomerRepository();
    private static final IVietnameseCustomerRepository<VietnameseCustomer> vietnameseCustomerRepository = new VietnameseCustomerRepository();
    private static final List<Person> personList = new ArrayList<>();

    @Override
    public List<ElectricBill> findAll() {
        return electricBillRepository.findAll();
    }
    public boolean check(ElectricBill electricBill){
        personList.addAll(foreignCustomerRepository.findAll());
        personList.addAll(vietnameseCustomerRepository.findAll());
        for (Person person: personList){
            if(person.getCustomId().equals(electricBill.getCustomerId())){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean add(ElectricBill electricBill){
        if(check(electricBill)){
            List<ElectricBill> electricBillList = findAll();
            if (electricBillList.isEmpty()) {
                electricBill.setInvoiceId("MHD-001");
            } else {
                ElectricBill endElectricBill = electricBillList.get(electricBillList.size() - 1);
                String[] array = endElectricBill.getInvoiceId().split("-");
                int newId = Integer.parseInt(array[1]) + 1;
                String formattedId = String.format("MHD-%03d", newId);
                electricBill.setInvoiceId(formattedId);
            }

            return electricBillRepository.add(electricBill);
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteById(ElectricBill electricBill) {
        List<ElectricBill> electricBillList= electricBillRepository.findAll();
        boolean check= electricBillList.removeIf(e-> e.getInvoiceId().equals(electricBill.getInvoiceId()));
        if(!check){
            return false;
        }
        return ((ElectricBillRepository) electricBillRepository).writeAll(electricBillList);
    }

    @Override
    public boolean editById(ElectricBill electricBill) {
        if(check(electricBill)){
            List<ElectricBill> electricBillList= electricBillRepository.findAll();
            boolean check= false;
            for (int i = 0; i < electricBillList.size(); i++) {
                if(electricBillList.get(i).getInvoiceId().equals(electricBill.getInvoiceId())){
                    electricBillList.set(i,electricBill);
                    check=true;
                    break;
                }
            }
            if(!check){
                return false;
            }
            return ((ElectricBillRepository) electricBillRepository).writeAll(electricBillList);
        }else {
            return false;
        }
    }
}
