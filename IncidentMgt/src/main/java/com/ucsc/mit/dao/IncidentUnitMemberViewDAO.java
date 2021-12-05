package com.ucsc.mit.dao;

import com.ucsc.mit.model.IncidentUnitMemberView;

public interface IncidentUnitMemberViewDAO {
 
	public IncidentUnitMemberView findTimeByIncidentNo(int incident_no);
}
