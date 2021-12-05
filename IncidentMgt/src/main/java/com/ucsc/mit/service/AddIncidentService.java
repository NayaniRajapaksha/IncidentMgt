package com.ucsc.mit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.BranchDAO;
import com.ucsc.mit.dao.EmployeeDAO;
import com.ucsc.mit.dao.IncidentProgressViewDAO;
import com.ucsc.mit.dao.IncidentSubTypeDAO;
import com.ucsc.mit.dao.IncidentTxnDAO;
import com.ucsc.mit.dao.IncidentTypeDAO;
import com.ucsc.mit.dao.NotificationDAO;
import com.ucsc.mit.dao.OriginDAO;
import com.ucsc.mit.dao.PriorotyDAO;
import com.ucsc.mit.dao.TechAffectedAreaDAO;
import com.ucsc.mit.dao.UnitCloseReasonDAO;
import com.ucsc.mit.model.Branch;
import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.IncidentProgressView;
import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.IncidentTxn;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.IrtMember;
import com.ucsc.mit.model.Notification;
import com.ucsc.mit.model.Origin;
import com.ucsc.mit.model.Priority;
import com.ucsc.mit.model.TechAffectedArea;
import com.ucsc.mit.model.TempIncidentTxn;
import com.ucsc.mit.model.UnitMember;

@Service
@ManagedBean(name="addIncidentService")
@SessionScoped
public class AddIncidentService{
	//AddIncidentService
	private String isNew="I";
	private String loggedUser;
	private String loggedUserLevel;
	private int loggedUserBranchId;
	private String loggedUserUnitName;
	private String loggedUserUnitId;
	private IncidentTypeDAO incidentTypeDAO;
	private IncidentSubTypeDAO incidentSubTypeDAO;
	private BranchDAO branchDAO;
	private EmployeeDAO employeeDAO;
	private NotificationDAO notificationDAO;
	private IncidentProgressViewDAO incidentProgressViewDAO;
	
	private String typeName;
	private String subTypeName;
	private String priorityLevel;
	private String techAffect;
	private String origin;
	private String location;
	
	private IncidentTxnDAO incidentTxnDAO;
	private UnitCloseReasonDAO unitCloseReasonDAO;
	private OriginDAO originDAO;
	private TechAffectedAreaDAO techAffectedAreaDAO;
	private PriorotyDAO priorotyDAO;

