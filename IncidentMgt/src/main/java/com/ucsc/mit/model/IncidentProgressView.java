package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="incident_status_view")
@ManagedBean(name="progress")
@Proxy(lazy=false)
public class IncidentProgressView  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Column(name="INCIDENT_NUMBER")
	private int incidentNo;
	
	@Id
	@Column(name="MODIFIED_DATE")
	private Date statusDate;
	
	@Column(name="STATUS")
	private String progStatusCode;
	
	@Column(name="MODIFIED_BY")
	private String userID;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="STATUS_REMARK")
	private String statusRemark;
	
	@Column(name="STATUS_DESC")
	private String statusDes;
	
	@Column(name="EMP_STATUS_DESC")
	private String empStatusDes;
	
	@Column(name="USER_LEVEL")
	private String userLevel;
	
	public IncidentProgressView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncidentProgressView(int incidentNo, Date statusDate, String progStatusCode, String userID, String empName,
			String createdBy, String statusRemark, String statusDes, String empStatusDes, String userLevel) {
		super();
		this.incidentNo = incidentNo;
		this.statusDate = statusDate;
		this.progStatusCode = progStatusCode;
		this.userID = userID;
		this.empName = empName;
		this.createdBy = createdBy;
		this.statusRemark = statusRemark;
		this.statusDes = statusDes;
		this.empStatusDes = empStatusDes;
		this.userLevel = userLevel;
	}

	public int getIncidentNo() {
		return incidentNo;
	}

	public void setIncidentNo(int incidentNo) {
		this.incidentNo = incidentNo;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public String getProgStatusCode() {
		return progStatusCode;
	}

	public void setProgStatusCode(String progStatusCode) {
		this.progStatusCode = progStatusCode;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatusRemark() {
		return statusRemark;
	}

	public void setStatusRemark(String statusRemark) {
		this.statusRemark = statusRemark;
	}

	public String getStatusDes() {
		return statusDes;
	}

	public void setStatusDes(String statusDes) {
		this.statusDes = statusDes;
	}

	public String getEmpStatusDes() {
		return empStatusDes;
	}

	public void setEmpStatusDes(String empStatusDes) {
		this.empStatusDes = empStatusDes;
	}

	
	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	@Override
	public String toString() {
		return "IncidentProgressView [incidentNo=" + incidentNo + ", statusDate=" + statusDate + ", progStatusCode="
				+ progStatusCode + ", userID=" + userID + ", empName=" + empName + ", createdBy=" + createdBy
				+ ", statusRemark=" + statusRemark + ", statusDes=" + statusDes + ", empStatusDes=" + empStatusDes
				+ ", userLevel=" + userLevel + "]";
	}

	
	
	
}
