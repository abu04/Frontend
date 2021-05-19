package com.cg.fms.service;
/******************************
 * @author       Amit Anveri
 * Description : This is the Service Implementation class for Admin. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.AdminDao;

import com.cg.fms.dto.Admin;
import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Land;
import com.cg.fms.dto.Orders;
import com.cg.fms.dto.Product;
import com.cg.fms.dto.Scheduler;
import com.cg.fms.dto.User;

@Service
	public class IAdminServiceImpl implements IAdminService {
		@Autowired
		AdminDao adao;
		@Autowired
		ILoginServiceImpl udao;
		@Autowired
		ContractServiceImpl cdao;
		@Autowired
		CustomerServiceImpl custDao;
		@Autowired
		LandServiceImpl landDao;
		@Autowired
		OrderServiceImpl iorderDao;
		@Autowired
		ProductServiceImpl iproductDao;
		@Autowired
		SchedulerServiceImpl ischedulerDao;

		
		@Override
		public Optional<Admin> getAdmin(int adminId) {
			return adao.findById(adminId);
		}

		@Override
		public boolean addAdmin(Admin admin) {
			adao.save(admin);
			return false;
		}

		@Override
		public boolean updateAdmin(Admin admin) {
			// TODO Auto-generated method stub
			adao.save(admin);
			return false;
		}

		@Override
		public boolean deleteAdmin(int adminId) {
			adao.deleteById(adminId);
			return false;
		}

		@Override
		public List<Admin> getAllAdmins() {
			// TODO Auto-generated method stub
			return adao.findAll();
		}
		@Override
		public User addUser(User user) {
			// TODO Auto-generated method stub
			udao.addUser(user);
			return null;
		}

		@Override
		public List<Contract> getAllContracts() {
			// TODO Auto-generated method stub
			return cdao.getAllContracts();
		}

		@Override
		public List<Land> getAllLands() {
			// TODO Auto-generated method stub
			return landDao.getAllLands();
		}

		@Override
		public List<Customer> getAllCustomers() {
			// TODO Auto-generated method stub
			return custDao.serviceGetAllCustomer();
		}

		@Override
		public List<Orders> getAllOrders() {
			// TODO Auto-generated method stub
			return iorderDao.getAllOrders();
		}

		@Override
		public List<Product> getAllProducts() {
			// TODO Auto-generated method stub
			return iproductDao.serviceGetAllProducts();
		}

		@Override
		public List<Scheduler> getAllSchedulers() {
			// TODO Auto-generated method stub
			return ischedulerDao.getAllSchedulers();
		}

	}

