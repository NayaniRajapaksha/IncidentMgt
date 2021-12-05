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
@Table(name="incident_dependency_detail_v")
@ManagedBean(name="dependency_view")
@Proxy(lazy=false)
public class DependencyDetailView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="DEPENDENCY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dependency_id;
	
	@Column(name="INCIDENT_ID")
	private int incident_id;
	
	@Column(name="UNIT_ID")
	private int unit_id;
	
	@Column(name="PRIORITY_ID")
	private int priority_id;
	
	@Column(name="DAYS")
	private int days;
	
	@Column(name="HOURS")
	private int hours;
	
	@Column(name="MINUTES")
	private int minutes;
	
	@Column(name="CREATED_DATE")
	private Date created_date;
	
	@Column(name="MODIFIED_DATE_TIME")
	private Date modified_date;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="DEPENDANCY_STATUS")
	private String dependency_status;
	
	@Column(name="ASSINGED_MEM")
	private String assinged_member;
	
	@Column(name="RESOLVED_DESC")
	private String resolved_des;
	
	@Column(name="CREATED_BY")
	private String created_by;
	
	@Column(name="DEPEND_CLOSE_REASON")
	private String depend_close_reason;
	
	@Column(name="VISIBLE_STATUS")
	private String visible_status;
	
	@Column(name="priority_name")
	private String priority_name;
	
	@Column(name="unit_name")
	private String unit_name;
	
	@Column(name="dep_satus_name")
	private String dep_satus_name;

	public DependencyDetailView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DependencyDetailView(int dependency_id, int incident_id, int unit_id, int priority_id, int days, int hours,
			int minutes, Date created_date, Date modified_date, String description, String dependency_status,
			String assinged_member, String resolved_des, String created_by, String depend_close_reason,
			String visible_status, String priority_name, String unit_name, String dep_satus_name) {
		super();
		this.dependency_id = dependency_id;
		this.incident_id = incident_id;
		this.unit_id = unit_id;
		this.priority_id = priority_id;
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.description = description;
		this.dependency_status = dependency_status;
		this.assinged_member = assinged_member;
		this.resolved_des = resolved_des;
		this.created_by = created_by;
		this.depend_close_reason = depend_close_reason;
		this.visible_status = visible_status;
		this.priority_name = priority_name;
		this.unit_name = unit_name;
		this.dep_satus_name = dep_satus_name;
	}

	public int getDependency_id() {
		return dependency_id;
	}

	public void setDependency_id(int dependency_id) {
		this.dependency_id = dependency_id;
	}

	public int getIncident_id() {
		return incident_id;
	}

	public void setIncident_id(int incident_id) {
		this.incident_id = incident_id;
	}

	public int getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
	}

	public int getPriority_id() {
		return priority_id;
	}

	public void setPriority_id(int priority_id) {
		this.priority_id = priority_id;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDependency_status() {
		return dependency_status;
	}

	public void setDependency_status(String dependency_status) {
		this.dependency_status = dependency_status;
	}

	public String getAssinged_member() {
		return assinged_member;
	}

	public void setAssinged_member(String assinged_member) {
		this.assinged_member = assinged_member;
	}

	public String getResolved_des() {
		return resolved_des;
	}

	public void setResolved_des(String resolved_des) {
		this.resolved_des = resolved_des;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getDepend_close_reason() {
		return depend_close_reason;
	}

	public void setDepend_close_reason(String depend_close_reason) {
		this.depend_close_reason = depend_close_reason;
	}

	public String getVisible_status() {
		return visible_status;
	}

	public void setVisible_status(String visible_status) {
		this.visible_status = visible_status;
	}

	public String getPriority_name() {
		return priority_name;
	}

	public void setPriority_name(String priority_name) {
		this.priority_name = priority_name;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getDep_satus_name() {
		return dep_satus_name;
	}

	public void setDep_satus_name(String dep_satus_name) {
		this.dep_satus_name = dep_satus_name;
	}

	@Override
	public String toString() {
		return "DependencyDetailView [dependency_id=" + dependency_id + ", incident_id=" + incident_id + ", unit_id="
				+ unit_id + ", priority_id=" + priority_id + ", days=" + days + ", hours=" + hours + ", minutes="
				+ minutes + ", created_date=" + created_date + ", modified_date=" + modified_date + ", description="
				+ description + ", dependency_status=" + dependency_status + ", assinged_member=" + assinged_member
				+ ", resolved_des=" + resolved_des + ", created_by=" + created_by + ", depend_close_reason="
				+ depend_close_reason + ", visible_status=" + visible_status + ", priority_name=" + priority_name
				+ ", unit_name=" + unit_name + ", dep_satus_name=" + dep_satus_name + "]";
	}
	
	
	

}
