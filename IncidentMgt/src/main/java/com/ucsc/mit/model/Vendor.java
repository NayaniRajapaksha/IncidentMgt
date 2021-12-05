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
@Table(name="incident_vendor_m")
@ManagedBean(name="vendor")
@Proxy(lazy=false)
public class Vendor implements Serializable{ 

	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="VEN_CODE")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ven_code;
    
	@Column(name="VEN_NAME")
    private String ven_name;
    
	@Column(name="ADDRESS")
    private String address;
    
	@Column(name="EMAIL")
    private String email;
    
	@Column(name="CONTACT_NO")
    private String contact_no;
    
	@Column(name="CONTACT_PERSON")
    private String contact_person;
    
	@Column(name="FAX_NO")
    private String fax_no;
    
	@Column(name="STATUS")
    private String status;
    
	@Column(name="CREATED_BY")
    private String created_by;
    
 //   private String created_date;
    @Column(name="CONTACT_NO_2")
    private String contact_no2;

    
    
	public Vendor() {
		
	}

	public Vendor(int ven_code, String ven_name, String address, String email, String contact_no, String contact_person,
		String fax_no, String status, String created_by, String contact_no2) {
	super();
	this.ven_code = ven_code;
	this.ven_name = ven_name;
	this.address = address;
	this.email = email;
	this.contact_no = contact_no;
	this.contact_person = contact_person;
	this.fax_no = fax_no;
	this.status = status;
	this.created_by = created_by;
	this.contact_no2 = contact_no2;
}

	public int getVen_code() {
		return ven_code;
	}

	public void setVen_code(int ven_code) {
		this.ven_code = ven_code;
	}

	public String getVen_name() {
		return ven_name;
	}

	public void setVen_name(String ven_name) {
		this.ven_name = ven_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getFax_no() {
		return fax_no;
	}

	public void setFax_no(String fax_no) {
		this.fax_no = fax_no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

//	public String getCreated_date() {
//		return created_date;
//	}
//
//	public void setCreated_date(String created_date) {
//		this.created_date = created_date;
//	}

	public String getContact_no2() {
		return contact_no2;
	}

	public void setContact_no2(String contact_no2) {
		this.contact_no2 = contact_no2;
	}

	@Override
	public String toString() {
		return "Vendor [ven_code=" + ven_code + ", ven_name=" + ven_name + ", address=" + address + ", email=" + email
				+ ", contact_no=" + contact_no + ", contact_person=" + contact_person + ", fax_no=" + fax_no
				+ ", status=" + status + ", created_by=" + created_by + ", contact_no2=" + contact_no2 + "]";
	}
    
    
	
}
