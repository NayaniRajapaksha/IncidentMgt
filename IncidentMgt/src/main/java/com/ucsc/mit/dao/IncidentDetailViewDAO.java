package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IncidentDetailView;

public interface IncidentDetailViewDAO {
	
	public List<IncidentDetailView>  getIncidentDetailByIncidentNo(int id);
	
	public List<IncidentDetailView>  getAllIncidentDetail();
	
	public List<IncidentDetailView>  getIncidentDetailByUnit(int id);
	
	public List<IncidentDetailView>  getIncidentDetailByAssignUser(String userId,int unitId);
	
	public List<IncidentDetailView>  getIncidentDetailByRegion(int regionId);
	
	public List<IncidentDetailView>  getIncidentDetailForReport(String assignMember,String impactLevel,String urgency,String status,String unitId,String incTypeId,String subTypeId,String locId,String fromDate,String toDate);

	public List<IncidentDetailView>  getCloseIncidentDetailForReport(String assignMember,String impactLevel,String urgency,String status,String unitId,String incTypeId,String subTypeId,String locId,String fromDate,String toDate);

	public List<IncidentDetailView>  getResolveIncidentDetailForReport(String assignMember,String impactLevel,String urgency,String status,String unitId,String incTypeId,String subTypeId,String locId,String fromDate,String toDate);

	public List<IncidentDetailView>  getReopenIncidentDetailForReport(String assignMember,String impactLevel,String urgency,String status,String unitId,String incTypeId,String subTypeId,String locId,String fromDate,String toDate);

}
