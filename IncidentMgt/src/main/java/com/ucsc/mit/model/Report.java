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
@Table(name="incident_report_name_m")
@ManagedBean(name="reports")
@Proxy(lazy=false)
public class Report implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="REPORT_NAME")
	private String reportName;
	
	@Column(name="REPORT_ID")
	private String reportID;

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(int id, String reportName, String reportID) {
		super();
		this.id = id;
		this.reportName = reportName;
		this.reportID = reportID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportID() {
		return reportID;
	}

	public void setReportID(String reportID) {
		this.reportID = reportID;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", reportName=" + reportName + ", reportID=" + reportID + "]";
	}
	
	

}
