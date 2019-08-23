package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.Customer;
import com.balti.restaurant.sys.entities.OrderCustomer;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.CustomerRepository;
import com.balti.restaurant.sys.repositories.OrderRepository;
import com.balti.restaurant.sys.texts.ExceptionStrings;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
		
	
	public List<OrderCustomer> getAll(){
		return orderRepository.findAll();
	}
	
	public ResponseEntity<OrderCustomer> getSingle(Long id){
		
		OrderCustomer order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.ORDER_NOT_FOUND + id));
		
		return ResponseEntity.ok().body(order);
	}
	
	public OrderCustomer create(Long customerId, OrderCustomer order){
		Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.CUSTOMER_NOT_FOUND +customerId));
		
		order.setCustomers(customer);
		
		return orderRepository.save(order);
	}
	
	public ResponseEntity<OrderCustomer> update(Long customerId, Long id, OrderCustomer details){
		OrderCustomer order = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.ORDER_NOT_FOUND + id));
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.CUSTOMER_NOT_FOUND + id));
				
		order.setStatus(details.getStatus());
		order.setBill(details.getBill());
		order.setTableNo(details.getTableNo());
		order.setCustomers(customer);
	    order.setUpdatedAt(new Date());
	    
	    final OrderCustomer updatedOrder = orderRepository.save(order);
 	    
	    return ResponseEntity.ok().body(updatedOrder);
		
	}
	
	public Map<String, Boolean> delete(Long id){
		OrderCustomer order = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.ORDER_NOT_FOUND + id));
		
		orderRepository.delete(order);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
		
}
