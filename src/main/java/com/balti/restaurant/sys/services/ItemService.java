package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.Brand;
import com.balti.restaurant.sys.entities.Category;
import com.balti.restaurant.sys.entities.Deal;
import com.balti.restaurant.sys.entities.Item;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.BrandRepository;
import com.balti.restaurant.sys.repositories.CategoryRepository;
import com.balti.restaurant.sys.repositories.DealRepository;
import com.balti.restaurant.sys.repositories.ItemRepository;
import com.balti.restaurant.sys.texts.ExceptionStrings;

@Service
public class ItemService {
	
	Brand brand = null;
	Category category = null;
	Deal deal = null;

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private DealRepository dealRepository;
	
	public List<Item> getAll(){
		return itemRepository.findAll();
	}
	
	public ResponseEntity<Item> getSingle(Long id){
		
		Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.ITEM_NOT_FOUND + id));
		
		return ResponseEntity.ok().body(item);
	}
	
	public Item create(Long brandId, Long categoryId, Long dealId, Item item){
		
		checkAndInitialize(brandId, categoryId, dealId);
		
		item.setBrand(brand);
		brand = null;
		item.setCategory(category);
		category = null;
		item.setDeal(deal);
		deal = null;
				
		return itemRepository.save(item);
	}
	
	public ResponseEntity<Item> update(Long brandId, Long categoryId, Long dealId, Long id, Item details){
		Item item = itemRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.ITEM_NOT_FOUND + id));
		
		checkAndInitialize(brandId, categoryId, dealId);
		
		item.setBrand(brand);
		brand = null;
		item.setCategory(category);
		category = null;
		item.setDeal(deal);
		deal = null;
				
	    item.setUpdatedAt(new Date());
	    
	    final Item updatedItem = itemRepository.save(item);
 	    
	    return ResponseEntity.ok().body(updatedItem);
		
	}
	
	public Map<String, Boolean> delete(Long id){
		Item item = itemRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.ITEM_NOT_FOUND + id));
		
		itemRepository.delete(item);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}		
	
	private void checkAndInitialize(Long brandId, Long categoryId, Long dealId){
		if(brandId != 0){
			brand = brandRepository.findById(brandId).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.BRAND_NOT_FOUND + brandId));
		}
		
		if(categoryId != 0){
			category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.CATEGORY_NOT_FOUND + categoryId));
		}
		
		if(dealId != 0){
			deal = dealRepository.findById(dealId).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.DEAL_NOT_FOUND + dealId));
		}
	}
}
