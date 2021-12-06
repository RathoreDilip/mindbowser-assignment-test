package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.Entity.Employee;
import com.luv2code.springboot.thymeleafdemo.Entity.Manager;

public interface ManagerService {
	public void save(Manager manager);
	
	public Manager findByEmail(String email,String pwd);
}
