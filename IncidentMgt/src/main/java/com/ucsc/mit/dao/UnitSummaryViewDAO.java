package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.UnitIncidentSummaryView;

public interface UnitSummaryViewDAO {
	public List<UnitIncidentSummaryView>  getUnitSummaryReport(String unitId,String fromDate,String toDate);
}
