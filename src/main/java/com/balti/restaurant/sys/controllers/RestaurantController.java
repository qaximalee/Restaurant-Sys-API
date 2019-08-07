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

import com.balti.restaurant.sys.entities.Restaurant;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.services.RestaurantService;

@RestController
@RequestMapping("/restaurant-api")
public class RestaurantController {
	  
  @Autowired
  private RestaurantService restaurantService;
  
  @GetMapping("/restaurants")
  public List<Restaurant> getAllUsers() {
    return restaurantService.getAll();
  }
  
  @GetMapping("/restaurants/{restaurantId}")
  public ResponseEntity<Restaurant> getUsersById(@PathVariable(value = "restaurantId") Long restaurantId)
      throws ResourceNotFoundException {
	  return restaurantService.getSingle(restaurantId);
  }
  
  @PostMapping("/restaurants")
  public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant) {
    return restaurantService.create(restaurant);
  }
 
  @PostMapping("/restaurants/update/{id}")
  public ResponseEntity<Restaurant> updateRestaurant(
      @PathVariable(value = "id") Long restaurantId, @Valid @RequestBody Restaurant restaurantDetails)
      throws ResourceNotFoundException {
	  
	  return restaurantService.update(restaurantId, restaurantDetails);
  }
  
  @PostMapping("/restaurants/delete/{id}")
  public Map<String, Boolean> deleteRestaurant(@PathVariable(value = "id") Long restaurantId) throws Exception {
	  return restaurantService.delete(restaurantId);
  }
}