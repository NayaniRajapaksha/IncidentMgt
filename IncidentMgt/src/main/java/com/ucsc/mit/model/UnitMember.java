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
@Table(name="incident_unit_member_m")
@ManagedBean(name="unitMember")
@Proxy(lazy=false)
public class UnitMember implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="TEAM_MEMBER_ID")
	private int memberId;
	
	@Column(name="UNIT_ID")
	private int unitId;
	
	@Column(name="UNIT_HEAD_ID")
	private int unitHeadId;
	
	@Column(name="CREATED_BY")
	private String createdBy;

	
	
	public UnitMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public UnitMember(int id, int memberId, int unitId, int unitHeadId, String createdBy) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.unitId = unitId;
		this.unitHeadId = unitHeadId;
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

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public int getUnitHeadId() {
		return unitHeadId;
	}

	public void setUnitHeadId(int unitHeadId) {
		this.unitHeadId = unitHeadId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	@Override
	public String toString() {
		return "UnitMember [id=" + id + ", memberId=" + memberId + ", unitId=" + unitId + ", unitHeadId=" + unitHeadId
				+ ", createdBy=" + createdBy + "]";
	}

	
	
	
}
