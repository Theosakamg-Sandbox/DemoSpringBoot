package com.tactfactory.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.tactfactory.spring.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
