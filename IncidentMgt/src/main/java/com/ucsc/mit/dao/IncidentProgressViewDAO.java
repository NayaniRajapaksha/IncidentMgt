package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IncidentProgressView;

public interface IncidentProgressViewDAO {
	
	public List<IncidentProgressView>  getIncidentProgressByIncidentNo(int id);
	
	public List<IncidentProgressView>  getIncidentProgressByIncidentNoForEmp(int id);

}
