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

import com.balti.restaurant.sys.entities.Category;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.services.CategoryService;

@RestController
@RequestMapping("/category-api")
public class CategoryController {
	  
  @Autowired
  private CategoryService categoryService;
  
  @GetMapping("/categories")
  public List<Category> getAllCategories() {
    return categoryService.getAll();
  }
  
  @GetMapping("/categories/{categoryId}")
  public ResponseEntity<Category> getCategoryById(@PathVariable(value = "categoryId") Long categoryId)
      throws ResourceNotFoundException {
	  return categoryService.getSingle(categoryId);
  }
  
  @PostMapping("/categories")
  public Category createCategory(@Valid @RequestBody Category category) {
    return categoryService.create(category);
  }
 
  @PostMapping("/categories/update/{id}")
  public ResponseEntity<Category> updateCategory(
      @PathVariable(value = "id") Long categoryId, @Valid @RequestBody Category categoryDetails)
      throws ResourceNotFoundException {
	  
	  return categoryService.update(categoryId, categoryDetails);
  }
  
  @PostMapping("/categories/delete/{id}")
  public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Long categoryId) throws Exception {
	  return categoryService.delete(categoryId);
  }
}