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
@Table(name="incident_tech_afct_area_m")
@ManagedBean(name="tech_affect")
@Proxy(lazy=false)
public class TechAffectedArea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="AFCT_AREA")
	private String afctArea;
	
	@Column(name="AFCT_AREA_NAME")
	private String afctAreaName;

	
	public TechAffectedArea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TechAffectedArea(int id, String afctArea, String afctAreaName) {
		super();
		this.id = id;
		this.afctArea = afctArea;
		this.afctAreaName = afctAreaName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAfctArea() {
		return afctArea;
	}

	public void setAfctArea(String afctArea) {
		this.afctArea = afctArea;
	}

	public String getAfctAreaName() {
		return afctAreaName;
	}

	public void setAfctAreaName(String afctAreaName) {
		this.afctAreaName = afctAreaName;
	}

	@Override
	public String toString() {
		return "TechAffectedArea [id=" + id + ", afctArea=" + afctArea + ", afctAreaName=" + afctAreaName + "]";
	}
	
	
	

}
