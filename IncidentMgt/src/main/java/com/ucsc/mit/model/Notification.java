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
@Table(name="notification")
@ManagedBean(name="notification")
@Proxy(lazy=false)
public class Notification  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name="NOTIFICATION_NO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="MODULE_ID")
	private int moduleId;
	
	@Column(name="REFERENCE_ID")
	private int refId;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="SERVICE_NO")
	private String serviceNo;
	
	@Column(name="NOTICATION_TEXT")
	private String notificationText;
	
	@Column(name="NOTIFI_TARGET")
	private String notifiTarget;
	
	@Column(name="NOTIFICATION_TIME")
	private Date notificationDate;

	public Notification(int id, int moduleId, int refId, String userId, String serviceNo, String notificationText,
			String notifiTarget, Date notificationDate) {
		super();
		this.id = id;
		this.moduleId = moduleId;
		this.refId = refId;
		this.userId = userId;
		this.serviceNo = serviceNo;
		this.notificationText = notificationText;
		this.notifiTarget = notifiTarget;
		this.notificationDate = notificationDate;
	}

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getNotificationText() {
		return notificationText;
	}

	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}

	public String getNotifiTarget() {
		return notifiTarget;
	}

	public void setNotifiTarget(String notifiTarget) {
		this.notifiTarget = notifiTarget;
	}

	public Date getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", moduleId=" + moduleId + ", refId=" + refId + ", userId=" + userId
				+ ", serviceNo=" + serviceNo + ", notificationText=" + notificationText + ", notifiTarget="
				+ notifiTarget + ", notificationDate=" + notificationDate + "]";
	}
	
	
}
