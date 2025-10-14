package DemoThi.service;

import DemoThi.entity.ElectricBill;
import DemoThi.repository.ElectricBillRepository;
import DemoThi.repository.IElectricBillRepository;

import java.util.List;

public class ElectricBillService implements IElectricBillService<ElectricBill>{
    private static final IElectricBillRepository<ElectricBill> electricBillRepository=new ElectricBillRepository();

    @Override
    public List<ElectricBill> findAll() {
        return electricBillRepository.findAll();
    }

    @Override
    public boolean add(ElectricBill electricBill) {
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
    }
}
