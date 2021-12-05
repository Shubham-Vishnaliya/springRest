package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.entity.UserCountByCity;
import com.example.demo.entity.UserCountByDepartment;

public interface UserService {

	public List<User> getAll();
	public User add(User user);
	public User update(User user, Integer id);
	public User getById(Integer id);
	public User delete(Integer id);
	public UserCountByCity getMaxUserCountByCity();
	public List<UserCountByDepartment> getUserCountByDepartment();
}
