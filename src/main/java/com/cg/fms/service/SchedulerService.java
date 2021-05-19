package com.cg.fms.service;
/**********
 * @author       Vijay Kumar T G
 * Description : This is the Service class for Scheduler. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 ***********/
import java.util.List;
import java.util.Optional;

import com.cg.fms.dto.Scheduler;

public interface SchedulerService {
	public Optional<Scheduler> getScheduler(String schedulerId);

	public boolean addScheduler(Scheduler scheduler);

	public Scheduler updateScheduler(Scheduler scheduler);

	public boolean deleteScheduler(String schedulerId);

	public List<Scheduler> getAllSchedulers();
}
