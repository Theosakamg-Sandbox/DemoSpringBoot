package com.tactfactory.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tactfactory.spring.entity.Address;
import com.tactfactory.spring.entity.Customer;
import com.tactfactory.spring.repository.AddressRepository;
import com.tactfactory.spring.repository.CustomerRepository;

@SpringBootApplication
public class Application {

    private static final Logger log =
            LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository, AddressRepository repoA) {
        return (args) -> {
            repository.deleteAll();

            Customer customer = new Customer("Mickael", "Gaillard");
            Address add1 = new Address("Toto");
            repoA.save(add1);
            customer.setAddresse(add1);
            add1.getCustomers().add(customer);
            Address add2 = new Address("Titi");
            repoA.save(add2);
            customer.setAddresse(add2);
            add2.getCustomers().add(customer);
            repository.save(customer);

            customer = new Customer("Gaillard", "mickael");
            customer.setAddresse(add2);
            add2.getCustomers().add(customer);
            repository.save(customer);


            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer cus : repository.findAll()) {
                log.info(cus.toString());
            }
            log.info("");

            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            customer = repository.findOne(1L);
            log.info(customer.toString());
            log.info("");

            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (Customer bauer : repository.findByLastName("Bauer")) {
                log.info(bauer.toString());
            }

        };

    }

}
