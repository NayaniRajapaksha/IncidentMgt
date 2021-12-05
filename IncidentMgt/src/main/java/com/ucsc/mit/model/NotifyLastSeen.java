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
@Table(name="notify_user_last_seen")
@ManagedBean(name="notify")
@Proxy(lazy=false)
public class NotifyLastSeen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOTIFI_NO")
	private String notifyNo;
	
	@Column(name="NOTIFI_USER_ID")
	private String notifyUserId;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="LAST_SEEN_TIME")
	private Date lastSeenDate;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;

	public NotifyLastSeen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotifyLastSeen(int id, String notifyNo, String notifyUserId, String createdBy, Date lastSeenDate,
			Date createdDate) {
		super();
		this.id = id;
		this.notifyNo = notifyNo;
		this.notifyUserId = notifyUserId;
		this.createdBy = createdBy;
		this.lastSeenDate = lastSeenDate;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNotifyNo() {
		return notifyNo;
	}

	public void setNotifyNo(String notifyNo) {
		this.notifyNo = notifyNo;
	}

	public String getNotifyUserId() {
		return notifyUserId;
	}

	public void setNotifyUserId(String notifyUserId) {
		this.notifyUserId = notifyUserId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastSeenDate() {
		return lastSeenDate;
	}

	public void setLastSeenDate(Date lastSeenDate) {
		this.lastSeenDate = lastSeenDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "NotifyLastSeen [id=" + id + ", notifyNo=" + notifyNo + ", notifyUserId=" + notifyUserId + ", createdBy="
				+ createdBy + ", lastSeenDate=" + lastSeenDate + ", createdDate=" + createdDate + "]";
	}
	
	

}
