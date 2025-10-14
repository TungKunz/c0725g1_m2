package DemoThi.repository;

import java.util.List;


public interface IVietnameseCustomerRepository<VietnameseCustomer> extends IPersonRepository<VietnameseCustomer> {
    List<String> customerTypelist();
}
