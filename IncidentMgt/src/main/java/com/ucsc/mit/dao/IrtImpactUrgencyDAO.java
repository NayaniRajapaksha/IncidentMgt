package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IrtImpactUrgency;

public interface IrtImpactUrgencyDAO {
	public List<IrtImpactUrgency> getImpactUrgencyCode(String impactLevel,String urgency);
	
	public List<IrtImpactUrgency> getDataByImpactUrgencyCode(String impUrgCode);
	
	public IrtImpactUrgency getIrtImpactUrgencyData(int id);
}
