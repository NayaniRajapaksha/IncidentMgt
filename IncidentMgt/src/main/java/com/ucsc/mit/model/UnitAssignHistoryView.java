package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="unit_assigned_history_v")
@ManagedBean(name="assign_history")
@Proxy(lazy=false)
public class UnitAssignHistoryView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ASSIGNED_DATE")
	private Date assignDate;

	@Column(name="ID")
	private int historyH_id;
	
	@Column(name="IRT_TXN_ID")
	private int irt_txnID;
	
	@Column(name="OPERATION")
	private String operation;
	
	@Column(name="INCIDENT_ID")
	private int incident_id;
	
	@Column(name="ASSIGNED_UNIT_ID")
	private int aUnit_id;
	
	@Column(name="ASSIGNED_UNIT")
	private String assigned_unit;
	
	@Column(name="IMPACT_URGENCY_CODE")
	private String impactUrgencyCode;
	
	@Column(name="IMPACT_LEVEL")
	private String impactLevel;
	
	@Column(name="URGENCY")
	private String urgency;
	
	@Column(name="UNIT_REASSIGN_REASON")
	private String reassignReasonId;
	
	@Column(name="IRT_ROLLBACK_REASON")
	private String rollbackReasonId;
	
	@Column(name="REASSIGNED_BY")
	private String reassignedBy;
	
	@Column(name="ROLLBACKED_LEVEL")
	private String rollbackedLevel;
	
	@Column(name="ROLLBACKED_BY")
	private String rollbackedBy;

	

	public UnitAssignHistoryView(Date assignDate, int historyH_id, int irt_txnID, String operation, int incident_id,
			int aUnit_id, String assigned_unit, String impactUrgencyCode, String impactLevel, String urgency,
			String reassignReasonId, String rollbackReasonId, String reassignedBy, String rollbackedLevel,
			String rollbackedBy) {
		super();
		this.assignDate = assignDate;
		this.historyH_id = historyH_id;
		this.irt_txnID = irt_txnID;
		this.operation = operation;
		this.incident_id = incident_id;
		this.aUnit_id = aUnit_id;
		this.assigned_unit = assigned_unit;
		this.impactUrgencyCode = impactUrgencyCode;
		this.impactLevel = impactLevel;
		this.urgency = urgency;
		this.reassignReasonId = reassignReasonId;
		this.rollbackReasonId = rollbackReasonId;
		this.reassignedBy = reassignedBy;
		this.rollbackedLevel = rollbackedLevel;
		this.rollbackedBy = rollbackedBy;
	}

	public UnitAssignHistoryView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getAssignDate() {
		return assignDate;
	}

	public int getHistoryH_id() {
		return historyH_id;
	}

	public void setHistoryH_id(int historyH_id) {
		this.historyH_id = historyH_id;
	}

	public int getIrt_txnID() {
		return irt_txnID;
	}

	public void setIrt_txnID(int irt_txnID) {
		this.irt_txnID = irt_txnID;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	public int getIncident_id() {
		return incident_id;
	}

	public void setIncident_id(int incident_id) {
		this.incident_id = incident_id;
	}

	public int getaUnit_id() {
		return aUnit_id;
	}

	public void setaUnit_id(int aUnit_id) {
		this.aUnit_id = aUnit_id;
	}

	public String getAssigned_unit() {
		return assigned_unit;
	}

	public void setAssigned_unit(String assigned_unit) {
		this.assigned_unit = assigned_unit;
	}

	public String getImpactUrgencyCode() {
		return impactUrgencyCode;
	}

	public void setImpactUrgencyCode(String impactUrgencyCode) {
		this.impactUrgencyCode = impactUrgencyCode;
	}

	public String getImpactLevel() {
		return impactLevel;
	}

	public void setImpactLevel(String impactLevel) {
		this.impactLevel = impactLevel;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getReassignReasonId() {
		return reassignReasonId;
	}

	public void setReassignReasonId(String reassignReasonId) {
		this.reassignReasonId = reassignReasonId;
	}

	public String getRollbackReasonId() {
		return rollbackReasonId;
	}

	public void setRollbackReasonId(String rollbackReasonId) {
		this.rollbackReasonId = rollbackReasonId;
	}

	public String getReassignedBy() {
		return reassignedBy;
	}

	public void setReassignedBy(String reassignedBy) {
		this.reassignedBy = reassignedBy;
	}

	public String getRollbackedLevel() {
		return rollbackedLevel;
	}

	public void setRollbackedLevel(String rollbackedLevel) {
		this.rollbackedLevel = rollbackedLevel;
	}

	public String getRollbackedBy() {
		return rollbackedBy;
	}

	public void setRollbackedBy(String rollbackedBy) {
		this.rollbackedBy = rollbackedBy;
	}

	@Override
	public String toString() {
		return "UnitAssignHistoryView [assignDate=" + assignDate + ", historyH_id=" + historyH_id + ", irt_txnID="
				+ irt_txnID + ", operation=" + operation + ", incident_id=" + incident_id + ", aUnit_id=" + aUnit_id
				+ ", assigned_unit=" + assigned_unit + ", impactUrgencyCode=" + impactUrgencyCode + ", impactLevel="
				+ impactLevel + ", urgency=" + urgency + ", reassignReasonId=" + reassignReasonId
				+ ", rollbackReasonId=" + rollbackReasonId + ", reassignedBy=" + reassignedBy + ", rollbackedLevel="
				+ rollbackedLevel + ", rollbackedBy=" + rollbackedBy + "]";
	}

	
	
	
}
