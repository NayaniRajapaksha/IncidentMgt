package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="incident_unit_mem_txn")
@ManagedBean(name="unitMemberTxn")
@Proxy(lazy=false)
public class UnitMemberTxn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="INC_ID")
	private int incidentID;
	
	@Column(name="REMAIN_TIME")
	private int remainTime;
	
	@Column(name="STARTED_TIME")
	private Date startedTime;
	
	@Column(name="UPDATED_TIME")
	private Date updatedTime;
	
	@Column(name="FINISHED_TIME")
	private Date finishedTime;
	
	@Column(name="ASSIGNED_DATE_TIME")
	private Date assignedDateTime;
	
	@Column(name="VENDOR_RESOLVE_DATE")
	private Date vendorResolveDate;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="ASSIGNEE_UNIT_ID")
	private String assignUnitID;
	
	@Column(name="ASSIGNEE_MEM_ID")
	private String assignMemID;
	
	@Column(name="ROOT_CAUSE")
	private String rootCause;
	
	@Column(name="ACTION_TAKEN")
	private String actionTaken;
	
	@Column(name="MEM_STATUS_ID")
	private String memStatusId;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="SOLVED_IN_TIME")
	private String solvedInTime;

	public UnitMemberTxn(int id, int incidentID, int remainTime, Date startedTime, Date updatedTime, Date finishedTime,
			Date assignedDateTime, Date vendorResolveDate, Date createdDate, String assignUnitID, String assignMemID,
			String rootCause, String actionTaken, String memStatusId, String createdBy, String updatedBy,
			String solvedInTime) {
		super();
		this.id = id;
		this.incidentID = incidentID;
		this.remainTime = remainTime;
		this.startedTime = startedTime;
		this.updatedTime = updatedTime;
		this.finishedTime = finishedTime;
		this.assignedDateTime = assignedDateTime;
		this.vendorResolveDate = vendorResolveDate;
		this.createdDate = createdDate;
		this.assignUnitID = assignUnitID;
		this.assignMemID = assignMemID;
		this.rootCause = rootCause;
		this.actionTaken = actionTaken;
		this.memStatusId = memStatusId;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.solvedInTime = solvedInTime;
	}

	public UnitMemberTxn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIncidentID() {
		return incidentID;
	}

	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}

	public int getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}

	public Date getStartedTime() {
		return startedTime;
	}

	public void setStartedTime(Date startedTime) {
		this.startedTime = startedTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getFinishedTime() {
		return finishedTime;
	}

	public void setFinishedTime(Date finishedTime) {
		this.finishedTime = finishedTime;
	}

	public Date getAssignedDateTime() {
		return assignedDateTime;
	}

	public void setAssignedDateTime(Date assignedDateTime) {
		this.assignedDateTime = assignedDateTime;
	}

	public Date getVendorResolveDate() {
		return vendorResolveDate;
	}

	public void setVendorResolveDate(Date vendorResolveDate) {
		this.vendorResolveDate = vendorResolveDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAssignUnitID() {
		return assignUnitID;
	}

	public void setAssignUnitID(String assignUnitID) {
		this.assignUnitID = assignUnitID;
	}

	public String getAssignMemID() {
		return assignMemID;
	}

	public void setAssignMemID(String assignMemID) {
		this.assignMemID = assignMemID;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getMemStatusId() {
		return memStatusId;
	}

	public void setMemStatusId(String memStatusId) {
		this.memStatusId = memStatusId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getSolvedInTime() {
		return solvedInTime;
	}

	public void setSolvedInTime(String solvedInTime) {
		this.solvedInTime = solvedInTime;
	}

	@Override
	public String toString() {
		return "UnitMemberTxn [id=" + id + ", incidentID=" + incidentID + ", remainTime=" + remainTime
				+ ", startedTime=" + startedTime + ", updatedTime=" + updatedTime + ", finishedTime=" + finishedTime
				+ ", assignedDateTime=" + assignedDateTime + ", vendorResolveDate=" + vendorResolveDate
				+ ", createdDate=" + createdDate + ", assignUnitID=" + assignUnitID + ", assignMemID=" + assignMemID
				+ ", rootCause=" + rootCause + ", actionTaken=" + actionTaken + ", memStatusId=" + memStatusId
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", solvedInTime=" + solvedInTime + "]";
	}
	
	

}
