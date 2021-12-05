package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IncidentTxn;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.IrtIncidentDetailView;

public interface IncidentTxnDAO {
	public List<IncidentTxn> listAllIncidents();
	
	public void addIncident(IncidentTxn t);
	
	public IncidentTxn getIncidentById(int id);
	
	public void deleteIncident(int id);
	
	public void updateIncident(IncidentTxn t);
	
	public void updateIncidentStatus(int id,String status);
	
	public List<IrtIncidentDetailView> listAllIncidentsByRegion(int region_id);
}
