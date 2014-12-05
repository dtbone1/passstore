package com.home.passstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;

import com.home.passstore.dao.User;
import com.home.passstore.dao.UserDao;


@Service("userService")
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void createUser(User user){
		userDao.create(user);
	}
	
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	public User getUserByEmail(String email){
		return userDao.getUser(email);
	}
	
	public void saveOrUpdateUser(User user){
		userDao.saveOrUpdateUser(user);
	}
}
