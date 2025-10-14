package DemoThi.service;

import DemoThi.entity.VietnameseCustomer;

import java.util.List;
import java.util.Map;

public interface IVietnameseCustomerService<VietnameseCustomer> extends IPersonService<VietnameseCustomer> {
    List<String> customerTypelist();
}
