package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="incident_unit_summary_v")
@ManagedBean(name="incident_unit_summary_v")
@Proxy(lazy=false)
public class UnitIncidentSummaryView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="INCIDENT_ID")
	private int INCIDENT_ID;
	
	@Column(name="UNIT_NAME")
	private String UNIT_NAME;
	
	@Column(name="ASSIGNED_UNIT_ID")
	private int ASSIGNED_UNIT_ID;
	
	@Column(name="status")
	private String status;
	
	@Column(name="SOLVED_IN_TIME")
	private String SOLVED_IN_TIME;
	
	@Column(name="created_date")
	private Date created_date;
	
	@Column(name="CREATED_BY")
	private String CREATED_BY;
	
	@Column(name="LOCATION_ID")
	private int LOCATION_ID;
	
	@Column(name="LOCATION_NAME")
	private String LOCATION_NAME;

	public UnitIncidentSummaryView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnitIncidentSummaryView(int iNCIDENT_ID, String uNIT_NAME, int aSSIGNED_UNIT_ID, String status,
			String sOLVED_IN_TIME, Date created_date, String cREATED_BY, int lOCATION_ID, String lOCATION_NAME) {
		super();
		INCIDENT_ID = iNCIDENT_ID;
		UNIT_NAME = uNIT_NAME;
		ASSIGNED_UNIT_ID = aSSIGNED_UNIT_ID;
		this.status = status;
		SOLVED_IN_TIME = sOLVED_IN_TIME;
		this.created_date = created_date;
		CREATED_BY = cREATED_BY;
		LOCATION_ID = lOCATION_ID;
		LOCATION_NAME = lOCATION_NAME;
	}

	public int getINCIDENT_ID() {
		return INCIDENT_ID;
	}

	public void setINCIDENT_ID(int iNCIDENT_ID) {
		INCIDENT_ID = iNCIDENT_ID;
	}

	public String getUNIT_NAME() {
		return UNIT_NAME;
	}

	public void setUNIT_NAME(String uNIT_NAME) {
		UNIT_NAME = uNIT_NAME;
	}

	public int getASSIGNED_UNIT_ID() {
		return ASSIGNED_UNIT_ID;
	}

	public void setASSIGNED_UNIT_ID(int aSSIGNED_UNIT_ID) {
		ASSIGNED_UNIT_ID = aSSIGNED_UNIT_ID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSOLVED_IN_TIME() {
		return SOLVED_IN_TIME;
	}

	public void setSOLVED_IN_TIME(String sOLVED_IN_TIME) {
		SOLVED_IN_TIME = sOLVED_IN_TIME;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	public int getLOCATION_ID() {
		return LOCATION_ID;
	}

	public void setLOCATION_ID(int lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}

	public String getLOCATION_NAME() {
		return LOCATION_NAME;
	}

	public void setLOCATION_NAME(String lOCATION_NAME) {
		LOCATION_NAME = lOCATION_NAME;
	}

	@Override
	public String toString() {
		return "UnitIncidentSummaryView [INCIDENT_ID=" + INCIDENT_ID + ", UNIT_NAME=" + UNIT_NAME
				+ ", ASSIGNED_UNIT_ID=" + ASSIGNED_UNIT_ID + ", status=" + status + ", SOLVED_IN_TIME=" + SOLVED_IN_TIME
				+ ", created_date=" + created_date + ", CREATED_BY=" + CREATED_BY + ", LOCATION_ID=" + LOCATION_ID
				+ ", LOCATION_NAME=" + LOCATION_NAME + "]";
	}

	
}
