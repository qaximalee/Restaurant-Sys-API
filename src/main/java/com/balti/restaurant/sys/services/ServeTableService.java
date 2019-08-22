package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.Employee;
import com.balti.restaurant.sys.entities.ServeTable;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.EmployeeRepository;
import com.balti.restaurant.sys.repositories.ServeTableRepository;
import com.balti.restaurant.sys.texts.ExceptionStrings;

@Service
public class ServeTableService {
	
	@Autowired
	private ServeTableRepository serveTableRepository;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	public List<ServeTable> getAll(){
		return serveTableRepository.findAll();
	}
	
	public ResponseEntity<ServeTable> getSingle(Long id){
		
		ServeTable serveTable = serveTableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.SERVE_TABLE_NOT_FOUND + id));
		
		return ResponseEntity.ok().body(serveTable);
	}
	
	public ServeTable create(Long empId, ServeTable serveTable){
		
		Employee emp = empRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.EMPLOYEE_NOT_FOUND + empId));
		
		serveTable.setEmployee(emp);
				
		return serveTableRepository.save(serveTable);
	}
	
	public ResponseEntity<ServeTable> update(Long empId, Long id, ServeTable details){
		ServeTable serveTable = serveTableRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.SERVE_TABLE_NOT_FOUND + id));
		
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException(ExceptionStrings.EMPLOYEE_NOT_FOUND+ empId));
		
		serveTable.setFloor(details.getFloor());
		serveTable.setBlock(details.getBlock());
		serveTable.setTableNo(details.getTableNo());
		serveTable.setEmployee(emp);
		
	    serveTable.setUpdatedAt(new Date());
	    
	    final ServeTable updatedServeTable = serveTableRepository.save(serveTable);
 	    
	    return ResponseEntity.ok().body(updatedServeTable);
		
	}
	
	public Map<String, Boolean> delete(Long id){
		ServeTable serveTable = serveTableRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ExceptionStrings.SERVE_TABLE_NOT_FOUND + id));
		
		serveTableRepository.delete(serveTable);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
		
}
