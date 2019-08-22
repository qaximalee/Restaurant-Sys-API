package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.Brand;
import com.balti.restaurant.sys.entities.Cart;
import com.balti.restaurant.sys.entities.Customer;
import com.balti.restaurant.sys.entities.Deal;
import com.balti.restaurant.sys.entities.Item;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.CartRepository;
import com.balti.restaurant.sys.repositories.CustomerRepository;
import com.balti.restaurant.sys.repositories.DealRepository;
import com.balti.restaurant.sys.repositories.ItemRepository;
import com.balti.restaurant.sys.texts.ExceptionStrings;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private DealRepository dealRepository;
		
	public List<Cart> getAll(Long customerId){
		Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.CUSTOMER_NOT_FOUND + customerId));
		
		return cartRepository.findAllByCustomer(customer);
	}
	
	/*public ResponseEntity<Cart> getSingle(Long id){
		
		Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + id));
		
		return ResponseEntity.ok().body(cart);
	}*/
	
	public Cart create(Long itemId, Long dealId, Long customerId, @Valid Cart cart) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.CUSTOMER_NOT_FOUND + customerId));
		Item item = null;
		Deal deal= null;
		
		if(itemId != 0){
			item = itemRepository.findById(itemId).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.ITEM_NOT_FOUND + itemId));
		}
		
		if(dealId != 0){
			deal = dealRepository.findById(dealId).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.DEAL_NOT_FOUND + dealId));
		}
		
		
		cart.setDeal(deal);
		cart.setItem(item);
		cart.setCustomer(customer);
		return cartRepository.save(cart);
	}
	
	/*public ResponseEntity<Cart> update(Long id, Cart details){
		Cart cart = cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(NOT_FOUND + id));
		
		cart.setUpdatedAt(new Date());
	    
	    final Cart updatedCart = cartRepository.save(cart);
 	    
	    return ResponseEntity.ok().body(updatedCart);
		
	}*/
	
	public Map<String, Boolean> delete(Long id){
		Cart cart = cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.CART_NOT_FOUND + id));
		
		cartRepository.delete(cart);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}

	
		
}
