package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.IrtMember;

public interface IrtMemberDAO {
	public void addIrtMember(IrtMember u);
	public void deleteIrtMember(int id);
	public void updateIrtMember(IrtMember u);
	public List<IrtMember> listMembersByRegion(int regionId);
	public List<IrtMember> getMemberByMemberID(int member_id);
}
