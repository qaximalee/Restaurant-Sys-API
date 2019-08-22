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

import com.balti.restaurant.sys.entities.Item;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.services.ItemService;

@RestController
@RequestMapping("/item-api")
public class ItemController {
	  
  @Autowired
  private ItemService itemService;
  
  @GetMapping("/items")
  public List<Item> getAllItems() {
    return itemService.getAll();
  }
  
  @GetMapping("/items/{itemId}")
  public ResponseEntity<Item> getItemById(@PathVariable(value = "itemId") Long itemId)
      throws ResourceNotFoundException {
	  return itemService.getSingle(itemId);
  }
  
  @PostMapping("/items/{brandId}/{categoryId}/{dealId}")
  public Item createItem(@PathVariable(value = "brandId") Long brandId,
		  @PathVariable(value = "categoryId") Long categoryId,
		  @PathVariable(value = "dealId") Long dealId, @Valid @RequestBody Item item) {
    return itemService.create(brandId, categoryId, dealId, item);
  }
 
  @PostMapping("/items/update/{brandId}/{categoryId}/{dealId}/{id}")
  public ResponseEntity<Item> updateItem(@PathVariable(value = "brandId") Long brandId,
		  @PathVariable(value = "categoryId") Long categoryId,
		  @PathVariable(value = "dealId") Long dealId,
		  @PathVariable(value = "id") Long itemId, @Valid @RequestBody Item itemDetails)
      throws ResourceNotFoundException {
	  
	  return itemService.update(brandId, categoryId, dealId, itemId, itemDetails);
  }
  
  @PostMapping("/items/delete/{id}")
  public Map<String, Boolean> deleteItem(@PathVariable(value = "id") Long itemId) throws Exception {
	  return itemService.delete(itemId);
  }
}