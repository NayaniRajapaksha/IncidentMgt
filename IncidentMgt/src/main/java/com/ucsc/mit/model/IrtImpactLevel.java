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
@Table(name="incident_irt_impact_lvl_m")
@ManagedBean(name="irt_impact_lvl")
@Proxy(lazy=false)
public class IrtImpactLevel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="IMPACT_LVL_CODE")
	private String impactLvlCode;
	
	@Column(name="IMPACT_LVL_NAME")
	private String impactLvlName;
	
	@Column(name="IMPACT_LVL_DESC")
	private String impactLvlDes;
	
	@Column(name="CREATED_BY")
	private String createdBy;

	public IrtImpactLevel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IrtImpactLevel(int id, String impactLvlCode, String impactLvlName, String impactLvlDes, String createdBy) {
		super();
		this.id = id;
		this.impactLvlCode = impactLvlCode;
		this.impactLvlName = impactLvlName;
		this.impactLvlDes = impactLvlDes;
		this.createdBy = createdBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImpactLvlCode() {
		return impactLvlCode;
	}

	public void setImpactLvlCode(String impactLvlCode) {
		this.impactLvlCode = impactLvlCode;
	}

	public String getImpactLvlName() {
		return impactLvlName;
	}

	public void setImpactLvlName(String impactLvlName) {
		this.impactLvlName = impactLvlName;
	}

	public String getImpactLvlDes() {
		return impactLvlDes;
	}

	public void setImpactLvlDes(String impactLvlDes) {
		this.impactLvlDes = impactLvlDes;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "IrtImpactLevel [id=" + id + ", impactLvlCode=" + impactLvlCode + ", impactLvlName=" + impactLvlName
				+ ", impactLvlDes=" + impactLvlDes + ", createdBy=" + createdBy + "]";
	}

	
}
