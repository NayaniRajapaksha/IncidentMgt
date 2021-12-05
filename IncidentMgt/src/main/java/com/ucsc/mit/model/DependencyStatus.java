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
@Table(name="incident_dependency_status_m")
@ManagedBean(name="dependency_status_m")
@Proxy(lazy=false)
public class DependencyStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="DEP_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dep_id;
	
	@Column(name="ORDER_SEQ")
	private int order_seq;
	
	
	
	@Column(name="DEP_STAT_CODE")
	private String dep_status_code;
	
	@Column(name="DEP_STAT")
	private String dep_status_des;
	
	@Column(name="DEP_STAT_TYPE")
	private String dep_status_type;
	
	@Column(name="CREATED_BY")
	private String created_by;
	
	@Column(name="CREATED_DATE")
	private Date created_date;

	public DependencyStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DependencyStatus(int dep_id, int order_seq, String dep_status_code, String dep_status_des,
			String dep_status_type, String created_by, Date created_date) {
		super();
		this.dep_id = dep_id;
		this.order_seq = order_seq;
		this.dep_status_code = dep_status_code;
		this.dep_status_des = dep_status_des;
		this.dep_status_type = dep_status_type;
		this.created_by = created_by;
		this.created_date = created_date;
	}

	public int getDep_id() {
		return dep_id;
	}

	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}

	public int getOrder_seq() {
		return order_seq;
	}

	public void setOrder_seq(int order_seq) {
		this.order_seq = order_seq;
	}

	public String getDep_status_code() {
		return dep_status_code;
	}

	public void setDep_status_code(String dep_status_code) {
		this.dep_status_code = dep_status_code;
	}

	public String getDep_status_des() {
		return dep_status_des;
	}

	public void setDep_status_des(String dep_status_des) {
		this.dep_status_des = dep_status_des;
	}

	public String getDep_status_type() {
		return dep_status_type;
	}

	public void setDep_status_type(String dep_status_type) {
		this.dep_status_type = dep_status_type;
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

	@Override
	public String toString() {
		return "DependencyStatus [dep_id=" + dep_id + ", order_seq=" + order_seq + ", dep_status_code="
				+ dep_status_code + ", dep_status_des=" + dep_status_des + ", dep_status_type=" + dep_status_type
				+ ", created_by=" + created_by + ", created_date=" + created_date + "]";
	}
	
	

}
