package com.ucsc.mit.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="similar_solution_v")
@ManagedBean(name="similar_solution")
@Proxy(lazy=false)
public class SimilarSolutionView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="QUESTION_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="TYPE_CODE")
	private String typeCode;
	
	@Column(name="inc_type")
	private String inc_type;
	
	
	@Column(name="SUBTYPE_CODE")
	private String subTypeName;
	
	@Column(name="inc_sub_type")
	private String inc_sub_type;
	
	@Column(name="UNIT_CODE")
	private String unitCode;
	
	@Column(name="unit_name")
	private String unit_name;
	
	@Column(name="QUESTION")
	private String question;
	
	@Column(name="ANSWER")
	private String answer;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="created_by_name")
	private String created_by_name;

	public SimilarSolutionView() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public SimilarSolutionView(int id, String typeCode, String inc_type, String subTypeName, String inc_sub_type,
			String unitCode, String unit_name, String question, String answer, String createdBy,
			String created_by_name) {
		super();
		this.id = id;
		this.typeCode = typeCode;
		this.inc_type = inc_type;
		this.subTypeName = subTypeName;
		this.inc_sub_type = inc_sub_type;
		this.unitCode = unitCode;
		this.unit_name = unit_name;
		this.question = question;
		this.answer = answer;
		this.createdBy = createdBy;
		this.created_by_name = created_by_name;
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

	public String getInc_type() {
		return inc_type;
	}

	public void setInc_type(String inc_type) {
		this.inc_type = inc_type;
	}

	public String getSubTypeName() {
		return subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

	public String getInc_sub_type() {
		return inc_sub_type;
	}

	public void setInc_sub_type(String inc_sub_type) {
		this.inc_sub_type = inc_sub_type;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
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

	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getCreated_by_name() {
		return created_by_name;
	}



	public void setCreated_by_name(String created_by_name) {
		this.created_by_name = created_by_name;
	}



	@Override
	public String toString() {
		return "SimilarSolutionView [id=" + id + ", typeCode=" + typeCode + ", inc_type=" + inc_type + ", subTypeName="
				+ subTypeName + ", inc_sub_type=" + inc_sub_type + ", unitCode=" + unitCode + ", unit_name=" + unit_name
				+ ", question=" + question + ", answer=" + answer + ", createdBy=" + createdBy + ", created_by_name="
				+ created_by_name + "]";
	}




	

}
