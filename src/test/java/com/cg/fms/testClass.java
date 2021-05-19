package com.cg.fms;
/******************************
 * @author Akash P Galagali
 * Description: This is the JUNIT class for Orders  module. 
 * Created Date: 26 April, 2021 
 * Version : v1.1.0
 *****************************/
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fms.dao.IOrderDao;
import com.cg.fms.dto.Orders;
import com.cg.fms.dto.Product;
import com.cg.fms.dto.Scheduler;
import com.cg.fms.service.OrderServiceImpl;
import com.cg.fms.service.ProductServiceImpl;
import com.cg.fms.service.SchedulerServiceImpl;
@SpringBootTest
public class testClass {
	@Autowired 
	OrderServiceImpl orderService;
	@Autowired
	ProductServiceImpl productService;
	@Autowired
	SchedulerServiceImpl schedulerService;
	@Autowired
	IOrderDao IOrderDaoobj;
	@Test
	void testGetorderById() {

		Orders o2=orderService.getOrder("O101").get();		
		assertEquals("string",o2.getDeliveryPlace());
	}
	/*@Test
	void testGetorderById1() {
		assertNotEquals("wrongName",orderService.getOrder("001"));
	}*/
	@Test
	void testAddOrder() {
		//Product p3=productService.serviceGetProduct(3).get();
		//Scheduler s3=schedulerService.getScheduler("004").get();
		Orders o=new Orders("004","raichur","05/07/2021","10","C101",101,"S101");
		Orders o1=orderService.addOrder(o);
		assertEquals(o.getDeliveryPlace(),o1.getDeliveryPlace());
		orderService.deleteOrder("004");
		//productService.serviceAddProduct(p3);
		//schedulerService.addScheduler(s3);
	}
	@Test
	void testGetAllOrders() {
		List<Orders> orders=orderService.getAllOrders();
		List<Orders> expectedOrders=IOrderDaoobj.findAll();
		assertArrayEquals(expectedOrders.toArray(),orders.toArray());
	}
	
	@Test
	void testDeleteOrders() {
		//Product p3=productService.serviceGetProduct(3).get();
		//Scheduler s3=schedulerService.getScheduler("004").get();
		Orders o=new Orders("004","raichur","05/07/202","10","C101",101,"S101");
		orderService.addOrder(o);
		assertEquals(true,orderService.deleteOrder("004"));
		//productService.serviceAddProduct(p3);
		//schedulerService.addScheduler(s3);
	}
	

}
