package com.ucsc.mit.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.DependencyDAO;
import com.ucsc.mit.dao.EmployeeDAO;
import com.ucsc.mit.dao.IncidentDetailViewDAO;
import com.ucsc.mit.dao.IrtImpactLevelDAO;
import com.ucsc.mit.dao.IrtUrgencyDAO;
import com.ucsc.mit.dao.NotificationDAO;
import com.ucsc.mit.dao.PriorotyDAO;
import com.ucsc.mit.dao.TeamMemberViewDAO;
import com.ucsc.mit.dao.UnitDAO;
import com.ucsc.mit.dao.UnitMemberDAO;
import com.ucsc.mit.dao.UnitMemberTxnDAO;
import com.ucsc.mit.dao.VendorDAO;
import com.ucsc.mit.model.Dependency;
import com.ucsc.mit.model.DependencyCloseReason;
import com.ucsc.mit.model.DependencyDetailView;
import com.ucsc.mit.model.DependencyStatus;
import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.IncidentDetailView;
import com.ucsc.mit.model.IncidentTxn;
import com.ucsc.mit.model.IrtImpactLevel;
import com.ucsc.mit.model.IrtUrgency;
import com.ucsc.mit.model.Notification;
import com.ucsc.mit.model.Priority;
import com.ucsc.mit.model.TeamMemberView;
import com.ucsc.mit.model.Unit;
import com.ucsc.mit.model.UnitCloseReason;
import com.ucsc.mit.model.UnitMember;
import com.ucsc.mit.model.UnitMemberTxn;
import com.ucsc.mit.model.Vendor;

@Service
@ManagedBean(name="dependencytService")
@SessionScoped
public class DependencyService {
	private Date today = new Date();
	private String isNew="I";
	private String loggedUser;
	private String loggedUserLevel;
	private int loggedUserBranchId;
	private String loggedUserUnitName;
	private String loggedUserUnitId;
	private IncidentDetailViewDAO incidentDetailViewDAO;
	private DependencyDAO dependencyDAO;
	private VendorDAO vendorDAO;
	private EmployeeDAO employeeDAO;
	private UnitMemberTxnDAO unitMemberTxnDAO;
	private UnitMemberDAO unitMemberDAO;
	private UnitDAO unitDAO;
	private TeamMemberViewDAO teamMemberViewDAO;
	private IrtUrgencyDAO irtUrgencyDAO;
	private PriorotyDAO priorotyDAO;
	private IrtImpactLevelDAO irtImpactLevelDAO;
	private NotificationDAO notificationDAO;
	private int unitId;
	private String unitName;
	private String incidentNo;
	private String impactLevel;
	private String urgency;
	private String status;
	private String rootCause;
	private String dependencyNo;
	private Date dCreatedDate;
	private String dPriority;
	private String workingDays;
	private String hours;
	private String minutes;
	private String depDescription;
	private String assignMember;
	private String  depAction;
	private Date  statusUpDate=today;
	private String  depStatus;
	private String  depCloseReason;
	private String  depAssignUnit;
	private static Map<Integer,Object> unitMemberValue;
	private static Map<Integer,Object> depStatusValue;
	private static Map<Integer,Object> depCloseReasonValue;
	List<DependencyDetailView> depList=new ArrayList<DependencyDetailView>();
	private String visibleSaveAction ="N";
	private String visibleCloseAction ="N";
	private String visibleAssignAction ="N";
	private String depActionVisibility="";
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



