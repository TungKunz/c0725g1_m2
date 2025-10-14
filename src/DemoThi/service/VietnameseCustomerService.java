package DemoThi.service;

import DemoThi.entity.VietnameseCustomer;
import DemoThi.repository.IVietnameseCustomerRepository;
import DemoThi.repository.VietnameseCustomerRepository;


import java.util.List;

public class VietnameseCustomerService implements IVietnameseCustomerService<VietnameseCustomer> {
    private static final IVietnameseCustomerRepository<VietnameseCustomer> vietnameseCustomerRepository = new VietnameseCustomerRepository();

    @Override
    public List<VietnameseCustomer> findAll() {
        return vietnameseCustomerRepository.findAll();
    }

    @Override
    public boolean add(VietnameseCustomer vietnameseCustomer) {
        if(findById(vietnameseCustomer.getCustomId())!=null){
            return false;
        }
        return vietnameseCustomerRepository.add(vietnameseCustomer);
    }

    @Override
    public boolean deleteById(VietnameseCustomer vietnameseCustomer) {
        List<VietnameseCustomer> vietnameseCustomerList = vietnameseCustomerRepository.findAll();
        boolean check=vietnameseCustomerList.removeIf(vn->vn.getCustomId().equals(vietnameseCustomer.getCustomId()));
        if(!check){
            return false;
        }else {
            return ((VietnameseCustomerRepository) vietnameseCustomerRepository).writeAll(vietnameseCustomerList);
        }
    }

    @Override
    public boolean editById(VietnameseCustomer vietnameseCustomer) {
        List<VietnameseCustomer> vietnameseCustomerList = vietnameseCustomerRepository.findAll();
        boolean check= false;
        for (int i = 0; i < vietnameseCustomerList.size(); i++) {
            if(vietnameseCustomerList.get(i).getCustomId().equals(vietnameseCustomer.getCustomId())){
                vietnameseCustomerList.set(i,vietnameseCustomer);
                check=true;
                break;
            }
        }
        if(!check){
            return false;
        }else {
            return ((VietnameseCustomerRepository) vietnameseCustomerRepository).writeAll(vietnameseCustomerList);
        }
    }

    @Override
    public VietnameseCustomer findById(String id) {
        List<VietnameseCustomer> vietnameseCustomerList= vietnameseCustomerRepository.findAll();
        for (VietnameseCustomer vn: vietnameseCustomerList){
            if(vn.getCustomId().equals(id)){
                return vn;
            }
        }
        return null;
    }

    @Override
    public List<String> customerTypelist() {
        return vietnameseCustomerRepository.customerTypelist();
    }
}
