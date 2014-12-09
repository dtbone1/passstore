package com.home.passstore.controllers;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.passstore.dao.User;
import com.home.passstore.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/")
	public String login(Model model, Principal principal){
		//logger.info("Attempting to redirect user to the login page.");
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		System.out.println("***** Here! *****");
		return "login";
	}
	

}
