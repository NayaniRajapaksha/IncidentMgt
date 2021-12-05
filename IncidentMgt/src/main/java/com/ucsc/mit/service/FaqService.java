package com.ucsc.mit.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Service;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.FaqDAO;
import com.ucsc.mit.dao.IncidentSubTypeDAO;
import com.ucsc.mit.dao.IncidentTypeDAO;
import com.ucsc.mit.dao.UnitDAO;
import com.ucsc.mit.model.Faq;
import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.TempFaq;
import com.ucsc.mit.model.TempIncidentSubType;
import com.ucsc.mit.model.Unit;
import com.ucsc.mit.model.Vendor;

@Service
@ManagedBean(name="faqService")
@SessionScoped
public class FaqService {

	private String loggedUserLevel;
	private int loggedUserBranchId;
	private String loggedUserUnitName;
	private String loggedUserUnitId;
	
	private FaqDAO faqDAO;
	private IncidentTypeDAO incidentTypeDAO;
	private IncidentSubTypeDAO incidentSubTypeDAO;
	private UnitDAO unitDAO;
	private String isNew="I";
	private String incidentType;
	private String incidentSubType;
	private static Map<Integer,Object> incidentTypeValue;
	private static Map<Integer,Object> incidentSubTypeValue= new LinkedHashMap<Integer,Object>();
	private static ArrayList<TempFaq> faqList=new ArrayList<TempFaq>();
	private String unitName;
	private static Map<Integer,Object> unitValue;
	private String isView="N";
	private String loggedUser;
	public FaqDAO getFaqDAO() {
		return faqDAO;
	}
	public void setFaqDAO(FaqDAO faqDAO) {
		this.faqDAO = faqDAO;
	}
		
	public IncidentTypeDAO getIncidentTypeDAO() {
		return incidentTypeDAO;
	}
	public void setIncidentTypeDAO(IncidentTypeDAO incidentTypeDAO) {
		this.incidentTypeDAO = incidentTypeDAO;
	}
		
	public IncidentSubTypeDAO getIncidentSubTypeDAO() {
		return incidentSubTypeDAO;
	}
	public void setIncidentSubTypeDAO(IncidentSubTypeDAO incidentSubTypeDAO) {
		this.incidentSubTypeDAO = incidentSubTypeDAO;
	}
	
	public UnitDAO getUnitDAO() {
		return unitDAO;
	}
	public void setUnitDAO(UnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public String getIncidentType() {
		return incidentType;
	}
	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}
	public String getIncidentSubType() {
		return incidentSubType;
	}
	public void setIncidentSubType(String incidentSubType) {
		this.incidentSubType = incidentSubType;
	}
	
	 public static Map<Integer, Object> getIncidentSubTypeValue() {
		return incidentSubTypeValue;
	}
	public static void setIncidentSubTypeValue(Map<Integer, Object> incidentSubTypeValue) {
		FaqService.incidentSubTypeValue = incidentSubTypeValue;
	}
	
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	
	public String getIsView() {
		return isView;
	}
	public void setIsView(String isView) {
		this.isView = isView;
	}
	
	public void setLoggedUser(String loggedUser) {
		this.loggedUser = loggedUser;
	}
	public String getLoggedUser(){
		
		HttpSession session = SessionUtils.getSession();
		if(session != null){
			loggedUser=(String) session.getAttribute("username"); 
		}
		return loggedUser;
		
	}
	
	public String getLoggedUserLevel() {
		HttpSession session = SessionUtils.getSession();
		if(session != null){
			loggedUserLevel=(String) session.getAttribute("userlevel"); 
		}
		
		return loggedUserLevel;
	}



	public void setLoggedUserLevel(String loggedUserLevel) {
		this.loggedUserLevel = loggedUserLevel;
	}

	public int getLoggedUserBranchId() {
		HttpSession session = SessionUtils.getSession();
		if(session != null){
			loggedUserBranchId=(Integer) session.getAttribute("branchId"); 
		}
		
		return loggedUserBranchId;
	}


	public void setLoggedUserBranchId(int loggedUserBranchId) {
		this.loggedUserBranchId = loggedUserBranchId;
	}


	public String getLoggedUserUnitName() {
		HttpSession session = SessionUtils.getSession();
		if(session != null){
			loggedUserUnitName=(String) session.getAttribute("uname"); 
		}
		
	
		return loggedUserUnitName;
	}


	public void setLoggedUserUnitName(String loggedUserUnitName) {
		this.loggedUserUnitName = loggedUserUnitName;
	}


	public String getLoggedUserUnitId() {
		HttpSession session = SessionUtils.getSession();
		if(session != null){
			loggedUserUnitId=(String) session.getAttribute("unitId"); 
		}
		
	
		return loggedUserUnitId;
	}


	public void setLoggedUserUnitId(String loggedUserUnitId) {
		this.loggedUserUnitId = loggedUserUnitId;
	}
	public Map<Integer,Object> getIncidentTypeValue() {
		 incidentTypeValue = new LinkedHashMap<Integer,Object>();
		 List<IncidentType> a= incidentTypeDAO.listIncidentTypes();
		 for(IncidentType x:a){
			 incidentTypeValue.put(x.getId(), x.getTypeName());
		 }
		 
	     return incidentTypeValue;
	}
	
