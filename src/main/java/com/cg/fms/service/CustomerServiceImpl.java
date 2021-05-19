package com.cg.fms.service;
/******************************
 * @author      Sanjana S
 * Description : This is the Service Implementation class for Customer. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fms.dao.CustomerDao;
import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Orders;
import com.cg.fms.exception.NoCustomerFoundException;
@Service
public class CustomerServiceImpl implements CustomerService{
    
	@Autowired
	CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Transactional
     public Optional<Customer> serviceGetCustomer(String customerId) {
		return customerDao.findById(customerId);
	}

	@Transactional
	public Customer serviceAddCustomer(Customer cust) {
	        customerDao.save(cust);
	        return cust;
	}

	@Transactional
	public Customer serviceUpdateCustomer(Customer cust) {
		
		customerDao.save(cust);
		return cust;
	}

	@Transactional
	public boolean serviceDeleteCustomer(String customerId) {
		List<Customer> com =customerDao.findAll();
		Customer customer = customerDao.findById(customerId).get();
		com.remove(customer);
		customerDao.deleteById(customerId);
		return false;
	}
	@Transactional(readOnly=true)
	public List<Customer> serviceGetAllCustomer() {
		return customerDao.findAll();
	}

	@Override
	public List<Orders> getAllOrdersByCustomerId(String customerId) {
		Customer c= customerDao.findById(customerId).get();
		return c.getOrders();
	}

	@Override
	public List<Contract> getAllContractsByCustomerId(String customerId) {
		Customer c= customerDao.findById(customerId).get();
		
		return c.getContract();
	}

	@Override
	public Optional<Customer> loginCustomer(String customerId, String customerPassword) {
		Optional<Customer> c= customerDao.findById(customerId);
		if(c.isEmpty())
		{
			throw new NoCustomerFoundException("No Customer with name "+ customerId);
		}
		else if( c.get().getCustomerId().equals(customerId) && c.get().getCustomerPassword().equals(customerPassword)) {
			return c;
		}
	
		return null;
	}
	
}
