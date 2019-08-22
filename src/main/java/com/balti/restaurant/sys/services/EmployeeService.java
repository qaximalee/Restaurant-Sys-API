package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.Employee;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.EmployeeRepository;
import com.balti.restaurant.sys.texts.ExceptionStrings;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	
	public ResponseEntity<Employee> getSingle(Long id){
		
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.EMPLOYEE_NOT_FOUND + id));
		
		return ResponseEntity.ok().body(employee);
	}
	
	public Employee create(Employee employee){
		return employeeRepository.save(employee);
	}
	
	public ResponseEntity<Employee> update(Long id, Employee details){
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.EMPLOYEE_NOT_FOUND + id));
		
		employee.setName(details.getName());
		employee.setDesignation(details.getDesignation());
		employee.setSalary(details.getSalary());
	    employee.setUpdatedAt(new Date());
	    
	    final Employee updatedEmployee = employeeRepository.save(employee);
 	    
	    return ResponseEntity.ok().body(updatedEmployee);
		
	}
	
	public Map<String, Boolean> delete(Long id){
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.EMPLOYEE_NOT_FOUND + id));
		
		employeeRepository.delete(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
		
}
