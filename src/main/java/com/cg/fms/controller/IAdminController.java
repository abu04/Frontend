package com.cg.fms.controller;
/******************************
 * @author Amit Anveri
 * Description: This is the rest controller class for Admin. 
 * Created Date: 23 April, 2021 
 * Version : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Admin;
import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Land;
import com.cg.fms.dto.Orders;
import com.cg.fms.dto.Product;
import com.cg.fms.dto.Scheduler;
import com.cg.fms.dto.User;
import com.cg.fms.exception.NoDataFoundException;
import com.cg.fms.service.IAdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class IAdminController {
	@Autowired
	IAdminServiceImpl adminService = new IAdminServiceImpl();

	public IAdminServiceImpl geIAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminServiceImpl adminService) {
		this.adminService = adminService;
	}
	/****
	 * * Method      : getAllAmins
	 * @return       Response Entity of Object type
	 * Description : This method fetches all the Admins.
	 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
	 **********/
	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<List<Admin>> getAllAdmin() {
		System.out.println("it worked");
		return new ResponseEntity<List<Admin>>(adminService.getAllAdmins(), HttpStatus.OK);
	}
	/***********
	 * Method      : getAllContracts   
	 * @return       Response Entity of Object type
	 * Description : This method fetches all the contracts.
	 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
	 **********/
	@GetMapping(value = "/all/contract", produces = "application/json")
	public ResponseEntity<List<Contract>> getAllContracts() {
		System.out.println("it worked");
		return new ResponseEntity<List<Contract>>(adminService.getAllContracts(), HttpStatus.OK);
	}
	/***********
	 * Method      : getAllCustomers   
	 * @return       Response Entity of Object type
	 * Description : This method fetches all the customers.
	 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
	 **********/
	@GetMapping(value = "/all/customer", produces = "application/json")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		System.out.println("it worked");
		return new ResponseEntity<List<Customer>>(adminService.getAllCustomers(), HttpStatus.OK);
	}
	/***********
	 * Method      : getAlllands   
	 * @return       Response Entity of Object type
	 * Description : This method fetches all the lands.
	 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
	 **********/
	@GetMapping(value = "/all/land", produces = "application/json")
	public ResponseEntity<List<Land>> getAllLands() {
		System.out.println("it worked");
		return new ResponseEntity<List<Land>>(adminService.getAllLands(), HttpStatus.OK);
	}
	/***********
	 * Method      : getAllOrders   
	 * @return       Response Entity of Object type
	 * Description : This method fetches all the orders.
	 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
	 **********/
	@GetMapping(value = "/all/order", produces = "application/json")
	public ResponseEntity<List<Orders>> getAllOrders() {
		System.out.println("it worked");
		return new ResponseEntity<List<Orders>>(adminService.getAllOrders(), HttpStatus.OK);
	}
	/***********
	 * Method      : getAllProducts  
	 * @return       Response Entity of Object type
	 * Description : This method fetches all the products.
	 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
	 **********/
	@GetMapping(value = "/all/product", produces = "application/json")
	public ResponseEntity<List<Product>> getAllProducts() {
		System.out.println("it worked");
		return new ResponseEntity<List<Product>>(adminService.getAllProducts(), HttpStatus.OK);
	}
	/***********
	 * Method      : getAllSchedulers  
	 * @return       Response Entity of Object type
	 * Description : This method fetches all the schedulers.
	 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
	 **********/
	@GetMapping(value = "/all/scheduler", produces = "application/json")
	public ResponseEntity<List<Scheduler>> getAllSchedulers() {
		System.out.println("it worked");
		return new ResponseEntity<List<Scheduler>>(adminService.getAllSchedulers(), HttpStatus.OK);
	}
	/*******************************
	 * Method      : getAdmin       
	 * @param        Admin id
	 * @return       Response entity of object type
	 * Description : This method fetches list of orders based on the Admin id.
	 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ******************************/
	@GetMapping(value = "/{adminid}", produces = "application/json")
	public ResponseEntity<Optional<Admin>> getAdmin(@PathVariable("adminid") int adminid) {
		Optional<Admin> a = null;
		a = adminService.getAdmin(adminid);
		System.out.println(a.toString());
		if (a.isPresent()) {
			return new ResponseEntity<Optional<Admin>>(a, HttpStatus.OK);
		} else
			throw new NoDataFoundException("No Admin data found with given Admin ID: " + adminid);

	}
	/***********
	 * Method      : addAdmin
	 * @param        Admin
	 * @return       Response Entity of Object type
	 * Description : This method adds a new Admin.
	 * @postmapping: Post mapping requests a body from the user which is then persisted onto the database.
	 **********/
	@PostMapping(consumes = "application/json")
	public ResponseEntity<HttpStatus> addAdmin(@RequestBody Admin admin) {
		adminService.addAdmin(admin);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	/***********
	 * Method      : addUser
	 * @param        User
	 * @return       Response Entity of Object type
	 * Description : This method adds a new User.
	 * @postmapping: Post mapping requests a body from the user which is then persisted onto the database.
	 **********/
	@PostMapping(value = "/user", consumes = "application/json")
	public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
		adminService.addUser(user);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	/***********
	 * Method      : modifyAdmin      
	 * @param        Admin
	 * @return       Response Entity of Object type
	 * Description : This method updates the Admin details.
	 * @PutMapping annotation  is used for mapping HTTP PUT requests onto specific handler methods.
	 **********/
	@PutMapping(consumes = "application/json")
	public ResponseEntity<HttpStatus> modifyAdmin(@RequestBody Admin admin) {
		adminService.updateAdmin(admin);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	/*****
	 * Method      : deleteAdmin      
	 * @param        Admin id
	 * @return       Response Entity of Object type
	 * Description : This method deletes the Admin based on id.
	 * @deletemapping: @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods.
	 ****/
	@DeleteMapping(value = "/{adminid}")
	public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("adminid") int adminid) {
		Optional<Admin> a = null;
		a = adminService.getAdmin(adminid);
		System.out.println(a.toString());
		if (a.isPresent()) {

			adminService.deleteAdmin(adminid);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} else
			throw new NoDataFoundException("No Admin data found with given Admin ID: " + adminid);

	}

}