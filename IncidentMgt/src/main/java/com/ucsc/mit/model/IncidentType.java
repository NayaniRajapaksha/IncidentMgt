package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name="incident_type_m")
@ManagedBean(name="inc_type")
@Proxy(lazy=false)
public class IncidentType implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="TYPE_CODE")
	private String typeCode;
	
	@Column(name="TYPE_NAME")
	private String typeName;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
//	@Column(name="CREATED_DATE")
//	private String createdDate;

	@OneToMany(mappedBy="incidentTypeCode",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	private Set<IncidentSubType> subTypes;
	
	public IncidentType() {
		
	}


	


	public IncidentType(int id, String typeCode, String typeName, String createdBy, 
			Set<IncidentSubType> subTypes) {
		super();
		this.id = id;
		this.typeCode = typeCode;
		this.typeName = typeName;
		this.createdBy = createdBy;
		this.subTypes = subTypes;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTypeCode() {
		return typeCode;
	}


	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	


	public Set<IncidentSubType> getSubTypes() {
		return subTypes;
	}


	public void setSubTypes(Set<IncidentSubType> subTypes) {
		this.subTypes = subTypes;
	}





	@Override
	public String toString() {
		return "IncidentType [id=" + id + ", typeCode=" + typeCode + ", typeName=" + typeName + ", createdBy="
				+ createdBy + ",  subTypes=" + subTypes + "]";
	}


	
	
	
}
