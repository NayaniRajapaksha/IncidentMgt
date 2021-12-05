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
@Table(name="user_group_txn")
@ManagedBean(name="user_group")
@Proxy(lazy=false)
public class UserGroupTxn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="USER_ID")
	private String user_id;
	
	
	@Column(name="ENTERPRISE_GROUP_ID")
	private String ent_group_id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="CREATED_DATE")
	private Date created_date;
	
	@Column(name="CREATED_BY")
	private String created_by;

	public UserGroupTxn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserGroupTxn(int id, String user_id, String ent_group_id, String description, Date created_date,
			String created_by) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.ent_group_id = ent_group_id;
		this.description = description;
		this.created_date = created_date;
		this.created_by = created_by;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getEnt_group_id() {
		return ent_group_id;
	}

	public void setEnt_group_id(String ent_group_id) {
		this.ent_group_id = ent_group_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	@Override
	public String toString() {
		return "UserGroupTxn [id=" + id + ", user_id=" + user_id + ", ent_group_id=" + ent_group_id + ", description="
				+ description + ", created_date=" + created_date + ", created_by=" + created_by + "]";
	}
	
	
}
