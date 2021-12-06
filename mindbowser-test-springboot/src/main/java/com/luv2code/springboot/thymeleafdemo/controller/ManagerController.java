package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.luv2code.springboot.thymeleafdemo.Entity.Manager;
import com.luv2code.springboot.thymeleafdemo.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;

	private Logger logger = Logger.getLogger(getClass().getName());
	
	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	@GetMapping("/signUpforManager")
	public String showFormForSignUp(Model theModel) {

		// create model attribute to bind form data
		Manager manager = new Manager();

		theModel.addAttribute("manager", manager);

		return "manager/manager-signup-form";
	}
	
	@GetMapping("/signInforManager")
	public String showFormForSignIn(Model theModel) {

		// create model attribute to bind form data
		Manager manager = new Manager();

		theModel.addAttribute("manager", manager);

		return "manager/manager-signin-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("manager") Manager manager) {

		logger.info("Manager for Add : " + manager);

		// save the manager
		managerService.save(manager);

		// use a redirect to prevent duplicate submissions

		return "redirect:/manager/signInforManager";

	}
	
	@PostMapping("/checkLogin")
	public String checkLogin(@ModelAttribute("manager") Manager manager) {

		logger.info("Manager for checkLogin : " + manager);

		// save the manager
		Manager managerData = managerService.findByEmail(manager.getEmail(),manager.getPassword());
		
		logger.info("findByEmailData :: "+managerData);
		
		// use a redirect to prevent duplicate submissions
		if(managerData!=null)
			return "redirect:/employees/list";
		
		return "redirect:/manager/signInforManager?error";

		
		

	}

}
