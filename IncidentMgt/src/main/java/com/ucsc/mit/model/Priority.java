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
@Table(name="incident_priority_m")
@ManagedBean(name="priority")
@Proxy(lazy=false)
public class Priority  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="PRIORITY_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="PRIORITY_NAME")
	private String priorityName;
	
	@Column(name="DEP_ORDER_SEQ")
	private int displayOrder;

	
	
	public Priority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Priority(int id, String priorityName, int displayOrder) {
		super();
		this.id = id;
		this.priorityName = priorityName;
		this.displayOrder = displayOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Override
	public String toString() {
		return "Priority [id=" + id + ", priorityName=" + priorityName + ", displayOrder=" + displayOrder + "]";
	}

	
	
}
