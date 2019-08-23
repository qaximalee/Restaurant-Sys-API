package com.balti.restaurant.sys.repositories;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.balti.restaurant.sys.entities.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{
	List<Cart> findByCustomer_CustomerId(@Param(value = "customerId") Long customerId);
}
