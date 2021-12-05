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
@Table(name="incident_dependency_close_reason_m")
@ManagedBean(name="dependency_close_reason")
@Proxy(lazy=false)
public class DependencyCloseReason implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="REASON_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reason_id;
	
	@Column(name="REASON_CODE")
	private String reasonCode;
	
	@Column(name="CLOSE_REASON")
	private String closeReasonName;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="ORDER_SEQ")
	private int orderSeq;
	
	@Column(name="CREATED_DATE")
	private Date createddate;

	public DependencyCloseReason() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DependencyCloseReason(int reason_id, String reasonCode, String closeReasonName, String createdBy,
			int orderSeq, Date createddate) {
		super();
		this.reason_id = reason_id;
		this.reasonCode = reasonCode;
		this.closeReasonName = closeReasonName;
		this.createdBy = createdBy;
		this.orderSeq = orderSeq;
		this.createddate = createddate;
	}

	public int getReason_id() {
		return reason_id;
	}

	public void setReason_id(int reason_id) {
		this.reason_id = reason_id;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getCloseReasonName() {
		return closeReasonName;
	}

	public void setCloseReasonName(String closeReasonName) {
		this.closeReasonName = closeReasonName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	@Override
	public String toString() {
		return "DependencyCloseReason [reason_id=" + reason_id + ", reasonCode=" + reasonCode + ", closeReasonName="
				+ closeReasonName + ", createdBy=" + createdBy + ", orderSeq=" + orderSeq + ", createddate="
				+ createddate + "]";
	}
	

}
