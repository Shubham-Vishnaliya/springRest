package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.entity.UserCountByCity;
import com.example.demo.entity.UserCountByDepartment;
import com.example.demo.service.UserService;

@RestController
public class MyController {

	@Autowired
	private UserService service;
	
	@GetMapping("/user")
	public List<User> getAllUser() { 
		return service.getAll();
	}
	
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return service.add(user);
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable String id) {
		return service.update(user, Integer.valueOf(id));
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable String id) {
		return service.getById(Integer.valueOf(id));
	}
	
	@DeleteMapping("/user/{id}")
	public User deleteEmployeeById(@PathVariable String id) {
		return service.delete(Integer.valueOf(id));
	}
	
	@GetMapping("/count_bydept")
	public List<UserCountByDepartment> getUserCountByDepartment() { 
		return service.getUserCountByDepartment();
	}
	
	@GetMapping("/max_count_bycity")
	public UserCountByCity getUserCountByCityt() { 
		return service.getMaxUserCountByCity();
	}
}
