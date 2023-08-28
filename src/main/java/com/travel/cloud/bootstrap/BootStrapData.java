package com.travel.cloud.bootstrap;

import com.travel.cloud.dao.CustomerRepository;
import com.travel.cloud.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) {
        Date currentDate = new Date(); // Current date for default values
        int newCustomersCount = 0; // Counter for new customers

        if (customerRepository.findByFirstNameAndLastName("Tom", "Jerry").isEmpty()) {
            Customer customer1 = new Customer("123 Easy St", currentDate, "Tom", "Jerry", currentDate, "(555)555-5555", "55555");
            customerRepository.save(customer1);
            newCustomersCount++;
        }

        if (customerRepository.findByFirstNameAndLastName("Jane", "Smith").isEmpty()) {
            Customer customer2 = new Customer("456 Oak Ave", currentDate, "Jane", "Smith", currentDate, "(555)555-5556", "55556");
            customerRepository.save(customer2);
            newCustomersCount++;
        }

        if (customerRepository.findByFirstNameAndLastName("Michael", "Johnson").isEmpty()) {
            Customer customer3 = new Customer("789 Maple Rd", currentDate, "Michael", "Johnson", currentDate, "(555)555-5557", "55557");
            customerRepository.save(customer3);
            newCustomersCount++;
        }

        if (customerRepository.findByFirstNameAndLastName("Emily", "Williams").isEmpty()) {
            Customer customer4 = new Customer("987 Elm St", currentDate, "Emily", "Williams", currentDate, "(555)555-5558", "55558");
            customerRepository.save(customer4);
            newCustomersCount++;
        }

        if (customerRepository.findByFirstNameAndLastName("David", "Brown").isEmpty()) {
            Customer customer5 = new Customer("654 Pine Dr", currentDate, "David", "Brown", currentDate, "(555)555-5559", "55559");
            customerRepository.save(customer5);
            newCustomersCount++;
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of New Customers Added: " + newCustomersCount);
        System.out.println("Number of Customers: " + customerRepository.count());
    }
}
