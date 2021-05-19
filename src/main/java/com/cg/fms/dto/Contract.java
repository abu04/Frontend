package com.cg.fms.dto;

/*******************************
 * @author Abu Md Faisal
 * Description: This is the DTO class for Contract module. 
 * Created Date: 21 April, 2021 
 * Version : v1.1
 *******************************/
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="contract3")
public class Contract{
		
		@Id
		private String contractNumber;
		private String deliveryPlace;
		private String deliveryDate;
		private String quantity;		
		private String customer_id;
	    private int productId;
		private String schedulerId;
		
		public Contract() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Contract(String contractNumber, String deliveryPlace, String deliveryDate, String quantity,
				String customer_id, String schedulerId, int productId) {
			super();
			this.contractNumber = contractNumber;
			this.deliveryPlace = deliveryPlace;
			this.deliveryDate = deliveryDate;
			this.quantity = quantity;
			this.customer_id = customer_id;
			this.productId = productId;
			this.schedulerId = schedulerId;
		}

		public String getContractNumber() {
			return contractNumber;
		}

		public void setContractNumber(String contractNumber) {
			this.contractNumber = contractNumber;
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
			return "Contract [contractNumber=" + contractNumber + ", deliveryPlace=" + deliveryPlace + ", deliveryDate="
					+ deliveryDate + ", quantity=" + quantity + ", customer_id=" + customer_id + ", productId="
					+ productId + ", schedulerId=" + schedulerId + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((contractNumber == null) ? 0 : contractNumber.hashCode());
			result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
			result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
			result = prime * result + ((deliveryPlace == null) ? 0 : deliveryPlace.hashCode());
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
			Contract other = (Contract) obj;
			if (contractNumber == null) {
				if (other.contractNumber != null)
					return false;
			} else if (!contractNumber.equals(other.contractNumber))
				return false;
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

/*******************************
 * @author Abu Md Faisal
 * Description: This is the DTO class for Contract module. 
 * Created Date: 21 April, 2021 
 * Version : v1.1
 *******************************
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="contract2")
public class Contract{
		
		@Id
		private String contractNumber;
		private String deliveryPlace;
		private String deliveryDate;
		private String quantity;		
		private String customer_id;
	    
	    
		@OneToOne//(cascade = CascadeType.ALL)
	    @JoinColumn(name = "product_id")
	    private Product productId;
		
		@OneToOne//(cascade = CascadeType.ALL)
		@JoinColumn(name="scheduler_id")
		private Scheduler schedulerId;
		
		public Contract() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Contract(String contractNumber, String customer_id, String deliveryPlace, String deliveryDate,
				String quantity) {
			super();
			this.contractNumber = contractNumber;
			this.customer_id = customer_id;
			this.deliveryPlace = deliveryPlace;
			this.deliveryDate = deliveryDate;
			this.quantity = quantity;
		}
		
		public Contract(String contractNumber, String deliveryPlace, String deliveryDate, String quantity,
		 String customer_id, Scheduler schedulerId,Product productId) {
			super();
			this.contractNumber = contractNumber;
			this.deliveryPlace = deliveryPlace;
			this.deliveryDate = deliveryDate;
			this.quantity = quantity;
			this.customer_id = customer_id;
			this.schedulerId = schedulerId;
			this.productId=productId;
		}
		
		public String getContractNumber() {
			return contractNumber;
		}
		public void setContractNumber(String contractNumber) {
			this.contractNumber = contractNumber;
		}
		public String getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(String customer_id) {
			this.customer_id = customer_id;
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

		public Product getProductId() {
			return productId;
		}
		public void setProductId(Product productId) {
			this.productId = productId;
		}
		public Scheduler getSchedulerId() {
			return schedulerId;
		}
		public void setSchedulerId(Scheduler schedulerId) {
			this.schedulerId = schedulerId;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((contractNumber == null) ? 0 : contractNumber.hashCode());
			result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
			result = prime * result + ((deliveryPlace == null) ? 0 : deliveryPlace.hashCode());
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
			Contract other = (Contract) obj;
			if (contractNumber == null) {
				if (other.contractNumber != null)
					return false;
			} else if (!contractNumber.equals(other.contractNumber))
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
			if (quantity == null) {
				if (other.quantity != null)
					return false;
			} else if (!quantity.equals(other.quantity))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Contract [contractNumber=" + contractNumber + ", deliveryPlace=" + deliveryPlace + ", deliveryDate="
					+ deliveryDate + ", quantity=" + quantity + ", customer_id=" + customer_id + ", schedulerId="
					+ schedulerId +"product"+productId+ "]";
		}
		
		
	}*/