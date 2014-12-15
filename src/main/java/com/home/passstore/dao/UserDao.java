package com.home.passstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Repository
@Transactional
@Component("userDao")
public class UserDao {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}
	
	public void saveOrUpdateUser(User user){
		session().saveOrUpdate(user);
	}
	
	public boolean exists(String email) {
		return getUser(email) != null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getAllUsers(){
		//List<User> users = session().createQuery("select new User(U.email,U.firstname,U.lastname,U.roleid) from User U").list();
		//System.out.println("*** Retrieved Users:" + users.toString());
		//return users;
		SQLQuery q = session().createSQLQuery("SELECT {u.*}, {r.*}  FROM User u, Roles r WHERE u.roleid = r.roleid")
		 .addEntity("u", User.class)
		 .addEntity("r", Roles.class);
		List<Object[]> rows = q.list();
		/* Debug Lines */
//	    for (Object[] row : rows) {
//	        System.out.println("***** " + row[0] + " " + row[1] + " *****");
//	    }
		
		return rows;
	}
	
	public User getUser(String email) {
		Criteria criteria = session().createCriteria(User.class);
		criteria.add(Restrictions.idEq(email));
		User user = (User)criteria.uniqueResult();
		return user;
	}
	
}
