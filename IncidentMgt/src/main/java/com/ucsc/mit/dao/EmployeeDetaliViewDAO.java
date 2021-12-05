package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.EmployeeDetailView;

public interface EmployeeDetaliViewDAO {
	public List<EmployeeDetailView> getIrtEmployeeByRegionId(int region_id,String groupId);
	
	public EmployeeDetailView getUserLevel(int userId);
}
