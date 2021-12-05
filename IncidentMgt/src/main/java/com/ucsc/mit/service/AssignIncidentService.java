package com.ucsc.mit.service;

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
import com.ucsc.mit.dao.BranchDAO;
import com.ucsc.mit.dao.EmployeeDAO;
import com.ucsc.mit.dao.FaqDAO;
import com.ucsc.mit.dao.IncidentDetailViewDAO;
import com.ucsc.mit.dao.IncidentProgressViewDAO;
import com.ucsc.mit.dao.IncidentSubTypeDAO;
import com.ucsc.mit.dao.IncidentTxnDAO;
import com.ucsc.mit.dao.IncidentTypeDAO;
import com.ucsc.mit.dao.IrtCloseReasonDAO;
import com.ucsc.mit.dao.IrtImpactLevelDAO;
import com.ucsc.mit.dao.IrtImpactUrgencyDAO;
import com.ucsc.mit.dao.IrtIncidentTxnDAO;
import com.ucsc.mit.dao.IrtReminderDAO;
import com.ucsc.mit.dao.IrtUrgencyDAO;
import com.ucsc.mit.dao.NotificationDAO;
import com.ucsc.mit.dao.OriginDAO;
import com.ucsc.mit.dao.PriorotyDAO;
import com.ucsc.mit.dao.SimilarSolutionDAO;
import com.ucsc.mit.dao.TeamMemberViewDAO;
import com.ucsc.mit.dao.TechAffectedAreaDAO;
import com.ucsc.mit.dao.UnitAssignHistoryViewDAO;
import com.ucsc.mit.dao.UnitCloseReasonDAO;
import com.ucsc.mit.dao.UnitDAO;
import com.ucsc.mit.dao.UnitMemberTxnDAO;
import com.ucsc.mit.model.Branch;
import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.Faq;
import com.ucsc.mit.model.IncidentDetailView;
import com.ucsc.mit.model.IncidentProgressView;
import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.IncidentTxn;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.IrtCloseReason;
import com.ucsc.mit.model.IrtImpactLevel;
import com.ucsc.mit.model.IrtImpactUrgency;
import com.ucsc.mit.model.IrtIncidentDetailView;
import com.ucsc.mit.model.IrtIncidentTxn;
import com.ucsc.mit.model.IrtReminder;
import com.ucsc.mit.model.IrtUrgency;
import com.ucsc.mit.model.Notification;
import com.ucsc.mit.model.Origin;
import com.ucsc.mit.model.Priority;
import com.ucsc.mit.model.SimilarSolutionView;
import com.ucsc.mit.model.TeamMemberView;
import com.ucsc.mit.model.TechAffectedArea;
import com.ucsc.mit.model.TempIncidentTxn;
import com.ucsc.mit.model.Unit;
import com.ucsc.mit.model.UnitAssignHistoryView;
import com.ucsc.mit.model.UnitMemberTxn;

@Service
@ManagedBean(name="assignIncidentService")
@SessionScoped
public class AssignIncidentService {
	
	private String isNew="I";
	private String loggedUser;
	private String loggedUserLevel;
	private int loggedUserBranchId;
	private String loggedUserUnitName;
	private String loggedUserUnitId;
	private int loggedUserRegionId;
	private IncidentTypeDAO incidentTypeDAO;
	private IncidentSubTypeDAO incidentSubTypeDAO;
	private BranchDAO branchDAO;
	private EmployeeDAO employeeDAO;
	private NotificationDAO notificationDAO;
	private IncidentProgressViewDAO incidentProgressViewDAO;
	private UnitDAO unitDAO;
	
	private String typeName;
	private String subTypeName;
	private String priorityLevel;
	private String techAffect;
	private String origin;
	private String location;
	private String impactLevel;
	private String urgency;
	private String reminder;
	private String closeReason;
	private String unitName;
	private String workingDays;
	private String hours;
	private String minutes;
	private String comments;
	
