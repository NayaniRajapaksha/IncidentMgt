package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IncidentType;

public interface IncidentTypeDAO {
	
	public void addIncidentType(IncidentType t);
	
	public List<IncidentType> listIncidentTypes();
	
	public void updateIncidentType(IncidentType t);
	
	public IncidentType getIncidentTypeById(int id);
	
	public void deleteIncidentType(int id);

	public int getLastId();
}
