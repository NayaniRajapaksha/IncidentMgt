package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class TMPerformanceReport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int INCIDENT_NUMBER;
	
	private String CREATED_BY;
	
	private String UNIT_NAME;
	
	
	private int ASSIGNED_UNIT;
	
	private String STATUS;
	
	private String SOLVED_IN_TIME;

	private Date CREATED_DATE;
	
	private int PENDING_COUNT;
	
	private int COMPLETE_DEPENDENCY;

	private int COLOSED_DEPENDENCY;

	public TMPerformanceReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TMPerformanceReport(int iNCIDENT_NUMBER, String cREATED_BY, String uNIT_NAME, int aSSIGNED_UNIT,
			String sTATUS, String sOLVED_IN_TIME, Date cREATED_DATE, int pENDING_COUNT, int cOMPLETE_DEPENDENCY,
			int cOLOSED_DEPENDENCY) {
		super();
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
		CREATED_BY = cREATED_BY;
		UNIT_NAME = uNIT_NAME;
		ASSIGNED_UNIT = aSSIGNED_UNIT;
		STATUS = sTATUS;
		SOLVED_IN_TIME = sOLVED_IN_TIME;
		CREATED_DATE = cREATED_DATE;
		PENDING_COUNT = pENDING_COUNT;
		COMPLETE_DEPENDENCY = cOMPLETE_DEPENDENCY;
		COLOSED_DEPENDENCY = cOLOSED_DEPENDENCY;
	}

	public int getINCIDENT_NUMBER() {
		return INCIDENT_NUMBER;
	}

	public void setINCIDENT_NUMBER(int iNCIDENT_NUMBER) {
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
	}

	public String getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
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

	@Override
	public String toString() {
		return "TMPerformanceReport [INCIDENT_NUMBER=" + INCIDENT_NUMBER + ", CREATED_BY=" + CREATED_BY + ", UNIT_NAME="
				+ UNIT_NAME + ", ASSIGNED_UNIT=" + ASSIGNED_UNIT + ", STATUS=" + STATUS + ", SOLVED_IN_TIME="
				+ SOLVED_IN_TIME + ", CREATED_DATE=" + CREATED_DATE + ", PENDING_COUNT=" + PENDING_COUNT
				+ ", COMPLETE_DEPENDENCY=" + COMPLETE_DEPENDENCY + ", COLOSED_DEPENDENCY=" + COLOSED_DEPENDENCY + "]";
	}
	


}
