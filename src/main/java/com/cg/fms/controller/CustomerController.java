package com.cg.fms.controller;
/******************************
 * @author Sanjana S
 * Description: This is the rest controller class for Customer. 
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

import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Orders;
import com.cg.fms.exception.NoCustomerFoundException;
import com.cg.fms.exception.NoDataFoundException;
import com.cg.fms.service.CustomerServiceImpl;
@RestController   
@RequestMapping("/cust")

public class CustomerController {
	
		@Autowired
		CustomerServiceImpl customerService;

		public CustomerServiceImpl getCustomerDAO() {
			return customerService;
		}

		public void setCustomerDAO(CustomerServiceImpl customerService) {
			this.customerService = customerService;
		}
		/*******************************
		 * Method      : getCustomers     
		 
		 * @return       List of Customers
		 * Description : This method fetches List of all customers 
		 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
		 ******************************/

		@GetMapping(value="/all",produces="application/json")
		public  ResponseEntity<List<Customer>> getCustomers(){
			return new ResponseEntity<List<Customer>> (customerService.serviceGetAllCustomer(),HttpStatus.OK);
		}
		
		/*******************************
		 * Method      : getOrdersById       
		 * @param        Customer Id
		 * @return       List of Orders
		 * Description : This method fetches list of orders based on the Customer Id.
		 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
		 ******************************/
		@GetMapping(value="/orders/{customerId}",produces="application/json")
		public  ResponseEntity<List<Orders>> getOrdersbyId(@PathVariable("customerId")String custId){
			Optional<Customer> cus=customerService.serviceGetCustomer(custId);
			if(cus.isPresent())
	    	return new ResponseEntity<List<Orders>>(customerService.getAllOrdersByCustomerId(custId),HttpStatus.OK);
			else 
				throw new NoCustomerFoundException("No Customer with id "+ custId);	
		}
		
		/*******************************
		 * Method      : getContractById       
		 * @param        Customer Id
		 * @return       List of Contract
		 * Description : This method fetches List of Contract based on the Customer Id.
		 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
		 ******************************/
		@GetMapping(value="/contract/{customerId}",produces="application/json")
		public  ResponseEntity<List<Contract>> getContractbyId(@PathVariable("customerId")String custId){
			Optional<Customer> cus=customerService.serviceGetCustomer(custId);
			if(cus.isPresent())
	    	return new ResponseEntity<List<Contract>>(customerService.getAllContractsByCustomerId(custId),HttpStatus.OK);
			else 
				throw new NoCustomerFoundException("No Customer with id "+ custId);	
		}
		
		
		/*******************************
		 * Method      : getCustomer       
		 * @param      Customer  Id
		 * @return       Customer object
		 * Description : This method fetches a Customer based on the Customer id.
		 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
		 ******************************/

		@GetMapping(value="/{customerId}",produces="application/json")
		public ResponseEntity<Customer> getCustomer(@PathVariable("customerId")String custId){ 
			Optional<Customer> cus=customerService.serviceGetCustomer(custId);
			if(cus.isPresent())
	    	return new ResponseEntity<Customer>(customerService.serviceGetCustomer(custId).get(),HttpStatus.OK);
			else 
				throw new NoCustomerFoundException("No Customer with id "+ custId);
		}
		/***********
		 * Method      : dologinCustomer     
		 * @param        Customer Id and Customer password
		 * @return       Customer object 
		 * Description : This method is for validation of Customer Id and Customer password
		 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
		 **********/
		@GetMapping(value="/id/{customerId}/pass/{customerPassword}",produces="application/json")
		public ResponseEntity<Customer> dologinCustomer(@PathVariable("customerId")String custId, @PathVariable("customerPassword")String custPassword){ 
			Optional<Customer> cus=customerService.loginCustomer(custId, custPassword);
			
			if(!cus.isPresent())
				throw new NoCustomerFoundException("Invalid id/password "+ custId);
				
	    	
			else 
				return new ResponseEntity<Customer>(customerService.loginCustomer(custId, custPassword).get(),HttpStatus.OK);
		}
	
		/***********
		 * Method      : addCustomer
		 * @param        Customer
		 * @return       Response Entity of Object type
		 * Description : This method adds a new Customer
		 * @posttmapping: Post mapping requests a body from the user which is then persisted onto the database.
		 **********/
		@PostMapping(consumes="application/json")
		public ResponseEntity<HttpStatus> addCustomer(@RequestBody Customer cus){
			customerService.serviceUpdateCustomer(cus);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			
		}
		/***********
		 * Method      : modifyCustomer     
		 * @param        Customer
		 * @return       Response Entity of Object type
		 * Description : This method modifies the Customer details
		 * @PutMapping annotation  is used for mapping HTTP PUT requests onto specific handler methods.
		 **********/
		@PutMapping(value="/update/{customerId}",produces="application/json")
		public ResponseEntity<Customer> updateScheduler(@PathVariable("customerId")String customerId,@RequestBody Customer customer){
		Optional<Customer> l=null;
		l=customerService.serviceGetCustomer(customerId);
		l.get().setCustomerId(customer.getCustomerId());
		l.get().setCustomerName(customer.getCustomerName());
		l.get().setCustomerPassword(customer.getCustomerPassword());
		l.get().setCustomerEmail(customer.getCustomerEmail());
		l.get().setCustomerTown(customer.getCustomerTown());
		l.get().setCustomerAddress(customer.getCustomerAddress());
		l.get().setCustPostalCode(customer.getCustPostalCode());
		l.get().setCustomerContact(customer.getCustomerContact());
		final Customer updatedCustomer= customerService.serviceUpdateCustomer(customer);
		if(l.isPresent()) {
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		}
		else
		throw new NoDataFoundException("No Customer data found with given ID: "+customerId);
		}
		/***********
		 * Method      : deleteCustomer 
		 * @param        Customer Id
		 * @return       Response Entity of Object type
		 * Description : This method deletes the Customer based on id.
		 * @deletemapping: @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods.
		 **********/
		@DeleteMapping(value="/{customerId}")
		public ResponseEntity<HttpStatus> deleteEmlpoyee(@PathVariable("customerId")String customerId)
		{   Optional<Customer> cus=customerService.serviceGetCustomer(customerId);
		      if(cus.isPresent()) {
			 customerService.serviceDeleteCustomer(customerId);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		      }
		      else 
		    	  throw new NoCustomerFoundException("No Customer with id "+ customerId);
		}
		
		
}
