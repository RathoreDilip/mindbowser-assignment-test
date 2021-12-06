package com.luv2code.springboot.thymeleafdemo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.Entity.Employee;
import com.luv2code.springboot.thymeleafdemo.Entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
	
 //   @Query("SELECT a FROM manager a WHERE email = ?1 AND password = ?2")
//	public Manager findManager(String email,String pwd);
	
	public Manager findByEmailAndPassword(String email,String pwd);
}
