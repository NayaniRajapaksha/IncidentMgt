package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.Branch;

public interface BranchDAO {
	
	public List<Branch> getAllRegionsAndDepartments();
	public List<Branch> getAllLocations();
	public int getRegionIdByBranchCode(int branch_code);
}
