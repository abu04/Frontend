package com.cg.fms.controller;
/**********
 * @author      Vijay Kumar T G
 * Description : This is the rest controller class for Scheduler. 
 * Created Date: 23 April, 2021 
 * Version     : v1.1.0
 ***********/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Scheduler;
import com.cg.fms.exception.NoDataFoundException;
import com.cg.fms.service.SchedulerService;
import com.cg.fms.service.SchedulerServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
	@RequestMapping("/scheduler")
	public class SchedulerController {
		@Autowired
		private SchedulerService schedulerService;
		
		public SchedulerService getSchedulerDAO() {
			return schedulerService;
		}
		
		public void setSchedulerDAO(SchedulerServiceImpl schedulerService) {
			this.schedulerService = schedulerService;
		}
		/*****
		 * Method      : getAllScheduler  
		 * @return       Response Entity of Object type
		 * Description : This method fetches all the Schedulers.
		 * @getmapping : Get mapping expects a PathVariable to be passed 
			 *               which is then used to return the entity object 
			 *               that is fetched from the database.
		 ****/
		@GetMapping(value="/all",produces="application/json")
		public  ResponseEntity<List<Scheduler>> getAllScheduler(){
			return new ResponseEntity<List<Scheduler>> (schedulerService.getAllSchedulers(),HttpStatus.OK);
		}
		/***********
		 * Method      : getScheduler      
		 * @param        schedulerId
		 * @return       Scheduler object
		 * Description : This method fetches a Scheduler based on the unique id.
		 * @getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
		 **********/
		@GetMapping(value="/get/{schedulerId}",produces="application/json")
		public ResponseEntity<Optional<Scheduler>> getScheduler(@PathVariable("schedulerId")String schedulerId){ 
			Optional<Scheduler> s=schedulerService.getScheduler(schedulerId);
			if(s.isPresent()) {
				return new ResponseEntity<Optional<Scheduler>>(s,HttpStatus.OK);
				}
			else 
				throw new NoDataFoundException("No Scheduler data found with given Scheduler ID: "+ schedulerId);

		}
		/**********
		 * Method      : addnewScheduler       
		 * @param        Scheduler
		 * @return       Response Entity of Object type
		 * Description : This method adds a new Scheduler.
		 * @postmapping: Post mapping requests a body from the Scheduler
		 * 				 which is then persisted onto the database.
		 **********/
		@PostMapping(value="/add",consumes="application/json")
		public ResponseEntity<HttpStatus> addnewScheduler(@RequestBody Scheduler scheduler){
			schedulerService.addScheduler(scheduler);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		/*****
		 * Method      : updateScheduler      
		 * @param        Scheduler
		 * @return       Response Entity of Object type
		 * Description : This method updates the Scheduler details.
		 * @PutMapping annotation  is used for mapping HTTP PUT requests onto specific handler methods.
		 ****/
		@PutMapping(value="/update/{schedulerId}",produces="application/json")
		public ResponseEntity<Scheduler> updateScheduler(@PathVariable("schedulerId")String schedulerId,@RequestBody Scheduler scheduler){
		Optional<Scheduler> l=null;
		l=schedulerService.getScheduler(schedulerId);
		l.get().setSchedulerId(scheduler.getSchedulerId());
		l.get().setSchedulerName(scheduler.getSchedulerName());
		l.get().setSchedulerContact(scheduler.getSchedulerContact());
		l.get().setTruckNumber(scheduler.getTruckNumber());
		final Scheduler updatedScheduler= schedulerService.updateScheduler(scheduler);
		if(l.isPresent()) {
		return new ResponseEntity<Scheduler>(updatedScheduler,HttpStatus.OK);
		}
		else
		throw new NoDataFoundException("No Land data found with given Land ID: "+ schedulerId);
		}
		/*****
		 * Method      : deleteScheduler      
		 * @param        Id
		 * @return       Response Entity of Object type
		 * Description : This method deletes the Scheduler based on id.
		 * @deletemapping: @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods.
		 ****/
		@DeleteMapping(value="/delete/{schedulerID}")
		public ResponseEntity<HttpStatus> deleteScheduler(@PathVariable("schedulerID")String schedulerId)
		{
			Optional<Scheduler> s=schedulerService.getScheduler(schedulerId);
			if(s.isPresent()) {
				schedulerService.deleteScheduler(schedulerId);
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
				}
			else 
				throw new NoDataFoundException("No Scheduler data found with given Scheduler ID: "+ schedulerId);

		}
	}

