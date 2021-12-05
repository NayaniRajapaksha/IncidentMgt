package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.Report;

public interface ReportsDAO {
public List<Report> getReportList();
	
	public Report getReportById(int id);
}
