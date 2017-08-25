package com.rockers.api.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rockers.api.model.User;
import com.rockers.api.repository.UserRepository;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Long> saveUser(@RequestBody User user){
		
		 userRepository.save(user);
		return new ResponseEntity<Long>(user.getId(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteUser(@PathVariable Long id){
		
		userRepository.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAll(){
		
		List<User> list = userRepository.findAll();		
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	} 
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<User> findOne(@PathVariable Long id){
		
		User user = userRepository.findOne(id);
		return new ResponseEntity<User> (user,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Long> updateUser(@RequestBody User user){
		
		 userRepository.save(user);
		return new ResponseEntity<Long>(user.getId(), HttpStatus.OK);
		
	}
	
	
}
