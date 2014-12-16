package com.home.passstore.controllers;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.passstore.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/")
	public String home(Model model, Principal principal){
		userService.throwTestException();
		List<Object[]> temp = userService.getAllUsers();
		model.addAttribute("users", temp);
		return "home";
	}
	
	@RequestMapping("/admin")
	public String admin(Model model, Principal principal){
		userService.throwTestException();
		List<Object[]> temp = userService.getAllUsers();
		model.addAttribute("users", temp);
		return "admin";
	}
	

}
