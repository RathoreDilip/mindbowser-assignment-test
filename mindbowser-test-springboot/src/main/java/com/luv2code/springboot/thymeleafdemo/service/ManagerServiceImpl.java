package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.Entity.Employee;
import com.luv2code.springboot.thymeleafdemo.Entity.Manager;
import com.luv2code.springboot.thymeleafdemo.dao.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService {

	private ManagerRepository managerRepository;
	
	@Autowired
	public ManagerServiceImpl(ManagerRepository managerRepository) {
		this.managerRepository = managerRepository;
	}

	public void save(Manager manager) {
		managerRepository.save(manager);		
	}

	public Manager findByEmail(String email,String pwd) {
		System.out.println("email :: "+email+"  -- pwd :: "+pwd);
		Manager result = managerRepository.findByEmailAndPassword(email, pwd);
		System.out.println("result count :: "+result);
		return result;
	}
	
}
