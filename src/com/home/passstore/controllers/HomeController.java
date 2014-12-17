package com.home.passstore.controllers;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.passstore.service.KeychainService;
import com.home.passstore.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KeychainService keychainService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/")
	public String home(Model model, Principal principal){
		List<Object[]> keychains = keychainService.getAllKeyChainsForUser(principal.getName());
		model.addAttribute("keychains", keychains);
		return "home";
	}
	
	@RequestMapping("/admin")
	public String admin(Model model, Principal principal){
		List<Object[]> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "admin";
	}
	

}
