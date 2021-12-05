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
@Table(name="incident_irt_member_m")
@ManagedBean(name="irtMember")
@Proxy(lazy=false)
public class IrtMember implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="MEMBER_ID")
	private int memberId;
	
	@Column(name="REGION_ID")
	private int regionId;
	
	
	@Column(name="CREATED_BY")
	private String createdBy;


	
	
	public IrtMember() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public IrtMember(int id, int memberId, int regionId, String createdBy) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.regionId = regionId;
		this.createdBy = createdBy;
	}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public int getRegionId() {
		return regionId;
	}


	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	


	@Override
	public String toString() {
		return "IrtMember [id=" + id + ", memberId=" + memberId + ", regionId=" + regionId + ", createdBy=" + createdBy
				+ "]";
	}
	
	
}
