package com.cg.fms.service;
/******************************
 * @author       Akash P Galagali
 * Description : This is the Service class for Login. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.Optional;

import com.cg.fms.dto.User;

public interface ILoginService {
	public Optional<User> login(String username,String password);
	public User logout(User user);
	public User addUser(User user);
	public boolean removeUser(User user);
}