	private IncidentTxnDAO incidentTxnDAO;
	private UnitCloseReasonDAO unitCloseReasonDAO;
	private OriginDAO originDAO;
	private TechAffectedAreaDAO techAffectedAreaDAO;
	private PriorotyDAO priorotyDAO;
	private IrtImpactLevelDAO irtImpactLevelDAO;
	private IrtCloseReasonDAO irtCloseReasonDAO;
	private IrtReminderDAO irtReminderDAO;
	private IrtUrgencyDAO irtUrgencyDAO;
	private FaqDAO faqDAO;
	private IrtIncidentTxnDAO irtIncidentTxnDAO;
	private IrtImpactUrgencyDAO irtImpactUrgencyDAO;
	private UnitMemberTxnDAO unitMemberTxnDAO;
	private TeamMemberViewDAO teamMemberViewDAO;
	private UnitAssignHistoryViewDAO unitAssignHistoryViewDAO;
;
	private SimilarSolutionDAO similarSolutionDAO;
	private static Map<Integer,Object> incidentTypeValue;
	private static Map<Integer,Object> incidentSubTypeValue= new LinkedHashMap<Integer,Object>();
	private static Map<Integer,Object> originValue;
	private static Map<Integer,Object> techAffectedValue;
	private static Map<Integer,Object> priorityValue;
	private static Map<Integer,Object> locationValue;
	private static Map<Integer,Object> impactLevelValue;
	private static Map<Integer,Object> unitValue;
	private static Map<Integer,Object> urgencyValue;
	private static Map<Integer,Object> reminderValue;
	private static Map<Integer,Object> closeReasonValue;
	
	private Date occuranceDate= new Date();
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
	private String selectedStatus;
	private int incidentNo;
	List<SimilarSolutionView> similarSolutionList = new ArrayList<>();
	List<IncidentProgressView> progressList = new ArrayList<>();
	String impactUrCode=null;
	
	private int selectedLocId;
	private int selectedIncidentTy;
	private int selectedIncSub;
	private int selectedTechId;
	private int selectedOriginId;
	
	private String assignBtnActive="N";
	private String closeIncBtnActive="N";
	List<UnitAssignHistoryView> unitAssignList = null;
	
