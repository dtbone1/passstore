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
@Component("store_TypeDao")
public class Store_TypeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Store_TypeDao(){
		
	}
	
	public Store_TypeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void createStore_Type(Store_Type store_type){
		session().save(store_type);
	}
	
	public void saveOrUpdateStore_Type(Store_Type store_type){
		session().saveOrUpdate(store_type);
	}
	
	@SuppressWarnings("unchecked")
	public List<Store_Type> getAllStore_Types(){
		return session().createQuery("from Store_Type").list();
	}
	
	public Store_Type getStoreType(int id) {
		Criteria criteria = session().createCriteria(Store_Type.class);
		criteria.add(Restrictions.idEq(id));
		Store_Type store_type = (Store_Type)criteria.uniqueResult();
		return store_type;
	}
}
