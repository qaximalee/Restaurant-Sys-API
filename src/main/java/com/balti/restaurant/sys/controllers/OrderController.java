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

import com.balti.restaurant.sys.entities.OrderCustomer;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.services.OrderService;

@RestController
@RequestMapping("/order-api")
public class OrderController {
	  
  @Autowired
  private OrderService orderService;
  
  @GetMapping("/orders")
  public List<OrderCustomer> getAllOrders() {
    return orderService.getAll();
  }
  
  @GetMapping("/orders/{orderId}")
  public ResponseEntity<OrderCustomer> getOrderById(@PathVariable(value = "orderId") Long orderId)
      throws ResourceNotFoundException {
	  return orderService.getSingle(orderId);
  }
  
  @PostMapping("/orders/{customerId}")
  public OrderCustomer createOrder(@PathVariable(value = "customerId") Long customerId, @Valid @RequestBody OrderCustomer order) {
    return orderService.create(customerId,order);
  }
 
  @PostMapping("/orders/update/{customerId}/{id}")
  public ResponseEntity<OrderCustomer> updateOrder(@PathVariable(value = "customerId") Long customerId,
      @PathVariable(value = "id") Long orderId, @Valid @RequestBody OrderCustomer orderDetails)
      throws ResourceNotFoundException {
	  
	  return orderService.update(customerId, orderId, orderDetails);
  }
  
  @PostMapping("/orders/delete/{id}")
  public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId) throws Exception {
	  return orderService.delete(orderId);
  }
}