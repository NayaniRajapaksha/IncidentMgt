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
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.BranchDAO;
import com.ucsc.mit.dao.EmployeeDAO;
import com.ucsc.mit.dao.IrtMemberDAO;
import com.ucsc.mit.dao.UnitDAO;
import com.ucsc.mit.dao.UserGroupDAO;
import com.ucsc.mit.model.Branch;
import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.IrtMember;
import com.ucsc.mit.model.TempIrtMember;

@Service
@ManagedBean(name="irtService")
@SessionScoped
public class IrtMemberService {
	private String brName;
	private String serviceNo;
	private String mName;
	private String isNew="I";
	String message = null;
	private IrtMemberDAO irtMemberDAO;
	private EmployeeDAO employeeDAO;
	private UnitDAO unitDAO;
	private BranchDAO branchDAO;
	private UserGroupDAO userGroupDAO;
	private int memberId;
	private String loggedUser;
	private String loggedUserLevel;
	private int loggedUserBranchId;
	private String loggedUserUnitName;
	private String loggedUserUnitId;
	private static ArrayList<TempIrtMember> irtMemberList=new ArrayList<TempIrtMember>();
	private static Map<Integer,Object> branchValue;
	
	
	

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
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

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public IrtMemberDAO getIrtMemberDAO() {
		return irtMemberDAO;
	}

	public void setIrtMemberDAO(IrtMemberDAO irtMemberDAO) {
		this.irtMemberDAO = irtMemberDAO;
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public UnitDAO getUnitDAO() {
		return unitDAO;
	}

	public void setUnitDAO(UnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}

	public BranchDAO getBranchDAO() {
		return branchDAO;
	}

	public UserGroupDAO getUserGroupDAO() {
		return userGroupDAO;
	}

	public void setUserGroupDAO(UserGroupDAO userGroupDAO) {
		this.userGroupDAO = userGroupDAO;
	}

	public void setBranchDAO(BranchDAO branchDAO) {
		this.branchDAO = branchDAO;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public static ArrayList<TempIrtMember> getIrtMemberList() {
		return irtMemberList;
	}

	public static void setIrtMemberList(ArrayList<TempIrtMember> irtMemberList) {
		IrtMemberService.irtMemberList = irtMemberList;
	}

	public static Map<Integer, Object> getBranchValue() {
		return branchValue;
	}

	public static void setBranchValue(Map<Integer, Object> branchValue) {
		IrtMemberService.branchValue = branchValue;
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
	public void createNew(){
    	setIsNew("N");
    	mName=null;
		serviceNo=null;
		brName=null;
		irtMemberList.clear();
    
    }
	public void cancel(){
		mName=null;
		serviceNo=null;
		brName=null;
		irtMemberList.clear();
    	setIsNew("I");
  
    }
	public void valueChangeServiceNo(){
    	if(serviceNo != null){
    		 if(!("".equals(serviceNo))){
    			 try{
    				 List<Employee> emp = employeeDAO.getEmployeeByEmpId(serviceNo);
    				 if(emp.size()!=0){
	    				 for(Employee x:emp){
	    				
	    	    			 setmName(x.getName());
	    	    			 setMemberId(x.getId());
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
	
	public List<Branch> listRegionAndDepartments() {

		try{
			return branchDAO.getAllRegionsAndDepartments();
	   	}catch(Exception ex){
	   		return null;
	   		
	   	}
				
	}
	
	public void getIrtMembersByRegion(int id) {
		// TODO Auto-generated method stub
		setIsNew("E");
		try{
			setBrName(Integer.toString(id));
			serviceNo=null;
			mName =null;
			irtMemberList.clear();
			List<IrtMember> mList=irtMemberDAO.listMembersByRegion(id);
			for(IrtMember x:mList){
				Employee emp=employeeDAO.getEmployeeById(x.getMemberId());
				irtMemberList.add(new TempIrtMember(x.getId(),x.getMemberId(),x.getRegionId(),emp.getName()));
			}
	   	}catch(Exception ex){
	   		
	   		message = "Unable to Select Record";
	   		FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
	   	}
				
	}
	

	public void addIrtMembers(){
		if(serviceNo !=null && brName !=null ){
			
			int brId = Integer.parseInt(brName);
			irtMemberList.add(new TempIrtMember(0,getMemberId(),brId,getmName()));
			
		}
		
	}
	
	public Map<Integer,Object> getBranchValues() {
		branchValue = new LinkedHashMap<Integer,Object>();
		 List<Branch> a= branchDAO.getAllRegionsAndDepartments();
		 for(Branch x:a){
			 branchValue.put(x.getRegionalId(), x.getBranchName());
		 }
		 
	     return branchValue;
	}
	
	public String deleteMember(TempIrtMember member) {
		
		
		try{
			
			if(irtMemberList.size()!=0){
				if(member.getId() ==0){
					irtMemberList.remove(member);
				}else{
					Employee emp=employeeDAO.getEmployeeById(member.getMemberId());
	        		userGroupDAO.getUpdateGroupByEmpId(emp.getUserId(), "EMP_USER");
					irtMemberDAO.deleteIrtMember(member.getId());
					
					setIsNew("I");
				}
				
    		}
			

			return "";
	   	}catch(Exception ex){
	   		message = "Unable to Delete Record";
	   		FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
	   		return "";
	   		
	   	}
	
	}
	
	public void saveIrtDetail(IrtMember member) {
		if(serviceNo !=null && brName !=null ){
 		String message = null;
 		IrtMember irt=new IrtMember();
 		
 		ArrayList<TempIrtMember>itemsSet=getIrtMemberList();
 		
 		
    	try{
    		
    		irt.setCreatedBy(getLoggedUser());
    		int brId = Integer.parseInt(getBrName()); 
        	if(isNew.equals("N")){
        		if(itemsSet.size()!=0){  
        			for(TempIrtMember f:itemsSet){
        				
		        		irt.setMemberId(f.getMemberId());
		        		irt.setRegionId(f.getRegionId());
		        		irtMemberDAO.addIrtMember(irt);
		        		Employee emp=employeeDAO.getEmployeeById(f.getMemberId());
		        		userGroupDAO.getUpdateGroupByEmpId(emp.getUserId(), "IRT_USER");
        			}
        		}
        	}else if(isNew.equals("E")){
        		if(itemsSet.size()!=0){  
        			for(TempIrtMember f:itemsSet){
		        		irt.setId(f.getId());
		        		irt.setMemberId(f.getMemberId());
		        		irt.setRegionId(f.getRegionId());
		        		irtMemberDAO.updateIrtMember(irt);
		        		Employee emp=employeeDAO.getEmployeeById(f.getMemberId());
		        		userGroupDAO.getUpdateGroupByEmpId(emp.getUserId(), "IRT_USER");
        		
        			}
        		}	
        		
        	}
        	message = "IRT Member Information is stored Successfully.";
        	
    	}catch(Exception ex){
    		message = "IRT Member Information is NOT stored Successfully. Member already assigned to region";
    		
    	}
    	setIsNew("I");
    
    	FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
 		}
    
 	}
}
