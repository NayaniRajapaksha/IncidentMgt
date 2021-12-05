package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.Priority;

public interface PriorotyDAO {
	public List<Priority> getPriorityLevels();
	
	public Priority getPrriorityById(int id);
}
