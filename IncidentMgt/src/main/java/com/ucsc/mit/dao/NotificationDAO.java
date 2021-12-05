package com.ucsc.mit.dao;

import java.util.Date;
import java.util.List;

import com.ucsc.mit.model.Notification;
import com.ucsc.mit.model.Unit;

public interface NotificationDAO {


	
	public List<Notification> listNortificationByIncidentTxn(int incidentNo);
	public void addNotification(Notification n);
	public void updateNotification(Notification n);
	public List<Notification> listNortificationByNotiftTarget(String dynamicWhere,String target,Date lastSeenDate);
}
