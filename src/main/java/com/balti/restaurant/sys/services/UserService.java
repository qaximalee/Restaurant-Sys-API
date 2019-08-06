package com.balti.restaurant.sys.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balti.restaurant.sys.entities.User;
import com.balti.restaurant.sys.exceptions.ResourceNotFoundException;
import com.balti.restaurant.sys.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public ResponseEntity<User> getSingle(Long id){
		User user =
		        userRepository
		            .findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		
		return ResponseEntity.ok().body(user);
	}
	
	public User create(User user){
		return userRepository.save(user);
	}
	
	public ResponseEntity<User> update(Long id, User details){
		User user =
		        userRepository
		            .findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		    user.setEmail(details.getEmail());
		    user.setLastName(details.getLastName());
		    user.setFirstName(details.getFirstName());
		    user.setUpdatedAt(new Date());
		    user.setUpdatedBy(details.getUpdatedBy());
		    final User updatedUser = userRepository.save(user);
		    return ResponseEntity.ok(updatedUser);
	}
	
	public Map<String, Boolean> delete(Long id){
		User user =
		        userRepository
		            .findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		    userRepository.delete(user);
		    Map<String, Boolean> response = new HashMap<>();
		    response.put("deleted", Boolean.TRUE);
		    return response;
	}
}
