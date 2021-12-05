package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IrtIncidentTxn;

public interface IrtIncidentTxnDAO {

	public void assignIncidentToUnit(IrtIncidentTxn t);
	public void updateAssignIncidentToUnit(IrtIncidentTxn t) ;
	public int getRecordCount(int id);
	
	public IrtIncidentTxn getIRTIncidentById(int id);
	
	public List<IrtIncidentTxn> getIRTIncidentByIncidentNo(int incidentNo);
}