	private int irtRegion;
	public AssignIncidentService() {
		super();
		// TODO Auto-generated constructor stub
		setIsNew("I");
		System.out.println(" --- form load ----"+getIsNew());
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


	public int getLoggedUserRegionId() {
		HttpSession session = SessionUtils.getSession();
		if(session != null){
			loggedUserRegionId=(Integer) session.getAttribute("regionId"); 
		}
		return loggedUserRegionId;
	}

	public void setLoggedUserRegionId( int loggedUserRegionId) {
		this.loggedUserRegionId = loggedUserRegionId;
	}

	public void setLoggedUserUnitId(String loggedUserUnitId) {
		this.loggedUserUnitId = loggedUserUnitId;
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

	
	public UnitDAO getUnitDAO() {
		return unitDAO;
	}

	public void setUnitDAO(UnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}

	
	public TeamMemberViewDAO getTeamMemberViewDAO() {
		return teamMemberViewDAO;
	}

	public void setTeamMemberViewDAO(TeamMemberViewDAO teamMemberViewDAO) {
		this.teamMemberViewDAO = teamMemberViewDAO;
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

	public IrtImpactLevelDAO getIrtImpactLevelDAO() {
		return irtImpactLevelDAO;
	}

	public void setIrtImpactLevelDAO(IrtImpactLevelDAO irtImpactLevelDAO) {
		this.irtImpactLevelDAO = irtImpactLevelDAO;
	}

	public IrtCloseReasonDAO getIrtCloseReasonDAO() {
		return irtCloseReasonDAO;
	}

	public void setIrtCloseReasonDAO(IrtCloseReasonDAO irtCloseReasonDAO) {
		this.irtCloseReasonDAO = irtCloseReasonDAO;
	}

	public IrtReminderDAO getIrtReminderDAO() {
		return irtReminderDAO;
	}

	public void setIrtReminderDAO(IrtReminderDAO irtReminderDAO) {
		this.irtReminderDAO = irtReminderDAO;
	}

	public IrtUrgencyDAO getIrtUrgencyDAO() {
		return irtUrgencyDAO;
	}

	public void setIrtUrgencyDAO(IrtUrgencyDAO irtUrgencyDAO) {
		this.irtUrgencyDAO = irtUrgencyDAO;
	}

	

	public static void setIncidentTypeValue(Map<Integer, Object> incidentTypeValue) {
		AssignIncidentService.incidentTypeValue = incidentTypeValue;
	}

	public static Map<Integer, Object> getIncidentSubTypeValue() {
		return incidentSubTypeValue;
	}

	public static void setIncidentSubTypeValue(Map<Integer, Object> incidentSubTypeValue) {
		AssignIncidentService.incidentSubTypeValue = incidentSubTypeValue;
	}

	public static Map<Integer, Object> getOriginValue() {
		return originValue;
	}

	public static void setOriginValue(Map<Integer, Object> originValue) {
		AssignIncidentService.originValue = originValue;
	}

	public static Map<Integer, Object> getTechAffectedValue() {
		return techAffectedValue;
	}

	public static void setTechAffectedValue(Map<Integer, Object> techAffectedValue) {
		AssignIncidentService.techAffectedValue = techAffectedValue;
	}

	public static Map<Integer, Object> getPriorityValue() {
		return priorityValue;
	}

	public static void setPriorityValue(Map<Integer, Object> priorityValue) {
		AssignIncidentService.priorityValue = priorityValue;
	}

	public static Map<Integer, Object> getLocationValue() {
		return locationValue;
	}

	public static void setLocationValue(Map<Integer, Object> locationValue) {
		AssignIncidentService.locationValue = locationValue;
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

	public int getSelectedid() {
		return selectedid;
	}

	public void setSelectedid(int selectedid) {
		this.selectedid = selectedid;
	}

	public IrtIncidentTxnDAO getIrtIncidentTxnDAO() {
		return irtIncidentTxnDAO;
	}

	public void setIrtIncidentTxnDAO(IrtIncidentTxnDAO irtIncidentTxnDAO) {
		this.irtIncidentTxnDAO = irtIncidentTxnDAO;
	}

	public IrtImpactUrgencyDAO getIrtImpactUrgencyDAO() {
		return irtImpactUrgencyDAO;
	}

	public void setIrtImpactUrgencyDAO(IrtImpactUrgencyDAO irtImpactUrgencyDAO) {
		this.irtImpactUrgencyDAO = irtImpactUrgencyDAO;
	}

	public UnitAssignHistoryViewDAO getUnitAssignHistoryViewDAO() {
		return unitAssignHistoryViewDAO;
	}

	public void setUnitAssignHistoryViewDAO(UnitAssignHistoryViewDAO unitAssignHistoryViewDAO) {
		this.unitAssignHistoryViewDAO = unitAssignHistoryViewDAO;
	}

	public List<UnitAssignHistoryView> getUnitAssignList() {
		return unitAssignList;
	}

	public void setUnitAssignList(List<UnitAssignHistoryView> unitAssignList) {
		this.unitAssignList = unitAssignList;
	}

	public SimilarSolutionDAO getSimilarSolutionDAO() {
		return similarSolutionDAO;
	}

	public void setSimilarSolutionDAO(SimilarSolutionDAO similarSolutionDAO) {
		this.similarSolutionDAO = similarSolutionDAO;
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
		
		
		public  Map<Integer, Object> getImpactLevelValue() {
			impactLevelValue = new LinkedHashMap<Integer,Object>();
			 List<IrtImpactLevel> a= irtImpactLevelDAO.listAllIrtImpactLevels();
			 for(IrtImpactLevel x:a){
				 impactLevelValue.put(x.getId(), x.getImpactLvlName());
			 }
			 
		     
			return impactLevelValue;
		}

		

		public  Map<Integer, Object> getUnitValue() {
			unitValue = new LinkedHashMap<Integer,Object>();
			 List<Unit> a= unitDAO.listUnits();
			 for(Unit x:a){
				 unitValue.put(x.getId(), x.getUnitName());
			 }
			 
		    
			return unitValue;
		}

		

		public  Map<Integer, Object> getUrgencyValue() {
			urgencyValue = new LinkedHashMap<Integer,Object>();
			 List<IrtUrgency> a= irtUrgencyDAO.listAllUrgendyCodes();
			 for(IrtUrgency x:a){
				 urgencyValue.put(x.getId(), x.getUrgencyName());
			 }
			return urgencyValue;
		}

	

		public  Map<Integer, Object> getReminderValue() {
			reminderValue = new LinkedHashMap<Integer,Object>();
			 List<IrtReminder> a= irtReminderDAO.listAllReminders();
			 for(IrtReminder x:a){
				 reminderValue.put(x.getId(), x.getRemName());
			 }
			return reminderValue;
		}

		

		public  Map<Integer, Object> getCloseReasonValue() {
			closeReasonValue = new LinkedHashMap<Integer,Object>();
			 List<IrtCloseReason> a= irtCloseReasonDAO.listAllIrtCloseReason();
			 for(IrtCloseReason x:a){
				 closeReasonValue.put(x.getId(), x.getCloseReason());
			 }
			return closeReasonValue;
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

		public String getReminder() {
			return reminder;
		}

		public void setReminder(String reminder) {
			this.reminder = reminder;
		}

		public String getCloseReason() {
			return closeReason;
		}

		public void setCloseReason(String closeReason) {
			this.closeReason = closeReason;
		}

		
		public String getUnitName() {
			return unitName;
		}

		public void setUnitName(String unitName) {
			this.unitName = unitName;
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

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public FaqDAO getFaqDAO() {
			return faqDAO;
		}

		public void setFaqDAO(FaqDAO faqDAO) {
			this.faqDAO = faqDAO;
		}

		
		public List<IncidentProgressView> getProgressList() {
			return progressList;
		}

		public void setProgressList(List<IncidentProgressView> progressList) {
			this.progressList = progressList;
		}

		
		public List<SimilarSolutionView> getSimilarSolutionList() {
			return similarSolutionList;
		}

		public void setSimilarSolutionList(List<SimilarSolutionView> similarSolutionList) {
			this.similarSolutionList = similarSolutionList;
		}

		public UnitMemberTxnDAO getUnitMemberTxnDAO() {
			return unitMemberTxnDAO;
		}

		public void setUnitMemberTxnDAO(UnitMemberTxnDAO unitMemberTxnDAO) {
			this.unitMemberTxnDAO = unitMemberTxnDAO;
		}

		public String getAssignBtnActive() {
			return assignBtnActive;
		}

		public String getCloseIncBtnActive() {
			return closeIncBtnActive;
		}

		public void setCloseIncBtnActive(String closeIncBtnActive) {
			this.closeIncBtnActive = closeIncBtnActive;
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
			selectedStatus=null;
			unitName=null;
			impactLevel=null;
			urgency=null;
			reminder=null;
			closeReason=null;
			workingDays=null;
			hours=null;
			minutes=null;
			comments=null;
	    
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
			selectedStatus=null;
			unitName=null;
			impactLevel=null;
			urgency=null;
			reminder=null;
			closeReason=null;
			workingDays=null;
			hours=null;
			minutes=null;
			comments=null;
	    	setIsNew("I");
	  
	    }
	
		
		 public List<TempIncidentTxn> listAllIncidents() {
			 
			 irtRegion=getLoggedUserRegionId() ;
			 // List<IncidentDetailView>mList=incidentDetailViewDAO.getIncidentDetailByRegion(irtRegion);
			  List<TempIncidentTxn> incList = new ArrayList<TempIncidentTxn>(); 
			  List<IrtIncidentDetailView> mList=incidentTxnDAO.listAllIncidentsByRegion(irtRegion);
			  for(IrtIncidentDetailView c:mList){
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
		 
		 public void getIncidentDataByID(int id) throws Exception{
			 	cancel();
				IncidentTxn in=incidentTxnDAO.getIncidentById(id);
				setTitle(in.getTitle());
				setAffectedProcess(in.getAtUnitProcess());
				setDescription(in.getDescription());
				setPriorityLevel(Integer.toString(in.getPriorityId()));
				setLocation(Integer.toString(in.getIncLocationId()));
				
				setTypeName(Integer.toString(in.getIncTypeId()));
				setSubTypeName(Integer.toString(in.getIncSubTypeId()));
				setTechAffect(Integer.toString(in.getTechId()));
				setLocationDetail(in.getIncLocDetail());
				setOrigin(Integer.toString(in.getOriginId()));
				setReportedBySno(in.getReportedBy());
				valueChangeServiceNo();
				setWorkEmail(in.getEmail());
				setWorkPhone(in.getPhone());
				setOccuranceDate(in.getCreatedDate());
				selectedStatus = in.getStatus();
				
				incidentNo = in.getId();
				selectedIncSub=in.getIncSubTypeId();
				selectedIncidentTy=in.getIncTypeId();
				selectedLocId=in.getIncLocationId();
				selectedTechId=in.getTechId();
				selectedOriginId=in.getOriginId();
				
				List<IrtIncidentTxn> ir=	irtIncidentTxnDAO.getIRTIncidentByIncidentNo(incidentNo);
				for(IrtIncidentTxn c:ir){
					List<IrtImpactUrgency> x=irtImpactUrgencyDAO.getDataByImpactUrgencyCode(c.getImpactUrgCode());
					for(IrtImpactUrgency s:x){
						
						List<IrtImpactLevel> g=irtImpactLevelDAO.getDataByImpactCode(s.getImpactLevel());
						for(IrtImpactLevel im:g){
							setImpactLevel(Integer.toString(im.getId()));
						}
						List<IrtUrgency> v=irtUrgencyDAO.getDataByUrgencyCode(s.getUrgency());
						for(IrtUrgency ur:v){
							
							setUrgency(Integer.toString(ur.getId()));
						}
						setWorkingDays(Integer.toString(s.getDays()));
						setHours(Integer.toString(s.getHours()));
						setMinutes(Integer.toString(s.getMinutes()));
					}
					setComments("");
					
					setUnitName(c.getAssignedUnit());
					setReminder(c.getIrtReminder());
				}
				setAssignBtnActive(selectedStatus);
				setCloseBtnActive(selectedStatus);
				loadSimilarSolutions();
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
		 
			public List<IncidentProgressView> progress(int id){
				
		    	setIsNew("P");
		    	System.out.println(" incident no ==== "+id);
		    	
		    	try{
		    		progressList=incidentProgressViewDAO.getIncidentProgressByIncidentNo(id);
		    	}catch(Exception ex){
				   	
		    		System.out.println(" error ==== "+ex.getMessage());
			   	}
				return progressList;
		    }
			
			public List<SimilarSolutionView> loadSimilarSolutions(){
				similarSolutionList.clear();
				String incidentType=getTypeName();
				String incidentSubType=getSubTypeName();
				System.out.println(incidentType+" -- selected incident type --"+incidentSubType);
				try{
					similarSolutionList=similarSolutionDAO.getSmByIncidentType(incidentType, incidentSubType);
					
		    	}catch(Exception ex){
				   	
		    		System.out.println(" error ==== "+ex.getMessage());
			   	}
				return similarSolutionList;
				
			}
			
			public void getAssignedHistory(){
				
				String incidentType=getTypeName();
				
				System.out.println(incidentType+" -- selected incident type --");
				
			}
			
			public void assigneIncident(){
				System.out.println(selectedid+" -- selected incident status --"+impactUrCode);
				
				String message=null;
				IncidentTxn incid=new IncidentTxn();
				IrtIncidentTxn txn=new IrtIncidentTxn();
			//	UnitMemberTxn uMemTxn =new UnitMemberTxn();
				Notification notf=new Notification();
				try{	
				List<IrtIncidentTxn> ir=	irtIncidentTxnDAO.getIRTIncidentByIncidentNo(incidentNo);
				for(IrtIncidentTxn c:ir){
					selectedid = c.getId();
				}
				Unit ut=unitDAO.getUnitByCode(Integer.parseInt(unitName));
				txn.setAssignedUnit(unitName);
				txn.setIncidentNo(incidentNo);
				txn.setIrtReminder(getReminder());
				txn.setImpactUrgCode(impactUrCode);
				txn.setRepeatingStatus("IW");
				txn.setCreatedDate(new Date());
				txn.setModifiedDate(new Date());
				
				
				List<TeamMemberView> team=teamMemberViewDAO.getTeamMemberByUnitCode(Integer.parseInt(unitName));
				int y=irtIncidentTxnDAO.getRecordCount(selectedid);
				
			
				incid.setId(incidentNo);
				incid.setStatus("PWU");
				
				incid.setTitle(getTitle());
				incid.setReportedBy(getReportedBySno());
				incid.setPriorityId(Integer.parseInt(getPriorityLevel()));
				incid.setIncLocationId(selectedLocId);
				incid.setIncTypeId(selectedIncidentTy);
				incid.setIncSubTypeId(selectedIncSub);
				incid.setTechId(selectedTechId);
				incid.setAtUnitProcess(getAffectedProcess());
				incid.setEmail(getWorkEmail());
				incid.setDescription(getDescription());
				incid.setPhone(getWorkPhone());
				incid.setIncLocDetail(getLocationDetail());
				incid.setOriginId(selectedOriginId);
				incid.setOccuranceDate(getOccuranceDate());
				incid.setCreatedBy(getReportedBySno());
				incid.setCreatedDate(getOccuranceDate());
				incid.setModifiedDate(new Date());
				incid.setModifiedBy(getLoggedUser());
				if(selectedStatus.equals("INITIAL")){
					if(y == 0){
						txn.setCreatedBy(getLoggedUser());
						irtIncidentTxnDAO.assignIncidentToUnit(txn);
//						unitMemberTxnDAO.addToUnitMemberTxn(uMemTxn);
						//incidentTxnDAO.updateIncidentStatus(incid.getId(),incid.getStatus());
						incidentTxnDAO.updateIncident(incid);
						for(TeamMemberView tm:team){
							notf.setNotificationText("Incident"+ incidentNo +"is assigned to :"+ut.getUnitName());
							notf.setModuleId(0);
							notf.setRefId(incidentNo);
							notf.setServiceNo(getLoggedUser());
							notf.setUserId(getLoggedUser());
							notf.setNotificationDate(new Date());
							notf.setNotifiTarget(tm.getEmp_id());
							notificationDAO.addNotification(notf);
						}
						
					}else{
						Date modifiedDate= new Date();
						txn.setId(selectedid);
						txn.setModifiedDate(modifiedDate);
						
						irtIncidentTxnDAO.updateAssignIncidentToUnit(txn);
					}
					
				}else {
					Date modifiedDate= new Date();
					txn.setId(selectedid);
					txn.setModifiedDate(modifiedDate);
					
					irtIncidentTxnDAO.updateAssignIncidentToUnit(txn);
				}
				message = "Incident Information is assigned Successfully.";
				}catch(Exception ex){
		    		message = "Incident Information is NOT assigned Successfully.";
		    		
		    	}
		    	setIsNew("I");
		    
		    	FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
				
			}
			
			public void valueChangeImpactCodeUrgency(){
			
				if(getImpactLevel() != null && getUrgency() != null){
					IrtImpactLevel	imp=irtImpactLevelDAO.getImpactLevelData(Integer.parseInt(getImpactLevel()));	
					IrtUrgency ur=irtUrgencyDAO.getUrgencyData(Integer.parseInt(getUrgency()));
					List<IrtImpactUrgency> x=irtImpactUrgencyDAO.getImpactUrgencyCode(imp.getImpactLvlCode(), ur.getUrgencyCode());
						for(IrtImpactUrgency v:x){
							impactUrCode=v.getImpUrgencyCode();
							setWorkingDays(Integer.toString(v.getDays()));
							setHours(Integer.toString(v.getHours()));
							setMinutes(Integer.toString(v.getMinutes()));
						}
				}
			}
			
			public void closeIncident(){
				String message=null;
				System.out.println(closeReason+" -- selected incident close --");
				
					if((closeReason == null)|| (closeReason.isEmpty()) ){
								message = "Close reason can not be blank.";
								FacesContext.getCurrentInstance().addMessage(
										null,
										new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
					}else{
						try{
							
							Date closedDate= new Date();
							Notification notf=new Notification();
							IncidentTxn incid=new IncidentTxn();
							incid.setId(incidentNo);
							incid.setStatus("CBI");
							incid.setIrtCloseReasonId(closeReason);
							incid.setModifiedBy(getLoggedUser());
							incid.setModifiedDate(closedDate);
							incid.setTitle(getTitle());
							incid.setReportedBy(getReportedBySno());
							incid.setPriorityId(Integer.parseInt(getPriorityLevel()));
							incid.setIncLocationId(selectedLocId);
							incid.setIncTypeId(selectedIncidentTy);
							incid.setIncSubTypeId(selectedIncSub);
							incid.setTechId(selectedTechId);
							incid.setAtUnitProcess(getAffectedProcess());
							incid.setEmail(getWorkEmail());
							incid.setDescription(getDescription());
							incid.setPhone(getWorkPhone());
							incid.setIncLocDetail(getLocationDetail());
							incid.setOriginId(selectedOriginId);
							incid.setOccuranceDate(getOccuranceDate());
							incid.setCreatedBy(getReportedBySno());
							incid.setCreatedDate(getOccuranceDate());
							
							notf.setNotificationDate(new Date());
							notf.setRefId(incidentNo);
							notf.setNotifiTarget(reportedBySno);
							notf.setNotificationText("Incident "+ incidentNo +"is closed at IRT level by :"+getLoggedUser());
							notf.setServiceNo(getLoggedUser());
							notf.setUserId(getLoggedUser());
							
							incidentTxnDAO.updateIncident(incid);
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
				}
			  
			public String setAssignBtnActive(String selectedStatus){
				
		        if ("CBI".equals(selectedStatus) || "OH".equals(selectedStatus) ||
		                "PWM".equals(selectedStatus) || "RBI".equals(selectedStatus) ||
		                "RSLV".equals(selectedStatus) || "PWU".equals(selectedStatus) ||
		                "RBE".equals(selectedStatus) || "FBI".equals(selectedStatus) || 
		                "RBU".equals(selectedStatus) || "CBU".equals(selectedStatus) || 
		                "CBE".equals(selectedStatus)) {
		        			assignBtnActive ="N";

		            } else {
		            	assignBtnActive ="Y";
		            }
				
				return assignBtnActive;
				
				
			}
			public String setCloseBtnActive(String selectedStatus){
				
	        if ("CBI".equals(selectedStatus) || "OH".equals(selectedStatus) ||
	                "PWM".equals(selectedStatus) || "CBE".equals(selectedStatus) ||
	                "CBU".equals(selectedStatus) || "PWU".equals(selectedStatus) ||
	                "RBI".equals(selectedStatus) || "FBI".equals(selectedStatus) ) {
	                closeIncBtnActive="N";
	            } else {
	            	closeIncBtnActive= "Y";

	            }
			return closeIncBtnActive;
			}
			
			public List<UnitAssignHistoryView> unitAssignHistory(){
				
		 		if(incidentNo > 0){
		 			try{
	 					unitAssignList=unitAssignHistoryViewDAO.getUnitAssignHisByIncidentNo(incidentNo);
	 					
	 		    	}catch(Exception ex){
	 				   	
	 		    		unitAssignList=null;
	 			   	}
		 			
		 		}
		 				
		 		return unitAssignList;
				
			}
	
}
