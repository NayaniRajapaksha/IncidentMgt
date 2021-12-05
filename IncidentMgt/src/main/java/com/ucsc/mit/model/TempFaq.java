package com.ucsc.mit.model;

import java.io.Serializable;

public class TempFaq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String incTypeName;
    String incSubTypeName;
    int incTypeID;
    int incSubTypeID;
    int unitID;
    String question;
    String answer;
    String unitName;
    
    
    
	public TempFaq(int id, String incTypeName, String incSubTypeName, int incTypeID, int incSubTypeID, int unitID,
			String question, String answer, String unitName) {
		super();
		this.id = id;
		this.incTypeName = incTypeName;
		this.incSubTypeName = incSubTypeName;
		this.incTypeID = incTypeID;
		this.incSubTypeID = incSubTypeID;
		this.unitID = unitID;
		this.question = question;
		this.answer = answer;
		this.unitName = unitName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIncTypeName() {
		return incTypeName;
	}
	public void setIncTypeName(String incTypeName) {
		this.incTypeName = incTypeName;
	}
	public String getIncSubTypeName() {
		return incSubTypeName;
	}
	public void setIncSubTypeName(String incSubTypeName) {
		this.incSubTypeName = incSubTypeName;
	}
	public int getIncTypeID() {
		return incTypeID;
	}
	public void setIncTypeID(int incTypeID) {
		this.incTypeID = incTypeID;
	}
	public int getIncSubTypeID() {
		return incSubTypeID;
	}
	public void setIncSubTypeID(int incSubTypeID) {
		this.incSubTypeID = incSubTypeID;
	}
	public int getUnitID() {
		return unitID;
	}
	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
    
    
}
