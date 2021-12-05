package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.TeamMemberView;

public interface TeamMemberViewDAO {
	public List<TeamMemberView> getTeamMemberByUnitCode(int code);
	
	public TeamMemberView getTeamMemberById(int id);
}
