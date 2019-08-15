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

import com.balti.restaurant.sys.entities.Brand;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.services.BrandService;

@RestController
@RequestMapping("/brand-api")
public class BrandController {
	  
  @Autowired
  private BrandService brandService;
  
  @GetMapping("/brands")
  public List<Brand> getAllBrands() {
    return brandService.getAll();
  }
  
  @GetMapping("/brands/{brandId}")
  public ResponseEntity<Brand> getBrandById(@PathVariable(value = "brandId") Long brandId)
      throws ResourceNotFoundException {
	  return brandService.getSingle(brandId);
  }
  
  @PostMapping("/brands")
  public Brand createBrand(@Valid @RequestBody Brand brand) {
    return brandService.create(brand);
  }
 
  @PostMapping("/brands/update/{id}")
  public ResponseEntity<Brand> updateBrand(
      @PathVariable(value = "id") Long brandId, @Valid @RequestBody Brand brandDetails)
      throws ResourceNotFoundException {
	  
	  return brandService.update(brandId, brandDetails);
  }
  
  @PostMapping("/brands/delete/{id}")
  public Map<String, Boolean> deleteBrand(@PathVariable(value = "id") Long brandId) throws Exception {
	  return brandService.delete(brandId);
  }
}