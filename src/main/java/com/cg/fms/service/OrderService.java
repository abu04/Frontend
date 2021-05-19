package com.cg.fms.service;
/******************************
 * @author       Akash P Galagali
 * Description : This is the Service  class for Orders. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.fms.dto.Orders;

@Service
public interface OrderService {

	public Optional<Orders> getOrder(String orderNumber);

	public Orders addOrder(Orders order);

	public Orders updateOrder(Orders order);

	public boolean deleteOrder(String orderNumber);
	
	public List<Orders> getAllOrders();
}