	private static Map<Integer,Object> incidentTypeValue;
	private static Map<Integer,Object> incidentSubTypeValue= new LinkedHashMap<Integer,Object>();
	private static Map<Integer,Object> originValue;
	private static Map<Integer,Object> techAffectedValue;
	private static Map<Integer,Object> priorityValue;
	private static Map<Integer,Object> locationValue;
	private Date today = new Date();
	private Date occuranceDate= today;
	private String title;
	private String affectedProcess;
	private String description;
	private String locationDetail;
	private String reportedBySno;
	private String reportedByName;
	private String workPhone;
	private String workEmail;
	private String mobile;
	private int selectedid;
	private Date createDate;
	List<IncidentProgressView> progressList = null;
	
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public String getLoggedUser() {
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
	public void setLoggedUser(String loggedUser) {
		this.loggedUser = loggedUser;
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
	public BranchDAO getBranchDAO() {
		return branchDAO;
	}
	public void setBranchDAO(BranchDAO branchDAO) {
		this.branchDAO = branchDAO;
	}
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
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
	public String getPriorityLevel() {
		return priorityLevel;
	}
	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}
	public String getTechAffect() {
		return techAffect;
	}
	public void setTechAffect(String techAffect) {
		this.techAffect = techAffect;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public IncidentTxnDAO getIncidentTxnDAO() {
		return incidentTxnDAO;
	}
	public void setIncidentTxnDAO(IncidentTxnDAO incidentTxnDAO) {
		this.incidentTxnDAO = incidentTxnDAO;
	}
	public UnitCloseReasonDAO getUnitCloseReasonDAO() {
		return unitCloseReasonDAO;
	}
	public void setUnitCloseReasonDAO(UnitCloseReasonDAO unitCloseReasonDAO) {
		this.unitCloseReasonDAO = unitCloseReasonDAO;
	}
	public OriginDAO getOriginDAO() {
		return originDAO;
	}
	public void setOriginDAO(OriginDAO originDAO) {
		this.originDAO = originDAO;
	}
	public TechAffectedAreaDAO getTechAffectedAreaDAO() {
		return techAffectedAreaDAO;
	}
	public void setTechAffectedAreaDAO(TechAffectedAreaDAO techAffectedAreaDAO) {
		this.techAffectedAreaDAO = techAffectedAreaDAO;
	}
	public PriorotyDAO getPriorotyDAO() {
		return priorotyDAO;
	}
	public void setPriorotyDAO(PriorotyDAO priorotyDAO) {
		this.priorotyDAO = priorotyDAO;
	}
	
	
	
	public static Map<Integer, Object> getIncidentSubTypeValue() {
		return incidentSubTypeValue;
	}
	public static void setIncidentSubTypeValue(Map<Integer, Object> incidentSubTypeValue) {
		AddIncidentService.incidentSubTypeValue = incidentSubTypeValue;
	}
	public static Map<Integer, Object> getOriginValue() {
		return originValue;
	}
	public static void setOriginValue(Map<Integer, Object> originValue) {
		AddIncidentService.originValue = originValue;
	}
	public static Map<Integer, Object> getTechAffectedValue() {
		return techAffectedValue;
	}
	public static void setTechAffectedValue(Map<Integer, Object> techAffectedValue) {
		AddIncidentService.techAffectedValue = techAffectedValue;
	}
	public static Map<Integer, Object> getPriorityValue() {
		return priorityValue;
	}
	public static void setPriorityValue(Map<Integer, Object> priorityValue) {
		AddIncidentService.priorityValue = priorityValue;
	}
	public static Map<Integer, Object> getLocationValue() {
		return locationValue;
	}
	public static void setLocationValue(Map<Integer, Object> locationValue) {
		AddIncidentService.locationValue = locationValue;
	}
		
	public Date getOccuranceDate() {
		return occuranceDate;
	}
	public void setOccuranceDate(Date occuranceDate) {
		this.occuranceDate = occuranceDate;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAffectedProcess() {
		return affectedProcess;
	}
	public void setAffectedProcess(String affectedProcess) {
		this.affectedProcess = affectedProcess;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocationDetail() {
		return locationDetail;
	}
	public void setLocationDetail(String locationDetail) {
		this.locationDetail = locationDetail;
	}
	public String getReportedBySno() {
		return reportedBySno;
	}
	public void setReportedBySno(String reportedBySno) {
		this.reportedBySno = reportedBySno;
	}
	public String getReportedByName() {
		return reportedByName;
	}
	public void setReportedByName(String reportedByName) {
		this.reportedByName = reportedByName;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getWorkEmail() {
		return workEmail;
	}
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public NotificationDAO getNotificationDAO() {
		return notificationDAO;
	}
	public void setNotificationDAO(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}
	public IncidentProgressViewDAO getIncidentProgressViewDAO() {
		return incidentProgressViewDAO;
	}
	public void setIncidentProgressViewDAO(IncidentProgressViewDAO incidentProgressViewDAO) {
		this.incidentProgressViewDAO = incidentProgressViewDAO;
	}
	
	
	public List<IncidentProgressView> getProgressList() {
		return progressList;
	}
	public void setProgressList(List<IncidentProgressView> progressList) {
		this.progressList = progressList;
	}
	public Map<Integer,Object> getIncidentTypeValue() {
		 incidentTypeValue = new LinkedHashMap<Integer,Object>();
		 List<IncidentType> a= incidentTypeDAO.listIncidentTypes();
		 for(IncidentType x:a){
			 incidentTypeValue.put(x.getId(), x.getTypeName());
		 }
		 
	     return incidentTypeValue;
	}
	
	public void valueChangeIncidentType(){
		
		incidentSubTypeValue.clear();	
		if(typeName !=null){
			int incidentId = Integer.parseInt(typeName);
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
	
		public Map<Integer,Object> getBranchValues() {
			locationValue = new LinkedHashMap<Integer,Object>();
			 List<Branch> a= branchDAO.getAllLocations();
			 for(Branch x:a){
				 locationValue.put(x.getId(), x.getBranchName());
			 }
			 
		     return locationValue;
		} 
		
		public Map<Integer,Object> getTechAffectedAreaValues() {
			techAffectedValue = new LinkedHashMap<Integer,Object>();
			 List<TechAffectedArea> a= techAffectedAreaDAO.getTechAffectedAreas();
			 for(TechAffectedArea x:a){
				 techAffectedValue.put(x.getId(), x.getAfctAreaName());
			 }
			 
		     return techAffectedValue;
		} 
		
		public Map<Integer,Object> getPriorityLevelValues() {
			priorityValue = new LinkedHashMap<Integer,Object>();
			 List<Priority> a= priorotyDAO.getPriorityLevels();
			 for(Priority x:a){
				 priorityValue.put(x.getId(), x.getPriorityName());
			 }
			 
		     return priorityValue;
		} 
		
		public Map<Integer,Object> getOriginValues() {
			originValue = new LinkedHashMap<Integer,Object>();
			 List<Origin> a= originDAO.getOriginData();
			 for(Origin x:a){
				 originValue.put(x.getId(), x.getOriginName());
			 }
			 
		     return originValue;
		} 
		
		public void valueChangeServiceNo(){
			String message=null;
	    	if(reportedBySno!= null){
	    		 if(!("".equals(reportedBySno))){
	    			 try{
	    				 List<Employee> emp = employeeDAO.getEmployeeByEmpId(reportedBySno);
	    				 if(emp.size()!=0){
		    				 for(Employee x:emp){
		    				
		    	    			 setReportedByName(x.getName());
		    	    			
		    				 }
	    				 }else{
	    					 reportedByName=null;
	    					 message ="Invalid service no.";
	    					 FacesContext.getCurrentInstance().addMessage(
	    	    						null,
	    	    						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
	    				 }
	    			 }catch(Exception ex){
	    				 reportedByName=null;
	    				 message = "Invalid service no.";
	    				 FacesContext.getCurrentInstance().addMessage(
	     						null,
	     						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
	    			 }
	    			
	    		 }
	    		
	    	}
	    
	    }
		public void createNew(){
	    	setIsNew("N");
	    	title=null;
			priorityLevel=null;
			occuranceDate=new Date();
			techAffect =null;
			affectedProcess =null;
			location = null;
			typeName=null;
			description=null;
			locationDetail=null;
			subTypeName=null;
			reportedBySno=getLoggedUser();
			valueChangeServiceNo();
			origin=null;
			workPhone=null;
			workEmail=null;
			mobile=null;
	    
	    }
		public void cancel(){
			title=null;
			priorityLevel=null;
			occuranceDate=new Date();
			techAffect =null;
			affectedProcess =null;
			location = null;
			typeName=null;
			description=null;
			locationDetail=null;
			subTypeName=null;
			reportedBySno=getLoggedUser();	
			valueChangeServiceNo();
			origin=null;
			workPhone=null;
			workEmail=null;
			mobile=null;
	    	setIsNew("I");
	  
	    }
	
		
		 public List<TempIncidentTxn> listAllIncidents() {
			  List<TempIncidentTxn> incList = new ArrayList<TempIncidentTxn>(); 
			  List<IncidentTxn> mList=incidentTxnDAO.listAllIncidents();
			  for(IncidentTxn c:mList){
				  IncidentType inc=incidentTypeDAO.getIncidentTypeById(c.getIncTypeId());
				  String inctype=inc.getTypeName();
				  IncidentSubType sub= incidentSubTypeDAO.getIncidentTypeSubById(c.getIncSubTypeId());
				  String incSubTypeName=sub.getSubTypeName();
				  Priority pri= priorotyDAO.getPrriorityById(c.getPriorityId());
				  String priorityName=pri.getPriorityName();
				  
				
				  
				  TempIncidentTxn tmp=new TempIncidentTxn(c.getId(), c.getOccuranceDate(), c.getIncTypeId(), 
						  inctype, c.getIncSubTypeId(), incSubTypeName, c.getPriorityId(),
						  priorityName, c.getStatus(), c.getTechId(), c.getIncLocationId(),
						  c.getOriginId(), c.getAtUnitProcess(), c.getDescription(), c.getIncLocDetail(),
						  c.getReportedBy(), c.getPhone(), c.getEmail(), c.getTitle());
				  incList.add(tmp);
				  
			  }
			return incList;
			  
			  
		  }
		
		public void saveIncident() {
			String message=null;
			IncidentTxn txn=new IncidentTxn();
		//	Notification notify=new Notification();
			try{	
			txn.setTitle(getTitle());
			txn.setAtUnitProcess(affectedProcess);
			txn.setDescription(description);
			txn.setPriorityId(Integer.parseInt(getPriorityLevel()));
			txn.setOccuranceDate(occuranceDate);
			txn.setTechId(Integer.parseInt(getTechAffect()));
			txn.setIncLocationId(Integer.parseInt(getLocation()));
			txn.setIncTypeId(Integer.parseInt(getTypeName()));
			txn.setIncLocDetail(locationDetail);
			txn.setIncSubTypeId(Integer.parseInt(getSubTypeName()));
			txn.setReportedBy(reportedBySno);
			txn.setOriginId(Integer.parseInt(getOrigin()));
			txn.setPhone(workPhone);
			txn.setEmail(workEmail);
			txn.setCreatedBy(getLoggedUser());
			
		
			txn.setStatus("INITIAL");
			if(isNew.equals("N")){
				txn.setCreatedDate(today);
				txn.setModifiedDate(today);
				incidentTxnDAO.addIncident(txn);
			//	notificationDAO.addNotification(notify);
			}else if(isNew.equals("E")){
				Date modifiedDate= new Date();
				txn.setId(selectedid);
				txn.setModifiedDate(modifiedDate);
				txn.setModifiedBy(getLoggedUser());
				txn.setCreatedDate(createDate);
				incidentTxnDAO.updateIncident(txn);
			}
			message = "Incident Information is stored Successfully.";
			}catch(Exception ex){
	    		message = "Incident Information is NOT stored Successfully.";
	    		
	    	}
	    	setIsNew("I");
	    
	    	FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
			
		}
		public void getIncidentDataByID(int id) throws Exception{
			
			IncidentTxn in=incidentTxnDAO.getIncidentById(id);
			setTitle(in.getTitle());
			setAffectedProcess(in.getAtUnitProcess());
			setDescription(in.getDescription());
			setPriorityLevel(Integer.toString(in.getPriorityId()));
			setLocation(Integer.toString(in.getIncLocationId()));
			setSubTypeName(Integer.toString(in.getIncSubTypeId()));
			setTypeName(Integer.toString(in.getIncTypeId()));
			setTechAffect(Integer.toString(in.getTechId()));
			setLocationDetail(in.getIncLocDetail());
			setOrigin(Integer.toString(in.getOriginId()));
			setReportedBySno(in.getReportedBy());
			valueChangeServiceNo();
			setWorkEmail(in.getEmail());
			setWorkPhone(in.getPhone());
			setOccuranceDate(in.getCreatedDate());
			createDate =in.getCreatedDate();
		}
		public void editIncidentDetailByID(int id) {
			String message=null;
			try{
				selectedid =id;
				getIncidentDataByID(id);
				
				
			}catch(Exception ex){
			   	
				message = "Unable to load the data.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
		   		
		   	}
			setIsNew("E");
		}	
		
		public void viewIncidentDetailByID(int id) {
			String message=null;
			try{
				
				getIncidentDataByID(id);
				
				
			}catch(Exception ex){
			   	
				message = "Unable to load the data.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
		   		
		   	}
			
			setIsNew("V");
		}	
		
		public void deleteIncidentDetailByID(int id) {
			String message=null;
			try{
				
				incidentTxnDAO.deleteIncident(id);
				
				
			}catch(Exception ex){
			   	
				message = "Unable to delete data.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
		   		
		   	}
			
			setIsNew("I");
		}
		
		public List<IncidentProgressView> progress(int id){
			
	    	setIsNew("P");
	    	System.out.println(" incident no ==== "+id);
	    	
	    	try{
	    		progressList=incidentProgressViewDAO.getIncidentProgressByIncidentNoForEmp(id);
	    	}catch(Exception ex){
			   	
	    		System.out.println(" error ==== "+ex.getMessage());
		   	}
			return progressList;
	    }
}
