package com.home.passstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.passstore.dao.Keychain;
import com.home.passstore.dao.KeychainDao;

@Service("keychainService")
public class KeychainService {

	@Autowired
	private KeychainDao keychainDao;
	
	public void createKeyChain(Keychain keychain){
		keychainDao.createKeyChain(keychain);
	}
	
	public List<Object[]> getAllKeyChains(){
		return keychainDao.getAllKeyChains();
	}
	
	public List<Object[]> getAllKeyChainsForUser(String email){
		return keychainDao.getAllKeyChainsForUser(email);
	}
	
	public void saveOrUpdateKeyChain(Keychain keychain){
		keychainDao.saveOrUpdateKeyChain(keychain);
	}
}
