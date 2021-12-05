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
@Table(name="incident_unit_close_reason_m")
@ManagedBean(name="unitCloseReason")
@Proxy(lazy=false)
public class UnitCloseReason  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="REASON_CODE")
	private String reasonCode;
	
	@Column(name="REASON_NAME")
	private String reasonName;
	
	@Column(name="CREATED_BY")
	private String createdBy;

	
	
	public UnitCloseReason() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnitCloseReason(int id, String reasonCode, String reasonName, String createdBy) {
		super();
		this.id = id;
		this.reasonCode = reasonCode;
		this.reasonName = reasonName;
		this.createdBy = createdBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getReasonName() {
		return reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "UnitCloseReason [id=" + id + ", reasonCode=" + reasonCode + ", reasonName=" + reasonName
				+ ", createdBy=" + createdBy + "]";
	}

	
	
}
