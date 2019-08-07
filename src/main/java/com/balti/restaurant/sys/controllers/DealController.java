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

import com.balti.restaurant.sys.entities.Deal;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.services.DealService;

@RestController
@RequestMapping("/deal-api")
public class DealController {
	  
  @Autowired
  private DealService dealService;
  
  @GetMapping("/deals")
  public List<Deal> getAllUsers() {
    return dealService.getAll();
  }
  
  @GetMapping("/deals/{dealId}")
  public ResponseEntity<Deal> getUsersById(@PathVariable(value = "dealId") Long dealId)
      throws ResourceNotFoundException {
	  return dealService.getSingle(dealId);
  }
  
  @PostMapping("/deals")
  public Deal createDeal(@Valid @RequestBody Deal deal) {
    return dealService.create(deal);
  }
 
  @PostMapping("/deals/update/{id}")
  public ResponseEntity<Deal> updateDeal(
      @PathVariable(value = "id") Long dealId, @Valid @RequestBody Deal dealDetails)
      throws ResourceNotFoundException {
	  
	  return dealService.update(dealId, dealDetails);
  }
  
  @PostMapping("/deals/delete/{id}")
  public Map<String, Boolean> deleteDeal(@PathVariable(value = "id") Long dealId) throws Exception {
	  return dealService.delete(dealId);
  }
}