package com.balti.restaurant.sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balti.restaurant.sys.entities.Customer;
import com.balti.restaurant.sys.entities.OrderCustomer;

public interface OrderRepository extends JpaRepository<OrderCustomer, Long>{

}
