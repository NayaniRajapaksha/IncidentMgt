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
@Table(name="incident_irt_impact_urgency_m")
@ManagedBean(name="irtImpactUrgency")
@Proxy(lazy=false)
public class IrtImpactUrgency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="DAYS")
	private int days;
	
	@Column(name="HOURS")
	private int hours;
	
	@Column(name="MINUTES")
	private int minutes;
	
	@Column(name="PERIOD")
	private int period;
	
	@Column(name="IMPACT_URGENCY_CODE")
	private String impUrgencyCode;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="URGENCY")
	private String urgency;
	
	@Column(name="IMPACT_LEVEL")
	private String impactLevel;

	public IrtImpactUrgency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IrtImpactUrgency(int id, int days, int hours, int minutes, int period, String impUrgencyCode,
			String createdBy, String urgency, String impactLevel) {
		super();
		this.id = id;
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
		this.period = period;
		this.impUrgencyCode = impUrgencyCode;
		this.createdBy = createdBy;
		this.urgency = urgency;
		this.impactLevel = impactLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getImpUrgencyCode() {
		return impUrgencyCode;
	}

	public void setImpUrgencyCode(String impUrgencyCode) {
		this.impUrgencyCode = impUrgencyCode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getImpactLevel() {
		return impactLevel;
	}

	public void setImpactLevel(String impactLevel) {
		this.impactLevel = impactLevel;
	}

	@Override
	public String toString() {
		return "IrtImpactUrgency [id=" + id + ", days=" + days + ", hours=" + hours + ", minutes=" + minutes
				+ ", period=" + period + ", impUrgencyCode=" + impUrgencyCode + ", createdBy=" + createdBy
				+ ", urgency=" + urgency + ", impactLevel=" + impactLevel + "]";
	}
	
	

}
