package com.home.passstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("userDao")
public class UserDao {

//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDao(){
		
	}
	
	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void create(User user){
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}
	
	public void saveOrUpdateUser(User user){
		session().saveOrUpdate(user);
	}
	
	public boolean exists(String email) {
		return getUser(email) != null;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		List<User> users = session().createQuery("from User").list();
		//System.out.println("*** Retrieved Users:" + users.toString());
		return users;
	}
	
	public User getUser(String email) {
		Criteria criteria = session().createCriteria(User.class);
		criteria.add(Restrictions.idEq(email));
		User user = (User)criteria.uniqueResult();
		return user;
	}
	
}
