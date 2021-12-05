package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.UnitMember;

public interface UnitMemberDAO {
	public void addMember(UnitMember u);
	
	public List<UnitMember> listMembers();
	
	public void updateMember(UnitMember u);
	
	public List<UnitMember>  getMemberByMemberId(int id);
	
	public List<UnitMember> listMembersByUnit(int unitId);
	
	public void deleteUnitMember(int id);
	
}
