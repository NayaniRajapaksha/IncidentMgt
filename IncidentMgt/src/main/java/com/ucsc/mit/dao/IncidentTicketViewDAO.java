package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IncidentTicketView;

public interface IncidentTicketViewDAO {
	public IncidentTicketView  getIncidentTicketByIncidentNo(int id);
	
	public List<IncidentTicketView>  getIncidentList(String dateFrom,String dateTo);
}
