package com.cg.fms.service;
/******************************
 * @author       Amit Anveri
 * Description : This is the Service class for Admin. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import com.cg.fms.dto.Admin;
import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Land;
import com.cg.fms.dto.Orders;
import com.cg.fms.dto.Product;
import com.cg.fms.dto.Scheduler;
import com.cg.fms.dto.User;

public interface IAdminService {
	public Optional<Admin> getAdmin(int adminId);

	public boolean addAdmin(Admin admin);
	
	public boolean updateAdmin(Admin admin);

	public boolean deleteAdmin(int adminId);

	public List<Admin> getAllAdmins();
	
	public User addUser(User user);
	
	public List<Contract> getAllContracts();

	public List<Land> getAllLands();

	public List<Customer> getAllCustomers();

	public List<Orders> getAllOrders();

	public List<Product> getAllProducts();

	public List<Scheduler> getAllSchedulers();
	
}
