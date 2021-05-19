package com.cg.fms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fms.dao.ContractDao;
import com.cg.fms.dao.CustomerDao;
import com.cg.fms.dao.IOrderDao;
import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Orders;
import com.cg.fms.dto.Product;
import com.cg.fms.exception.NoCustomerFoundException;
import com.cg.fms.service.CustomerServiceImpl;

@SpringBootTest
class ForestManagementApplicationTests {

	
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
		Customer c=new Customer("101","password","name","email@gmail.com","address","town","code","contact");
		Customer test=customerService.serviceGetCustomer("101").get();
		assertEquals("name",test.getCustomerName());
	}
	
	@Test
	void testserviceGetCustomerById2( ) {
		Customer c=new Customer("101","password","name","email@gmail.com","address","town","code","contact");
		Customer test=customerService.serviceGetCustomer("101").get();
		assertNotEquals("name1",test.getCustomerName());
	}
	
	
	@Test
	void testserviceGetCustomerById1( ) {
		
		assertThrows(NoSuchElementException.class,()->customerService.serviceGetCustomer("200").get());
	}
	
	@Test
	void testServiceUpdateCustomer() {
		Customer c2=new Customer("003","pooja","pooja malhotra","pooja@gmail.com","#3/3 rs street","goa","65223","954335523");
		customerDao.save(c2);
		Customer test=customerService.serviceGetCustomer("001").get();
		assertEquals("rakesh malhotra",test.getCustomerName());
	}
	@Test
	void testaddCustomer( ) {
		Customer c2=new Customer("006","reema","reema chaudry","chaudary@gmail.com","#5/3 ms street","mumbai","564432","87747322");
		assertEquals(c2.getCustomerAddress(),customerService.serviceAddCustomer(c2).getCustomerAddress());
	}
	
	@Test
	void testDeleteCustomer( ) {
		Customer c3=new Customer("007","reema","reema chaudry","chaudary@gmail.com","#5/3 ms street","mumbai","564432","87747322");
		customerService.serviceAddCustomer(c3);
		customerService.serviceDeleteCustomer("007");
		assertThrows(NoSuchElementException.class,()->customerService.serviceGetCustomer("007").get());
	}
	
	@Test
	void testGetAllCustomer() {
		List<Customer> cust=customerService.serviceGetAllCustomer();
	
		List< Customer> expectedCustomers= new ArrayList<Customer>();
		expectedCustomers.add(customerDao.findById("001").get());
		expectedCustomers.add(customerDao.findById("002").get());
		expectedCustomers.add(customerDao.findById("003").get());
		expectedCustomers.add(customerDao.findById("006").get());
		expectedCustomers.add(customerDao.findById("101").get());
		
		assertArrayEquals(expectedCustomers.toArray(),cust.toArray());
		
		} 
	
	@Test
	void trstGetAllOrders() {
	List<Orders> ord=customerService.getAllOrdersByCustomerId("001");
		List<Orders> expord=new ArrayList<Orders>();
		expord.add(orderDao.findById("111").get());
		expord.add(orderDao.findById("222").get());
		
		assertArrayEquals(expord.toArray(),ord.toArray());
	}
	
	@Test
	void trstGetAllContract() {
	List<Contract> con=customerService.getAllContractsByCustomerId("001");
		List<Contract> expcon=new ArrayList<Contract>();
		expcon.add(contractDao.findById("c001").get());
		expcon.add(contractDao.findById("c002").get());
		
		assertArrayEquals(expcon.toArray(),con.toArray());
	}
}
