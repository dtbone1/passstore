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

import com.home.passstore.dao.Roles;
import com.home.passstore.dao.RolesDao;
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
	
	private Roles role1 = new Roles(1,"ROLE_USER");
	private Roles role2 = new Roles(2,"ROLE_ADMIN");
	
	private User user1 = new User("john@caveofprogramming.com","John", "Purcell","hellothere",true,1);
	private User user2 = new User("richard@caveofprogramming.com","Richard","Hannay","the39steps",true,1);
	private User user3 = new User("sue@caveofprogramming.com","Sue", "Black","iloveviolins",true,2);
	private User user4 = new User("rog@caveofprogramming.com","Rog", "Blake","liberator",true,2);
	
	@Before
	public void init(){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from user;");
		jdbc.execute("delete from roles");
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
		userDao.create(user1);
		userDao.create(user2);
		userDao.create(user3);
		assertTrue("Use should exist.",userDao.exists(user2.getEmail()));
		assertFalse("User should not exist.",userDao.exists("aksjfhasd"));
	}

}
