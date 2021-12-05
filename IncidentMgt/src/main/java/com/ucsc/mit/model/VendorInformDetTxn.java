package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="incident_vendor_informed_det_txn")
@ManagedBean(name="vendor_informed_det_txn")
@Proxy(lazy=false)
public class VendorInformDetTxn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="INFORM_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int informId;
	
	@Column(name="INCIDENT_ID")
	private int incidentNo;
	
	@Column(name="VENDOR_ID")
	private int vendorId;
	
	@Column(name="INFORMED_DATE")
	private Date informedDate;
	
	@Column(name="VENDOR_RESOLVE_DATE")
	private Date vResolvedDate;
	
	@Column(name="INFORMED_BY")
	private String informedBy;
	
	@Column(name="INFORMED_USER_LEVEL")
	private String informedUserLevel;
	
	@Column(name="RESOLVE_DATE_UPDATED_BY")
	private String resolveDateUpBy;
	
	@Column(name="UPDATED_USER_LEVEL")
	private String upUserLevel;
	
	@Column(name="EMAIL_BODY")
	private String emailBody;
	
	@Column(name="SUBJECT")
	private String subject;

	public VendorInformDetTxn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendorInformDetTxn(int informId, int incidentNo, int vendorId, Date informedDate, Date vResolvedDate,
			String informedBy, String informedUserLevel, String resolveDateUpBy, String upUserLevel, String emailBody,
			String subject) {
		super();
		this.informId = informId;
		this.incidentNo = incidentNo;
		this.vendorId = vendorId;
		this.informedDate = informedDate;
		this.vResolvedDate = vResolvedDate;
		this.informedBy = informedBy;
		this.informedUserLevel = informedUserLevel;
		this.resolveDateUpBy = resolveDateUpBy;
		this.upUserLevel = upUserLevel;
		this.emailBody = emailBody;
		this.subject = subject;
	}

	public int getInformId() {
		return informId;
	}

	public void setInformId(int informId) {
		this.informId = informId;
	}

	public int getIncidentNo() {
		return incidentNo;
	}

	public void setIncidentNo(int incidentNo) {
		this.incidentNo = incidentNo;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public Date getInformedDate() {
		return informedDate;
	}

	public void setInformedDate(Date informedDate) {
		this.informedDate = informedDate;
	}

	public Date getvResolvedDate() {
		return vResolvedDate;
	}

	public void setvResolvedDate(Date vResolvedDate) {
		this.vResolvedDate = vResolvedDate;
	}

	public String getInformedBy() {
		return informedBy;
	}

	public void setInformedBy(String informedBy) {
		this.informedBy = informedBy;
	}

	public String getInformedUserLevel() {
		return informedUserLevel;
	}

	public void setInformedUserLevel(String informedUserLevel) {
		this.informedUserLevel = informedUserLevel;
	}

	public String getResolveDateUpBy() {
		return resolveDateUpBy;
	}

	public void setResolveDateUpBy(String resolveDateUpBy) {
		this.resolveDateUpBy = resolveDateUpBy;
	}

	public String getUpUserLevel() {
		return upUserLevel;
	}

	public void setUpUserLevel(String upUserLevel) {
		this.upUserLevel = upUserLevel;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "VendorInformDetTxn [informId=" + informId + ", incidentNo=" + incidentNo + ", vendorId=" + vendorId
				+ ", informedDate=" + informedDate + ", vResolvedDate=" + vResolvedDate + ", informedBy=" + informedBy
				+ ", informedUserLevel=" + informedUserLevel + ", resolveDateUpBy=" + resolveDateUpBy + ", upUserLevel="
				+ upUserLevel + ", emailBody=" + emailBody + ", subject=" + subject + "]";
	}
	
	
}
