package com.cg.fms.dao;

/******************************
 * @author       Akash P Galagali
 * Description : This is the DAO class for Orders. 
 * Created Date: 21 April, 2021 
 * Version     : v1.1.0
 *****************************/

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.dto.Orders;

public interface IOrderDao extends JpaRepository<Orders,String>{

	
}
