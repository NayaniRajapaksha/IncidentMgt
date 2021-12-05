package com.ucsc.mit.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
@Entity
@Table(name="team_member_v")
@ManagedBean(name="team_member_view")
@Proxy(lazy=false)
public class TeamMemberView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @Column(name="ID")
	private int id;
	
	@Column(name="unit_id")
	private int unit_id;
	
	@Column(name="team_member_id")
	private int team_member_id;
	
	@Column(name="unit_head_id")
	private String unit_head_id;
	
	@Column(name="unit_name")
	private String unit_name;
	
	@Column(name="team_m_name")
	private String team_m_name;
	
	@Column(name="emp_id")
	private String emp_id;
	
	@Column(name="unit_head_name")
	private String unit_head_name;
	
	@Column(name="unit_head_emp_id")
	private String unit_head_emp_id;

	public TeamMemberView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamMemberView(int id, int unit_id, int team_member_id, String unit_head_id, String unit_name,
			String team_m_name, String emp_id, String unit_head_name, String unit_head_emp_id) {
		super();
		this.id = id;
		this.unit_id = unit_id;
		this.team_member_id = team_member_id;
		this.unit_head_id = unit_head_id;
		this.unit_name = unit_name;
		this.team_m_name = team_m_name;
		this.emp_id = emp_id;
		this.unit_head_name = unit_head_name;
		this.unit_head_emp_id = unit_head_emp_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
	}

	public int getTeam_member_id() {
		return team_member_id;
	}

	public void setTeam_member_id(int team_member_id) {
		this.team_member_id = team_member_id;
	}

	public String getUnit_head_id() {
		return unit_head_id;
	}

	public void setUnit_head_id(String unit_head_id) {
		this.unit_head_id = unit_head_id;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getTeam_m_name() {
		return team_m_name;
	}

	public void setTeam_m_name(String team_m_name) {
		this.team_m_name = team_m_name;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getUnit_head_name() {
		return unit_head_name;
	}

	public void setUnit_head_name(String unit_head_name) {
		this.unit_head_name = unit_head_name;
	}

	public String getUnit_head_emp_id() {
		return unit_head_emp_id;
	}

	public void setUnit_head_emp_id(String unit_head_emp_id) {
		this.unit_head_emp_id = unit_head_emp_id;
	}

	@Override
	public String toString() {
		return "TeamMemberView [id=" + id + ", unit_id=" + unit_id + ", team_member_id=" + team_member_id
				+ ", unit_head_id=" + unit_head_id + ", unit_name=" + unit_name + ", team_m_name=" + team_m_name
				+ ", emp_id=" + emp_id + ", unit_head_name=" + unit_head_name + ", unit_head_emp_id=" + unit_head_emp_id
				+ "]";
	}
	
	

}
