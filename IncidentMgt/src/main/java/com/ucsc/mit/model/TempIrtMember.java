package com.ucsc.mit.model;

public class TempIrtMember {
	private int id;
	

	private int memberId;
	

	private int regionId;
	

	private String memberName;


	public TempIrtMember(int id, int memberId, int regionId, String memberName) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.regionId = regionId;
		this.memberName = memberName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public int getRegionId() {
		return regionId;
	}


	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	@Override
	public String toString() {
		return "TempIrtMember [id=" + id + ", memberId=" + memberId + ", regionId=" + regionId + ", memberName="
				+ memberName + "]";
	}
	
	
}
