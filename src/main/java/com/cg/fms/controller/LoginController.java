package com.cg.fms.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dao.ILoginDao;
import com.cg.fms.dto.User;
import com.cg.fms.exception.InvalidCredentialsException;
import com.cg.fms.service.ILoginServiceImpl;

@RestController
	@RequestMapping("/user")
	public class LoginController {
	@Autowired
	ILoginServiceImpl loginService=null;
	@Autowired 
	ILoginDao ldao;
	public ILoginServiceImpl getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginServiceImpl loginervice) {
		this.loginService = loginervice;
	}/***********
	 * Method      : validateLogin     
	 * @param        User Id and User password
	 * @return       User object 
	 * Description : This method is for validation of User Id and User password
	 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 **********/
	@GetMapping(value="login/{username}/pass/{password}",produces="application/json")
	public ResponseEntity<Optional<User>> validateLogin(@PathVariable("username")String username,@PathVariable("password")String password){
		System.out.println("it worked");
		System.out.println(username+password);
		Optional<User> u=loginService.login(username,password);
		if(!(Objects.isNull(u))) {
			System.out.println("Welcome "+username);
			return new ResponseEntity<Optional<User>>(u,HttpStatus.OK);
			}
		else
			throw new InvalidCredentialsException("Invalid UserName or Password please Try again...");
	}
	@GetMapping(value="logout/{username}",produces="application/json")
	public ResponseEntity<User> Logout(@PathVariable("username")String username)
	{	User u1=ldao.findById(username).get();
		User u=loginService.logout(u1);
		return new ResponseEntity<User>(u,HttpStatus.OK);
		
	}	

	}
