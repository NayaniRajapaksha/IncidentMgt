package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.Session;

import com.ucsc.mit.model.IncidentSubType;

public interface IncidentSubTypeDAO {
	
	public void addIncidentSubType(IncidentSubType t,Session session);
	
	public List<IncidentSubType> listIncidentSubTypes();
	
	public void updateIncidentSubType(IncidentSubType t,Session session);
	
	public IncidentSubType getIncidentTypeSubById(int id);
	
	public void deleteIncidentSubType(int id);
	
	public int getLastId();
	
	public List<IncidentSubType>  getIncidentTypeSubByType(String code);
	
	public List<IncidentSubType> listIncidentSubTypesByTypeId(int id);
}
