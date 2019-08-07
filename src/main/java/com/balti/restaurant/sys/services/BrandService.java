package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.Brand;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.BrandRepository;

@Service
public class BrandService {
	
	private final String NOT_FOUND = "Brand not found on :: "; 

	@Autowired
	private BrandRepository brandRepository;
	
	
	public List<Brand> getAll(){
		return brandRepository.findAll();
	}
	
	public ResponseEntity<Brand> getSingle(Long id){
		
		Brand brand = brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + id));
		
		return ResponseEntity.ok().body(brand);
	}
	
	public Brand create(Brand brand){
		return brandRepository.save(brand);
	}
	
	public ResponseEntity<Brand> update(Long id, Brand details){
		Brand brand = brandRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(NOT_FOUND + id));
		
		brand.setName(details.getName());
		brand.setDescription(details.getDescription());
		brand.setUpdatedAt(new Date());
	    
	    final Brand updatedBrand = brandRepository.save(brand);
 	    
	    return ResponseEntity.ok().body(updatedBrand);
		
	}
	
	public Map<String, Boolean> delete(Long id){
		Brand brand = brandRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(NOT_FOUND + id));
		
		brandRepository.delete(brand);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
		
}
