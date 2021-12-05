package com.ucsc.mit.model;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="incident_faq")
@ManagedBean(name="faq")
@Proxy(lazy=false)
public class Faq implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="QUESTION_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="TYPE_CODE")
	private String typeCode;
	
	@Column(name="SUBTYPE_CODE")
	private String subTypeName;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
//	@Column(name="CREATED_DATE")
//	private Date createdDate;
	
	@Column(name="UNIT_CODE")
	private String unitCode;
	
	@Column(name="QUESTION")
	private String question;
	
	@Column(name="ANSWER")
	private String answer;
	
//	@Column(name="ATTACH_ID")
//	private int attach_id;

	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faq(int id, String typeCode, String subTypeName, String createdBy, String unitCode,
			String question, String answer) {
		super();
		this.id = id;
		this.typeCode = typeCode;
		this.subTypeName = subTypeName;
		this.createdBy = createdBy;
		this.unitCode = unitCode;
		this.question = question;
		this.answer = answer;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
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



	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
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



	@Override
	public String toString() {
		return "Faq [id=" + id + ", typeCode=" + typeCode + ", subTypeName=" + subTypeName + ", createdBy=" + createdBy
				+ ",  unitCode=" + unitCode + ", question=" + question + ", answer="
				+ answer +  "]";
	}
	
	

}
