package Furama.repository;

import Furama.entity.Contract;



import java.util.List;
import java.util.ArrayList;


public class ContractRepository implements IContactRepository{
    private static final List<Contract> contractList = new ArrayList<>();
//    static {
//        contractList.add(new Contract("C001", "B001", 1000, 5000));
//        contractList.add(new Contract("C002", "B002", 2000, 8000));
//        contractList.add(new Contract("C003", "B003", 1500, 6000));
//    }

    @Override
    public boolean add(Contract contract) {
        return contractList.add(contract);
    }


    @Override
    public Contract findById(String id) {
        for (Contract c : contractList) {
            if (c.getContractId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean edit(Contract contract) {
        for (int i = 0; i < contractList.size(); i++) {
            if (contractList.get(i).getContractId().equals(contract.getContractId())) {
                contractList.set(i, contract);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Contract> findAll() {
        return new ArrayList<>(contractList);
    }
}
