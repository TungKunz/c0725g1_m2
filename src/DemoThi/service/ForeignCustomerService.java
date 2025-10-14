package DemoThi.service;

import DemoThi.entity.ForeignCustomer;
import DemoThi.repository.ForeignCustomerRepository;
import DemoThi.repository.IForeignCustomerRepository;



import java.util.List;

public class ForeignCustomerService implements IForeignCustomerService<ForeignCustomer> {
    private static final IForeignCustomerRepository<ForeignCustomer> foreignCustomerRepository = new ForeignCustomerRepository();
    @Override
    public List<ForeignCustomer> findAll() {
        return foreignCustomerRepository.findAll();
    }

    @Override
    public boolean add(ForeignCustomer foreignCustomer) {
        if(findById(foreignCustomer.getCustomId())!=null){
            return false;
        }
        return foreignCustomerRepository.add(foreignCustomer);
    }

    @Override
    public boolean deleteById(ForeignCustomer foreignCustomer) {
        List<ForeignCustomer> foreignCustomerList= foreignCustomerRepository.findAll();
        boolean check= foreignCustomerList.removeIf(nn-> nn.getCustomId().equals(foreignCustomer.getCustomId()));
        if(!check){
            return false;
        }else {
            return ((ForeignCustomerRepository) foreignCustomerRepository).writeAll(foreignCustomerList);
        }
    }

    @Override
    public boolean editById(ForeignCustomer foreignCustomer) {
        List<ForeignCustomer> foreignCustomerList= foreignCustomerRepository.findAll();
        boolean check= false;
        for (int i = 0; i < foreignCustomerList.size(); i++) {
            if(foreignCustomerList.get(i).getCustomId().equals(foreignCustomer.getCustomId())){
                foreignCustomerList.set(i,foreignCustomer);
                check=true;
                break;
            }
        }
        if(!check){
            return false;
        }
        return ((ForeignCustomerRepository) foreignCustomerRepository).writeAll(foreignCustomerList);
    }

    @Override
    public ForeignCustomer findById(String id) {
        List<ForeignCustomer> foreignCustomerList = foreignCustomerRepository.findAll();
        for(ForeignCustomer nn: foreignCustomerList){
            if(nn.getCustomId().equals(id)){
                return nn;
            }
        }
        return null;
    }

    @Override
    public List<String> nationalityList() {
        return foreignCustomerRepository.nationalityList();
    }
}
