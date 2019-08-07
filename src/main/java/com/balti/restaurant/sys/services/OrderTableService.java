package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.Customer;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.CustomerRepository;

@Service
public class OrderTableService {
	
	private final String NOT_FOUND = "Customer not found on :: "; 

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public List<Customer> getAll(){
		return customerRepository.findAll();
	}
	
	public ResponseEntity<Customer> getSingle(Long id){
		
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + id));
		
		return ResponseEntity.ok().body(customer);
	}
	
	public Customer create(Customer customer){
		return customerRepository.save(customer);
	}
	
	public ResponseEntity<Customer> update(Long id, Customer details){
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(NOT_FOUND + id));
		
		customer.setEmail(details.getEmail());
	    customer.setLastName(details.getLastName());
	    customer.setFirstName(details.getFirstName());
	    customer.setAddress(details.getAddress());
	    customer.setCity(details.getCity());
	    customer.setCountry(details.getCountry());
	    customer.setImageUri(details.getImageUri());
	    customer.setMobileNo(details.getMobileNo());
	    customer.setUpdatedAt(new Date());
	    
	    final Customer updatedCustomer = customerRepository.save(customer);
 	    
	    return ResponseEntity.ok().body(updatedCustomer);
		
	}
	
	public Map<String, Boolean> delete(Long id){
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(NOT_FOUND + id));
		
		customerRepository.delete(customer);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
		
}
