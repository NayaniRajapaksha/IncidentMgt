package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.SimilarSolutionView;

public interface SimilarSolutionDAO {
	
	public List<SimilarSolutionView> getSmByIncidentType(String typeId,String subTypeId);

}
