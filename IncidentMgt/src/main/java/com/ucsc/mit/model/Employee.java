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
@Table(name="employee")
@ManagedBean(name="employee")
@Proxy(lazy=false)
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="BRANCH_ID")
	private int branchId;
	
	
	@Column(name="EMP_ID",unique=true)
	private String empId;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="PASSWORD")
	private String pwd;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ID_NO")
	private String id_no;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ACTIVE")
	private String status;
	
	@Column(name="SUPERVISOR_EMP_ID")
	private String supervisorEmpId;
	
	@Column(name="JOB_ROLE")
	private String jobRole;
	
	@Column(name="CONTACT_NO")
	private String contactNo;

	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Employee(int id, int branchId, String empId, String name) {
		super();
		this.id = id;
		this.branchId = branchId;
		this.empId = empId;
		this.name = name;
	}



	public Employee(int id, int branchId, String empId, String userId, String pwd, String name, String id_no,
			String email, String status, String supervisorEmpId, String jobRole, String contactNo) {
		super();
		this.id = id;
		this.branchId = branchId;
		this.empId = empId;
		this.userId = userId;
		this.pwd = pwd;
		this.name = name;
		this.id_no = id_no;
		this.email = email;
		this.status = status;
		this.supervisorEmpId = supervisorEmpId;
		this.jobRole = jobRole;
		this.contactNo = contactNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupervisorEmpId() {
		return supervisorEmpId;
	}

	public void setSupervisorEmpId(String supervisorEmpId) {
		this.supervisorEmpId = supervisorEmpId;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", branchId=" + branchId + ", empId=" + empId + ", userId=" + userId + ", pwd="
				+ pwd + ", name=" + name + ", id_no=" + id_no + ", email=" + email + ", status=" + status
				+ ", supervisorEmpId=" + supervisorEmpId + ", jobRole=" + jobRole + ", contactNo=" + contactNo + "]";
	}
	
	
}
