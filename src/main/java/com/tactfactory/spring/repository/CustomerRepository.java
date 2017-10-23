package com.tactfactory.spring.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.tactfactory.spring.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
