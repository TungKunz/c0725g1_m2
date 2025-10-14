package DemoThi.repository;

import DemoThi.entity.ForeignCustomer;

import java.util.List;

public interface IForeignCustomerRepository<ForeignCustomer> extends IPersonRepository<ForeignCustomer>{
    List<String> nationalityList();
}
