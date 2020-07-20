package guru.spring.swagger.repositories;

import guru.spring.swagger.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 9/24/17.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerById(Long Id);
    //Customer customerDtoToCustomer(CustomerDTO customerDTO);

}
