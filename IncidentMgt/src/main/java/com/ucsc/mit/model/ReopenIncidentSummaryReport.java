package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

public class ReopenIncidentSummaryReport implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int INCIDENT_NUMBER;
	private Date CREATED_DATE;
	private Date ASSIGNED_DATE_TIME;
	private String INI_DATE_TIME;
	private Date REOPN_DATE_TIME;
	private Date MODIFIED_DATE;
	
	private String UNIT_NAME;
	
	private String IMPACT_LVL_NAME;
	
	private String URGENCY_NAME;
	
	private String REOPEN_BY;
	
	private String REOPENLVL;
	
	private String STATUS_REMARK;
	
	private String STATUS;
		
	private String MODIFIED_BY;
	
	private String CREATED_BY;
	
	private String REOPEN_REASON;
	
	private String CURRENT_PROG;

	public ReopenIncidentSummaryReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ReopenIncidentSummaryReport(int iNCIDENT_NUMBER, Date cREATED_DATE, Date aSSIGNED_DATE_TIME,
			String iNI_DATE_TIME, Date rEOPN_DATE_TIME, Date mODIFIED_DATE, String uNIT_NAME,
			String iMPACT_LVL_NAME, String uRGENCY_NAME, String rEOPEN_BY, String rEOPENLVL, String sTATUS_REMARK,
			String sTATUS, String mODIFIED_BY, String cREATED_BY, String rEOPEN_REASON, String cURRENT_PROG) {
		super();
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
		CREATED_DATE = cREATED_DATE;
		ASSIGNED_DATE_TIME = aSSIGNED_DATE_TIME;
		INI_DATE_TIME = iNI_DATE_TIME;
		REOPN_DATE_TIME = rEOPN_DATE_TIME;
		MODIFIED_DATE = mODIFIED_DATE;
		UNIT_NAME = uNIT_NAME;
		IMPACT_LVL_NAME = iMPACT_LVL_NAME;
		URGENCY_NAME = uRGENCY_NAME;
		REOPEN_BY = rEOPEN_BY;
		REOPENLVL = rEOPENLVL;
		STATUS_REMARK = sTATUS_REMARK;
		STATUS = sTATUS;
		MODIFIED_BY = mODIFIED_BY;
		CREATED_BY = cREATED_BY;
		REOPEN_REASON = rEOPEN_REASON;
		CURRENT_PROG = cURRENT_PROG;
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

	public Date getASSIGNED_DATE_TIME() {
		return ASSIGNED_DATE_TIME;
	}

	public void setASSIGNED_DATE_TIME(Date aSSIGNED_DATE_TIME) {
		ASSIGNED_DATE_TIME = aSSIGNED_DATE_TIME;
	}

	public String getINI_DATE_TIME() {
		return INI_DATE_TIME;
	}

	public void setINI_DATE_TIME(String iNI_DATE_TIME) {
		INI_DATE_TIME = iNI_DATE_TIME;
	}

	public Date getREOPN_DATE_TIME() {
		return REOPN_DATE_TIME;
	}

	public void setREOPN_DATE_TIME(Date rEOPN_DATE_TIME) {
		REOPN_DATE_TIME = rEOPN_DATE_TIME;
	}

	public Date getMODIFIED_DATE() {
		return MODIFIED_DATE;
	}

	public void setMODIFIED_DATE(Date mODIFIED_DATE) {
		MODIFIED_DATE = mODIFIED_DATE;
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

	public String getREOPEN_BY() {
		return REOPEN_BY;
	}

	public void setREOPEN_BY(String rEOPEN_BY) {
		REOPEN_BY = rEOPEN_BY;
	}

	public String getREOPENLVL() {
		return REOPENLVL;
	}

	public void setREOPENLVL(String rEOPENLVL) {
		REOPENLVL = rEOPENLVL;
	}

	public String getSTATUS_REMARK() {
		return STATUS_REMARK;
	}

	public void setSTATUS_REMARK(String sTATUS_REMARK) {
		STATUS_REMARK = sTATUS_REMARK;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(String mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	public String getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	public String getREOPEN_REASON() {
		return REOPEN_REASON;
	}

	public void setREOPEN_REASON(String rEOPEN_REASON) {
		REOPEN_REASON = rEOPEN_REASON;
	}

	public String getCURRENT_PROG() {
		return CURRENT_PROG;
	}

	public void setCURRENT_PROG(String cURRENT_PROG) {
		CURRENT_PROG = cURRENT_PROG;
	}

	@Override
	public String toString() {
		return "ReopenIncidentSummaryReport [INCIDENT_NUMBER=" + INCIDENT_NUMBER + ", CREATED_DATE=" + CREATED_DATE
				+ ", ASSIGNED_DATE_TIME=" + ASSIGNED_DATE_TIME + ", INI_DATE_TIME=" + INI_DATE_TIME
				+ ", REOPN_DATE_TIME=" + REOPN_DATE_TIME + ", MODIFIED_DATE=" + MODIFIED_DATE + ", UNIT_NAME="
				+ UNIT_NAME + ", IMPACT_LVL_NAME=" + IMPACT_LVL_NAME + ", URGENCY_NAME=" + URGENCY_NAME + ", REOPEN_BY="
				+ REOPEN_BY + ", REOPENLVL=" + REOPENLVL + ", STATUS_REMARK=" + STATUS_REMARK + ", STATUS=" + STATUS
				+ ", MODIFIED_BY=" + MODIFIED_BY + ", CREATED_BY=" + CREATED_BY + ", REOPEN_REASON=" + REOPEN_REASON
				+ ", CURRENT_PROG=" + CURRENT_PROG + "]";
	}
	
	

}
