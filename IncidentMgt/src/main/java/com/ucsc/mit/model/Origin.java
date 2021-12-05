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
@Table(name="incident_origin_m")
@ManagedBean(name="origin")
@Proxy(lazy=false)
public class Origin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ORIGIN")
	private String originCode;
	
	@Column(name="ORIGIN_NAME")
	private String originName;

	
	
	public Origin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Origin(int id, String originCode, String originName) {
		super();
		this.id = id;
		this.originCode = originCode;
		this.originName = originName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginCode() {
		return originCode;
	}

	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	@Override
	public String toString() {
		return "Origin [id=" + id + ", originCode=" + originCode + ", originName=" + originName + "]";
	}

	
	
}