	public void setLoggedUser(String loggedUser) {
		this.loggedUser = loggedUser;
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


	public IncidentDetailViewDAO getIncidentDetailViewDAO() {
		return incidentDetailViewDAO;
	}



	public void setIncidentDetailViewDAO(IncidentDetailViewDAO incidentDetailViewDAO) {
		this.incidentDetailViewDAO = incidentDetailViewDAO;
	}



	public DependencyDAO getDependencyDAO() {
		return dependencyDAO;
	}



	public void setDependencyDAO(DependencyDAO dependencyDAO) {
		this.dependencyDAO = dependencyDAO;
	}



	public VendorDAO getVendorDAO() {
		return vendorDAO;
	}



	public void setVendorDAO(VendorDAO vendorDAO) {
		this.vendorDAO = vendorDAO;
	}



	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}



	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}



	public UnitMemberTxnDAO getUnitMemberTxnDAO() {
		return unitMemberTxnDAO;
	}



	public void setUnitMemberTxnDAO(UnitMemberTxnDAO unitMemberTxnDAO) {
		this.unitMemberTxnDAO = unitMemberTxnDAO;
	}



	public UnitMemberDAO getUnitMemberDAO() {
		return unitMemberDAO;
	}



	public void setUnitMemberDAO(UnitMemberDAO unitMemberDAO) {
		this.unitMemberDAO = unitMemberDAO;
	}



	public int getUnitId() {
		return unitId;
	}



	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}



	public String getUnitName() {
		return unitName;
	}



	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}



	public List<DependencyDetailView> getDepList() {
		return depList;
	}



	public void setDepList(List<DependencyDetailView> depList) {
		this.depList = depList;
	}



	public UnitDAO getUnitDAO() {
		return unitDAO;
	}



	public void setUnitDAO(UnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}



	public String getIncidentNo() {
		return incidentNo;
	}



	public void setIncidentNo(String incidentNo) {
		this.incidentNo = incidentNo;
	}



	public String getImpactLevel() {
		return impactLevel;
	}



	public void setImpactLevel(String impactLevel) {
		this.impactLevel = impactLevel;
	}



	public String getUrgency() {
		return urgency;
	}



	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getRootCause() {
		return rootCause;
	}



	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}



	public String getDependencyNo() {
		return dependencyNo;
	}



	public void setDependencyNo(String dependencyNo) {
		this.dependencyNo = dependencyNo;
	}



	public Date getdCreatedDate() {
		return dCreatedDate;
	}



	public void setdCreatedDate(Date dCreatedDate) {
		this.dCreatedDate = dCreatedDate;
	}



	public String getdPriority() {
		return dPriority;
	}



	public void setdPriority(String dPriority) {
		this.dPriority = dPriority;
	}



	public String getWorkingDays() {
		return workingDays;
	}



	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}



	public String getHours() {
		return hours;
	}



	public void setHours(String hours) {
		this.hours = hours;
	}



	public String getMinutes() {
		return minutes;
	}



	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}



	public String getDepDescription() {
		return depDescription;
	}



	public void setDepDescription(String depDescription) {
		this.depDescription = depDescription;
	}



	public String getAssignMember() {
		return assignMember;
	}



	public void setAssignMember(String assignMember) {
		this.assignMember = assignMember;
	}



	public TeamMemberViewDAO getTeamMemberViewDAO() {
		return teamMemberViewDAO;
	}



	public void setTeamMemberViewDAO(TeamMemberViewDAO teamMemberViewDAO) {
		this.teamMemberViewDAO = teamMemberViewDAO;
	}



	public static Map<Integer, Object> getUnitMemberValue() {
		return unitMemberValue;
	}



	public static void setUnitMemberValue(Map<Integer, Object> unitMemberValue) {
		DependencyService.unitMemberValue = unitMemberValue;
	}



	public IrtUrgencyDAO getIrtUrgencyDAO() {
		return irtUrgencyDAO;
	}



	public void setIrtUrgencyDAO(IrtUrgencyDAO irtUrgencyDAO) {
		this.irtUrgencyDAO = irtUrgencyDAO;
	}



	public PriorotyDAO getPriorotyDAO() {
		return priorotyDAO;
	}



	public void setPriorotyDAO(PriorotyDAO priorotyDAO) {
		this.priorotyDAO = priorotyDAO;
	}



	public IrtImpactLevelDAO getIrtImpactLevelDAO() {
		return irtImpactLevelDAO;
	}



	public void setIrtImpactLevelDAO(IrtImpactLevelDAO irtImpactLevelDAO) {
		this.irtImpactLevelDAO = irtImpactLevelDAO;
	}



	public NotificationDAO getNotificationDAO() {
		return notificationDAO;
	}



	public void setNotificationDAO(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}



	public String getDepAction() {
		return depAction;
	}



	public void setDepAction(String depAction) {
		this.depAction = depAction;
	}



	public Date getStatusUpDate() {
		return statusUpDate;
	}



	public void setStatusUpDate(Date statusUpDate) {
		this.statusUpDate = statusUpDate;
	}



	public String getDepStatus() {
		return depStatus;
	}



	public void setDepStatus(String depStatus) {
		this.depStatus = depStatus;
	}



	public static Map<Integer, Object> getDepStatusValue() {
		return depStatusValue;
	}



	public static void setDepStatusValue(Map<Integer, Object> depStatusValue) {
		DependencyService.depStatusValue = depStatusValue;
	}



	public static Map<Integer, Object> getDepCloseReasonValue() {
		return depCloseReasonValue;
	}



	public static void setDepCloseReasonValue(Map<Integer, Object> depCloseReasonValue) {
		DependencyService.depCloseReasonValue = depCloseReasonValue;
	}



	public String getDepCloseReason() {
		return depCloseReason;
	}



	public void setDepCloseReason(String depCloseReason) {
		this.depCloseReason = depCloseReason;
	}



	public String getDepAssignUnit() {
		return depAssignUnit;
	}



	public void setDepAssignUnit(String depAssignUnit) {
		this.depAssignUnit = depAssignUnit;
	}



	public String getVisibleSaveAction() {
		return visibleSaveAction;
	}



	public void setVisibleSaveAction(String visibleSaveAction) {
		this.visibleSaveAction = visibleSaveAction;
	}



	public String getVisibleCloseAction() {
		return visibleCloseAction;
	}



	public void setVisibleCloseAction(String visibleCloseAction) {
		this.visibleCloseAction = visibleCloseAction;
	}



	public String getVisibleAssignAction() {
		return visibleAssignAction;
	}



	public void setVisibleAssignAction(String visibleAssignAction) {
		this.visibleAssignAction = visibleAssignAction;
	}



	public String getDepActionVisibility() {
		return depActionVisibility;
	}



	public void setDepActionVisibility(String depActionVisibility) {
		this.depActionVisibility = depActionVisibility;
	}



	public String back(){
		 
		 return "unitIncident";
	}
	
	public void cancel(){
		visibleSaveAction="N";
		visibleAssignAction="N";
		visibleCloseAction="N";
		depActionVisibility="N";
		 setIsNew("I");
	 }
	public void closeDependency(){
		String message=null;
		System.out.println(getDependencyNo()+" -- selected dependency  --");
		try{
			
			Date closedDate= new Date();
			Notification notf=new Notification();
			dependencyDAO.closeDependency(Integer.parseInt(getDependencyNo()), closedDate, getDepCloseReason());
					
			List<IncidentDetailView> in=incidentDetailViewDAO.getIncidentDetailByIncidentNo(Integer.parseInt(getIncidentNo()));
			 for(IncidentDetailView v:in){
				 notf.setNotifiTarget(v.getAssigned_unit());
			 }
			notf.setNotificationDate(new Date());
			notf.setRefId(Integer.parseInt(getDependencyNo()));
			
			notf.setNotificationText("Dependency No-:"+ getDependencyNo() +"is closed by :"+getDepAssignUnit());
			notf.setServiceNo(getLoggedUser());
			notf.setUserId(getLoggedUser());
			
			
			notificationDAO.addNotification(notf);
			message = "Incident  is closed Successfully.";
		
		}catch(Exception ex){
    		message = "Incident  is NOT closed Successfully.";
    		
    	}
    	setIsNew("I");
    
    	FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
		
		
	}
	 public List<DependencyDetailView> listAllDependency() {
			
		System.out.println(" == listAllDependency ===");
			
		int unit_id=getUnitIdByUserID();
		depList.clear();
		//List<IncidentDetailView> incList=new ArrayList<IncidentDetailView>();
		
 			
		depList= dependencyDAO.listDependencyFromViewForUnit(unit_id);
 			
 		
		return depList;
			  
			  
	 }
	 
		public int getUnitIdByUserID(){
			int unitID=0;
			if(getLoggedUser() != null){
				List<Employee> emp=employeeDAO.getEmployeeByEmpId(loggedUser);
				for(Employee v:emp){
					int empId = v.getId();
					List<UnitMember> mList=unitMemberDAO.getMemberByMemberId(empId);
					for(UnitMember n:mList){
						unitID = n.getUnitId();
						unitId =unitID;
						Unit u	 =unitDAO.getUnitByCode(unitID);
						unitName =u.getUnitName();
					}
				}
				
			}
			return unitID;
		}
		public Map<Integer,Object> getUnitMemberValues() {
			
			unitMemberValue = new LinkedHashMap<Integer,Object>();
			if(unitName != null){
			 unitMemberValue.clear();
			 List<TeamMemberView> a= teamMemberViewDAO.getTeamMemberByUnitCode(unitId);
			 for(TeamMemberView x:a){
				 unitMemberValue.put(x.getTeam_member_id(), x.getTeam_m_name());
			 }
			}else{
				List<TeamMemberView> a= teamMemberViewDAO.getTeamMemberByUnitCode(1);
				 for(TeamMemberView x:a){
					 unitMemberValue.put(x.getTeam_member_id(), x.getTeam_m_name());
				 }
				
			}
		     return unitMemberValue;
		} 
		public  Map<Integer, Object> getDepStatusListValue() {
			depStatusValue = new LinkedHashMap<Integer,Object>();
			 List<DependencyStatus> a= dependencyDAO.listDependencyStatus();
			 for(DependencyStatus x:a){
				 depStatusValue.put(x.getDep_id(), x.getDep_status_des());
			 }
			 
		    
			return depStatusValue;
		}
		public  Map<Integer, Object> getDepCloseReasonListValue() {
			depCloseReasonValue = new LinkedHashMap<Integer,Object>();
			 List<DependencyCloseReason> a= dependencyDAO.listDependencyCloseReason();
			 for(DependencyCloseReason x:a){
				 depCloseReasonValue.put(x.getReason_id(), x.getCloseReasonName());
			 }
			 
		    
			return depCloseReasonValue;
		}
		
		public void getIncidentDataByID(int dep_id,int incident_id) throws Exception{
			 setIsNew("V");
			 assignMember=null;
			
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 List<IncidentDetailView> in=incidentDetailViewDAO.getIncidentDetailByIncidentNo(incident_id);
			 setDependencyNo(Integer.toString(dep_id));
			 
			 for(IncidentDetailView x:in){
				 setIncidentNo(Integer.toString(x.getIncident_number()));
				 setRootCause(x.getRoot_cause());			
				 setStatus(x.getStatus_desc());
				List<IrtUrgency> irtUrgency =irtUrgencyDAO.getDataByUrgencyCode(x.getUrgency());
				for(IrtUrgency k:irtUrgency){
					setUrgency(k.getUrgencyName());
				} 
				List<IrtImpactLevel> imp=irtImpactLevelDAO.getDataByImpactCode(x.getImpact_level());
				for(IrtImpactLevel v:imp){
					setImpactLevel(v.getImpactLvlName());
				} 
				
				Dependency dept=dependencyDAO.getDependencyById(dep_id);
				setDependencyNo(Integer.toString(dept.getDependency_id()));
				setdCreatedDate(dept.getCreated_date());
				
				setWorkingDays(Integer.toString(dept.getDays()));
				setHours(Integer.toString(dept.getHours()));
				setMinutes(Integer.toString(dept.getMinutes()));
				setDepDescription(depDescription);
				setDepAssignUnit(Integer.toString(dept.getUnit_id()));
				Priority prio=priorotyDAO.getPrriorityById(dept.getPriority_id());
				setdPriority(prio.getPriorityName());
				if(dept.getAssinged_member() != null){
					List<Employee> emp=employeeDAO.getEmployeeByEmpId(dept.getAssinged_member());
					for(Employee d:emp){
						setAssignMember(Integer.toString(d.getId()));
						if(d.getEmpId().equals(getLoggedUser())){
							visibleSaveAction="Y";
						}else{
							visibleSaveAction="N";
						}
					}	
					List<TeamMemberView> inList= teamMemberViewDAO.getTeamMemberByUnitCode(Integer.parseInt(getDepAssignUnit()));
					for(TeamMemberView f:inList){
							
						if(f.getUnit_head_id().equals(getLoggedUser())){
							
							if(dept.getDependency_status() !=null){
								if ("RSLV".equals(dept.getDependency_status() ) ||  "CD".equals(dept.getDependency_status() )) {
									visibleCloseAction="Y";
									visibleAssignAction="N";
					            } else {
					            	
					            	if ("INP".equals(dept.getDependency_status() ) ||  "OH".equals(dept.getDependency_status() )) {
					            		visibleAssignAction="N";
					            	}
					            	visibleCloseAction= "N";
					            	visibleAssignAction="Y";

					            }
							}
						}else{
							if(getLoggedUser().equals(dept.getAssinged_member())){
				        		depActionVisibility="Y";
				        		
				        	}else{
				        		depActionVisibility="N";
				        		
				        	}
							visibleCloseAction="N";
							visibleCloseAction= "N";
						}
					 }
						
					
				}
			 
			 }
		}
		
		public void assignToTeamMember(){
	 		String message=null;
	 		
	 	
	 		Notification notf=new Notification();
	 		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			if(unitName == null){
				message = "Unit name cannot be blank.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
			}else if(assignMember == null){
				message = "Select team member.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
			}else{
				
				try{	
				
				    System.out.println(" -- assignToTeamMember --"+getAssignMember());
				    Dependency dept=dependencyDAO.getDependencyById(Integer.parseInt(getDependencyNo()));
					
					if(dept !=null){
						Employee emp=employeeDAO.getEmployeeById(Integer.parseInt(getAssignMember()));
						
						dependencyDAO.updateAssignMember(Integer.parseInt(getDependencyNo()), emp.getEmpId(), "ASSIGNED");
						
						
						
						notf.setNotificationText("Dependency "+ getDependencyNo() +" is reassigend to : "+emp.getEmpId()+" in the "+unitName+" for incident no "+getIncidentNo());
						notf.setModuleId(0);
						notf.setRefId(Integer.parseInt(getDependencyNo()));
						notf.setServiceNo(getLoggedUser());
						notf.setUserId(getLoggedUser());
						notf.setNotificationDate(new Date());
						notf.setNotifiTarget((emp.getEmpId()));
						notificationDAO.addNotification(notf);
						
						message = "Dependency  is assigned Successfully.";
					}else{
						
						message = "Dependency  is already assigned.";
					}
				}catch(Exception ex){
		    		message = "Dependency  is NOT assigned Successfully.";
		    		
		    	}
				setIsNew("I");
			    
		    	FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
		    	
		    	
				
			}
		}
		
		public void saveDependencyAction(){
			
			
	 		String message=null;
	 		Notification notf=new Notification();
			if(assignMember == null){
				message = "Select team member.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
			}else if(depStatus == null){
				message = "Status can not be blank.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
			}else if(depAction == null){
				message = "Action taken can not be blank.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
			}else{
				
				try{	
					
					dependencyDAO.updateDependencyAction(Integer.parseInt(getDependencyNo()), getStatusUpDate(), getDepStatus(), getDepAction());
					List<TeamMemberView> inList= teamMemberViewDAO.getTeamMemberByUnitCode(Integer.parseInt(getDepAssignUnit()));
					for(TeamMemberView d:inList){
						
						notf.setNotifiTarget((d.getUnit_head_id()));
					}
					notf.setNotificationText("Dependency "+ getDependencyNo() +" is resolved for incident no "+getIncidentNo());
					notf.setModuleId(0);
					notf.setRefId(Integer.parseInt(getDependencyNo()));
					notf.setServiceNo(getLoggedUser());
					notf.setUserId(getLoggedUser());
					notf.setNotificationDate(new Date());
					
					notificationDAO.addNotification(notf);	
					
					message = "Dependency action is saved Successfully.";
						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
					
				}catch(Exception ex){
		    		message = "Dependency action is NOT saved Successfully.";
		    		FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
		    		
		    	}
				setIsNew("I");
			    
		    	
		    	
		    	
				
			}
		
			
		}
		
		
		
		
	}