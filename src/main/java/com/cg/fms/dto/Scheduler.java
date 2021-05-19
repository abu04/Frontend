package com.cg.fms.dto;
import java.util.List;

/**********
 * @author       Vijay Kumar T G
 * Description : This is the DTO class for Scheduler module 
 * Created Date: 21 April, 2021 
 * Version     : v1.1.0
 ***********/
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="scheduler3")
	public class Scheduler  {
		@Id
		@Column(name="schedulerId")
		private String schedulerId;
		@Column(name="scheduler_name")
		private String schedulerName;
		@Column(name="scheduler_contact")
		private String schedulerContact;
		@Column(name="truck_number")
		private String truckNumber;
		
		/*@OneToOne(mappedBy="schedulerId",cascade = CascadeType.ALL)
		Orders order;*/
		
		@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
		@JoinColumn(name="schedulerId")
		 List<Orders> orders;
		
		
		@LazyCollection(LazyCollectionOption.FALSE)
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="schedulerId")
		 List<Contract> contract;
		
		public Scheduler() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Scheduler(String schedulerId, String schedulerName, String schedulerContact, String truckNumber) {
			super();
			this.schedulerId = schedulerId;
			this.schedulerName = schedulerName;
			this.schedulerContact = schedulerContact;
			this.truckNumber = truckNumber;
		}
		public String getSchedulerId() {
			return schedulerId;
		}
		public void setSchedulerId(String schedulerId) {
			this.schedulerId = schedulerId;
		}
		public String getSchedulerName() {
			return schedulerName;
		}
		public void setSchedulerName(String schedulerName) {
			this.schedulerName = schedulerName;
		}
		public String getSchedulerContact() {
			return schedulerContact;
		}
		public void setSchedulerContact(String schedulerContact) {
			this.schedulerContact = schedulerContact;
		}
		public String getTruckNumber() {
			return truckNumber;
		}
		public void setTruckNumber(String truckNumber) {
			this.truckNumber = truckNumber;
		}
		
		
		public List<Orders> getOrders() {
			return orders;
		}
		public void setOrders(List<Orders> orders) {
			this.orders = orders;
		}
		public List<Contract> getContract() {
			return contract;
		}
		public void setContract(List<Contract> contract) {
			this.contract = contract;
		}
		@Override
		public String toString() {
			return "Scheduler [schedulerId=" + schedulerId + ", schedulerName=" + schedulerName + ", schedulerContact="
					+ schedulerContact + ", truckNumber=" + truckNumber + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((schedulerContact == null) ? 0 : schedulerContact.hashCode());
			result = prime * result + ((schedulerId == null) ? 0 : schedulerId.hashCode());
			result = prime * result + ((schedulerName == null) ? 0 : schedulerName.hashCode());
			result = prime * result + ((truckNumber == null) ? 0 : truckNumber.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Scheduler other = (Scheduler) obj;
			if (schedulerContact == null) {
				if (other.schedulerContact != null)
					return false;
			} else if (!schedulerContact.equals(other.schedulerContact))
				return false;
			if (schedulerId == null) {
				if (other.schedulerId != null)
					return false;
			} else if (!schedulerId.equals(other.schedulerId))
				return false;
			if (schedulerName == null) {
				if (other.schedulerName != null)
					return false;
			} else if (!schedulerName.equals(other.schedulerName))
				return false;
			if (truckNumber == null) {
				if (other.truckNumber != null)
					return false;
			} else if (!truckNumber.equals(other.truckNumber))
				return false;
			return true;
		}
		
	}

