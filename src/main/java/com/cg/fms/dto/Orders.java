package com.cg.fms.dto;
/******************************
 * @author       Akash P Galagali
 * Description : This is the DTO class for Orders  
 * Created Date: 21 April, 2021 
 * Version     : v1.1.0
 *****************************/

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="orders3")
public class Orders{
	@Id
	private String order_number;
	private String deliveryPlace;
	private String deliveryDate;
	private String quantity;
	private String customer_id;
    private int productId;
	private String schedulerId;
	
	public Orders() {
	
	}

	public Orders(String order_number, String deliveryPlace, String deliveryDate, String quantity, String customer_id,
			int productId, String schedulerId) {
		super();
		this.order_number = order_number;
		this.deliveryPlace = deliveryPlace;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
		this.customer_id = customer_id;
		this.productId = productId;
		this.schedulerId = schedulerId;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(String schedulerId) {
		this.schedulerId = schedulerId;
	}

	@Override
	public String toString() {
		return "Orders [order_number=" + order_number + ", deliveryPlace=" + deliveryPlace + ", deliveryDate="
				+ deliveryDate + ", quantity=" + quantity + ", customer_id=" + customer_id + ", productId=" + productId
				+ ", schedulerId=" + schedulerId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((deliveryPlace == null) ? 0 : deliveryPlace.hashCode());
		result = prime * result + ((order_number == null) ? 0 : order_number.hashCode());
		result = prime * result + productId;
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((schedulerId == null) ? 0 : schedulerId.hashCode());
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
		Orders other = (Orders) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (deliveryPlace == null) {
			if (other.deliveryPlace != null)
				return false;
		} else if (!deliveryPlace.equals(other.deliveryPlace))
			return false;
		if (order_number == null) {
			if (other.order_number != null)
				return false;
		} else if (!order_number.equals(other.order_number))
			return false;
		if (productId != other.productId)
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (schedulerId == null) {
			if (other.schedulerId != null)
				return false;
		} else if (!schedulerId.equals(other.schedulerId))
			return false;
		return true;
	}

	
	

	
}


/*package com.cg.fms.dto;
/******************************
 * @author       Akash P Galagali
 * Description : This is the DTO class for Orders  
 * Created Date: 21 April, 2021 
 * Version     : v1.1.0
 *****************************

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="orders3")
public class Orders{
	@Id
	private String order_number;
	private String deliveryPlace;
	private String deliveryDate;
	private String quantity;
	private String customer_id;
	 
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product productId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="scheduler_id")
	private Scheduler schedulerId;
	
	public Orders() {
	
	}

	public Orders(String order_number, String deliveryPlace, String deliveryDate, String quantity, Customer customer,
			Product product,Scheduler scheduler) {
		super();
		this.order_number = order_number;
		this.deliveryPlace = deliveryPlace;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
		//this.customer = customer;
		this.productId = product;
		this.schedulerId=scheduler;
	}

	public Orders(String order_number, String deliveryPlace, String deliveryDate, String quantity, String customer_id,
			Product product,Scheduler scheduler) {
		super();
		this.order_number = order_number;
		this.deliveryPlace = deliveryPlace;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
		this.customer_id = customer_id;
		this.productId = product;
		this.schedulerId=scheduler;
	}
	



	
	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public Product getProduct() {
		return productId;
	}

	public void setProduct(Product product) {
		this.productId = product;
	}

	public Scheduler getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(Scheduler schedulerId) {
		this.schedulerId = schedulerId;
	}
/*	public String getScheduler_id() {
		return scheduler_id;
	}

	public void setScheduler_id(String scheduler_id) {
		this.scheduler_id = scheduler_id;
	}

   

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((deliveryPlace == null) ? 0 : deliveryPlace.hashCode());
		result = prime * result + ((order_number == null) ? 0 : order_number.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Orders other = (Orders) obj;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (deliveryPlace == null) {
			if (other.deliveryPlace != null)
				return false;
		} else if (!deliveryPlace.equals(other.deliveryPlace))
			return false;
		if (order_number == null) {
			if (other.order_number != null)
				return false;
		} else if (!order_number.equals(other.order_number))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [order_number=" + order_number + ", deliveryPlace=" + deliveryPlace + ", deliveryDate="
				+ deliveryDate + ", quantity=" + quantity + ", customer_id=" + customer_id + ", scheduleId="
				+ schedulerId + ", product=" + productId + "]";
	}

	

	
}*/