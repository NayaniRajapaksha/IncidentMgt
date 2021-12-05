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
@Table(name="incident_irt_reminder_m")
@ManagedBean(name="irt_reminder")
@Proxy(lazy=false)
public class IrtReminder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="REM_CODE")
	private String remCode;
	
	@Column(name="REM_NAME")
	private String remName;
	
	@Column(name="REM_DESC")
	private String remDes;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="PERIOD")
	private int period;
	
	@Column(name="REM_MSG_ID")
	private int remMsgId;

	public IrtReminder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IrtReminder(int id, String remCode, String remName, String remDes, String createdBy, int period,
			int remMsgId) {
		super();
		this.id = id;
		this.remCode = remCode;
		this.remName = remName;
		this.remDes = remDes;
		this.createdBy = createdBy;
		this.period = period;
		this.remMsgId = remMsgId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemCode() {
		return remCode;
	}

	public void setRemCode(String remCode) {
		this.remCode = remCode;
	}

	public String getRemName() {
		return remName;
	}

	public void setRemName(String remName) {
		this.remName = remName;
	}

	public String getRemDes() {
		return remDes;
	}

	public void setRemDes(String remDes) {
		this.remDes = remDes;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getRemMsgId() {
		return remMsgId;
	}

	public void setRemMsgId(int remMsgId) {
		this.remMsgId = remMsgId;
	}

	@Override
	public String toString() {
		return "IrtReminder [id=" + id + ", remCode=" + remCode + ", remName=" + remName + ", remDes=" + remDes
				+ ", createdBy=" + createdBy + ", period=" + period + ", remMsgId=" + remMsgId + "]";
	}
	
	

}
