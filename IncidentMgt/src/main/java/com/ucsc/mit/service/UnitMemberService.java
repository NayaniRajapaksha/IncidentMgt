package com.ucsc.mit.service;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.EmployeeDAO;
import com.ucsc.mit.dao.UnitDAO;
import com.ucsc.mit.dao.UnitMemberDAO;
import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.TempFaq;
import com.ucsc.mit.model.TempIncidentSubType;
import com.ucsc.mit.model.Unit;
import com.ucsc.mit.model.UnitMember;

@Service
@ManagedBean(name="unitMemberService")
@SessionScoped
public class UnitMemberService {
	
	private String isNew="I";
	private EmployeeDAO employeeDAO;
	private UnitMemberDAO unitMemberDAO;
	private UnitDAO unitDAO;
	private String serviceNo;
	private String mName;
	private String unitName;
	private int memberId;
	String message = null;
//	private String loginUserId;
	private int loginUserUnitId;
	private String loggedUser;
	private String loggedUserLevel;
	private int loggedUserBranchId;
	private String loggedUserUnitName;
	private String loggedUserUnitId;
	public UnitMemberService() {
		super();
	
		loginUserUnitId =2;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public void setUnitMemberDAO(UnitMemberDAO unitMemberDAO) {
		this.unitMemberDAO = unitMemberDAO;
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
	
	
    
    public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	
	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
	public void createNew(){
    	setIsNew("N");
    	mName=null;
		serviceNo=null;
		unitName=null;
    
    }
	public void cancel(){
		mName=null;
		serviceNo=null;
		unitName=null;
    	setIsNew("I");
  
    }
	
	public void valueChangeServiceNo(){
    	if(serviceNo != null){
    		 if(!("".equals(serviceNo))){
    			 try{
    				 List<Employee> emp = employeeDAO.getEmployeeByEmpId(serviceNo);
    				 if(emp.size()!=0){
	    				 for(Employee x:emp){
	    					 setMemberId(x.getId());
	    	    			 setmName( x.getName());
	    				 }
    				 }else{
    					 mName=null;
    					 message ="No record found.";
    					 FacesContext.getCurrentInstance().addMessage(
    	    						null,
    	    						new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
    				 }
    			 }catch(Exception ex){
    				 mName=null;
    				 message = "No record found.";
    				 FacesContext.getCurrentInstance().addMessage(
     						null,
     						new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
    			 }
    		 }
    		
    	}
    
    }
	
	public void addUnitMembers() {
		if(unitName !=null && serviceNo != null){
   		 int unitId = Integer.parseInt(unitName);
			UnitMember uMember=new UnitMember();
 		
 		
 		
 		
    	try{
    		
    		Unit unit=unitDAO.getUnitByCode(unitId);
    		int uHead=Integer.parseInt(unit.getUnitHead());
    		
        	if(isNew.equals("N")){
        		uMember.setMemberId(getMemberId());
        		uMember.setUnitId(unitId);
        		uMember.setUnitHeadId(uHead);
        		uMember.setCreatedBy(getLoggedUser());
        		
        		unitMemberDAO.addMember(uMember);
        	}
        	message = "Unit member Information is stored Successfully.";
        	
    	}catch(Exception ex){
    		message = "Unit member  Information is NOT stored Successfully.";
    		
    	}
    	setIsNew("I");
    
    	 FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
 		}
    
 	}
	
	  public List<Employee> listUnitMembers() {
		  List<Employee> empList = new ArrayList<Employee>(); 
		  List<Employee> empx = employeeDAO.getEmployeeByEmpId(getLoggedUser());
			
				 for(Employee x:empx){
					 List<UnitMember> umList=unitMemberDAO.getMemberByMemberId(x.getId());
						for(UnitMember n:umList){
							loginUserUnitId=n.getUnitId();
						}
				 }
		  
		 
		  List<UnitMember> mList=unitMemberDAO.listMembersByUnit(loginUserUnitId);
		  for(UnitMember c:mList){
			  
			  Employee emp = employeeDAO.getEmployeeById(c.getMemberId());
			  empList.add(emp);
			  
		  }
		return empList;
		  
		  
	  }
	  
	  public String deleteTeamMemberById(int id) {
			
			//setIsNew("I");
				try{
					
					List<UnitMember> mList=unitMemberDAO.getMemberByMemberId(id);
					
					System.out.println(" vvvvvvvvvvvv77777777777");
					if(mList.size() != 0){
						 for(UnitMember um:mList){
							 unitMemberDAO.deleteUnitMember(um.getId());
						 }
					}
					return "";
			   	}catch(Exception ex){
			   		String message = "Team Menber  Information is NOT deteted Successfully.";
			   	 FacesContext.getCurrentInstance().addMessage(
 						null,
 						new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
			   		return "";
			   		
			   	}
			
		}
}
