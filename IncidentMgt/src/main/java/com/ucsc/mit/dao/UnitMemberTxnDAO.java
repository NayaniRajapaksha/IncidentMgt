package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.UnitMemberTxn;

public interface UnitMemberTxnDAO {
	public void addToUnitMemberTxn(UnitMemberTxn t);
	public UnitMemberTxn getUnitMemberTxnById(int id);
	public List<UnitMemberTxn> getUnitMemberTxnByIncidentNo(int incidentNo);
	public void updateUnitMemberTxn(UnitMemberTxn t);
}
