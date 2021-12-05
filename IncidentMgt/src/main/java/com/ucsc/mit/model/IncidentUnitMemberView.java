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
@Table(name="incident_unit_member_v")
@ManagedBean(name="incident_unit_member")
@Proxy(lazy=false)
public class IncidentUnitMemberView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INC_ID")
	private int incident_number;
	
	@Column(name="ASSIGNEE_UNIT_ID")
	private String assignee_unit;
	
	@Column(name="ASSIGNEE_MEM_ID")
	private int assignee_mem_id;
	
	@Column(name="ROOT_CAUSE")
	private String root_cause;
	
	@Column(name="ACTION_TAKEN")
	private String action_taken;
	
	@Column(name="STARTED_TIME")
	private String started_time;
	
	@Column(name="UPDATED_TIME")
	private String updated_time;
	
	@Column(name="MEM_STATUS_ID")
	private String mem_status_id;
	
	@Column(name="CREATED_BY")
	private String created_by;
	
	@Column(name="CREATED_DATE")
	private Date created_date;
	
	@Column(name="UPDATED_BY")
	private String updated_by;
	
	@Column(name="REMAIN_TIME")
	private int remain_time;
	
	@Column(name="ASSIGNED_DATE_TIME")
	private Date assigned_date;
	
	@Column(name="IMPACT_URGENCY_CODE")
	private String imp_urgency_code;
	
	@Column(name="IMPACT_LVL_NAME")
	private String imp_lvl_name;
	
	@Column(name="URGENCY_NAME")
	private String urgency_name;

	public IncidentUnitMemberView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncidentUnitMemberView(int incident_number, String assignee_unit, int assignee_mem_id, String root_cause,
			String action_taken, String started_time, String updated_time, String mem_status_id, String created_by,
			Date created_date, String updated_by, int remain_time, Date assigned_date, String imp_urgency_code,
			String imp_lvl_name, String urgency_name) {
		super();
		this.incident_number = incident_number;
		this.assignee_unit = assignee_unit;
		this.assignee_mem_id = assignee_mem_id;
		this.root_cause = root_cause;
		this.action_taken = action_taken;
		this.started_time = started_time;
		this.updated_time = updated_time;
		this.mem_status_id = mem_status_id;
		this.created_by = created_by;
		this.created_date = created_date;
		this.updated_by = updated_by;
		this.remain_time = remain_time;
		this.assigned_date = assigned_date;
		this.imp_urgency_code = imp_urgency_code;
		this.imp_lvl_name = imp_lvl_name;
		this.urgency_name = urgency_name;
	}

	public int getIncident_number() {
		return incident_number;
	}

	public void setIncident_number(int incident_number) {
		this.incident_number = incident_number;
	}

	public String getAssignee_unit() {
		return assignee_unit;
	}

	public void setAssignee_unit(String assignee_unit) {
		this.assignee_unit = assignee_unit;
	}

	public int getAssignee_mem_id() {
		return assignee_mem_id;
	}

	public void setAssignee_mem_id(int assignee_mem_id) {
		this.assignee_mem_id = assignee_mem_id;
	}

	public String getRoot_cause() {
		return root_cause;
	}

	public void setRoot_cause(String root_cause) {
		this.root_cause = root_cause;
	}

	public String getAction_taken() {
		return action_taken;
	}

	public void setAction_taken(String action_taken) {
		this.action_taken = action_taken;
	}

	public String getStarted_time() {
		return started_time;
	}

	public void setStarted_time(String started_time) {
		this.started_time = started_time;
	}

	public String getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}

	public String getMem_status_id() {
		return mem_status_id;
	}

	public void setMem_status_id(String mem_status_id) {
		this.mem_status_id = mem_status_id;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public int getRemain_time() {
		return remain_time;
	}

	public void setRemain_time(int remain_time) {
		this.remain_time = remain_time;
	}

	public Date getAssigned_date() {
		return assigned_date;
	}

	public void setAssigned_date(Date assigned_date) {
		this.assigned_date = assigned_date;
	}

	public String getImp_urgency_code() {
		return imp_urgency_code;
	}

	public void setImp_urgency_code(String imp_urgency_code) {
		this.imp_urgency_code = imp_urgency_code;
	}

	public String getImp_lvl_name() {
		return imp_lvl_name;
	}

	public void setImp_lvl_name(String imp_lvl_name) {
		this.imp_lvl_name = imp_lvl_name;
	}

	public String getUrgency_name() {
		return urgency_name;
	}

	public void setUrgency_name(String urgency_name) {
		this.urgency_name = urgency_name;
	}

	@Override
	public String toString() {
		return "IncidentUnitMemberView [incident_number=" + incident_number + ", assignee_unit=" + assignee_unit
				+ ", assignee_mem_id=" + assignee_mem_id + ", root_cause=" + root_cause + ", action_taken="
				+ action_taken + ", started_time=" + started_time + ", updated_time=" + updated_time
				+ ", mem_status_id=" + mem_status_id + ", created_by=" + created_by + ", created_date=" + created_date
				+ ", updated_by=" + updated_by + ", remain_time=" + remain_time + ", assigned_date=" + assigned_date
				+ ", imp_urgency_code=" + imp_urgency_code + ", imp_lvl_name=" + imp_lvl_name + ", urgency_name="
				+ urgency_name + "]";
	}
	
	
}
