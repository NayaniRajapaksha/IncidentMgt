package com.ucsc.mit.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="employee_detail_v")
@ManagedBean(name="employee_detail_v")
@Proxy(lazy=false)
public class EmployeeDetailView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name="emp_name")
	private String emp_name;
	
	@Column(name="JOB_ROLE")
	private String job_role ;
	
	@Column(name="BRANCH_ID")
	private int branch_id;
	
	@Column(name="ENTERPRISE_GROUP_ID")
	private String enterprise_group;
	
	@Column(name="REGIONAL_ID")
	private int regional_id;
	
	@Column(name="branch_name")
	private String branch_name;
	
	@Column(name="ID")
	private int id;
	
	@Column(name="unit_id")
	private String unit_id;
	
	@Column(name="unit_name")
	private String unit_name;
	
	public EmployeeDetailView() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public EmployeeDetailView(int user_id, String emp_name, String job_role, int branch_id, String enterprise_group,
			int regional_id, String branch_name, int id, String unit_id, String unit_name) {
		super();
		this.user_id = user_id;
		this.emp_name = emp_name;
		this.job_role = job_role;
		this.branch_id = branch_id;
		this.enterprise_group = enterprise_group;
		this.regional_id = regional_id;
		this.branch_name = branch_name;
		this.id = id;
		this.unit_id = unit_id;
		this.unit_name = unit_name;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getJob_role() {
		return job_role;
	}

	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getEnterprise_group() {
		return enterprise_group;
	}

	public void setEnterprise_group(String enterprise_group) {
		this.enterprise_group = enterprise_group;
	}

	public int getRegional_id() {
		return regional_id;
	}

	public void setRegional_id(int regional_id) {
		this.regional_id = regional_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUnit_id() {
		return unit_id;
	}



	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}



	public String getUnit_name() {
		return unit_name;
	}



	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}



	@Override
	public String toString() {
		return "EmployeeDetailView [user_id=" + user_id + ", emp_name=" + emp_name + ", job_role=" + job_role
				+ ", branch_id=" + branch_id + ", enterprise_group=" + enterprise_group + ", regional_id=" + regional_id
				+ ", branch_name=" + branch_name + ", id=" + id + ", unit_id=" + unit_id + ", unit_name=" + unit_name
				+ "]";
	}



	
	
	
}
