package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IrtImpactLevel;
import com.ucsc.mit.model.IrtImpactUrgency;

public interface IrtImpactLevelDAO {
	public List<IrtImpactLevel> listAllIrtImpactLevels();
	
	public IrtImpactLevel getImpactLevelData(int id);
	
	public List<IrtImpactLevel> getDataByImpactCode(String code) ;
}
