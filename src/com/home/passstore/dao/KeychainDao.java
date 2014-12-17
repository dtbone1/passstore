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
@Component("keychainDao")
public class KeychainDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public KeychainDao(){
		
	}
	
	public KeychainDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void createKeyChain(Keychain keychain){
		session().save(keychain);
	}
	
	public void saveOrUpdateKeyChain(Keychain keychain){
		session().saveOrUpdate(keychain);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getAllKeyChains(){
		SQLQuery q = session().createSQLQuery("SELECT {k.*}, {s.*}  FROM Keychain k, Store_Type s WHERE k.storeid = s.storeid")
		 .addEntity("k", Keychain.class)
		 .addEntity("s", com.home.passstore.dao.Store_Type.class);
		List<Object[]> rows = q.list();
		System.out.println("***** LIST OF KEYCHAINS: " + rows);
		return rows;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getAllKeyChainsForUser(String email){
		SQLQuery q = session().createSQLQuery("SELECT {k.*}, {s.*}  FROM Keychain k, Store_Type s WHERE k.storeid = s.storeid AND k.email = '" + email + "'")
		 .addEntity("k", Keychain.class)
		 .addEntity("s", Store_Type.class);
		List<Object[]> rows = q.list();
		
		return rows;
	}
	
	public Keychain getKeychain(int id) {
		Criteria criteria = session().createCriteria(Keychain.class);
		criteria.add(Restrictions.idEq(id));
		Keychain keychain = (Keychain)criteria.uniqueResult();
		return keychain;
	}
}
