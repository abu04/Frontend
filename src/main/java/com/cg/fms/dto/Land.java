package com.cg.fms.dto;
/*******************************
 * @author Abu Md Faisal
 * Description: This is the DTO class for Land module. 
 * Created Date: 21 April, 2021 
 * Version : v1.1
 *******************************/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="land3")
	public class Land  {
		
		@Column(name="land_id")
		private int landId;
		@Id
		@Column(name="survey_number")
		private String surveyNumber;
		@Column(name="owner_name")
		private String ownerName;
		@Column(name="land_area")
		private String landArea;
		public Land() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Land(int landId, String surveyNumber, String ownerName, String landArea) {
			super();
			this.landId = landId;
			this.surveyNumber = surveyNumber;
			this.ownerName = ownerName;
			this.landArea = landArea;
		}
		public int getLandId() {
			return landId;
		}
		public void setLandId(int landId) {
			this.landId = landId;
		}
		public String getSurveyNumber() {
			return surveyNumber;
		}
		public void setSurveyNumber(String surveyNumber) {
			this.surveyNumber = surveyNumber;
		}
		public String getOwnerName() {
			return ownerName;
		}
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		public String getLandArea() {
			return landArea;
		}
		public void setLandArea(String landArea) {
			this.landArea = landArea;
		}
		@Override
		public String toString() {
			return "Land [landId=" + landId + ", surveyNumber=" + surveyNumber + ", ownerName=" + ownerName + ", landArea="
					+ landArea + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((landArea == null) ? 0 : landArea.hashCode());
			result = prime * result + landId;
			result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
			result = prime * result + ((surveyNumber == null) ? 0 : surveyNumber.hashCode());
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
			Land other = (Land) obj;
			if (landArea == null) {
				if (other.landArea != null)
					return false;
			} else if (!landArea.equals(other.landArea))
				return false;
			if (landId != other.landId)
				return false;
			if (ownerName == null) {
				if (other.ownerName != null)
					return false;
			} else if (!ownerName.equals(other.ownerName))
				return false;
			if (surveyNumber == null) {
				if (other.surveyNumber != null)
					return false;
			} else if (!surveyNumber.equals(other.surveyNumber))
				return false;
			return true;
		}
		
	}

