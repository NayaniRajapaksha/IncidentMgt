package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class VendorSummaryReport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int INCIDENT_NUMBER;
	

	private String VEN_NAME;
	

	private String CONTACT_NO;
	

	private String status;
	

	private String EMAIL;
	

	private Date created_date;
	

	private String INFORMED_BY;
	

	private Date INFORMED_DATE;
	

	private Date VENDOR_RESOLVE_DATE;
	

	private String RESOLVE_DATE_UPDATED_BY;
	
	private String CREATED_BY;
	private int LOCATION_NAME;
	
	public VendorSummaryReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendorSummaryReport(int iNCIDENT_NUMBER, String vEN_NAME, String cONTACT_NO, String status, String eMAIL,
			Date created_date, String iNFORMED_BY, Date iNFORMED_DATE, Date vENDOR_RESOLVE_DATE,
			String rESOLVE_DATE_UPDATED_BY, String cREATED_BY, int lOCATION_NAME) {
		super();
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
		VEN_NAME = vEN_NAME;
		CONTACT_NO = cONTACT_NO;
		this.status = status;
		EMAIL = eMAIL;
		this.created_date = created_date;
		INFORMED_BY = iNFORMED_BY;
		INFORMED_DATE = iNFORMED_DATE;
		VENDOR_RESOLVE_DATE = vENDOR_RESOLVE_DATE;
		RESOLVE_DATE_UPDATED_BY = rESOLVE_DATE_UPDATED_BY;
		CREATED_BY = cREATED_BY;
		LOCATION_NAME = lOCATION_NAME;
	}

	public int getINCIDENT_NUMBER() {
		return INCIDENT_NUMBER;
	}

	public void setINCIDENT_NUMBER(int iNCIDENT_NUMBER) {
		INCIDENT_NUMBER = iNCIDENT_NUMBER;
	}

	public String getVEN_NAME() {
		return VEN_NAME;
	}

	public void setVEN_NAME(String vEN_NAME) {
		VEN_NAME = vEN_NAME;
	}

	public String getCONTACT_NO() {
		return CONTACT_NO;
	}

	public void setCONTACT_NO(String cONTACT_NO) {
		CONTACT_NO = cONTACT_NO;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getINFORMED_BY() {
		return INFORMED_BY;
	}

	public void setINFORMED_BY(String iNFORMED_BY) {
		INFORMED_BY = iNFORMED_BY;
	}

	public Date getINFORMED_DATE() {
		return INFORMED_DATE;
	}

	public void setINFORMED_DATE(Date iNFORMED_DATE) {
		INFORMED_DATE = iNFORMED_DATE;
	}

	public Date getVENDOR_RESOLVE_DATE() {
		return VENDOR_RESOLVE_DATE;
	}

	public void setVENDOR_RESOLVE_DATE(Date vENDOR_RESOLVE_DATE) {
		VENDOR_RESOLVE_DATE = vENDOR_RESOLVE_DATE;
	}

	public String getRESOLVE_DATE_UPDATED_BY() {
		return RESOLVE_DATE_UPDATED_BY;
	}

	public void setRESOLVE_DATE_UPDATED_BY(String rESOLVE_DATE_UPDATED_BY) {
		RESOLVE_DATE_UPDATED_BY = rESOLVE_DATE_UPDATED_BY;
	}

	public String getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	public int getLOCATION_NAME() {
		return LOCATION_NAME;
	}

	public void setLOCATION_NAME(int lOCATION_NAME) {
		LOCATION_NAME = lOCATION_NAME;
	}

	@Override
	public String toString() {
		return "VendorSummaryReport [INCIDENT_NUMBER=" + INCIDENT_NUMBER + ", VEN_NAME=" + VEN_NAME + ", CONTACT_NO="
				+ CONTACT_NO + ", status=" + status + ", EMAIL=" + EMAIL + ", created_date=" + created_date
				+ ", INFORMED_BY=" + INFORMED_BY + ", INFORMED_DATE=" + INFORMED_DATE + ", VENDOR_RESOLVE_DATE="
				+ VENDOR_RESOLVE_DATE + ", RESOLVE_DATE_UPDATED_BY=" + RESOLVE_DATE_UPDATED_BY + ", CREATED_BY="
				+ CREATED_BY + ", LOCATION_NAME=" + LOCATION_NAME + "]";
	}
	
	
	
}
