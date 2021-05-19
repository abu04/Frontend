package com.cg.fms.dao;
/******************************
 * @author       Anitha J Saini
 * Description : This is the DAO class for Products. 
 * Created Date: 21 April, 2021 
 * Version     : v1.1.0
 *****************************/
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.dto.Product;

public interface IProductDao extends JpaRepository<Product,Integer>
	{

	}
