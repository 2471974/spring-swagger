package guru.spring.swagger.bootstrap;

import guru.spring.swagger.domain.Category;
import guru.spring.swagger.domain.Customer;
import guru.spring.swagger.repositories.CategoryRepository;
import guru.spring.swagger.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomer();
    }

    private void loadCategories() {

        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("# of Data Loaded = " + categoryRepository.count());
    }

    private void loadCustomer(){

        Customer paul = new Customer();
        paul.setFirstName("Paul");
        paul.setLastName("Newman");
        paul.setCustomer_url("http://www.paul.com");

        Customer tom = new Customer();
        tom.setFirstName("Tom");
        tom.setLastName("Hanks");
        tom.setCustomer_url("http://www.tom.com");

        Customer chris = new Customer();
        chris.setFirstName("Chris");
        chris.setLastName("Evans");
        chris.setCustomer_url("http://www.chris.com");

        Customer leon = new Customer();
        leon.setFirstName("Leonardo");
        leon.setLastName("Decaprio");
        leon.setCustomer_url("http://www.leon.com");

        Customer john = new Customer();
        john.setFirstName("John");
        john.setLastName("Miller");
        john.setCustomer_url("http://www.john.com");

        customerRepository.save(paul);
        customerRepository.save(tom);
        customerRepository.save(chris);
        customerRepository.save(leon);
        customerRepository.save(john);

        System.out.println("# of Customers Loaded = " + customerRepository.count() );

    }
}
