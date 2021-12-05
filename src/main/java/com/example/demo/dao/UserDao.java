package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	@Query(value = "select department , count(employee_id) as count from User Group BY department", nativeQuery = true)
	List<Object[]> getUserCountByDepartment();
	
	@Query(value = "select city,count(employee_id) as count from user Group by city ORDER BY count DESC LIMIT 1", nativeQuery = true)
	List<Object[]> getUserCountByCity();
}
