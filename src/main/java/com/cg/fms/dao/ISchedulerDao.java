package com.cg.fms.dao;
/**********
 * @author       Vijay Kumar T G
 * Description : This is the DAO class for Scheduler. 
 * Created Date: 21 April, 2021 
 * Version     : v1.1.0
 ***********/
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.dto.Scheduler;

public interface ISchedulerDao extends JpaRepository<Scheduler,String> {

}
