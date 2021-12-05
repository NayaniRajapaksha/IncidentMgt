package com.ucsc.mit.dao;

import java.util.Date;
import java.util.List;

import com.ucsc.mit.model.NotifyLastSeen;

public interface NotifyLastSeenDAO {
	public void addSeenNotification(NotifyLastSeen n);
	public Date getLastSeenDateByUser(String userId);
}
