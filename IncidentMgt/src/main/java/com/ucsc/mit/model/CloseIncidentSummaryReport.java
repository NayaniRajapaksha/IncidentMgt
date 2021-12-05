package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

public class CloseIncidentSummaryReport implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int INCIDENT_NUMBER;
	
	private Date CREATED_DATE;
	
	private Date MODIFIED_DATE;
	
	private Date UASSIGN_DATE;
	
	private String UNIT_NAME;
	
	private String IMPACT_LVL_NAME;
	
	private String URGENCY_NAME;
	
	private String STATUS;
	
	private String CLOSE_USER_LVL;
	
	private String MODIFIED_BY;
	
	private String CLOSE_RESON;

	public CloseIncidentSummaryReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CloseIncidentSummaryReport(int iNCIDENT_NUMBER, Date cREATED_DATE, Date mODIFIED_DATE, Date uASSIGN_DATE,
			String uNIT_NAME, String iMPACT_LVL_NAME, String uRGENCY_NAME, String sTATUS, String cLOSE_USER_LVL,
			String mODIFIED_BY, String cLOSE_RESON) {
		super();
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
		CREATED_DATE = cREATED_DATE;
		MODIFIED_DATE = mODIFIED_DATE;
		UASSIGN_DATE = uASSIGN_DATE;
		UNIT_NAME = uNIT_NAME;
		IMPACT_LVL_NAME = iMPACT_LVL_NAME;
		URGENCY_NAME = uRGENCY_NAME;
		STATUS = sTATUS;
		CLOSE_USER_LVL = cLOSE_USER_LVL;
		MODIFIED_BY = mODIFIED_BY;
		CLOSE_RESON = cLOSE_RESON;
	}

	public int getINCIDENT_NUMBER() {
		return INCIDENT_NUMBER;
	}

	public void setINCIDENT_NUMBER(int iNCIDENT_NUMBER) {
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
	}

	public Date getCREATED_DATE() {
		return CREATED_DATE;
	}

	public void setCREATED_DATE(Date cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}

	public Date getMODIFIED_DATE() {
		return MODIFIED_DATE;
	}

	public void setMODIFIED_DATE(Date mODIFIED_DATE) {
		MODIFIED_DATE = mODIFIED_DATE;
	}

	public Date getUASSIGN_DATE() {
		return UASSIGN_DATE;
	}

	public void setUASSIGN_DATE(Date uASSIGN_DATE) {
		UASSIGN_DATE = uASSIGN_DATE;
	}

	public String getUNIT_NAME() {
		return UNIT_NAME;
	}

	public void setUNIT_NAME(String uNIT_NAME) {
		UNIT_NAME = uNIT_NAME;
	}

	public String getIMPACT_LVL_NAME() {
		return IMPACT_LVL_NAME;
	}

	public void setIMPACT_LVL_NAME(String iMPACT_LVL_NAME) {
		IMPACT_LVL_NAME = iMPACT_LVL_NAME;
	}

	public String getURGENCY_NAME() {
		return URGENCY_NAME;
	}

	public void setURGENCY_NAME(String uRGENCY_NAME) {
		URGENCY_NAME = uRGENCY_NAME;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getCLOSE_USER_LVL() {
		return CLOSE_USER_LVL;
	}

	public void setCLOSE_USER_LVL(String cLOSE_USER_LVL) {
		CLOSE_USER_LVL = cLOSE_USER_LVL;
	}

	public String getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(String mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	public String getCLOSE_RESON() {
		return CLOSE_RESON;
	}

	public void setCLOSE_RESON(String cLOSE_RESON) {
		CLOSE_RESON = cLOSE_RESON;
	}

	@Override
	public String toString() {
		return "CloseIncidentSummaryReport [INCIDENT_NUMBER=" + INCIDENT_NUMBER + ", CREATED_DATE=" + CREATED_DATE
				+ ", MODIFIED_DATE=" + MODIFIED_DATE + ", UASSIGN_DATE=" + UASSIGN_DATE + ", UNIT_NAME=" + UNIT_NAME
				+ ", IMPACT_LVL_NAME=" + IMPACT_LVL_NAME + ", URGENCY_NAME=" + URGENCY_NAME + ", STATUS=" + STATUS
				+ ", CLOSE_USER_LVL=" + CLOSE_USER_LVL + ", MODIFIED_BY=" + MODIFIED_BY + ", CLOSE_RESON=" + CLOSE_RESON
				+ "]";
	}
	
	
}
