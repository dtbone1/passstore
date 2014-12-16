package com.home.passstore.test;


import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.passstore.dao.Keychain;
import com.home.passstore.dao.KeychainDao;
import com.home.passstore.dao.Roles;
import com.home.passstore.dao.RolesDao;
import com.home.passstore.dao.Store_Type;
import com.home.passstore.dao.Store_TypeDao;
import com.home.passstore.dao.User;
import com.home.passstore.dao.UserDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/home/passstore/config/dao-context.xml",
		"classpath:com/home/passstore/config/security-context.xml",
		"classpath:com/home/passstore/test/config/datasource.xml", })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RolesDao rolesDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private Store_TypeDao store_TypeDao;
	
	@Autowired
	private KeychainDao keychainDao;
	
	private Roles role1 = new Roles(1,"ROLE_USER");
	private Roles role2 = new Roles(2,"ROLE_ADMIN");
	
	private User user1 = new User("john@caveofprogramming.com","John", "Purcell","hellothere",true,1);
	private User user2 = new User("richard@caveofprogramming.com","Richard","Hannay","the39steps",true,1);
	private User user3 = new User("sue@caveofprogramming.com","Sue", "Black","iloveviolins",true,2);
	private User user4 = new User("rog@caveofprogramming.com","Rog", "Blake","liberator",true,2);
	
	private Store_Type store_type1 = new Store_Type(1,"General");
	private Store_Type store_type2 = new Store_Type(2,"Website");
	
	private Keychain keychain1 = new Keychain(0,"This is a test","Of the first 2 fields only.","","","","","","","","",1,"john@caveofprogramming.com");
	private Keychain keychain2 = new Keychain(0,"This is also a test, but of 3 fields.","This is field 2.","This is field 3.","","","","","","","",1,"john@caveofprogramming.com");
	private Keychain keychain3 = new Keychain(0,"I also want to test out this keychain.","","","","","","","","","",1,"sue@caveofprogramming.com");
	private Keychain keychain4 = new Keychain(0,"Testing 1,2,3.","","","","","","","","","",1,"john@caveofprogramming.com");
	
	@Before
	public void init(){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from keychain");
		jdbc.execute("delete from user;");
		jdbc.execute("delete from roles");
		jdbc.execute("delete from store_type");
	}
	
	@Test
	public void testCreateRoles(){
		rolesDao.createRole(role1);
		rolesDao.createRole(role2);
		
		List<Roles> roles1 = rolesDao.getAllRoles();
		assertEquals("Two roles should have been created and retrieved.", 2, roles1.size());
		
		Roles firstRole = roles1.get(0);
		assertEquals("Inserted Role should match retrieved",role1,firstRole);
	}
	
	@Test
	public void testCreateRetrieve(){
		rolesDao.createRole(role1);
		rolesDao.createRole(role2);
		userDao.create(user1);
		List<Object[]> users1 = userDao.getAllUsers();
		assertEquals("One user should have been created and retrieved.", 1, users1.size());
		Object[] firstUser = users1.get(0);
		assertEquals("Inserted user should match retrieved",user1,firstUser[0]);
		
		userDao.create(user2);
		userDao.create(user3);
		userDao.create(user4);
		
		List<Object[]> users2 = userDao.getAllUsers();
		
		assertEquals("Should be four retrieved users.",4,users2.size());
	}
	
	@Test
	public void testUserExists(){
		rolesDao.createRole(role1);
		rolesDao.createRole(role2);
		store_TypeDao.createStore_Type(store_type1);
		store_TypeDao.createStore_Type(store_type2);
		userDao.create(user1);
		userDao.create(user2);
		userDao.create(user3);
		keychainDao.createKeyChain(keychain1);
		keychainDao.createKeyChain(keychain2);
		keychainDao.createKeyChain(keychain3);
		keychainDao.createKeyChain(keychain4);
		assertTrue("User should exist.",userDao.exists(user2.getEmail()));
		assertFalse("User should not exist.",userDao.exists("aksjfhasd"));
	}
	
	@Test
	public void testStore_TypeCreateRetrieve(){
		store_TypeDao.createStore_Type(store_type1);
		store_TypeDao.createStore_Type(store_type2);
		List<Store_Type> store_Types1 = store_TypeDao.getAllStore_Types();
		assertEquals("Two Store Types should have been created and retrieved.", 2, store_Types1.size());
		
		Store_Type firstStore_Type = store_Types1.get(0);
		assertEquals("Inserted Role should match retrieved",store_type1,firstStore_Type);
	}
	
	@Test
	public void testKeychainCreateRetrieve(){
		//Create dependent database entries.
		store_TypeDao.createStore_Type(store_type1);
		store_TypeDao.createStore_Type(store_type2);
		rolesDao.createRole(role1);
		rolesDao.createRole(role2);
		userDao.create(user1);
		userDao.create(user2);
		userDao.create(user3);
		
		keychainDao.createKeyChain(keychain1);
		keychainDao.createKeyChain(keychain2);
		keychainDao.createKeyChain(keychain3);
		keychainDao.createKeyChain(keychain4);
		
		List<Object[]> keychains1 = keychainDao.getAllKeyChains();
		assertEquals("Four keychains should have been created and retrieved.", 4, keychains1.size());
		
		Object[] firstKeychain = keychains1.get(0);
		assertEquals("Inserted keychain should match retrieved",keychain1,firstKeychain[0]);
		
		List<Object[]> keychains2 = keychainDao.getAllKeyChainsForUser("john@caveofprogramming.com");
		assertEquals("Three keychains should have been retrieved for user: john@caveofprogramming.com.", 3, keychains2.size());
		
		assertEquals("Email should be: john@caveofprogramming.com.","john@caveofprogramming.com",((Keychain) keychains2.get(0)[0]).getEmail());
		assertEquals("Email should be: john@caveofprogramming.com.","john@caveofprogramming.com",((Keychain) keychains2.get(1)[0]).getEmail());
		assertEquals("Email should be: john@caveofprogramming.com.","john@caveofprogramming.com",((Keychain) keychains2.get(2)[0]).getEmail());
	}

}
