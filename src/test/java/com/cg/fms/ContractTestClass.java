package com.cg.fms;
/******************************
 * @author       Abu Md Faisal
 * Description : This is the Junit Test class for Contract Module. 
 * Created Date: 26 April, 2021 
 * Version     : v1.1.0
 *****************************/
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fms.dao.ContractDao;
import com.cg.fms.dao.CustomerDao;
import com.cg.fms.dao.IProductDao;
import com.cg.fms.dao.ISchedulerDao;
import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Product;
import com.cg.fms.dto.Scheduler;
import com.cg.fms.service.ContractServiceImpl;
import com.cg.fms.service.CustomerServiceImpl;
import com.cg.fms.service.ProductServiceImpl;
import com.cg.fms.service.SchedulerServiceImpl;
@SpringBootTest
class ContractTestClass {
	@Autowired
	ContractServiceImpl cser;
	
	@Autowired
	ProductServiceImpl pser;
	
	@Autowired
	CustomerServiceImpl cuser;
	
	@Autowired
	ContractDao cdao;
	
	@Autowired 
	IProductDao pdao;
	
	@Autowired
	ISchedulerDao sdao;
	
	@Autowired
	CustomerDao cudao;
	
	@Autowired
	SchedulerServiceImpl scser;

	@Test
	void testGetContractById() {
		
		//Scheduler s= scser.getScheduler("S101").get();
		//Product p= pser.serviceGetProduct(1).get();
		Contract c= new Contract("CR101","Bengaluru","23/04/2021","100","C101","S101",101);
		Contract c2=cser.getContract("CR101").get();
		assertEquals(c.getDeliveryPlace(),c2.getDeliveryPlace());
	}
	
	
	@Test
	void testAddContract() {
		Customer cs= new Customer("C102","ABU1234","ABU","abu@gmail.com","BENGALURU","whitefield","560066","9113239447");
		Scheduler s= new Scheduler("S102","ram","789065432","KA-09");
		Product p= new Product(104,"sandalwood","10","tree");
		cuser.serviceAddCustomer(cs);
		pser.serviceAddProduct(p);
		scser.addScheduler(s);
		Contract c= new Contract("CR102","BENGALURU","25/02/2021","100","C102","S102",104);
		cser.addContract(c);
		Contract c1=cser.getContract("CR102").get();
		assertEquals(c.getQuantity(),c1.getQuantity());
		cser.deleteContract("CR102");
		
	}
	

	
	@Test
	void testDeleteContract() {
		Customer cs= new Customer("C102","ABU1234","ABU","abu@gmail.com","BENGALURU","whitefield","560066","9113239447");
		Scheduler s= new Scheduler("S102","ram","789065432","KA-09");
		Product p= new Product(104,"sandalwood","10","tree");
		cuser.serviceAddCustomer(cs);
		pser.serviceAddProduct(p);
		scser.addScheduler(s);
		Contract c= new Contract("CR102","BENGALURU","25/02/2021","100","C102","S102",104);
		cser.addContract(c);
		cser.deleteContract("CR102");
		assertEquals(Optional.empty(),cser.getContract("CR102"));
	}
	
	@Test
	void testGetAllContracts() {
		List<Contract> clist= cser.getAllContracts();
		List<Contract> exlist= new ArrayList<Contract>();
		exlist.addAll(cdao.findAll());
		assertArrayEquals(exlist.toArray(),clist.toArray());
		
	}

}