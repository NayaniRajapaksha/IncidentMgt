package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IncidentStatus;

public interface IncidentStatusDAO {
	
	public List<IncidentStatus> getIncidentStatusForIrt();
	
	public List<IncidentStatus> getIncidentStatusForIrtSecondSet();
	
	public List<IncidentStatus> getIncidentStatusForDependency();
	
	public List<IncidentStatus> getIncidentStatusForGRP();
	public List<IncidentStatus> getIncidentStatusForIncidentAction();
	
	public IncidentStatus getIncidentStatusById(int id);
	
	public List<IncidentStatus> getAllIncidentStatus();
}
