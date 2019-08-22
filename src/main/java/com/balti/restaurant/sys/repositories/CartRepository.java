package com.balti.restaurant.sys.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balti.restaurant.sys.entities.Cart;
import com.balti.restaurant.sys.entities.Customer;

public interface CartRepository extends JpaRepository<Cart, Long>{
	public List<Cart> findAllByCustomer(Customer customer); 
}
