package com.ucsc.mit.dao;

import java.util.Date;
import java.util.List;

import com.ucsc.mit.model.Dependency;
import com.ucsc.mit.model.DependencyCloseReason;
import com.ucsc.mit.model.DependencyDetailView;
import com.ucsc.mit.model.DependencyStatus;

public interface DependencyDAO {
	
	public void addDependency(Dependency t);
	
	public Dependency getDependencyById(int id);
	
	public List<Dependency> listDependencyForUnit(int id);
	
	public List<DependencyDetailView> listDependencyFromViewForUnit(int id);
	
	public void updateAssignMember(int dep_id,String emp_id,String dep_status);
	
	public List<DependencyStatus> listDependencyStatus();
	
	public List<DependencyCloseReason> listDependencyCloseReason();
	
	public void updateDependencyAction(int dep_id,Date statusTime,String dep_status,String action);
	
	public void closeDependency(int dep_id,Date statusTime,String reason);

}
