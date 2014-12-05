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
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.home.passstore.dao.User;
import com.home.passstore.dao.UserDao;
import com.home.passstore.test.config.InitializerTest;
import com.home.passstore.test.config.RootConfigTest;
import com.home.passstore.test.config.WebappConfigTest;

@ContextHierarchy({
	@ContextConfiguration(classes = InitializerTest.class),
	@ContextConfiguration(classes = RootConfigTest.class),
	@ContextConfiguration(classes = WebappConfigTest.class)
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DataSource dataSource;
	
	private User user1 = new User("john@caveofprogramming.com","John", "Purcell","hellothere",1);
	private User user2 = new User("richard@caveofprogramming.com","Richard","Hannay","the39steps",1);
	private User user3 = new User("sue@caveofprogramming.com","Sue", "Black","iloveviolins",2);
	private User user4 = new User("rog@caveofprogramming.com","Rog", "Blake","liberator",2);
	
	@Before
	public void init(){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from user;");
	}
	
	@Test
	public void testCreateRetrieve(){
		userDao.create(user1);
		List<User> users1 = userDao.getAllUsers();
		assertEquals("One user should have been created and retrieved.", 1, users1.size());
		
		assertEquals("Inserted user should match retrieved",user1,users1.get(0));
		
		userDao.create(user2);
		userDao.create(user3);
		userDao.create(user4);
		
		List<User> users2 = userDao.getAllUsers();
		
		assertEquals("Should be four retrieved users.",4,users2.size());
	}
	
	@Test
	public void testExists(){
		userDao.create(user1);
		userDao.create(user2);
		userDao.create(user3);
		assertTrue("Use should exist.",userDao.exists(user2.getEmail()));
		assertFalse("User should not exist.",userDao.exists("aksjfhasd"));
	}

}
