package com.balti.restaurant.sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balti.restaurant.sys.entities.Customer;

public interface ItemRepository extends JpaRepository<Customer, Long>{

}
