package com.cg.fms.service;
/******************************
 * @author       Akash P Galagali
 * Description : This is the Service Implementation class for Login. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.ILoginDao;
import com.cg.fms.dto.User;

@Service
	public class ILoginServiceImpl implements ILoginService{
		@Autowired
		ILoginDao ldao;
		
		@Override
		public Optional<User> login(String username, String password) {
			Optional<User> user=ldao.findById(username);
			if(user.get().getUserName().equals(username)&&user.get().getPassword().equals(password)) {
					return user;
			}
			return null;
		}

		@Override
		public User logout(User user) {
			System.out.println("User Logged Out!");
			String name=user.getUserName();
			return ldao.findById(name).get();
		}

		@Override
		public User addUser(User user) {
			ldao.save(user);
			return user;
		}

		@Override
		public boolean removeUser(User user) {
			ldao.delete(user);
			return true;
		}

	}


