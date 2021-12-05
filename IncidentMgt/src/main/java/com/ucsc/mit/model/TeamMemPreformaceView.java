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
@Table(name="team_member_performance_summary_v")
@ManagedBean(name="team_member_performance")
@Proxy(lazy=false)
public class TeamMemPreformaceView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="INCIDENT_NUMBER")
	private int INCIDENT_NUMBER;
	
	@Column(name="NAME")
	private String NAME;
	
	@Column(name="UNIT_NAME")
	private String UNIT_NAME;
	
	@Column(name="ASSIGNED_UNIT")
	private int ASSIGNED_UNIT;
	
	@Column(name="STATUS")
	private String STATUS;
	
	@Column(name="SOLVED_IN_TIME")
	private String SOLVED_IN_TIME;
	
	@Column(name="CREATED_DATE")
	private Date CREATED_DATE;
	
	@Column(name="PENDING_COUNT")
	private int PENDING_COUNT;
	
	@Column(name="COMPLETE_DEPENDENCY")
	private int COMPLETE_DEPENDENCY;
	
	@Column(name="COLOSED_DEPENDENCY")
	private int COLOSED_DEPENDENCY;
	
	@Column(name="LOCATION_NAME")
	private int LOCATION_NAME;

	public TeamMemPreformaceView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamMemPreformaceView(int iNCIDENT_NUMBER, String nAME, String uNIT_NAME, int aSSIGNED_UNIT, String sTATUS,
			String sOLVED_IN_TIME, Date cREATED_DATE, int pENDING_COUNT, int cOMPLETE_DEPENDENCY,
			int cOLOSED_DEPENDENCY, int lOCATION_NAME) {
		super();
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
		NAME = nAME;
		UNIT_NAME = uNIT_NAME;
		ASSIGNED_UNIT = aSSIGNED_UNIT;
		STATUS = sTATUS;
		SOLVED_IN_TIME = sOLVED_IN_TIME;
		CREATED_DATE = cREATED_DATE;
		PENDING_COUNT = pENDING_COUNT;
		COMPLETE_DEPENDENCY = cOMPLETE_DEPENDENCY;
		COLOSED_DEPENDENCY = cOLOSED_DEPENDENCY;
		LOCATION_NAME = lOCATION_NAME;
	}

	public int getINCIDENT_NUMBER() {
		return INCIDENT_NUMBER;
	}

	public void setINCIDENT_NUMBER(int iNCIDENT_NUMBER) {
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getUNIT_NAME() {
		return UNIT_NAME;
	}

	public void setUNIT_NAME(String uNIT_NAME) {
		UNIT_NAME = uNIT_NAME;
	}

	public int getASSIGNED_UNIT() {
		return ASSIGNED_UNIT;
	}

	public void setASSIGNED_UNIT(int aSSIGNED_UNIT) {
		ASSIGNED_UNIT = aSSIGNED_UNIT;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getSOLVED_IN_TIME() {
		return SOLVED_IN_TIME;
	}

	public void setSOLVED_IN_TIME(String sOLVED_IN_TIME) {
		SOLVED_IN_TIME = sOLVED_IN_TIME;
	}

	public Date getCREATED_DATE() {
		return CREATED_DATE;
	}

	public void setCREATED_DATE(Date cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}

	public int getPENDING_COUNT() {
		return PENDING_COUNT;
	}

	public void setPENDING_COUNT(int pENDING_COUNT) {
		PENDING_COUNT = pENDING_COUNT;
	}

	public int getCOMPLETE_DEPENDENCY() {
		return COMPLETE_DEPENDENCY;
	}

	public void setCOMPLETE_DEPENDENCY(int cOMPLETE_DEPENDENCY) {
		COMPLETE_DEPENDENCY = cOMPLETE_DEPENDENCY;
	}

	public int getCOLOSED_DEPENDENCY() {
		return COLOSED_DEPENDENCY;
	}

	public void setCOLOSED_DEPENDENCY(int cOLOSED_DEPENDENCY) {
		COLOSED_DEPENDENCY = cOLOSED_DEPENDENCY;
	}

	public int getLOCATION_NAME() {
		return LOCATION_NAME;
	}

	public void setLOCATION_NAME(int lOCATION_NAME) {
		LOCATION_NAME = lOCATION_NAME;
	}

	@Override
	public String toString() {
		return "TeamMemPreformaceView [INCIDENT_NUMBER=" + INCIDENT_NUMBER + ", NAME=" + NAME + ", UNIT_NAME="
				+ UNIT_NAME + ", ASSIGNED_UNIT=" + ASSIGNED_UNIT + ", STATUS=" + STATUS + ", SOLVED_IN_TIME="
				+ SOLVED_IN_TIME + ", CREATED_DATE=" + CREATED_DATE + ", PENDING_COUNT=" + PENDING_COUNT
				+ ", COMPLETE_DEPENDENCY=" + COMPLETE_DEPENDENCY + ", COLOSED_DEPENDENCY=" + COLOSED_DEPENDENCY
				+ ", LOCATION_NAME=" + LOCATION_NAME + "]";
	}
	
	

}
