package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

public class UnitSummaryReport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int INC_ID;
	
	private String UNIT_NAME;
	private int ASSIGNED_UNIT;
	private String STATUS;
	private String SOLVED_IN_TIME;
	
	private Date CREATED_DATE;

	public UnitSummaryReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnitSummaryReport(int iNC_ID, String uNIT_NAME, int aSSIGNED_UNIT, String sTATUS, String sOLVED_IN_TIME,
			Date cREATED_DATE) {
		super();
		INC_ID = iNC_ID;
		UNIT_NAME = uNIT_NAME;
		ASSIGNED_UNIT = aSSIGNED_UNIT;
		STATUS = sTATUS;
		SOLVED_IN_TIME = sOLVED_IN_TIME;
		CREATED_DATE = cREATED_DATE;
	}

	public int getINC_ID() {
		return INC_ID;
	}

	public void setINC_ID(int iNC_ID) {
		INC_ID = iNC_ID;
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

	@Override
	public String toString() {
		return "UnitSummaryReport [INC_ID=" + INC_ID + ", UNIT_NAME=" + UNIT_NAME + ", ASSIGNED_UNIT=" + ASSIGNED_UNIT
				+ ", STATUS=" + STATUS + ", SOLVED_IN_TIME=" + SOLVED_IN_TIME + ", CREATED_DATE=" + CREATED_DATE + "]";
	}
	
	

}
