package com.cg.fms;
/**********
 * @author Vijay Kumar T G
 * Description: This is the JUNIT class for Scheduler  module. 
 * Created Date: 26 April, 2021 
 * Version : v1.1.0
 ***********/
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fms.dao.ISchedulerDao;
import com.cg.fms.dto.Scheduler;
import com.cg.fms.service.SchedulerServiceImpl;

@SpringBootTest
class SchedulerTestClass {

	@Autowired
	SchedulerServiceImpl schedulerService;
	@Autowired
	ISchedulerDao sdao;
	
	@Test
	void testGetScheduler() {
		Scheduler s=new Scheduler("S101","string","string","string");
		Scheduler s2=schedulerService.getScheduler("S101").get();
		assertEquals(s.getSchedulerName(),s2.getSchedulerName());
	}
	
	@Test
	void testAddScheduler() {
		Scheduler s=new Scheduler("002","ali","8467236273","KA037");
		schedulerService.addScheduler(s);
		assertEquals(s.getSchedulerName(),schedulerService.getScheduler("002").get().getSchedulerName());
	}
	
	
	@Test
	void testUpdateScheduler() {
		Scheduler s=new Scheduler("002","ali","8467236273","KA037");
		schedulerService.updateScheduler(s);
		Scheduler s2=schedulerService.getScheduler("002").get();
		assertEquals(s,s2);
	}
	
	@Test
	void testDeleteScheduler() {
		Scheduler s=new Scheduler("010","abu","75214896","KA037");
		schedulerService.addScheduler(s);
		schedulerService.deleteScheduler("010");
		assertEquals(Optional.empty(),schedulerService.getScheduler("010"));
	}
	
	@Test
	void testGetAllScheduler() {
		List<Scheduler> schedulers=schedulerService.getAllSchedulers();

		List<Scheduler> expected=sdao.findAll();
		assertArrayEquals(expected.toArray(),schedulers.toArray());
	}
}