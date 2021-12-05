package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class IncidentTicketPrint implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id

	private int incident_number;
	

	private int priority_id;
	
	
	private String title;
	

	private String reported_by;
	

	private Date created_date;
	
	

	private String origin;
	

	private String afct_unit_process;
	

	private String tech_afct_area;
	

	private String mobile_phone;
	

	private String email;
	

	private String incident_type;
	

	private String incident_sub_type;
	

	private String incident_location_id;
	

	private String incident_location;
	

	private String description;
	

	private String status;
	

	private String m_origin;
	

	private String m_origin_name;
	

	private String m_priority_id;
	
	
	private String m_priority_name;
	
	
	private String m_afct_area;
	

	private String m_afct_name;
	

	private String m_type;
	

	private String m_type_name;
	
	
	private String m_sub_type;
	

	private String m_sub_type_name;
	

	private String irt_impact_urgency_code;
	

	private String assigned_unit;
	

	private String irt_reminder;
	

	private String unit_rollback_reason;
	

	private String m_impact_urgency_code;
	

	private String m_days;
	

	private String m_hours;
	

	private String m_minutes;

	private String m_urgency;
	

	private String m_impact_level;
	

	private String m_unit_code;
	

	private String m_unit_name;
	

	

	private String m_rem_code;
	

	private String m_rem_name;
	

	private Date occured_date;
	

	private Date irt_modified_date;
	

	private String assignee_mem_id;
	

	private String root_cause;
	

	private String action_taken;
	

	private String started_time;
	

	private String updated_time;
	

	private String mem_status_id;
	

	private String finish_time;
	

	private String solved_in_time;
	

	private String region_id;
	

	private String tgt_period;
	
	
	private String rem_period;
	

	private String branch_id;
	

	private String br_name;
	

	private String br_type_code;
	

	private String reg_name;
	
	
	private String assign_mem_name;
	

	private String loc_details;
	
	
	private String rep_emp_name;
	
	private String unit_close_reason_code;

	private String unit_close_comment;

	private String irt_close_comment;

	public IncidentTicketPrint() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IncidentTicketPrint(int incident_number, int priority_id, String title, String reported_by,
			Date created_date, String origin, String afct_unit_process, String tech_afct_area, String mobile_phone,
			String email, String incident_type, String incident_sub_type, String incident_location_id,
			String incident_location, String description, String status, String m_origin, String m_origin_name,
			String m_priority_id, String m_priority_name, String m_afct_area, String m_afct_name, String m_type,
			String m_type_name, String m_sub_type, String m_sub_type_name, String irt_impact_urgency_code,
			String assigned_unit, String irt_reminder, String unit_rollback_reason, String m_impact_urgency_code,
			String m_days, String m_hours, String m_minutes, String m_urgency, String m_impact_level,
			String m_unit_code, String m_unit_name, String m_rem_code, String m_rem_name, Date occured_date,
			Date irt_modified_date, String assignee_mem_id, String root_cause, String action_taken, String started_time,
			String updated_time, String mem_status_id, String finish_time, String solved_in_time, String region_id,
			String tgt_period, String rem_period, String branch_id, String br_name, String br_type_code,
			String reg_name, String assign_mem_name, String loc_details, String rep_emp_name,
			String unit_close_reason_code, String unit_close_comment, String irt_close_comment) {
		super();
		this.incident_number = incident_number;
		this.priority_id = priority_id;
		this.title = title;
		this.reported_by = reported_by;
		this.created_date = created_date;
		this.origin = origin;
		this.afct_unit_process = afct_unit_process;
		this.tech_afct_area = tech_afct_area;
		this.mobile_phone = mobile_phone;
		this.email = email;
		this.incident_type = incident_type;
		this.incident_sub_type = incident_sub_type;
		this.incident_location_id = incident_location_id;
		this.incident_location = incident_location;
		this.description = description;
		this.status = status;
		this.m_origin = m_origin;
		this.m_origin_name = m_origin_name;
		this.m_priority_id = m_priority_id;
		this.m_priority_name = m_priority_name;
		this.m_afct_area = m_afct_area;
		this.m_afct_name = m_afct_name;
		this.m_type = m_type;
		this.m_type_name = m_type_name;
		this.m_sub_type = m_sub_type;
		this.m_sub_type_name = m_sub_type_name;
		this.irt_impact_urgency_code = irt_impact_urgency_code;
		this.assigned_unit = assigned_unit;
		this.irt_reminder = irt_reminder;
		this.unit_rollback_reason = unit_rollback_reason;
		this.m_impact_urgency_code = m_impact_urgency_code;
		this.m_days = m_days;
		this.m_hours = m_hours;
		this.m_minutes = m_minutes;
		this.m_urgency = m_urgency;
		this.m_impact_level = m_impact_level;
		this.m_unit_code = m_unit_code;
		this.m_unit_name = m_unit_name;
		this.m_rem_code = m_rem_code;
		this.m_rem_name = m_rem_name;
		this.occured_date = occured_date;
		this.irt_modified_date = irt_modified_date;
		this.assignee_mem_id = assignee_mem_id;
		this.root_cause = root_cause;
		this.action_taken = action_taken;
		this.started_time = started_time;
		this.updated_time = updated_time;
		this.mem_status_id = mem_status_id;
		this.finish_time = finish_time;
		this.solved_in_time = solved_in_time;
		this.region_id = region_id;
		this.tgt_period = tgt_period;
		this.rem_period = rem_period;
		this.branch_id = branch_id;
		this.br_name = br_name;
		this.br_type_code = br_type_code;
		this.reg_name = reg_name;
		this.assign_mem_name = assign_mem_name;
		this.loc_details = loc_details;
		this.rep_emp_name = rep_emp_name;
		this.unit_close_reason_code = unit_close_reason_code;
		this.unit_close_comment = unit_close_comment;
		this.irt_close_comment = irt_close_comment;
	}



	public IncidentTicketPrint(int incident_number, String title, Date created_date, Date occured_date, String br_name,
			String rep_emp_name) {
		super();
		this.incident_number = incident_number;
		this.title = title;
		this.created_date = created_date;
		this.occured_date = occured_date;
		this.br_name = br_name;
		this.rep_emp_name = rep_emp_name;
	}


	public int getIncident_number() {
		return incident_number;
	}


	public void setIncident_number(int incident_number) {
		this.incident_number = incident_number;
	}


	public int getPriority_id() {
		return priority_id;
	}


	public void setPriority_id(int priority_id) {
		this.priority_id = priority_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getReported_by() {
		return reported_by;
	}


	public void setReported_by(String reported_by) {
		this.reported_by = reported_by;
	}


	public Date getCreated_date() {
		return created_date;
	}


	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getAfct_unit_process() {
		return afct_unit_process;
	}


	public void setAfct_unit_process(String afct_unit_process) {
		this.afct_unit_process = afct_unit_process;
	}


	public String getTech_afct_area() {
		return tech_afct_area;
	}


	public void setTech_afct_area(String tech_afct_area) {
		this.tech_afct_area = tech_afct_area;
	}


	public String getMobile_phone() {
		return mobile_phone;
	}


	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getIncident_type() {
		return incident_type;
	}


	public void setIncident_type(String incident_type) {
		this.incident_type = incident_type;
	}


	public String getIncident_sub_type() {
		return incident_sub_type;
	}


	public void setIncident_sub_type(String incident_sub_type) {
		this.incident_sub_type = incident_sub_type;
	}


	public String getIncident_location_id() {
		return incident_location_id;
	}


	public void setIncident_location_id(String incident_location_id) {
		this.incident_location_id = incident_location_id;
	}


	public String getIncident_location() {
		return incident_location;
	}


	public void setIncident_location(String incident_location) {
		this.incident_location = incident_location;
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


	public String getM_origin() {
		return m_origin;
	}


	public void setM_origin(String m_origin) {
		this.m_origin = m_origin;
	}


	public String getM_origin_name() {
		return m_origin_name;
	}


	public void setM_origin_name(String m_origin_name) {
		this.m_origin_name = m_origin_name;
	}


	public String getM_priority_id() {
		return m_priority_id;
	}


	public void setM_priority_id(String m_priority_id) {
		this.m_priority_id = m_priority_id;
	}


	public String getM_priority_name() {
		return m_priority_name;
	}


	public void setM_priority_name(String m_priority_name) {
		this.m_priority_name = m_priority_name;
	}


	public String getM_afct_area() {
		return m_afct_area;
	}


	public void setM_afct_area(String m_afct_area) {
		this.m_afct_area = m_afct_area;
	}


	public String getM_afct_name() {
		return m_afct_name;
	}


	public void setM_afct_name(String m_afct_name) {
		this.m_afct_name = m_afct_name;
	}


	public String getM_type() {
		return m_type;
	}


	public void setM_type(String m_type) {
		this.m_type = m_type;
	}


	public String getM_type_name() {
		return m_type_name;
	}


	public void setM_type_name(String m_type_name) {
		this.m_type_name = m_type_name;
	}


	public String getM_sub_type() {
		return m_sub_type;
	}


	public void setM_sub_type(String m_sub_type) {
		this.m_sub_type = m_sub_type;
	}


	public String getM_sub_type_name() {
		return m_sub_type_name;
	}


	public void setM_sub_type_name(String m_sub_type_name) {
		this.m_sub_type_name = m_sub_type_name;
	}


	public String getIrt_impact_urgency_code() {
		return irt_impact_urgency_code;
	}


	public void setIrt_impact_urgency_code(String irt_impact_urgency_code) {
		this.irt_impact_urgency_code = irt_impact_urgency_code;
	}


	public String getAssigned_unit() {
		return assigned_unit;
	}


	public void setAssigned_unit(String assigned_unit) {
		this.assigned_unit = assigned_unit;
	}


	public String getIrt_reminder() {
		return irt_reminder;
	}


	public void setIrt_reminder(String irt_reminder) {
		this.irt_reminder = irt_reminder;
	}


	public String getUnit_rollback_reason() {
		return unit_rollback_reason;
	}


	public void setUnit_rollback_reason(String unit_rollback_reason) {
		this.unit_rollback_reason = unit_rollback_reason;
	}


	public String getM_impact_urgency_code() {
		return m_impact_urgency_code;
	}


	public void setM_impact_urgency_code(String m_impact_urgency_code) {
		this.m_impact_urgency_code = m_impact_urgency_code;
	}


	public String getM_days() {
		return m_days;
	}


	public void setM_days(String m_days) {
		this.m_days = m_days;
	}


	public String getM_hours() {
		return m_hours;
	}


	public void setM_hours(String m_hours) {
		this.m_hours = m_hours;
	}


	public String getM_minutes() {
		return m_minutes;
	}


	public void setM_minutes(String m_minutes) {
		this.m_minutes = m_minutes;
	}


	public String getM_urgency() {
		return m_urgency;
	}


	public void setM_urgency(String m_urgency) {
		this.m_urgency = m_urgency;
	}


	public String getM_impact_level() {
		return m_impact_level;
	}


	public void setM_impact_level(String m_impact_level) {
		this.m_impact_level = m_impact_level;
	}


	public String getM_unit_code() {
		return m_unit_code;
	}


	public void setM_unit_code(String m_unit_code) {
		this.m_unit_code = m_unit_code;
	}


	public String getM_unit_name() {
		return m_unit_name;
	}


	public void setM_unit_name(String m_unit_name) {
		this.m_unit_name = m_unit_name;
	}


	public String getM_rem_code() {
		return m_rem_code;
	}


	public void setM_rem_code(String m_rem_code) {
		this.m_rem_code = m_rem_code;
	}


	public String getM_rem_name() {
		return m_rem_name;
	}


	public void setM_rem_name(String m_rem_name) {
		this.m_rem_name = m_rem_name;
	}


	public Date getOccured_date() {
		return occured_date;
	}


	public void setOccured_date(Date occured_date) {
		this.occured_date = occured_date;
	}


	public Date getIrt_modified_date() {
		return irt_modified_date;
	}


	public void setIrt_modified_date(Date irt_modified_date) {
		this.irt_modified_date = irt_modified_date;
	}


	public String getAssignee_mem_id() {
		return assignee_mem_id;
	}


	public void setAssignee_mem_id(String assignee_mem_id) {
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


	public String getFinish_time() {
		return finish_time;
	}


	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}


	public String getSolved_in_time() {
		return solved_in_time;
	}


	public void setSolved_in_time(String solved_in_time) {
		this.solved_in_time = solved_in_time;
	}


	public String getRegion_id() {
		return region_id;
	}


	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}


	public String getTgt_period() {
		return tgt_period;
	}


	public void setTgt_period(String tgt_period) {
		this.tgt_period = tgt_period;
	}


	public String getRem_period() {
		return rem_period;
	}


	public void setRem_period(String rem_period) {
		this.rem_period = rem_period;
	}


	public String getBranch_id() {
		return branch_id;
	}


	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}


	public String getBr_name() {
		return br_name;
	}


	public void setBr_name(String br_name) {
		this.br_name = br_name;
	}


	public String getBr_type_code() {
		return br_type_code;
	}


	public void setBr_type_code(String br_type_code) {
		this.br_type_code = br_type_code;
	}


	public String getReg_name() {
		return reg_name;
	}


	public void setReg_name(String reg_name) {
		this.reg_name = reg_name;
	}


	public String getAssign_mem_name() {
		return assign_mem_name;
	}


	public void setAssign_mem_name(String assign_mem_name) {
		this.assign_mem_name = assign_mem_name;
	}


	public String getLoc_details() {
		return loc_details;
	}


	public void setLoc_details(String loc_details) {
		this.loc_details = loc_details;
	}


	public String getRep_emp_name() {
		return rep_emp_name;
	}


	public void setRep_emp_name(String rep_emp_name) {
		this.rep_emp_name = rep_emp_name;
	}


	public String getUnit_close_reason_code() {
		return unit_close_reason_code;
	}


	public void setUnit_close_reason_code(String unit_close_reason_code) {
		this.unit_close_reason_code = unit_close_reason_code;
	}


	public String getUnit_close_comment() {
		return unit_close_comment;
	}


	public void setUnit_close_comment(String unit_close_comment) {
		this.unit_close_comment = unit_close_comment;
	}


	public String getIrt_close_comment() {
		return irt_close_comment;
	}


	public void setIrt_close_comment(String irt_close_comment) {
		this.irt_close_comment = irt_close_comment;
	}


	@Override
	public String toString() {
		return "IncidentTicketPrint [incident_number=" + incident_number + ", priority_id=" + priority_id + ", title="
				+ title + ", reported_by=" + reported_by + ", created_date=" + created_date + ", origin=" + origin
				+ ", afct_unit_process=" + afct_unit_process + ", tech_afct_area=" + tech_afct_area + ", mobile_phone="
				+ mobile_phone + ", email=" + email + ", incident_type=" + incident_type + ", incident_sub_type="
				+ incident_sub_type + ", incident_location_id=" + incident_location_id + ", incident_location="
				+ incident_location + ", description=" + description + ", status=" + status + ", m_origin=" + m_origin
				+ ", m_origin_name=" + m_origin_name + ", m_priority_id=" + m_priority_id + ", m_priority_name="
				+ m_priority_name + ", m_afct_area=" + m_afct_area + ", m_afct_name=" + m_afct_name + ", m_type="
				+ m_type + ", m_type_name=" + m_type_name + ", m_sub_type=" + m_sub_type + ", m_sub_type_name="
				+ m_sub_type_name + ", irt_impact_urgency_code=" + irt_impact_urgency_code + ", assigned_unit="
				+ assigned_unit + ", irt_reminder=" + irt_reminder + ", unit_rollback_reason=" + unit_rollback_reason
				+ ", m_impact_urgency_code=" + m_impact_urgency_code + ", m_days=" + m_days + ", m_hours=" + m_hours
				+ ", m_minutes=" + m_minutes + ", m_urgency=" + m_urgency + ", m_impact_level=" + m_impact_level
				+ ", m_unit_code=" + m_unit_code + ", m_unit_name=" + m_unit_name + ", m_rem_code=" + m_rem_code
				+ ", m_rem_name=" + m_rem_name + ", occured_date=" + occured_date + ", irt_modified_date="
				+ irt_modified_date + ", assignee_mem_id=" + assignee_mem_id + ", root_cause=" + root_cause
				+ ", action_taken=" + action_taken + ", started_time=" + started_time + ", updated_time=" + updated_time
				+ ", mem_status_id=" + mem_status_id + ", finish_time=" + finish_time + ", solved_in_time="
				+ solved_in_time + ", region_id=" + region_id + ", tgt_period=" + tgt_period + ", rem_period="
				+ rem_period + ", branch_id=" + branch_id + ", br_name=" + br_name + ", br_type_code=" + br_type_code
				+ ", reg_name=" + reg_name + ", assign_mem_name=" + assign_mem_name + ", loc_details=" + loc_details
				+ ", rep_emp_name=" + rep_emp_name + ", unit_close_reason_code=" + unit_close_reason_code
				+ ", unit_close_comment=" + unit_close_comment + ", irt_close_comment=" + irt_close_comment + "]";
	}








	

	

	

	
}
