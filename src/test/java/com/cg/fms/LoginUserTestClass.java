package com.cg.fms;
/******************************
 * @author Akash P Galagali
 * Description: This is the JUNIT class for Login  module. 
 * Created Date: 26 April, 2021 
 * Version : v1.1.0
 *****************************/
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fms.dto.User;
import com.cg.fms.service.ILoginServiceImpl;

@SpringBootTest
class LoginUserTestClass {

	@Autowired
	ILoginServiceImpl loginService;
	
	//Login
	@Test
	void testLogin()
	{
		User u=new User("akash","pass","customer");
		User u2=loginService.login("akash", "pass").get();
		assertEquals(u.getUserName(),u2.getUserName());
	}
	//LoginOut
	@Test
	void testLogOut()
	{
		User u=new User("akash","pass","customer");
		User u2=loginService.logout(u);
		assertEquals(u.getUserName(),u2.getUserName());	}
	//AddUser
	@Test
	void testAddUser()
	{
		User u=new User("Ram","ram","admin");
		loginService.addUser(u);
		assertEquals(u.getUserName(),loginService.logout(u).getUserName());
	}
	
	//DeleteProduct
	@Test
	void testDeleteUser()
	{
		User u=new User("Ram","ram","admin");
		assertEquals(true,loginService.removeUser(u));
	}
	    
}
