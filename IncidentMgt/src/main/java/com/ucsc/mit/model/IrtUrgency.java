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
@Table(name="incident_irt_urgency_m")
@ManagedBean(name="incident_irt_urgency")
@Proxy(lazy=false)
public class IrtUrgency  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="URGENCY_CODE")
	private String urgencyCode;
	
	@Column(name="URGENCY_NAME")
	private String urgencyName;
	
	@Column(name="URGENCY_NAME_DESC")
	private String urgencyDes;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="GRP_ORDER_SEQ")
	private String orderSeq;

	public IrtUrgency(int id, String urgencyCode, String urgencyName, String urgencyDes, String createdBy,
			String orderSeq) {
		super();
		this.id = id;
		this.urgencyCode = urgencyCode;
		this.urgencyName = urgencyName;
		this.urgencyDes = urgencyDes;
		this.createdBy = createdBy;
		this.orderSeq = orderSeq;
	}

	public IrtUrgency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrgencyCode() {
		return urgencyCode;
	}

	public void setUrgencyCode(String urgencyCode) {
		this.urgencyCode = urgencyCode;
	}

	public String getUrgencyName() {
		return urgencyName;
	}

	public void setUrgencyName(String urgencyName) {
		this.urgencyName = urgencyName;
	}

	public String getUrgencyDes() {
		return urgencyDes;
	}

	public void setUrgencyDes(String urgencyDes) {
		this.urgencyDes = urgencyDes;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(String orderSeq) {
		this.orderSeq = orderSeq;
	}

	@Override
	public String toString() {
		return "IrtUrgency [id=" + id + ", urgencyCode=" + urgencyCode + ", urgencyName=" + urgencyName
				+ ", urgencyDes=" + urgencyDes + ", createdBy=" + createdBy + ", orderSeq=" + orderSeq + "]";
	}
	
	

}
