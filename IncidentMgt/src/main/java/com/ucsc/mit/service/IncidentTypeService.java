package com.ucsc.mit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.IncidentSubTypeDAO;
import com.ucsc.mit.dao.IncidentTypeDAO;
import com.ucsc.mit.dao.VendorDAO;
import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.TempIncidentSubType;
import com.ucsc.mit.model.Vendor;

@Service
@ManagedBean(name="incidentTypeService")
@SessionScoped
public class IncidentTypeService {

	private String typeName;
	private String subTypeName;
	private String isNew="I";
	
	private IncidentTypeDAO incidentTypeDAO;
	private IncidentSubTypeDAO incidentSubTypeDAO;

	private static ArrayList<TempIncidentSubType> incidentSubList=new ArrayList<TempIncidentSubType>();
	
	private String loggedUser;
	private String loggedUserLevel;
	private int loggedUserBranchId;
	private String loggedUserUnitName;
	private String loggedUserUnitId;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getSubTypeName() {
		return subTypeName;
	}
	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	
	public void setIncidentTypeDAO(IncidentTypeDAO incidentTypeDAO) {
		this.incidentTypeDAO = incidentTypeDAO;
	}
	
	public void setIncidentSubTypeDAO(IncidentSubTypeDAO incidentSubTypeDAO) {
		this.incidentSubTypeDAO = incidentSubTypeDAO;
	}
	 
	
	public static ArrayList<TempIncidentSubType> getIncidentSubList() {
		return incidentSubList;
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
	public String  addSubTypesToIncident() {
		
		
		if(typeName !=null && subTypeName !=null){
		  if(!("".equals(subTypeName))){
				String subTypeCode =null;
				
				int sublastId=0;
				try {
					subTypeCode =subTypeName.substring(0,3).toUpperCase();
					sublastId=incidentSubTypeDAO.getLastId();
				} catch (Exception e) {
					subTypeCode =subTypeName.substring(0,1).toUpperCase();
					sublastId=0;
				}
				
	    		
	    		subTypeCode =sublastId+"0"+subTypeCode;
	    		incidentSubList.add(new TempIncidentSubType(0,subTypeCode, getSubTypeName(), getLoggedUser()));

		
		  }else{
			  FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "","Empty value isn't accepted"));
		  }
		}else{
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "","Empty value isn't accepted"));
		}

		subTypeName=null;
		return "";
	}
	

	 public void createNew(){
	    	setIsNew("N");
	    	subTypeName=null;
	    	typeName=null;
	    	if(incidentSubList.size()!=0){
	    		incidentSubList.clear();
	    	}
	    	System.out.println("test");
	    }
	    
	    public void cancel(){
	    	setIsNew("I");
	    	subTypeName=null;
	    	typeName=null;
	    	if(incidentSubList.size()!=0){
	    		incidentSubList.clear();
	    	}
	    	System.out.println("test");
	    }
	
	
	

	
	 	public List<IncidentSubType> listIncidentSubTypes() {
	    	try{
	    		 String type=getTypeName();
	    		 return this.incidentSubTypeDAO.getIncidentTypeSubByType(type);
	    	}catch(Exception ex){
	    		return null;
	    		
	    	}
	       
	    }
	 	
	 	 public List<IncidentType> listIncidentTypes() {
	     	try{
	     		 return this.incidentTypeDAO.listIncidentTypes();
	     	}catch(Exception ex){
	     		return null;
	     		
	     	}
	        
	     }
	 	 
	 	public void addIncidentTypes(IncidentType inct) {
	 		if(typeName !=null && subTypeName !=null){
	 		String message = null;
	 		IncidentType incidentType=new IncidentType();
	 		String typeCode =  typeName.substring(0,3).toUpperCase();
	 		Set<IncidentSubType> itemsSet = new HashSet<IncidentSubType>();
	 		
	 		
	 		
	    	try{
	    		
	    		incidentType.setCreatedBy(getLoggedUser());
	    		
	        	if(isNew.equals("N")){
	        		
	        	
	        		incidentType.setTypeCode(typeCode);
	        		incidentType.setTypeName(getTypeName());
	        		itemsSet=addIncidentSubTypes(incidentType);
	        		incidentType.setSubTypes(itemsSet);
	        		incidentTypeDAO.addIncidentType(incidentType);
	        	}else if(isNew.equals("E")){
	        		incidentType.setId(inct.getId());
	        		incidentType.setTypeCode(typeCode);
	        		incidentType.setTypeName(getTypeName());
	        		itemsSet=addIncidentSubTypes(incidentType);
	        		incidentType.setSubTypes(itemsSet);
	        		incidentTypeDAO.updateIncidentType(incidentType);
	        		
	        		
	        	}
	        	message = "Incident type Information is stored Successfully.";
	        	
	    	}catch(Exception ex){
	    		message = "Incident type  Information is NOT stored Successfully.";
	    		
	    	}
	    	setIsNew("I");
	    
	    	 FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
	 		}
	    
	 	}
	 	
	 	public Set<IncidentSubType> addIncidentSubTypes(IncidentType v){
	 		Set<IncidentSubType> itemsSet = new HashSet<IncidentSubType>();
	 		IncidentSubType incidentSub = new IncidentSubType();
	 		if(incidentSubList.size()!=0){
	 			
    			for(TempIncidentSubType a:incidentSubList){
    				incidentSub = new IncidentSubType(a.getId(),a.getSubTypeCode(), a.getSubTypeName(), a.getCreatedBy(),v);
    				itemsSet.add(incidentSub);
    			}
    		}
	 		
	 		
			return itemsSet;
	 		
	 		
	 	}
	 	
	 	public String getIncidentTypeById(int id) {
			
	 		setIsNew("E");
				try{
					incidentSubList.clear();
					IncidentType inctype=incidentTypeDAO.getIncidentTypeById(id);
					setTypeName(inctype.getTypeName());
					Set<IncidentSubType> st=inctype.getSubTypes();
					for(IncidentSubType a:st){
				
						incidentSubList.add(new TempIncidentSubType(a.getId(),a.getSubTypeCode(), a.getSubTypeName(), a.getCreatedBy()));
	    			}
			
					
					
					return "";
			   	}catch(Exception ex){
			   		return "";
			   		
			   	}
			
			
		}
	 	
	 	public String deleteIncidentTypeById(int id) {
			
			//setIsNew("I");
				try{
					
					incidentTypeDAO.deleteIncidentType(id);
					
	
					return "";
			   	}catch(Exception ex){
			   		String message = "Incident type  Information is NOT deteted Successfully.";
			   		FacesContext.getCurrentInstance().addMessage(
 						null,
 						new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
			   		return "";
			   		
			   	}
			
		}
	 	
	 	public String deleteIncidentTypeSubType(TempIncidentSubType tempSubType) {
			
			
				try{
					
					if(incidentSubList.size()!=0){
						if(tempSubType.getId() ==0){
							incidentSubList.remove(tempSubType);
						}else{
							incidentSubTypeDAO.deleteIncidentSubType(tempSubType.getId());
							setIsNew("I");
						}
						
		    		}
					
	
					return "";
			   	}catch(Exception ex){
			   		
			   		return "";
			   		
			   	}
			
		}
	
}
