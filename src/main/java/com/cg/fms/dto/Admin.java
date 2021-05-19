package com.cg.fms.dto;
/******************************
 * @author       Amit Anveri
 * Description : This is the DTO class for Admin. 
 * Created Date: 21 April, 2021 
 * Version     : v1.1.0
 *****************************/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin3")
	//public class Admin extends User{
	public class Admin{	
		@Id
		@Column(name="admin_id")
		private int adminId;
		@Column(name="admin_name")
		private String adminName;
		@Column(name="admin_password")
		private String adminPassword;
		public Admin() {}
		public Admin(int adminId, String adminName, String adminPassword) {
			//super(adminName,adminPassword,"admin");
			this.adminId = adminId;
			this.adminName = adminName;
			this.adminPassword = adminPassword;
		}
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getAdminName() {
			return adminName;
		}
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		public String getAdminPassword() {
			return adminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + adminId;
			result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
			result = prime * result + ((adminPassword == null) ? 0 : adminPassword.hashCode());
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
			Admin other = (Admin) obj;
			if (adminId != other.adminId)
				return false;
			if (adminName == null) {
				if (other.adminName != null)
					return false;
			} else if (!adminName.equals(other.adminName))
				return false;
			if (adminPassword == null) {
				if (other.adminPassword != null)
					return false;
			} else if (!adminPassword.equals(other.adminPassword))
				return false;
			return true;
		}
		

	}

