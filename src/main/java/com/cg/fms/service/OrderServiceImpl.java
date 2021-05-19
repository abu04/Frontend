package com.cg.fms.service;
/******************************
 * @author       Akash P Galagali
 * Description : This is the Service Implementation class for Orders. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.IOrderDao;
import com.cg.fms.dto.Orders;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	IOrderDao odao;
	
	@Override
	public Optional<Orders> getOrder(String orderNumber) {
		return odao.findById(orderNumber);
	}

	@Override
	public Orders addOrder(Orders order) {
		
		return odao.save(order);
	}

	@Override
	public Orders updateOrder(Orders order) {
		// TODO Auto-generated method stub
		return odao.save(order);
	}

	@Override
	public boolean deleteOrder(String orderNumber) {
		odao.deleteById(orderNumber);
		return true;
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return odao.findAll();
	}

}
