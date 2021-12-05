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

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="incident_unit_m")
@ManagedBean(name="unit")
@Proxy(lazy=false)
public class Unit implements Serializable{
	
	
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="UNIT_CODE")
	private String unitCode;
	
	@Column(name="UNIT_NAME")
	private String unitName;
	
	@Column(name="UNIT_STATUS")
	private String unitStatus;
	
	@Column(name="UNIT_HEAD")
	private String unitHead;
	
	@Column(name="UNIT_REPORT_TO")
	private String unitReportTo;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;

	
	

	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Unit(int id, String unitCode, String unitName, String unitStatus, String unitHead, String unitReportTo,
			String createdBy, Date createdDate) {
		super();
		this.id = id;
		this.unitCode = unitCode;
		this.unitName = unitName;
		this.unitStatus = unitStatus;
		this.unitHead = unitHead;
		this.unitReportTo = unitReportTo;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitStatus() {
		return unitStatus;
	}

	public void setUnitStatus(String unitStatus) {
		this.unitStatus = unitStatus;
	}

	public String getUnitHead() {
		return unitHead;
	}

	public void setUnitHead(String unitHead) {
		this.unitHead = unitHead;
	}

	public String getUnitReportTo() {
		return unitReportTo;
	}

	public void setUnitReportTo(String unitReportTo) {
		this.unitReportTo = unitReportTo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	@Override
	public String toString() {
		return "Unit [id=" + id + ", unitCode=" + unitCode + ", unitName=" + unitName + ", unitStatus=" + unitStatus
				+ ", unitHead=" + unitHead + ", unitReportTo=" + unitReportTo + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + "]";
	}
	

	
}
