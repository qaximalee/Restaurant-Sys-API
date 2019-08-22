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

import com.balti.restaurant.sys.entities.Cart;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.services.CartService;

@RestController
@RequestMapping("/cart-api")
public class CartController {
	  
  @Autowired
  private CartService cartService;
  
  @GetMapping("/carts/{customerId}")
  public List<Cart> getAllCarts(@PathVariable(value = "customerId") Long customerId) {
    return cartService.getAll(customerId);
  }
  
  /*@GetMapping("/carts/{cartId}")
  public ResponseEntity<Cart> getCartById(@PathVariable(value = "cartId") Long cartId)
      throws ResourceNotFoundException {
	  return cartService.getSingle(cartId);
  }*/
  
  @PostMapping("/carts/{itemId}/{dealId}/{customerId}")
  public Cart createCart(@PathVariable(value = "itemId") Long itemId,
		  @PathVariable(value = "dealId") Long dealId,
		  @PathVariable(value = "customerId") Long customerId, @Valid @RequestBody Cart cart) {
    return cartService.create(itemId, dealId, customerId, cart);
  }
 
  /*@PostMapping("/carts/update/{id}")
  public ResponseEntity<Cart> updateCart(
      @PathVariable(value = "id") Long cartId, @Valid @RequestBody Cart cartDetails)
      throws ResourceNotFoundException {
	  
	  return cartService.update(cartId, cartDetails);
  }*/
  
  @PostMapping("/carts/delete/{id}")
  public Map<String, Boolean> deleteCart(@PathVariable(value = "id") Long cartId) throws Exception {
	  return cartService.delete(cartId);
  }
}