	public Map<Integer,Object> getUnitValues() {
		unitValue = new LinkedHashMap<Integer,Object>();
		 List<Unit> a= unitDAO.listUnits();
		 for(Unit x:a){
			 unitValue.put(x.getId(), x.getUnitName());
		 }
		 
	     return unitValue;
	}
	public void valueChangeIncidentType(){
		
		incidentSubTypeValue.clear();	
		if(incidentType !=null){
			int incidentId = Integer.parseInt(incidentType);
			incidentSubTypeValue=getIncidentSubTypeValue(incidentId);
			
		}
		
	} 
	 public Map<Integer,Object> getIncidentSubTypeValue(int incidentId) {
		 Map<Integer,Object> incidentSubTypeTmpValue = new LinkedHashMap<Integer,Object>();
		 List<IncidentSubType> a= incidentSubTypeDAO.listIncidentSubTypesByTypeId(incidentId);
		 for(IncidentSubType x:a){
			 incidentSubTypeTmpValue.put(x.getId(), x.getSubTypeName());
		 }
		 
	     return incidentSubTypeTmpValue;
	}
	 
	 public void addFaq(Faq a) {
	 		if(incidentType !=null && incidentSubType!=null){
	 		String message = null;
	 		Faq faq=new Faq();
	 		
	 		
	 		
	    	try{
	    		
	    		
	    		faq.setCreatedBy(getLoggedUser());
	        	if(isNew.equals("N")){
	        		faq.setTypeCode(getIncidentType());
	        		faq.setSubTypeName(getIncidentSubType());
	        		faq.setQuestion(a.getQuestion());
	        		faq.setAnswer(a.getAnswer());
	        		faq.setUnitCode(getUnitName());
	        		faqDAO.addFaq(faq);
	        	}else if(isNew.equals("E")){
	        		faq.setId(a.getId());
	        		faq.setTypeCode(getIncidentType());
	        		faq.setSubTypeName(getIncidentSubType());
	        		faq.setQuestion(a.getQuestion());
	        		faq.setAnswer(a.getAnswer());
	        		faq.setUnitCode(getUnitName());
	        		faqDAO.updateFaq(faq);
	        		
	        	}
	        	message = "FAQ Information is stored Successfully.";
	        	
	    	}catch(Exception ex){
	    		message = "FAQ  Information is NOT stored Successfully.";
	    		
	    	}
	    	setIsNew("I");
	    	setIsView("N");
	    	 FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
	 		}
	    
	 	}
	 
	 public void createNew(){
	    	setIsNew("N");
	    	setIsView("N");
	    	incidentType =null;
	    	incidentSubType =null;
	    	unitName =null;
	    }
	    
	    public void cancel(){
	    	setIsNew("I");
	    	setIsView("N");
	    	incidentType =null;
	    	incidentSubType =null;
	    	unitName =null;
	    	
	    }
	    
	    public List<TempFaq> listFaqs() {
	    	try{
	    		List<Faq> fList=faqDAO.listFaqs();
	    		faqList.clear();
	    		for(Faq x:fList){
	    			
	    			int incTypeId=Integer.parseInt(x.getTypeCode());
	    			int incSubTypeId=Integer.parseInt(x.getSubTypeName());
	    			IncidentType in=incidentTypeDAO.getIncidentTypeById(incTypeId);
	    			String inTypeName = in.getTypeName();
	    			IncidentSubType sb=incidentSubTypeDAO.getIncidentTypeSubById(incSubTypeId);
	    			String incSubTypeName=sb.getSubTypeName();
	    			int unitId=Integer.parseInt(x.getUnitCode());
	    			faqList.add(new TempFaq(x.getId(), inTypeName, incSubTypeName, incTypeId, incSubTypeId,  unitId, x.getQuestion(), x.getAnswer(), x.getUnitCode()));
					
	    		}
	    		 return faqList;
	    	}catch(Exception ex){
	    		return faqList;
	    		
	    	}
	    	
	    }
	    
	    public String deleteFaqById(int id) {
			
			//setIsNew("I");
				try{
					
					faqDAO.deleteFaq(id);
					
	
					return "";
			   	}catch(Exception ex){
			   		String message = "FAQ  Information is NOT deteted Successfully.";
			   	 FacesContext.getCurrentInstance().addMessage(
 						null,
 						new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
			   		return "";
			   		
			   	}
			
		}
	    
	    public String getFaqById(int id) {
			
			setIsNew("E");
			setIsView("N");
				try{
					
					Faq c=faqDAO.getFaqByCode(id);
					incidentType =c.getTypeCode();
					incidentSubTypeValue.clear();	
					if(incidentType !=null){
						int incidentId = Integer.parseInt(incidentType);
						incidentSubTypeValue=getIncidentSubTypeValue(incidentId);
						
					}
			    	incidentSubType =c.getSubTypeName();
			    	unitName =c.getUnitCode();
					return "";
			   	}catch(Exception ex){
			   	
			   		return "";
			   		
			   	}
			
		}
	    public String viewFaqById(int id) {
				setIsView("Y");
				setIsNew("E");
					try{
						
						Faq c=faqDAO.getFaqByCode(id);
						incidentType =c.getTypeCode();
						incidentSubTypeValue.clear();	
						if(incidentType !=null){
							int incidentId = Integer.parseInt(incidentType);
							incidentSubTypeValue=getIncidentSubTypeValue(incidentId);
							
						}
				    	incidentSubType =c.getSubTypeName();
				    	unitName =c.getUnitCode();
						return "";
				   	}catch(Exception ex){
				   	
				   		return "";
				   		
				   	}
				
			}
}
