package guru.spring.swagger.services;

import guru.spring.swagger.api.v1.mapper.CustomerMapper;
import guru.spring.swagger.api.v1.model.CustomerDTO;
import guru.spring.swagger.domain.Customer;
import guru.spring.swagger.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomer_det("/api/v1/customers/" + customer.getId());
                    return customerDTO;
                    })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long Id) {
        return customerRepository.findById(Id)
                .map(customerMapper::customerToCustomerDTO)
                .orElseThrow(RuntimeException::new);
        //return customerMapper.customerToCustomerDTO(customerRepository.findCustomerById(Id));
    }

    /*
    @Override
    public  CustomerDTO createNewCustomer(CustomerDTO customerDTO){

        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnCustomerDto = customerMapper.customerToCustomerDTO(savedCustomer);
        returnCustomerDto.setCustomer_det("/api/v1/customers/" + savedCustomer.getId());
        return returnCustomerDto;

    }    */


    @Override
    public  CustomerDTO createNewCustomer(CustomerDTO customerDTO){
        return saveCustomer(customerMapper.customerDtoToCustomer(customerDTO));
    }

    @Override
    public  CustomerDTO postCustomer(Long Id, CustomerDTO customerDTO){
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        customer.setId(Id);
        return saveCustomer(customer);
    }

    @Override
    public  CustomerDTO patchCustomer(Long Id, CustomerDTO customerDTO){

        return customerRepository.findById(Id).map(customer -> {

            if(customerDTO.getFirstName() != null){
                customer.setFirstName(customerDTO.getFirstName());
            }
            if(customerDTO.getLastName() != null){
                customer.setLastName(customerDTO.getLastName());
            }
            if(customerDTO.getCustomer_url() != null){
                customer.setCustomer_url(customerDTO.getCustomer_url());
            }
            CustomerDTO returnDto = customerMapper.customerToCustomerDTO(customerRepository.save(customer));
            returnDto.setCustomer_det("/api/v1/customer/" + Id);
            return returnDto;

        }).orElseThrow(RuntimeException::new); //todo implement better exception handling;
    }

    @Override
    public void deleteCustomer(Long custid) {
        customerRepository.deleteById(custid);
    }

    //LOCAL METHOD USED BY IMPLEMENTATION METHODS ABOVE
    public  CustomerDTO saveCustomer(Customer customer){
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnCustomerDto = customerMapper.customerToCustomerDTO(savedCustomer);
        returnCustomerDto.setCustomer_det("/api/v1/customers/" + savedCustomer.getId());
        return returnCustomerDto;

    }

}
