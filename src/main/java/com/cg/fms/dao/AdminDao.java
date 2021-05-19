package com.cg.fms.dao;
/******************************
 * @author       Amit Anveri
 * Description : This is the DAO class for Admin. 
 * Created Date: 21 April, 2021 
 * Version     : v1.1.0
 *****************************/
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.dto.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

}
