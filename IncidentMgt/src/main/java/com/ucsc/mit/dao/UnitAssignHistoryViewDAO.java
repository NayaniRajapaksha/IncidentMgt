package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.UnitAssignHistoryView;

public interface UnitAssignHistoryViewDAO {
	public List<UnitAssignHistoryView>  getUnitAssignHisByIncidentNo(int id);
}
