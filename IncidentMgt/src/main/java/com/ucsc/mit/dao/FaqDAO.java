package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.Faq;

public interface FaqDAO {
	public void addFaq(Faq v);
	
	public List<Faq> listFaqs();
	
	public void updateFaq(Faq v);
	
	public Faq getFaqByCode(int code);
	
	public void deleteFaq(int id);
	
	public List<Faq> getFaqByIncidentType(String typeId,String subTypeId);
}
