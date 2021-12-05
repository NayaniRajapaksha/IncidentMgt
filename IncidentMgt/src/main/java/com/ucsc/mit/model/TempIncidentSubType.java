package com.ucsc.mit.model;

import java.io.Serializable;

public class TempIncidentSubType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String subTypeCode;
    String subTypeName;
    String createdBy;
   
        
    boolean editable;

    public boolean isEditable() {
        return editable;
    }
    
    
    
	public TempIncidentSubType(int id,String subTypeCode, String subTypeName, String createdBy) {
		super();
		this.id = id;
		this.subTypeCode = subTypeCode;
		this.subTypeName = subTypeName;
		this.createdBy = createdBy;
	}



	public String getSubTypeCode() {
		return subTypeCode;
	}


	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}


	public String getSubTypeName() {
		return subTypeName;
	}


	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public void setEditable(boolean editable) {
		this.editable = editable;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
    
    
}
