package com.ucsc.mit.service;

import java.util.List;

import com.ucsc.mit.model.Unit;

public interface UnitService {
	public List<Unit> listUnits();
	public void save(Unit u);
	public void updateUnit(Unit u);
	public Unit getUnitByCode(String code);
}
