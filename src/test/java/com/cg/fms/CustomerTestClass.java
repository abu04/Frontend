package com.cg.fms;
/******************************
 * @author Sanjana S
 * Description: This is the JUNIT class for Customer module. 
 * Created Date: 26 April, 2021 
 * Version : v1.1.0
 *****************************/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fms.dao.ContractDao;
import com.cg.fms.dao.CustomerDao;
import com.cg.fms.dao.IOrderDao;
import com.cg.fms.dto.Admin;
import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Orders;
import com.cg.fms.dto.Product;
import com.cg.fms.dto.User;
import com.cg.fms.service.CustomerServiceImpl;
import com.cg.fms.service.IAdminServiceImpl;
@SpringBootTest
class CustomerTestClass {

	
	@Autowired 
	CustomerServiceImpl customerService;
	
	@Autowired
	CustomerDao customerDao;
	@Autowired
	IOrderDao orderDao;
	
	@Autowired
	ContractDao contractDao;
	
	@Test
	void testserviceGetCustomerById( ) {
		Customer c=new Customer("003","56064","add3","852147963","Sandya@gmail.com","Sandya","sand123","Mysore");
		Customer test=customerService.serviceGetCustomer("003").get();
		assertEquals("Sandya",test.getCustomerName());
	}
	
	@Test
	void testserviceGetCustomerById2( ) {
		Customer c=new Customer("003","56064","add3","852147963","Sandya@gmail.com","Sandya","sand123","Mysore");
		Customer test=customerService.serviceGetCustomer("003").get();
		assertNotEquals("name1",test.getCustomerName());
	}
	
	
	@Test
	void testserviceGetCustomerById1( ) {
		
		assertThrows(NoSuchElementException.class,()->customerService.serviceGetCustomer("200").get());
	}
	
	@Test
	void testServiceUpdateCustomer() {
		Customer c2=new Customer("004","jerin123","Jerin","Jerin@gmail.com","add4","Delhi","56024","7412589630");
		customerDao.save(c2);
		Customer test=customerService.serviceGetCustomer("004").get();
		assertEquals("Delhi",test.getCustomerTown());
	}
	@Test
	void testaddCustomer( ) {
		Customer c2=new Customer("006","reema123","reema chaudry","chaudary@gmail.com","add6","mumbai","564432","87747322");
		assertEquals(c2.getCustomerAddress(),customerService.serviceAddCustomer(c2).getCustomerAddress());
	}
	
	@Test
	void testDeleteCustomer( ) {
		Customer c3=new Customer("007","bhuvan","bhuvan chaudry","chaudary@gmail.com","#5/3 ms street","bombay","564432","87747322");
		customerService.serviceAddCustomer(c3);
		customerService.serviceDeleteCustomer("007");
		assertThrows(NoSuchElementException.class,()->customerService.serviceGetCustomer("007").get());
	}
	
	@Test
	void testGetAllCustomer() {
		List<Customer> cust=customerService.serviceGetAllCustomer();
	
		List< Customer> expectedCustomers= customerDao.findAll();
//				new ArrayList<Customer>();
//		expectedCustomers.add(customerDao.findById("001").get());
//		expectedCustomers.add(customerDao.findById("002").get());
//		expectedCustomers.add(customerDao.findById("004").get());
//		expectedCustomers.add(customerDao.findById("003").get());
		//expectedCustomers.add(customerDao.findById("101").get());
		
		assertArrayEquals(expectedCustomers.toArray(),cust.toArray());
		
		} 
	
	@Test
	void trstGetAllOrders() {
	List<Orders> ord=customerService.getAllOrdersByCustomerId("002");
		List<Orders> expord=new ArrayList<Orders>();
		expord.add(orderDao.findById("001").get());
		
		assertArrayEquals(expord.toArray(),ord.toArray());
	}
	
	@Test
	void trstGetAllContract() {
	List<Contract> con=customerService.getAllContractsByCustomerId("002");
		List<Contract> expcon=new ArrayList<Contract>();
		expcon.add(contractDao.findById("cr101").get());
		
		assertArrayEquals(expcon.toArray(),con.toArray());
	}
}
