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
@Table(name="incident_status_m")
@ManagedBean(name="incidentStatus")
@Proxy(lazy=false)
public class IncidentStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="IRT_SEQ")
	private int irt_seq;
	
	
	
	@Column(name="DEP_SEQ")
	private int dependency_seq;
	
	@Column(name="STATUS_CODE")
	private String status_code;
	
	@Column(name="STATUS_DESC")
	private String status_des;
	
	@Column(name="STATUS_TYPE")
	private String status_type;
	
	@Column(name="CREATED_BY")
	private String created_by;

	public IncidentStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncidentStatus(int id, int irt_seq,  int dependency_seq, String status_code, String status_des,
			String status_type, String created_by) {
		super();
		this.id = id;
		this.irt_seq = irt_seq;
	
		this.dependency_seq = dependency_seq;
		this.status_code = status_code;
		this.status_des = status_des;
		this.status_type = status_type;
		this.created_by = created_by;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIrt_seq() {
		return irt_seq;
	}

	public void setIrt_seq(int irt_seq) {
		this.irt_seq = irt_seq;
	}

	

	public int getDependency_seq() {
		return dependency_seq;
	}

	public void setDependency_seq(int dependency_seq) {
		this.dependency_seq = dependency_seq;
	}

	public String getStatus_code() {
		return status_code;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public String getStatus_des() {
		return status_des;
	}

	public void setStatus_des(String status_des) {
		this.status_des = status_des;
	}

	public String getStatus_type() {
		return status_type;
	}

	public void setStatus_type(String status_type) {
		this.status_type = status_type;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	@Override
	public String toString() {
		return "IncidentStatus [id=" + id + ", irt_seq=" + irt_seq + ", dependency_seq="
				+ dependency_seq + ", status_code=" + status_code + ", status_des=" + status_des + ", status_type="
				+ status_type + ", created_by=" + created_by + "]";
	}
	
	

}
