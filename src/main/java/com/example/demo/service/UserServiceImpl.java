package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.entity.UserCountByCity;
import com.example.demo.entity.UserCountByDepartment;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	@Override
	public User update(User user, Integer id) {
		// TODO Auto-generated method stub
		User old = dao.getById(id);
		old.setFirstname(user.getFirstname());
		old.setLastname(user.getLastname());
		old.setCity(user.getCity());
		old.setSalary(user.getSalary());
		old.setDepartment(user.getDepartment());
		old.setAge(user.getAge());
		return dao.save(old);
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public User delete(Integer id) {
		User user = dao.findById(id).get();
		dao.delete(user);
		return user;
	}

	@Override
	public UserCountByCity getMaxUserCountByCity() {
		// TODO Auto-generated method stub
		UserCountByCity result = new UserCountByCity();
		List<Object[]> list = dao.getUserCountByCity();
		
		for (Object[] obj : list) {
			result.setCity((String) obj[0]);
			result.setCount(Long.parseLong(obj[1].toString()));
		}
		return result;
	}

	@Override
	public List<UserCountByDepartment> getUserCountByDepartment() {
		// TODO Auto-generated method stub
		List<UserCountByDepartment> result = new ArrayList<>();
		List<Object[]> list = dao.getUserCountByDepartment();
		
		for (Object[] obj : list) {
			UserCountByDepartment instance = new UserCountByDepartment();
			instance.setDepartment((String) obj[0]);
			
			instance.setCount(Long.parseLong(obj[1].toString()));
			result.add(instance);
		}
		return result;
	}

}
