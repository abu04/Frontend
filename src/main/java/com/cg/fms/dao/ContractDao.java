package com.cg.fms.dao;
/******************************
 * @author       Abu Md Faisal
 * Description : This is the DAO class for Contract. 
 * Created Date: 21 April, 2021 
 * Version     : v1.1.0
 *****************************/
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.dto.Contract;



public interface ContractDao extends JpaRepository<Contract,String>{

}


