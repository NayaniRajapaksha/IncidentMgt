package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

public class ResolveIncidentSummaryReport implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	private int INCIDENT_NUMBER;
		
	private Date CREATED_DATE;
	
	private Date UASSIGN_DATE;
		
	private String RESOLVE_DATE;
	
	private String UNIT_NAME;
	
	private String MEM_NAME;
	
	private String IMPACT_LVL_NAME;
	
	private String URGENCY_NAME;
	
	private String ROOT_CAUSE;
		
	private String ACTION_TAKEN;

	public ResolveIncidentSummaryReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResolveIncidentSummaryReport(int iNCIDENT_NUMBER, Date cREATED_DATE, Date uASSIGN_DATE, String rESOLVE_DATE,
			String uNIT_NAME, String mEM_NAME, String iMPACT_LVL_NAME, String uRGENCY_NAME, String rOOT_CAUSE,
			String aCTION_TAKEN) {
		super();
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
		CREATED_DATE = cREATED_DATE;
		UASSIGN_DATE = uASSIGN_DATE;
		RESOLVE_DATE = rESOLVE_DATE;
		UNIT_NAME = uNIT_NAME;
		MEM_NAME = mEM_NAME;
		IMPACT_LVL_NAME = iMPACT_LVL_NAME;
		URGENCY_NAME = uRGENCY_NAME;
		ROOT_CAUSE = rOOT_CAUSE;
		ACTION_TAKEN = aCTION_TAKEN;
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

	public Date getUASSIGN_DATE() {
		return UASSIGN_DATE;
	}

	public void setUASSIGN_DATE(Date uASSIGN_DATE) {
		UASSIGN_DATE = uASSIGN_DATE;
	}

	public String getRESOLVE_DATE() {
		return RESOLVE_DATE;
	}

	public void setRESOLVE_DATE(String rESOLVE_DATE) {
		RESOLVE_DATE = rESOLVE_DATE;
	}

	public String getUNIT_NAME() {
		return UNIT_NAME;
	}

	public void setUNIT_NAME(String uNIT_NAME) {
		UNIT_NAME = uNIT_NAME;
	}

	public String getMEM_NAME() {
		return MEM_NAME;
	}

	public void setMEM_NAME(String mEM_NAME) {
		MEM_NAME = mEM_NAME;
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

	public String getROOT_CAUSE() {
		return ROOT_CAUSE;
	}

	public void setROOT_CAUSE(String rOOT_CAUSE) {
		ROOT_CAUSE = rOOT_CAUSE;
	}

	public String getACTION_TAKEN() {
		return ACTION_TAKEN;
	}

	public void setACTION_TAKEN(String aCTION_TAKEN) {
		ACTION_TAKEN = aCTION_TAKEN;
	}

	@Override
	public String toString() {
		return "ResolveIncidentSummaryReport [INCIDENT_NUMBER=" + INCIDENT_NUMBER + ", CREATED_DATE=" + CREATED_DATE
				+ ", UASSIGN_DATE=" + UASSIGN_DATE + ", RESOLVE_DATE=" + RESOLVE_DATE + ", UNIT_NAME=" + UNIT_NAME
				+ ", MEM_NAME=" + MEM_NAME + ", IMPACT_LVL_NAME=" + IMPACT_LVL_NAME + ", URGENCY_NAME=" + URGENCY_NAME
				+ ", ROOT_CAUSE=" + ROOT_CAUSE + ", ACTION_TAKEN=" + ACTION_TAKEN + "]";
	}
	
	
	
	
}
