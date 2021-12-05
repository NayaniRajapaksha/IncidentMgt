package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;


public class TempIncidentTxn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	Date createdDate;
    int incTypeId;
    String incTypeName;
    int incSubTypeId;
    String incSubTypeName;
    int priorityId;
    String priorityName;
    String incidentStatus;
    int techAffectId;
    int incLocationId;
    int incOriginId;
    String unitProcess;
    String description;
    String incLocDetail;
    String reportedBy;
    String workPhone;
    String workEmail;
    String title;
	public TempIncidentTxn(int id, Date createdDate, int incTypeId, String incTypeName, int incSubTypeId,
			String incSubTypeName, int priorityId, String priorityName, String incidentStatus, int techAffectId,
			int incLocationId, int incOriginId, String unitProcess, String description, String incLocDetail,
			String reportedBy, String workPhone, String workEmail, String title) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.incTypeId = incTypeId;
		this.incTypeName = incTypeName;
		this.incSubTypeId = incSubTypeId;
		this.incSubTypeName = incSubTypeName;
		this.priorityId = priorityId;
		this.priorityName = priorityName;
		this.incidentStatus = incidentStatus;
		this.techAffectId = techAffectId;
		this.incLocationId = incLocationId;
		this.incOriginId = incOriginId;
		this.unitProcess = unitProcess;
		this.description = description;
		this.incLocDetail = incLocDetail;
		this.reportedBy = reportedBy;
		this.workPhone = workPhone;
		this.workEmail = workEmail;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getIncTypeId() {
		return incTypeId;
	}
	public void setIncTypeId(int incTypeId) {
		this.incTypeId = incTypeId;
	}
	public String getIncTypeName() {
		return incTypeName;
	}
	public void setIncTypeName(String incTypeName) {
		this.incTypeName = incTypeName;
	}
	public int getIncSubTypeId() {
		return incSubTypeId;
	}
	public void setIncSubTypeId(int incSubTypeId) {
		this.incSubTypeId = incSubTypeId;
	}
	public String getIncSubTypeName() {
		return incSubTypeName;
	}
	public void setIncSubTypeName(String incSubTypeName) {
		this.incSubTypeName = incSubTypeName;
	}
	public int getPriorityId() {
		return priorityId;
	}
	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}
	public String getPriorityName() {
		return priorityName;
	}
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}
	public String getIncidentStatus() {
		return incidentStatus;
	}
	public void setIncidentStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}
	public int getTechAffectId() {
		return techAffectId;
	}
	public void setTechAffectId(int techAffectId) {
		this.techAffectId = techAffectId;
	}
	public int getIncLocationId() {
		return incLocationId;
	}
	public void setIncLocationId(int incLocationId) {
		this.incLocationId = incLocationId;
	}
	public int getIncOriginId() {
		return incOriginId;
	}
	public void setIncOriginId(int incOriginId) {
		this.incOriginId = incOriginId;
	}
	public String getUnitProcess() {
		return unitProcess;
	}
	public void setUnitProcess(String unitProcess) {
		this.unitProcess = unitProcess;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIncLocDetail() {
		return incLocDetail;
	}
	public void setIncLocDetail(String incLocDetail) {
		this.incLocDetail = incLocDetail;
	}
	public String getReportedBy() {
		return reportedBy;
	}
	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getWorkEmail() {
		return workEmail;
	}
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "TempIncidentTxn [id=" + id + ", createdDate=" + createdDate + ", incTypeId=" + incTypeId
				+ ", incTypeName=" + incTypeName + ", incSubTypeId=" + incSubTypeId + ", incSubTypeName="
				+ incSubTypeName + ", priorityId=" + priorityId + ", priorityName=" + priorityName + ", incidentStatus="
				+ incidentStatus + ", techAffectId=" + techAffectId + ", incLocationId=" + incLocationId
				+ ", incOriginId=" + incOriginId + ", unitProcess=" + unitProcess + ", description=" + description
				+ ", incLocDetail=" + incLocDetail + ", reportedBy=" + reportedBy + ", workPhone=" + workPhone
				+ ", workEmail=" + workEmail + ", title=" + title + "]";
	}
    
    
    
}
