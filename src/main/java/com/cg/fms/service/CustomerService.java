package com.cg.fms.service;
/******************************
 * @author       Sanjana S
 * Description : This is the Service class for Customer. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Orders;

public interface CustomerService  {
	
	   public Optional<Customer> loginCustomer(String customerId, String customerPassword);
		public Optional<Customer> serviceGetCustomer(String customerId);

		public Customer serviceAddCustomer(Customer customer);

		public Customer serviceUpdateCustomer(Customer customer);

		public boolean serviceDeleteCustomer(String customerId);

		public List<Customer> serviceGetAllCustomer();
		public List<Orders> getAllOrdersByCustomerId(String customerId);
		public List<Contract> getAllContractsByCustomerId(String customerId);

}
