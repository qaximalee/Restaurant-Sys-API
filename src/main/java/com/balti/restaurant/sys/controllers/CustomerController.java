package com.balti.restaurant.sys.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balti.restaurant.sys.entities.Customer;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.services.CustomerService;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {
	  
  @Autowired
  private CustomerService customerService;
  
  @GetMapping("/customers")
  public List<Customer> getAllCustomers() {
    return customerService.getAll();
  }
  
  @GetMapping("/customers/{customerId}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "customerId") Long customerId)
      throws ResourceNotFoundException {
	  return customerService.getSingle(customerId);
  }
  
  @PostMapping("/customers")
  public Customer createCustomer(@Valid @RequestBody Customer customer) {
    return customerService.create(customer);
  }
 
  @PostMapping("/customers/update/{id}")
  public ResponseEntity<Customer> updateCustomer(
      @PathVariable(value = "id") Long customerId, @Valid @RequestBody Customer customerDetails)
      throws ResourceNotFoundException {
	  
	  return customerService.update(customerId, customerDetails);
  }
  
  @PostMapping("/customers/delete/{id}")
  public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId) throws Exception {
	  return customerService.delete(customerId);
  }
}