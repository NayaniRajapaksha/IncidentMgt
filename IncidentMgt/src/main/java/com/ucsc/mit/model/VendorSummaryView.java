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
@Table(name="vendor_summary_v")
@ManagedBean(name="vendor_summary_v")
@Proxy(lazy=false)
public class VendorSummaryView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="INCIDENT_NUMBER")
	private int INCIDENT_NUMBER;
	
	@Column(name="VEN_NAME")
	private String VEN_NAME;
	
	@Column(name="CONTACT_NO")
	private String CONTACT_NO;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="EMAIL")
	private String EMAIL;
	
	@Column(name="CREATED_DATE")
	private Date created_date;
	
	@Column(name="INFORMED_BY")
	private String INFORMED_BY;
	
	@Column(name="INFORMED_DATE")
	private Date INFORMED_DATE;
	
	@Column(name="VENDOR_RESOLVE_DATE")
	private Date VENDOR_RESOLVE_DATE;
	
	@Column(name="RESOLVE_DATE_UPDATED_BY")
	private String RESOLVE_DATE_UPDATED_BY;
	
	@Column(name="LOCATION_NAME")
	private int LOCATION_ID;

	public VendorSummaryView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendorSummaryView(int iNCIDENT_NUMBER, String vEN_NAME, String cONTACT_NO, String status, String eMAIL,
			Date created_date, String iNFORMED_BY, Date iNFORMED_DATE, Date vENDOR_RESOLVE_DATE,
			String rESOLVE_DATE_UPDATED_BY, int lOCATION_ID) {
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
		LOCATION_ID = lOCATION_ID;
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

	public int getLOCATION_ID() {
		return LOCATION_ID;
	}

	public void setLOCATION_ID(int lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}

	@Override
	public String toString() {
		return "VendorSummaryView [INCIDENT_NUMBER=" + INCIDENT_NUMBER + ", VEN_NAME=" + VEN_NAME + ", CONTACT_NO="
				+ CONTACT_NO + ", status=" + status + ", EMAIL=" + EMAIL + ", created_date=" + created_date
				+ ", INFORMED_BY=" + INFORMED_BY + ", INFORMED_DATE=" + INFORMED_DATE + ", VENDOR_RESOLVE_DATE="
				+ VENDOR_RESOLVE_DATE + ", RESOLVE_DATE_UPDATED_BY=" + RESOLVE_DATE_UPDATED_BY + ", LOCATION_ID="
				+ LOCATION_ID + "]";
	}
	
	

}
