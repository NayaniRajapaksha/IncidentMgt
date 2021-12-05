package com.ucsc.mit.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.UnitDAO;
import com.ucsc.mit.model.Unit;


@Service
@ManagedBean(name="unitService")
@SessionScoped
public class UnitServiceImpl {
	
	private UnitDAO unitDAO;

	private String isNew="I";
	private String loggedUser;
	private String loggedUserLevel;
	private int loggedUserBranchId;
	private String loggedUserUnitName;
	private String loggedUserUnitId;
	

	



	public void setUnitDAO(UnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}


 
	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
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
	


	public List<Unit> listUnits() {
		// TODO Auto-generated method stub
		try{
			return this.unitDAO.listUnits();
	   	}catch(Exception ex){
	   		return null;
	   		
	   	}
				
	}

	@Transactional
	public void save(Unit u) {
		// TODO Auto-generated method stub
		System.out.println(isNew+" - status");
    	String message = null;
    	Unit unit=new Unit();
    	try{
    		
        
    		u.setCreatedBy(getLoggedUser());
        	if(isNew.equals("N")){
        		
        		unit.setCreatedBy(u.getCreatedBy());
        		unit.setUnitCode(u.getUnitCode());
        		unit.setUnitHead(u.getUnitHead());
        		unit.setUnitName(u.getUnitName());
        		unit.setUnitReportTo(u.getUnitReportTo());
        		unit.setUnitStatus(u.getUnitStatus());
        		
        		
        		this.unitDAO.save(u);
        		
        	}else if(isNew.equals("E")){
        		
        		unit.setId(u.getId());
        		unit.setCreatedBy(u.getCreatedBy());
        		unit.setUnitCode(u.getUnitCode());
        		unit.setUnitHead(u.getUnitHead());
        		unit.setUnitName(u.getUnitName());
        		unit.setUnitReportTo(u.getUnitReportTo());
        		unit.setUnitStatus(u.getUnitStatus());
        		
        		this.unitDAO.updateUnit(u);
        	}
        	message = "Unit Information is stored Successfully.";
        	
    	}catch(Exception ex){
    		message = "Unit Information is NOT stored Successfully.";
    		
    	}
    	setIsNew("I");
    
    	FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
    	
	

	}

	@Transactional
	public void updateUnit(Unit u) {
		// TODO Auto-generated method stub
		this.unitDAO.updateUnit(u);
	}


	public Unit getUnitByCode(int code) {
		
		setIsNew("E");
		try{
			return this.unitDAO.getUnitByCode(code);
	   	}catch(Exception ex){
	   		return null;
	   		
	   	}	
	}
	
	public void createNew(){
		setIsNew("N");
	
	}
	
	
	public void cancel(){
		setIsNew("I");
	
	}
}
