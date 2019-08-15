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

import com.balti.restaurant.sys.entities.Employee;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.services.EmployeeService;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController {
	  
  @Autowired
  private EmployeeService employeeService;
  
  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return employeeService.getAll();
  }
  
  @GetMapping("/employees/{employeeId}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "employeeId") Long employeeId)
      throws ResourceNotFoundException {
	  return employeeService.getSingle(employeeId);
  }
  
  @PostMapping("/employees")
  public Employee createEmployee(@Valid @RequestBody Employee employee) {
    return employeeService.create(employee);
  }
 
  @PostMapping("/employees/update/{id}")
  public ResponseEntity<Employee> updateEmployee(
      @PathVariable(value = "id") Long employeeId, @Valid @RequestBody Employee employeeDetails)
      throws ResourceNotFoundException {
	  
	  return employeeService.update(employeeId, employeeDetails);
  }
  
  @PostMapping("/employees/delete/{id}")
  public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws Exception {
	  return employeeService.delete(employeeId);
  }
}