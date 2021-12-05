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
@Table(name="incident_detail_v")
@ManagedBean(name="incident_detail")
@Proxy(lazy=false)
public class IncidentDetailView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="INCIDENT_NUMBER")
	private int incident_number;
	
	@Column(name="IRT_ID")
	private int irt_id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="REPORTED_BY")
	private String reported_by;
	
	@Column(name="PRIORITY_ID")
	private String priority_id;
	
	@Column(name="CREATED_DATE")
	private Date created_date;
	
	
	
	@Column(name="ORIGIN")
	private String origin;
	
	@Column(name="AFCT_UNIT_PROCESS")
	private String afct_unit_process;
	
	@Column(name="TECH_AFCT_AREA")
	private String tech_afct_area;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="INCIDENT_TYPE")
	private String incident_type;
	
	@Column(name="INCIDENT_SUB_TYPE")
	private String incident_sub_type;
	
	@Column(name="INCIDENT_LOCATION_ID")
	private String incident_location_id;
	
	@Column(name="incident_location")
	private String incident_location;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private String status;
	
	@Column(name="origin_code")
	private String origin_code;
	
	@Column(name="origin_name")
	private String origin_name;
	
	@Column(name="p_priority_id")
	private String p_priority_id;
	
	@Column(name="priority_name")
	private String priority_name;
	
	@Column(name="afct_area")
	private String afct_area;
	
	@Column(name="afct_area_name")
	private String afct_area_name;
	
	@Column(name="type_code")
	private String type_code;
	
	@Column(name="type_name")
	private String type_name;
	
	@Column(name="sub_type_code")
	private String sub_type_code;
	
	@Column(name="sub_type_name")
	private String sub_type_name;
	
	@Column(name="impact_urgency_code")
	private String impact_urgency_code;
	
	@Column(name="assigned_unit")
	private String assigned_unit;
	
	@Column(name="irt_reminder")
	private String irt_reminder;
	
	@Column(name="unit_rollback_reason")
	private String unit_rollback_reason;
	
	@Column(name="repeating_status")
	private String repeating_status;
	
	@Column(name="is_iso_incident")
	private String is_iso_incident;
	
	@Column(name="i_impact_urgency_code")
	private String i_impact_urgency_code;
	
	@Column(name="days")
	private String days;
	
	@Column(name="hours")
	private String hours;
	
	@Column(name="minutes")
	private String minutes;
	
	@Column(name="urgency")
	private String urgency;
	
	@Column(name="impact_level")
	private String impact_level;
	
	@Column(name="unit_code")
	private String unit_code;
	
	@Column(name="unit_name")
	private String unit_name;
	
	@Column(name="repeating_status_code")
	private String repeating_status_code;
	
	@Column(name="repeat_status_name")
	private String repeat_status_name;
	
	@Column(name="rem_code")
	private String rem_code;
	
	@Column(name="rem_name")
	private String rem_name;
	
	@Column(name="assignee_mem_id")
	private String assignee_mem_id;
	
	@Column(name="root_cause")
	private String root_cause;
	
	@Column(name="action_taken")
	private String action_taken;
	
	@Column(name="started_time")
	private String started_time;
	
	@Column(name="updated_time")
	private String updated_time;
	
	@Column(name="mem_status_id")
	private String mem_status_id;
	
	@Column(name="occurance_date")
	private Date occurance_date;
	
	@Column(name="modified_date")
	private Date modified_date;
	
	@Column(name="finish_time")
	private String finish_time;
	
	@Column(name="REGIONAL_ID")
	private String regional_id;
	
	@Column(name="REM_PERIOD")
	private String rem_period;
	
	@Column(name="TGT_PERIOD")
	private String tgt_period;
	
	@Column(name="branch_id")
	private String branch_id;
	
	@Column(name="NAME")
	private String bname;
	
	@Column(name="branch_type_code")
	private String branch_type_code;
	
	@Column(name="regional_name")
	private String regional_name;
	
	@Column(name="ass_mem_name")
	private String ass_mem_name;
	
	@Column(name="inc_loc_details")
	private String inc_loc_details;
	
	@Column(name="rep_emp_name")
	private String rep_emp_name;
	
	@Column(name="unit_close_reason_code")
	private String unit_close_reason_code;
	
	@Column(name="solved_in_time")
	private String solved_in_time;

	@Column(name="status_desc")
	private String status_desc;
	
	@Column(name="unit_assign_date")
	private Date unit_assign_date;
	
	@Column(name="irt_close_reason_code")
	private String irt_close_reason_code;
	
	@Column(name="unit_close_reason")
	private String unit_close_reason;
	
	@Column(name="irt_close_reason")
	private String irt_close_reason;
	
	@Column(name="mem_status_desc")
	private String mem_status_desc;
	
	@Column(name="irt_modified_date")
	private Date unit_assign_modify_date;
	
	@Column(name="inc_status_modified_by")
	private String inc_status_modified_by;
	
	
	
	public IncidentDetailView() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IncidentDetailView(int incident_number, int irt_id, String title, String reported_by, String priority_id,
			Date created_date, String origin, String afct_unit_process, String tech_afct_area, String phone,
			String email, String incident_type, String incident_sub_type, String incident_location_id,
			String incident_location, String description, String status, String origin_code, String origin_name,
			String p_priority_id, String priority_name, String afct_area, String afct_area_name, String type_code,
			String type_name, String sub_type_code, String sub_type_name, String impact_urgency_code,
			String assigned_unit, String irt_reminder, String unit_rollback_reason, String repeating_status,
			String is_iso_incident, String i_impact_urgency_code, String days, String hours, String minutes,
			String urgency, String impact_level, String unit_code, String unit_name, String repeating_status_code,
			String repeat_status_name, String rem_code, String rem_name, String assignee_mem_id, String root_cause,
			String action_taken, String started_time, String updated_time, String mem_status_id, Date occurance_date,
			Date modified_date, String finish_time, String regional_id, String rem_period, String tgt_period,
			String branch_id, String bname, String branch_type_code, String regional_name, String ass_mem_name,
			String inc_loc_details, String rep_emp_name, String unit_close_reason_code, String solved_in_time,
			String status_desc,Date unit_assign_date,String irt_close_reason_code,String unit_close_reason,String irt_close_reason,
			String mem_status_desc,Date unit_assign_modify_date,String inc_status_modified_by) {
		super();
		this.incident_number = incident_number;
		this.irt_id = irt_id;
		this.title = title;
		this.reported_by = reported_by;
		this.priority_id = priority_id;
		this.created_date = created_date;
		this.origin = origin;
		this.afct_unit_process = afct_unit_process;
		this.tech_afct_area = tech_afct_area;
		this.phone = phone;
		this.email = email;
		this.incident_type = incident_type;
		this.incident_sub_type = incident_sub_type;
		this.incident_location_id = incident_location_id;
		this.incident_location = incident_location;
		this.description = description;
		this.status = status;
		this.origin_code = origin_code;
		this.origin_name = origin_name;
		this.p_priority_id = p_priority_id;
		this.priority_name = priority_name;
		this.afct_area = afct_area;
		this.afct_area_name = afct_area_name;
		this.type_code = type_code;
		this.type_name = type_name;
		this.sub_type_code = sub_type_code;
		this.sub_type_name = sub_type_name;
		this.impact_urgency_code = impact_urgency_code;
		this.assigned_unit = assigned_unit;
		this.irt_reminder = irt_reminder;
		this.unit_rollback_reason = unit_rollback_reason;
		this.repeating_status = repeating_status;
		this.is_iso_incident = is_iso_incident;
		this.i_impact_urgency_code = i_impact_urgency_code;
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
		this.urgency = urgency;
		this.impact_level = impact_level;
		this.unit_code = unit_code;
		this.unit_name = unit_name;
		this.repeating_status_code = repeating_status_code;
		this.repeat_status_name = repeat_status_name;
		this.rem_code = rem_code;
		this.rem_name = rem_name;
		this.assignee_mem_id = assignee_mem_id;
		this.root_cause = root_cause;
		this.action_taken = action_taken;
		this.started_time = started_time;
		this.updated_time = updated_time;
		this.mem_status_id = mem_status_id;
		this.occurance_date = occurance_date;
		this.modified_date = modified_date;
		this.finish_time = finish_time;
		this.regional_id = regional_id;
		this.rem_period = rem_period;
		this.tgt_period = tgt_period;
		this.branch_id = branch_id;
		this.bname = bname;
		this.branch_type_code = branch_type_code;
		this.regional_name = regional_name;
		this.ass_mem_name = ass_mem_name;
		this.inc_loc_details = inc_loc_details;
		this.rep_emp_name = rep_emp_name;
		this.unit_close_reason_code = unit_close_reason_code;
		this.solved_in_time = solved_in_time;
		this.status_desc = status_desc;
		this.unit_assign_date=unit_assign_date;
		this.irt_close_reason_code = irt_close_reason_code;
		this.unit_close_reason = unit_close_reason;
		this.irt_close_reason = irt_close_reason;
		this.mem_status_desc=mem_status_desc;
		this.unit_assign_modify_date=unit_assign_modify_date;
		this.inc_status_modified_by=inc_status_modified_by;
	}


	public int getIncident_number() {
		return incident_number;
	}

	public void setIncident_number(int incident_number) {
		this.incident_number = incident_number;
	}

	public int getIrt_id() {
		return irt_id;
	}

	public void setIrt_id(int irt_id) {
		this.irt_id = irt_id;
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

	public String getPriority_id() {
		return priority_id;
	}

	public void setPriority_id(String priority_id) {
		this.priority_id = priority_id;
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

	public String getOrigin_code() {
		return origin_code;
	}

	public void setOrigin_code(String origin_code) {
		this.origin_code = origin_code;
	}

	public String getOrigin_name() {
		return origin_name;
	}

	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}

	public String getP_priority_id() {
		return p_priority_id;
	}

	public void setP_priority_id(String p_priority_id) {
		this.p_priority_id = p_priority_id;
	}

	public String getPriority_name() {
		return priority_name;
	}

	public void setPriority_name(String priority_name) {
		this.priority_name = priority_name;
	}

	public String getAfct_area() {
		return afct_area;
	}

	public void setAfct_area(String afct_area) {
		this.afct_area = afct_area;
	}

	public String getAfct_area_name() {
		return afct_area_name;
	}

	public void setAfct_area_name(String afct_area_name) {
		this.afct_area_name = afct_area_name;
	}

	public String getType_code() {
		return type_code;
	}

	public void setType_code(String type_code) {
		this.type_code = type_code;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getSub_type_code() {
		return sub_type_code;
	}

	public void setSub_type_code(String sub_type_code) {
		this.sub_type_code = sub_type_code;
	}

	public String getSub_type_name() {
		return sub_type_name;
	}

	public void setSub_type_name(String sub_type_name) {
		this.sub_type_name = sub_type_name;
	}

	public String getImpact_urgency_code() {
		return impact_urgency_code;
	}

	public void setImpact_urgency_code(String impact_urgency_code) {
		this.impact_urgency_code = impact_urgency_code;
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

	public String getRepeating_status() {
		return repeating_status;
	}

	public void setRepeating_status(String repeating_status) {
		this.repeating_status = repeating_status;
	}

	public String getIs_iso_incident() {
		return is_iso_incident;
	}

	public void setIs_iso_incident(String is_iso_incident) {
		this.is_iso_incident = is_iso_incident;
	}

	public String getI_impact_urgency_code() {
		return i_impact_urgency_code;
	}

	public void setI_impact_urgency_code(String i_impact_urgency_code) {
		this.i_impact_urgency_code = i_impact_urgency_code;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getImpact_level() {
		return impact_level;
	}

	public void setImpact_level(String impact_level) {
		this.impact_level = impact_level;
	}

	public String getUnit_code() {
		return unit_code;
	}

	public void setUnit_code(String unit_code) {
		this.unit_code = unit_code;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getRepeating_status_code() {
		return repeating_status_code;
	}

	public void setRepeating_status_code(String repeating_status_code) {
		this.repeating_status_code = repeating_status_code;
	}

	public String getRepeat_status_name() {
		return repeat_status_name;
	}

	public void setRepeat_status_name(String repeat_status_name) {
		this.repeat_status_name = repeat_status_name;
	}

	public String getRem_code() {
		return rem_code;
	}

	public void setRem_code(String rem_code) {
		this.rem_code = rem_code;
	}

	public String getRem_name() {
		return rem_name;
	}

	public void setRem_name(String rem_name) {
		this.rem_name = rem_name;
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

	public Date getOccurance_date() {
		return occurance_date;
	}

	public void setOccurance_date(Date occurance_date) {
		this.occurance_date = occurance_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public String getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}

	public String getRegional_id() {
		return regional_id;
	}

	public void setRegional_id(String regional_id) {
		this.regional_id = regional_id;
	}

	

	public String getRem_period() {
		return rem_period;
	}


	public void setRem_period(String rem_period) {
		this.rem_period = rem_period;
	}


	public String getTgt_period() {
		return tgt_period;
	}


	public void setTgt_period(String tgt_period) {
		this.tgt_period = tgt_period;
	}


	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBranch_type_code() {
		return branch_type_code;
	}

	public void setBranch_type_code(String branch_type_code) {
		this.branch_type_code = branch_type_code;
	}

	public String getRegional_name() {
		return regional_name;
	}

	public void setRegional_name(String regional_name) {
		this.regional_name = regional_name;
	}

	public String getAss_mem_name() {
		return ass_mem_name;
	}

	public void setAss_mem_name(String ass_mem_name) {
		this.ass_mem_name = ass_mem_name;
	}

	public String getInc_loc_details() {
		return inc_loc_details;
	}

	public void setInc_loc_details(String inc_loc_details) {
		this.inc_loc_details = inc_loc_details;
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

	public String getSolved_in_time() {
		return solved_in_time;
	}

	public void setSolved_in_time(String solved_in_time) {
		this.solved_in_time = solved_in_time;
	}

	public String getStatus_desc() {
		return status_desc;
	}

	public void setStatus_desc(String status_desc) {
		this.status_desc = status_desc;
	}


	public Date getUnit_assign_date() {
		return unit_assign_date;
	}


	public void setUnit_assign_date(Date unit_assign_date) {
		this.unit_assign_date = unit_assign_date;
	}


	public String getIrt_close_reason_code() {
		return irt_close_reason_code;
	}


	public void setIrt_close_reason_code(String irt_close_reason_code) {
		this.irt_close_reason_code = irt_close_reason_code;
	}


	public String getUnit_close_reason() {
		return unit_close_reason;
	}


	public void setUnit_close_reason(String unit_close_reason) {
		this.unit_close_reason = unit_close_reason;
	}


	public String getIrt_close_reason() {
		return irt_close_reason;
	}


	public void setIrt_close_reason(String irt_close_reason) {
		this.irt_close_reason = irt_close_reason;
	}


	public String getMem_status_desc() {
		return mem_status_desc;
	}


	public void setMem_status_desc(String mem_status_desc) {
		this.mem_status_desc = mem_status_desc;
	}


	public Date getUnit_assign_modify_date() {
		return unit_assign_modify_date;
	}


	public void setUnit_assign_modify_date(Date unit_assign_modify_date) {
		this.unit_assign_modify_date = unit_assign_modify_date;
	}


	public String getInc_status_modified_by() {
		return inc_status_modified_by;
	}


	public void setInc_status_modified_by(String inc_status_modified_by) {
		this.inc_status_modified_by = inc_status_modified_by;
	}


	@Override
	public String toString() {
		return "IncidentDetailView [incident_number=" + incident_number + ", irt_id=" + irt_id + ", title=" + title
				+ ", reported_by=" + reported_by + ", priority_id=" + priority_id + ", created_date=" + created_date
				+ ", origin=" + origin + ", afct_unit_process=" + afct_unit_process + ", tech_afct_area="
				+ tech_afct_area + ", phone=" + phone + ", email=" + email + ", incident_type=" + incident_type
				+ ", incident_sub_type=" + incident_sub_type + ", incident_location_id=" + incident_location_id
				+ ", incident_location=" + incident_location + ", description=" + description + ", status=" + status
				+ ", origin_code=" + origin_code + ", origin_name=" + origin_name + ", p_priority_id=" + p_priority_id
				+ ", priority_name=" + priority_name + ", afct_area=" + afct_area + ", afct_area_name=" + afct_area_name
				+ ", type_code=" + type_code + ", type_name=" + type_name + ", sub_type_code=" + sub_type_code
				+ ", sub_type_name=" + sub_type_name + ", impact_urgency_code=" + impact_urgency_code
				+ ", assigned_unit=" + assigned_unit + ", irt_reminder=" + irt_reminder + ", unit_rollback_reason="
				+ unit_rollback_reason + ", repeating_status=" + repeating_status + ", is_iso_incident="
				+ is_iso_incident + ", i_impact_urgency_code=" + i_impact_urgency_code + ", days=" + days + ", hours="
				+ hours + ", minutes=" + minutes + ", urgency=" + urgency + ", impact_level=" + impact_level
				+ ", unit_code=" + unit_code + ", unit_name=" + unit_name + ", repeating_status_code="
				+ repeating_status_code + ", repeat_status_name=" + repeat_status_name + ", rem_code=" + rem_code
				+ ", rem_name=" + rem_name + ", assignee_mem_id=" + assignee_mem_id + ", root_cause=" + root_cause
				+ ", action_taken=" + action_taken + ", started_time=" + started_time + ", updated_time=" + updated_time
				+ ", mem_status_id=" + mem_status_id + ", occurance_date=" + occurance_date + ", modified_date="
				+ modified_date + ", finish_time=" + finish_time + ", regional_id=" + regional_id + ", rem_period="
				+ rem_period + ", tgt_period=" + tgt_period + ", branch_id=" + branch_id + ", bname=" + bname
				+ ", branch_type_code=" + branch_type_code + ", regional_name=" + regional_name + ", ass_mem_name="
				+ ass_mem_name + ", inc_loc_details=" + inc_loc_details + ", rep_emp_name=" + rep_emp_name
				+ ", unit_close_reason_code=" + unit_close_reason_code + ", solved_in_time=" + solved_in_time
				+ ", status_desc=" + status_desc + ", unit_assign_date=" + unit_assign_date + ", irt_close_reason_code="
				+ irt_close_reason_code + ", unit_close_reason=" + unit_close_reason + ", irt_close_reason="
				+ irt_close_reason + ", mem_status_desc=" + mem_status_desc + ", unit_assign_modify_date="
				+ unit_assign_modify_date + ", inc_status_modified_by=" + inc_status_modified_by + "]";
	}


	




	

	

	
}
