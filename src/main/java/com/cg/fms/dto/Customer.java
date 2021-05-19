package com.cg.fms.dto;

/*******************************
 * @author Sanjana S
 * Description: This is the DTO class for Customer module. 
 * Created Date: 21 April, 2021 
 * Version : v1.1
 *******************************/
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
@Table(name="customer3")
public class Customer {
	@Id
	@Column(name="customer_id")
	String customerId;
	@Column(name="customer_password")
	String customerPassword;
	@Column(name="customer_name")
	String customerName;
	@Column(name="customer_email")
	String customerEmail;
	@Column(name="customer_address")
	String customerAddress;
	@Column(name="customer_town")
	String customerTown;
	@Column(name="customer_postal_code")
	String custPostalCode;
	@Column(name="customer_contact")
	String customerContact;
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	 List<Orders> orders;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	 List<Contract> contract;
	
	/*@OneToMany(mappedBy="Contract")
	List<Contract> contract;*/
		
	public Customer() {}
	
	public Customer(String customerId, String customerPassword, String customerName, String customerEmail,
			String customerAddress, String customerTown, String custPostalCode, String customerContact) {
		
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerTown = customerTown;
		this.custPostalCode = custPostalCode;
		this.customerContact = customerContact;
	}

	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public String getCustomerTown() {
		return customerTown;
	}


	public void setCustomerTown(String customerTown) {
		this.customerTown = customerTown;
	}


	public String getCustPostalCode() {
		return custPostalCode;
	}


	public void setCustPostalCode(String custPostalCode) {
		this.custPostalCode = custPostalCode;
	}


	public String getCustomerContact() {
		return customerContact;
	}


	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((contract == null) ? 0 : contract.hashCode());
		result = prime * result + ((custPostalCode == null) ? 0 : custPostalCode.hashCode());
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + ((customerContact == null) ? 0 : customerContact.hashCode());
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
		result = prime * result + ((customerTown == null) ? 0 : customerTown.hashCode());
		//result = prime * result + ((orders == null) ? 0 : orders.hashCode());
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
		Customer other = (Customer) obj;
		
		if (custPostalCode == null) {
			if (other.custPostalCode != null)
				return false;
		} else if (!custPostalCode.equals(other.custPostalCode))
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerContact == null) {
			if (other.customerContact != null)
				return false;
		} else if (!customerContact.equals(other.customerContact))
			return false;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPassword == null) {
			if (other.customerPassword != null)
				return false;
		} else if (!customerPassword.equals(other.customerPassword))
			return false;
		if (customerTown == null) {
			if (other.customerTown != null)
				return false;
		} else if (!customerTown.equals(other.customerTown))
			return false;
		
		return true;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPassword=" + customerPassword + ", customerName="
				+ customerName + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress
				+ ", customerTown=" + customerTown + ", custPostalCode=" + custPostalCode + ", customerContact="
				+ customerContact + "]";
	}


	
	
	
	
}
