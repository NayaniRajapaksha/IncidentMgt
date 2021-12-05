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
@Table(name="incident_irt_txn")
@ManagedBean(name="incidentIrtTxn")
@Proxy(lazy=false)
public class IrtIncidentTxn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="INCIDENT_ID")
	private int incidentNo;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;
	
	@Column(name="ASSIGNED_UNIT")
	private String assignedUnit;
	
	@Column(name="IRT_REMINDER")
	private String irtReminder;
	
	@Column(name="UNIT_ROLLBACK_REASON")
	private String unitRollbackReason;
	
	@Column(name="REPEATING_STATUS")
	private String repeatingStatus;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="IMPACT_URGENCY_CODE")
	private String impactUrgCode;
	
	@Column(name="IS_ISO_INCIDENT")
	private String isIsoIncident;
	
	@Column(name="UNIT_REASSIGN_REASON")
	private String unitReassignReason;
	
	@Column(name="REASSIGNED_BY")
	private String reassignedBy;
	
	@Column(name="ROLLBACKED_LEVEL")
	private String rollbackLevel;
	
	@Column(name="ROLLBACKED_BY")
	private String rollbackBy;

	public IrtIncidentTxn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IrtIncidentTxn(int id, int incidentNo, Date createdDate, Date modifiedDate, String assignedUnit,
			String irtReminder, String unitRollbackReason, String repeatingStatus, String createdBy,
			String impactUrgCode, String isIsoIncident, String unitReassignReason, String reassignedBy,
			String rollbackLevel, String rollbackBy) {
		super();
		this.id = id;
		this.incidentNo = incidentNo;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.assignedUnit = assignedUnit;
		this.irtReminder = irtReminder;
		this.unitRollbackReason = unitRollbackReason;
		this.repeatingStatus = repeatingStatus;
		this.createdBy = createdBy;
		this.impactUrgCode = impactUrgCode;
		this.isIsoIncident = isIsoIncident;
		this.unitReassignReason = unitReassignReason;
		this.reassignedBy = reassignedBy;
		this.rollbackLevel = rollbackLevel;
		this.rollbackBy = rollbackBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIncidentNo() {
		return incidentNo;
	}

	public void setIncidentNo(int incidentNo) {
		this.incidentNo = incidentNo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getAssignedUnit() {
		return assignedUnit;
	}

	public void setAssignedUnit(String assignedUnit) {
		this.assignedUnit = assignedUnit;
	}

	public String getIrtReminder() {
		return irtReminder;
	}

	public void setIrtReminder(String irtReminder) {
		this.irtReminder = irtReminder;
	}

	public String getUnitRollbackReason() {
		return unitRollbackReason;
	}

	public void setUnitRollbackReason(String unitRollbackReason) {
		this.unitRollbackReason = unitRollbackReason;
	}

	public String getRepeatingStatus() {
		return repeatingStatus;
	}

	public void setRepeatingStatus(String repeatingStatus) {
		this.repeatingStatus = repeatingStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getImpactUrgCode() {
		return impactUrgCode;
	}

	public void setImpactUrgCode(String impactUrgCode) {
		this.impactUrgCode = impactUrgCode;
	}

	public String getIsIsoIncident() {
		return isIsoIncident;
	}

	public void setIsIsoIncident(String isIsoIncident) {
		this.isIsoIncident = isIsoIncident;
	}

	public String getUnitReassignReason() {
		return unitReassignReason;
	}

	public void setUnitReassignReason(String unitReassignReason) {
		this.unitReassignReason = unitReassignReason;
	}

	public String getReassignedBy() {
		return reassignedBy;
	}

	public void setReassignedBy(String reassignedBy) {
		this.reassignedBy = reassignedBy;
	}

	public String getRollbackLevel() {
		return rollbackLevel;
	}

	public void setRollbackLevel(String rollbackLevel) {
		this.rollbackLevel = rollbackLevel;
	}

	public String getRollbackBy() {
		return rollbackBy;
	}

	public void setRollbackBy(String rollbackBy) {
		this.rollbackBy = rollbackBy;
	}

	@Override
	public String toString() {
		return "IrtIncidentTxn [id=" + id + ", incidentNo=" + incidentNo + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", assignedUnit=" + assignedUnit + ", irtReminder=" + irtReminder
				+ ", unitRollbackReason=" + unitRollbackReason + ", repeatingStatus=" + repeatingStatus + ", createdBy="
				+ createdBy + ", impactUrgCode=" + impactUrgCode + ", isIsoIncident=" + isIsoIncident
				+ ", unitReassignReason=" + unitReassignReason + ", reassignedBy=" + reassignedBy + ", rollbackLevel="
				+ rollbackLevel + ", rollbackBy=" + rollbackBy + "]";
	}
	
	

}
