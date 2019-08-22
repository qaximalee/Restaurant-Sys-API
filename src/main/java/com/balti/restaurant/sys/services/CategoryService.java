package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.Category;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.CategoryRepository;
import com.balti.restaurant.sys.texts.ExceptionStrings;

@Service
public class CategoryService { 

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<Category> getAll(){
		return categoryRepository.findAll();
	}
	
	public ResponseEntity<Category> getSingle(Long id){
		
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.CATEGORY_NOT_FOUND + id));
		
		return ResponseEntity.ok().body(category);
	}
	
	public Category create(Category category){
		return categoryRepository.save(category);
	}
	
	public ResponseEntity<Category> update(Long id, Category details){
		Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.CATEGORY_NOT_FOUND + id));
		
		category.setName(details.getName());
		category.setDescription(details.getDescription());
	    category.setUpdatedAt(new Date());
	    
	    final Category updatedCategory = categoryRepository.save(category);
 	    
	    return ResponseEntity.ok().body(updatedCategory);
		
	}
	
	public Map<String, Boolean> delete(Long id){
		Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.CATEGORY_NOT_FOUND + id));
		
		categoryRepository.delete(category);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
		
}
