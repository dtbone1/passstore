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

@Repository
@Transactional
@Component("rolesDao")
public class RolesDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public RolesDao(){
		
	}
	
	public RolesDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void createRole(Roles role){
		session().save(role);
	}
	
	public void saveOrUpdateRole(Roles role){
		session().saveOrUpdate(role);
	}
	
	@SuppressWarnings("unchecked")
	public List<Roles> getAllRoles(){
		return session().createQuery("from Roles").list();
	}
	
	public Roles getRole(int id) {
		Criteria criteria = session().createCriteria(Roles.class);
		criteria.add(Restrictions.idEq(id));
		Roles role = (Roles)criteria.uniqueResult();
		return role;
	}
}
