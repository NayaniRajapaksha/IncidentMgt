package com.ucsc.mit.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="incident_irt_close_reason_m")
@ManagedBean(name="irt_close_reason")
@Proxy(lazy=false)
public class IrtCloseReason implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="REASON_ID")
	private String reasonId;
	
	@Column(name="CLOSE_REASON")
	private String closeReason;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="ORDER_SEQ")
	private int orderSeq;

	public IrtCloseReason() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IrtCloseReason(int id, String reasonId, String closeReason, String createdBy, int orderSeq) {
		super();
		this.id = id;
		this.reasonId = reasonId;
		this.closeReason = closeReason;
		this.createdBy = createdBy;
		this.orderSeq = orderSeq;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReasonId() {
		return reasonId;
	}

	public void setReasonId(String reasonId) {
		this.reasonId = reasonId;
	}

	public String getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
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

	@Override
	public String toString() {
		return "IrtCloseReason [id=" + id + ", reasonId=" + reasonId + ", closeReason=" + closeReason + ", createdBy="
				+ createdBy + ", orderSeq=" + orderSeq + "]";
	}
	
	
}
