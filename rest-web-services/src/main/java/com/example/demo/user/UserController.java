package com.example.demo.user;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.*;

import javax.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;
	
	//retrive all users
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		
		return service.findAll();
	}
	
	//retrive one user
	@GetMapping("/users/{id}")
	public User retriveOneUser(@PathVariable int id){
	
		
		 User user =service.findOne(id);
		
		 if(user == null)
			 throw new UserNotFoundException("id-"+id);
		 
		 //HATEOAS
		 
		 
		 
		 return user;
		 
	}
	
	//create one user
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser = service.save(user);
		//return status
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
	
		 User user =service.deleteById(id);
		
		 if(user == null)
			 throw new UserNotFoundException("id-"+id);
		
		 
	}
	
	
}
