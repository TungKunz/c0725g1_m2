package DemoThi.service;

import DemoThi.entity.ForeignCustomer;

import java.util.List;

public interface IForeignCustomerService<ForeignCustomer> extends IPersonService<ForeignCustomer>{
    List<String> nationalityList();
}
