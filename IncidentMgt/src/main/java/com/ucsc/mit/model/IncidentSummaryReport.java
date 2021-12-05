package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class IncidentSummaryReport implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int INCIDENT_NUMBER;
		
	private Date CREATED_DATE;
	
	private String STATUS_DESC;
		
	private String IMPACT_LVL_NAME;
	
	private String URGENCY_NAME;
	
	private String TYPE_NAME;
	
	private String SUB_TYPE_NAME;
	
	private String LOC_NAME;
	
	private String IRTMEMBER;
		
	private String ASSIGN_MEM;
	
	private String UNIT_NAME;
		
	private Date MODIFIED_DATE;
	
	private String REPORTED_BY;
	
	private String EMPNAME;
	
	private String STATUS_CODE;

	public IncidentSummaryReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncidentSummaryReport(int iNCIDENT_NUMBER, Date cREATED_DATE, String sTATUS_DESC, String iMPACT_LVL_NAME,
			String uRGENCY_NAME, String tYPE_NAME, String sUB_TYPE_NAME, String lOC_NAME, String iRTMEMBER,
			String aSSIGN_MEM, String uNIT_NAME, Date mODIFIED_DATE, String rEPORTED_BY, String eMPNAME,
			String sTATUS_CODE) {
		super();
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
		CREATED_DATE = cREATED_DATE;
		STATUS_DESC = sTATUS_DESC;
		IMPACT_LVL_NAME = iMPACT_LVL_NAME;
		URGENCY_NAME = uRGENCY_NAME;
		TYPE_NAME = tYPE_NAME;
		SUB_TYPE_NAME = sUB_TYPE_NAME;
		LOC_NAME = lOC_NAME;
		IRTMEMBER = iRTMEMBER;
		ASSIGN_MEM = aSSIGN_MEM;
		UNIT_NAME = uNIT_NAME;
		MODIFIED_DATE = mODIFIED_DATE;
		REPORTED_BY = rEPORTED_BY;
		EMPNAME = eMPNAME;
		STATUS_CODE = sTATUS_CODE;
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

	public String getSTATUS_DESC() {
		return STATUS_DESC;
	}

	public void setSTATUS_DESC(String sTATUS_DESC) {
		STATUS_DESC = sTATUS_DESC;
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

	public String getTYPE_NAME() {
		return TYPE_NAME;
	}

	public void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}

	public String getSUB_TYPE_NAME() {
		return SUB_TYPE_NAME;
	}

	public void setSUB_TYPE_NAME(String sUB_TYPE_NAME) {
		SUB_TYPE_NAME = sUB_TYPE_NAME;
	}

	public String getLOC_NAME() {
		return LOC_NAME;
	}

	public void setLOC_NAME(String lOC_NAME) {
		LOC_NAME = lOC_NAME;
	}

	public String getIRTMEMBER() {
		return IRTMEMBER;
	}

	public void setIRTMEMBER(String iRTMEMBER) {
		IRTMEMBER = iRTMEMBER;
	}

	public String getASSIGN_MEM() {
		return ASSIGN_MEM;
	}

	public void setASSIGN_MEM(String aSSIGN_MEM) {
		ASSIGN_MEM = aSSIGN_MEM;
	}

	public String getUNIT_NAME() {
		return UNIT_NAME;
	}

	public void setUNIT_NAME(String uNIT_NAME) {
		UNIT_NAME = uNIT_NAME;
	}

	public Date getMODIFIED_DATE() {
		return MODIFIED_DATE;
	}

	public void setMODIFIED_DATE(Date mODIFIED_DATE) {
		MODIFIED_DATE = mODIFIED_DATE;
	}

	public String getREPORTED_BY() {
		return REPORTED_BY;
	}

	public void setREPORTED_BY(String rEPORTED_BY) {
		REPORTED_BY = rEPORTED_BY;
	}

	public String getEMPNAME() {
		return EMPNAME;
	}

	public void setEMPNAME(String eMPNAME) {
		EMPNAME = eMPNAME;
	}

	public String getSTATUS_CODE() {
		return STATUS_CODE;
	}

	public void setSTATUS_CODE(String sTATUS_CODE) {
		STATUS_CODE = sTATUS_CODE;
	}

	@Override
	public String toString() {
		return "IncidentSummaryReport [INCIDENT_NUMBER=" + INCIDENT_NUMBER + ", CREATED_DATE=" + CREATED_DATE
				+ ", STATUS_DESC=" + STATUS_DESC + ", IMPACT_LVL_NAME=" + IMPACT_LVL_NAME + ", URGENCY_NAME="
				+ URGENCY_NAME + ", TYPE_NAME=" + TYPE_NAME + ", SUB_TYPE_NAME=" + SUB_TYPE_NAME + ", LOC_NAME="
				+ LOC_NAME + ", IRTMEMBER=" + IRTMEMBER + ", ASSIGN_MEM=" + ASSIGN_MEM + ", UNIT_NAME=" + UNIT_NAME
				+ ", MODIFIED_DATE=" + MODIFIED_DATE + ", REPORTED_BY=" + REPORTED_BY + ", EMPNAME=" + EMPNAME
				+ ", STATUS_CODE=" + STATUS_CODE + "]";
	}
	
	
}
