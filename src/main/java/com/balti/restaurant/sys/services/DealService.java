package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.Deal;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.DealRepository;
import com.balti.restaurant.sys.texts.ExceptionStrings;

@Service
public class DealService {

	@Autowired
	private DealRepository dealRepository;
	
	
	public List<Deal> getAll(){
		return dealRepository.findAll();
	}
	
	public ResponseEntity<Deal> getSingle(Long id){
		
		Deal deal = dealRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.DEAL_NOT_FOUND + id));
		
		return ResponseEntity.ok().body(deal);
	}
	
	public Deal create(Deal deal){
		return dealRepository.save(deal);
	}
	
	public ResponseEntity<Deal> update(Long id, Deal details){
		Deal deal = dealRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.DEAL_NOT_FOUND + id));
		
		deal.setName(details.getName());
		deal.setDescription(details.getDescription());
		deal.setPrice(details.getPrice());
	    deal.setUpdatedAt(new Date());
	    
	    final Deal updatedDeal = dealRepository.save(deal);
 	    
	    return ResponseEntity.ok().body(updatedDeal);
		
	}
	
	public Map<String, Boolean> delete(Long id){
		Deal deal = dealRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.DEAL_NOT_FOUND + id));
		
		dealRepository.delete(deal);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
		
}
