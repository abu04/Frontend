package com.cg.fms.dao;
/**********
 * @author      Sanjana S
 * Description : This is the DAO class for Customer. 
 * Created Date: 21 April, 2021 
 * Version     : v1.1.0
 ***********/
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Contract;
import com.cg.fms.dto.Customer;
import com.cg.fms.dto.Orders;
@Repository
public interface CustomerDao extends JpaRepository<Customer, String>{
	
    //Customer loginCustomer(String customerName, String customerPassword);
	List<Orders> getAllOrdersByCustomerId(String customerId);
	List<Contract> getAllContractsByCustomerId(String customerId);
}
