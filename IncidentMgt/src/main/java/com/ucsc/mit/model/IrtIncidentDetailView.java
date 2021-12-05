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
@Table(name="irt_incident_detail_v")
@ManagedBean(name="irt_incident_detail_v")
@Proxy(lazy=false)
public class IrtIncidentDetailView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="INCIDENT_NUMBER")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="PRIORITY_ID")
	private int priorityId;
	
	@Column(name="ORIGIN")
	private int originId;
	
	@Column(name="TECH_AFCT_AREA")
	private int techId;
	
	@Column(name="INCIDENT_TYPE")
	private int incTypeId;
	
	@Column(name="INCIDENT_LOCATION_ID")
	private int incLocationId;
	
	@Column(name="INCIDENT_SUB_TYPE")
	private int incSubTypeId;
	
	@Column(name="UNIT_CLOSE_REASON_CODE")
	private String uCloseRId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="REPORTED_BY")
	private String reportedBy;
	
	@Column(name="AFCT_UNIT_PROCESS")
	private String atUnitProcess;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="STATUS_REMARK")
	private String statusRemark;
	
	@Column(name="INC_LOC_DETAILS")
	private String incLocDetail;
	
	@Column(name="IRT_CLOSE_REASON_CODE")
	private String irtCloseReasonId;
	
	@Column(name="OCCURANCE_DATE")
	private Date occuranceDate;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;
	
	@Column(name="regional_id")
	private int regional_id;

	public IrtIncidentDetailView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IrtIncidentDetailView(int id, int priorityId, int originId, int techId, int incTypeId, int incLocationId,
			int incSubTypeId, String uCloseRId, String title, String reportedBy, String atUnitProcess, String phone,
			String email, String description, String status, String modifiedBy, String createdBy, String statusRemark,
			String incLocDetail, String irtCloseReasonId, Date occuranceDate, Date createdDate, Date modifiedDate,
			int regional_id) {
		super();
		this.id = id;
		this.priorityId = priorityId;
		this.originId = originId;
		this.techId = techId;
		this.incTypeId = incTypeId;
		this.incLocationId = incLocationId;
		this.incSubTypeId = incSubTypeId;
		this.uCloseRId = uCloseRId;
		this.title = title;
		this.reportedBy = reportedBy;
		this.atUnitProcess = atUnitProcess;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.status = status;
		this.modifiedBy = modifiedBy;
		this.createdBy = createdBy;
		this.statusRemark = statusRemark;
		this.incLocDetail = incLocDetail;
		this.irtCloseReasonId = irtCloseReasonId;
		this.occuranceDate = occuranceDate;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.regional_id = regional_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}

	public int getOriginId() {
		return originId;
	}

	public void setOriginId(int originId) {
		this.originId = originId;
	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public int getIncTypeId() {
		return incTypeId;
	}

	public void setIncTypeId(int incTypeId) {
		this.incTypeId = incTypeId;
	}

	public int getIncLocationId() {
		return incLocationId;
	}

	public void setIncLocationId(int incLocationId) {
		this.incLocationId = incLocationId;
	}

	public int getIncSubTypeId() {
		return incSubTypeId;
	}

	public void setIncSubTypeId(int incSubTypeId) {
		this.incSubTypeId = incSubTypeId;
	}

	public String getuCloseRId() {
		return uCloseRId;
	}

	public void setuCloseRId(String uCloseRId) {
		this.uCloseRId = uCloseRId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	public String getAtUnitProcess() {
		return atUnitProcess;
	}

	public void setAtUnitProcess(String atUnitProcess) {
		this.atUnitProcess = atUnitProcess;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatusRemark() {
		return statusRemark;
	}

	public void setStatusRemark(String statusRemark) {
		this.statusRemark = statusRemark;
	}

	public String getIncLocDetail() {
		return incLocDetail;
	}

	public void setIncLocDetail(String incLocDetail) {
		this.incLocDetail = incLocDetail;
	}

	public String getIrtCloseReasonId() {
		return irtCloseReasonId;
	}

	public void setIrtCloseReasonId(String irtCloseReasonId) {
		this.irtCloseReasonId = irtCloseReasonId;
	}

	public Date getOccuranceDate() {
		return occuranceDate;
	}

	public void setOccuranceDate(Date occuranceDate) {
		this.occuranceDate = occuranceDate;
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

	public int getRegional_id() {
		return regional_id;
	}

	public void setRegional_id(int regional_id) {
		this.regional_id = regional_id;
	}

	@Override
	public String toString() {
		return "IrtIncidentDetailView [id=" + id + ", priorityId=" + priorityId + ", originId=" + originId + ", techId="
				+ techId + ", incTypeId=" + incTypeId + ", incLocationId=" + incLocationId + ", incSubTypeId="
				+ incSubTypeId + ", uCloseRId=" + uCloseRId + ", title=" + title + ", reportedBy=" + reportedBy
				+ ", atUnitProcess=" + atUnitProcess + ", phone=" + phone + ", email=" + email + ", description="
				+ description + ", status=" + status + ", modifiedBy=" + modifiedBy + ", createdBy=" + createdBy
				+ ", statusRemark=" + statusRemark + ", incLocDetail=" + incLocDetail + ", irtCloseReasonId="
				+ irtCloseReasonId + ", occuranceDate=" + occuranceDate + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", regional_id=" + regional_id + "]";
	}
	
	

}
