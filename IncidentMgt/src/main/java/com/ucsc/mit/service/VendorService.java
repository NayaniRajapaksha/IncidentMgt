package com.ucsc.mit.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.VendorDAO;
import com.ucsc.mit.model.Vendor;

@Service
@ManagedBean(name="vendorService")
@SessionScoped
public class VendorService {
	private VendorDAO vendorDAO;
	private String isNew="I"; 
	private String loggedUser;
	private String loggedUserLevel;
	private int loggedUserBranchId;
	private String loggedUserUnitName;
	private String loggedUserUnitId;
    public void setVendorDAO(VendorDAO vendorDAO) {
        this.vendorDAO = vendorDAO;
    }
    
    public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
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
	// Validate Email
    public void validateEmail(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
        String emailStr = (String) value;
        if (-1 == emailStr.indexOf("@")) {
            FacesMessage message = new FacesMessage("Email Address is Valid");
            throw new ValidatorException(message);
        }
    }
 
    public void createNew(){
    	setIsNew("N");
    	System.out.println("test");
    }
    
    public void cancel(){
    	setIsNew("I");
    	System.out.println("test"+getIsNew());
    }
    
   
    @SuppressWarnings("null")
	public String addVendor(Vendor v) {
    	System.out.println(getIsNew()+" - status");
    	String message = null;
    	Vendor vendor=new Vendor();
    	try{
    		
        	String outcome=null;
    		v.setCreated_by(getLoggedUser());
        	if(isNew.equals("N")){
        		
        		
        		vendor.setVen_name(v.getVen_name());
        		vendor.setStatus(v.getStatus());
        		vendor.setFax_no(v.getFax_no());
        		vendor.setEmail(v.getEmail());
        		vendor.setCreated_by(v.getCreated_by());
        		vendor.setContact_person(v.getContact_person());
        		vendor.setContact_no2(v.getContact_no2());
        		vendor.setContact_no(v.getContact_no());
        		vendor.setAddress(v.getAddress());
        		
        		outcome = vendorDAO.addVendor(vendor);
        		
        	}else if(isNew.equals("E")){
        		
        		vendor.setVen_code(v.getVen_code());
        		vendor.setVen_name(v.getVen_name());
        		vendor.setStatus(v.getStatus());
        		vendor.setFax_no(v.getFax_no());
        		vendor.setEmail(v.getEmail());
        		vendor.setCreated_by(v.getCreated_by());
        		vendor.setContact_person(v.getContact_person());
        		vendor.setContact_no2(v.getContact_no2());
        		vendor.setContact_no(v.getContact_no());
        		vendor.setAddress(v.getAddress());
        		
        		outcome = vendorDAO.updateVendor(vendor);
        	}
        	message = "Vendor Information is stored Successfully.";
        	
    	}catch(Exception ex){
    		message = "Vendor Information is NOT stored Successfully.";
    		
    	}
    	setIsNew("I");
    
    	 FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
    	
    	return "";
    }
 
  
   
    public List<Vendor> listVendors() {
    	try{
    		 return this.vendorDAO.listVendors();
    	}catch(Exception ex){
    		return null;
    		
    	}
       
    }
    
  
	public Vendor getVendorByCode(int code) {
		
		setIsNew("E");
			try{
				return this.vendorDAO.getVendorByCode(code);
		   	}catch(Exception ex){
		   		return null;
		   		
		   	}
		
	}
}
