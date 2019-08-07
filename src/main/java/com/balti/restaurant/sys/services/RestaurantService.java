package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.Restaurant;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	
	private final String NOT_FOUND = "Restaurant not found on :: "; 

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	public List<Restaurant> getAll(){
		return restaurantRepository.findAll();
	}
	
	public ResponseEntity<Restaurant> getSingle(Long id){
		
		Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + id));
		
		return ResponseEntity.ok().body(restaurant);
	}
	
	public Restaurant create(Restaurant restaurant){
		return restaurantRepository.save(restaurant);
	}
	
	public ResponseEntity<Restaurant> update(Long id, Restaurant details){
		Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(NOT_FOUND + id));
		
		restaurant.setName(details.getName());
		restaurant.setDescription(details.getDescription());
		restaurant.setAddress(details.getAddress());
		restaurant.setCity(details.getCity());
		restaurant.setCountry(details.getCountry());
		restaurant.setBranch(details.getBranch());
	    restaurant.setUpdatedAt(new Date());
	    
	    final Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
 	    
	    return ResponseEntity.ok().body(updatedRestaurant);
		
	}
	
	public Map<String, Boolean> delete(Long id){
		Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(NOT_FOUND + id));
		
		restaurantRepository.delete(restaurant);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
		
}
