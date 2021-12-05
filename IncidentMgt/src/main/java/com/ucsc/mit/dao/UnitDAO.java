package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.Unit;



public interface UnitDAO {

public void save(Unit u);
	
	public List<Unit> listUnits();
	
	public void updateUnit(Unit u);
	
	public Unit getUnitByCode(int code);
	

	
	
}
