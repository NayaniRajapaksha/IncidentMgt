package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.TeamMemPreformaceView;

public interface TeamMemPreformaceViewDAO {
	public List<TeamMemPreformaceView>  getTeamPerformanceReport(String assignMember,String unitId,String fromDate,String toDate);

}
