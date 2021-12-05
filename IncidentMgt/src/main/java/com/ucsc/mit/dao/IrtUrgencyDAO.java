package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IrtUrgency;

public interface IrtUrgencyDAO {
	public List<IrtUrgency> listAllUrgendyCodes();
	
	public IrtUrgency getUrgencyData(int id);
	public List<IrtUrgency> getDataByUrgencyCode(String code) ;
}
