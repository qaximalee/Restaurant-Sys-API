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

import com.balti.restaurant.sys.entities.ServeTable;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.services.ServeTableService;

@RestController
@RequestMapping("/serveTable-api")
public class ServeTableController {
	  
  @Autowired
  private ServeTableService serveTableService;
  
  @GetMapping("/serveTables")
  public List<ServeTable> getAllServeTables() {
    return serveTableService.getAll();
  }
  
  @GetMapping("/serveTables/{serveTableId}")
  public ResponseEntity<ServeTable> getServeTableById(@PathVariable(value = "serveTableId") Long serveTableId)
      throws ResourceNotFoundException {
	  return serveTableService.getSingle(serveTableId);
  }
  
  @PostMapping("/serveTables/{empId}")
  public ServeTable createServeTable(@PathVariable(value = "empId") Long empId, @Valid @RequestBody ServeTable serveTable) {
    return serveTableService.create(empId, serveTable);
  }
 
  @PostMapping("/serveTables/update/{id}/{empId}")
  public ResponseEntity<ServeTable> updateServeTable(@PathVariable(value = "empId") Long empId,
      @PathVariable(value = "id") Long serveTableId, @Valid @RequestBody ServeTable serveTableDetails)
      throws ResourceNotFoundException {
	  
	  return serveTableService.update(empId, serveTableId, serveTableDetails);
  }
  
  @PostMapping("/serveTables/delete/{id}")
  public Map<String, Boolean> deleteServeTable(@PathVariable(value = "id") Long serveTableId) throws Exception {
	  return serveTableService.delete(serveTableId);
  }
}