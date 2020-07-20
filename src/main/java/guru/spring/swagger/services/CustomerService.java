package guru.spring.swagger.services;

import guru.spring.swagger.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long Id);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO postCustomer(Long Id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long custid, CustomerDTO customerDTO);

    void deleteCustomer(Long custid);

    //CustomerDTO saveCustomer(Customer customer);



}
