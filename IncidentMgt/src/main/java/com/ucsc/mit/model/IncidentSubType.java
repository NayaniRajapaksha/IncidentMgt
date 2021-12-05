package com.ucsc.mit.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="incident_sub_type_m")
@ManagedBean(name="inc_sub_type")
@Proxy(lazy=false)
public class IncidentSubType implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="SUB_TYPE_CODE")
	private String subTypeCode;
	
	@Column(name="SUB_TYPE_NAME")
	private String subTypeName;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
//	@Column(name="CREATED_DATE")
//	private String createdDate;

	@ManyToOne
	@JoinColumn(name="INCIDENT_TYPE_CODE", nullable=false)
	private IncidentType incidentTypeCode;

	public IncidentSubType() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public IncidentSubType(int id, String subTypeCode, String subTypeName, String createdBy, 
			IncidentType incidentTypeCode) {
		super();
		this.id = id;
		this.subTypeCode = subTypeCode;
		this.subTypeName = subTypeName;
		this.createdBy = createdBy;
		
		this.incidentTypeCode = incidentTypeCode;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubTypeCode() {
		return subTypeCode;
	}

	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}

	public String getSubTypeName() {
		return subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	



	public IncidentType getIncidentTypeCode() {
		return incidentTypeCode;
	}



	public void setIncidentTypeCode(IncidentType incidentTypeCode) {
		this.incidentTypeCode = incidentTypeCode;
	}



	@Override
	public String toString() {
		return "IncidentSubType [id=" + id + ", subTypeCode=" + subTypeCode + ", subTypeName=" + subTypeName
				+ ", createdBy=" + createdBy + ", incidentType=" + incidentTypeCode + "]";
	}

	
	
	
}
