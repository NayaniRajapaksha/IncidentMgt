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
@Table(name="branch_m")
@ManagedBean(name="branch")
@Proxy(lazy=false)
public class Branch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="BRANCH_ID")
	private int branchId;
	
	@Column(name="REGIONAL_ID")
	private int regionalId;
	
	@Column(name="MAIN_BRANCH_ID")
	private int mainBranchId;
	
	@Column(name="NAME")
	private String branchName;
	
	@Column(name="BRANCH_TYPE_CODE")
	private String branchType;
	
	@Column(name="LINE1")
	private String line1;
	
	@Column(name="LINE2")
	private String line2;
	
	@Column(name="LINE3")
	private String line3;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ACTIVE")
	private String active;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="PHONE1")
	private String phone1;
	
	@Column(name="PHONE2")
	private String phone2;
	
	@Column(name="FAX")
	private String fax;
	
	@Column(name="CONTACT_PERSON")
	private String contactPerson;

	
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Branch(int id, int branchId, int regionalId, int mainBranchId, String branchName, String branchType,
			String line1, String line2, String line3, String email, String active, String createdBy, String phone1,
			String phone2, String fax, String contactPerson) {
		super();
		this.id = id;
		this.branchId = branchId;
		this.regionalId = regionalId;
		this.mainBranchId = mainBranchId;
		this.branchName = branchName;
		this.branchType = branchType;
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.email = email;
		this.active = active;
		this.createdBy = createdBy;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.fax = fax;
		this.contactPerson = contactPerson;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getRegionalId() {
		return regionalId;
	}

	public void setRegionalId(int regionalId) {
		this.regionalId = regionalId;
	}

	public int getMainBranchId() {
		return mainBranchId;
	}

	public void setMainBranchId(int mainBranchId) {
		this.mainBranchId = mainBranchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	@Override
	public String toString() {
		return "Branch [id=" + id + ", branchId=" + branchId + ", regionalId=" + regionalId + ", mainBranchId="
				+ mainBranchId + ", branchName=" + branchName + ", branchType=" + branchType + ", line1=" + line1
				+ ", line2=" + line2 + ", line3=" + line3 + ", email=" + email + ", active=" + active + ", createdBy="
				+ createdBy + ", phone1=" + phone1 + ", phone2=" + phone2 + ", fax=" + fax + ", contactPerson="
				+ contactPerson + "]";
	}
	
	
	
	
}
