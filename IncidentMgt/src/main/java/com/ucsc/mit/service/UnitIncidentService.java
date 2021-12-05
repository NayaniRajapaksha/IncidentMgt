package com.ucsc.mit.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Service;

import com.ucsc.mit.common.EmailRequest;
import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.BranchDAO;
import com.ucsc.mit.dao.DependencyDAO;
import com.ucsc.mit.dao.EmployeeDAO;
import com.ucsc.mit.dao.EmployeeDetaliViewDAO;
import com.ucsc.mit.dao.FaqDAO;
import com.ucsc.mit.dao.IncidentDetailViewDAO;
import com.ucsc.mit.dao.IncidentProgressViewDAO;
import com.ucsc.mit.dao.IncidentStatusDAO;
import com.ucsc.mit.dao.IncidentSubTypeDAO;
import com.ucsc.mit.dao.IncidentTxnDAO;
import com.ucsc.mit.dao.IncidentTypeDAO;
import com.ucsc.mit.dao.IncidentUnitMemberViewDAO;
import com.ucsc.mit.dao.IrtCloseReasonDAO;
import com.ucsc.mit.dao.IrtImpactLevelDAO;
import com.ucsc.mit.dao.IrtImpactUrgencyDAO;
import com.ucsc.mit.dao.IrtIncidentTxnDAO;
import com.ucsc.mit.dao.IrtReminderDAO;
import com.ucsc.mit.dao.IrtUrgencyDAO;
import com.ucsc.mit.dao.NotificationDAO;
import com.ucsc.mit.dao.OriginDAO;
import com.ucsc.mit.dao.PriorotyDAO;
import com.ucsc.mit.dao.TeamMemberViewDAO;
import com.ucsc.mit.dao.TechAffectedAreaDAO;
import com.ucsc.mit.dao.UnitAssignHistoryViewDAO;
import com.ucsc.mit.dao.UnitCloseReasonDAO;
import com.ucsc.mit.dao.UnitDAO;
import com.ucsc.mit.dao.UnitMemberDAO;
import com.ucsc.mit.dao.UnitMemberTxnDAO;
import com.ucsc.mit.dao.VendorDAO;
import com.ucsc.mit.dao.VendorInformDetTxnDAO;
import com.ucsc.mit.model.Dependency;
import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.EmployeeDetailView;
import com.ucsc.mit.model.Faq;
import com.ucsc.mit.model.IncidentDetailView;
import com.ucsc.mit.model.IncidentProgressView;
import com.ucsc.mit.model.IncidentStatus;
import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.IncidentTxn;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.IncidentUnitMemberView;
import com.ucsc.mit.model.IrtImpactUrgency;
import com.ucsc.mit.model.IrtIncidentTxn;
import com.ucsc.mit.model.Notification;
import com.ucsc.mit.model.Origin;
import com.ucsc.mit.model.Priority;
import com.ucsc.mit.model.TeamMemberView;
import com.ucsc.mit.model.TempIncidentTxn;
import com.ucsc.mit.model.Unit;
import com.ucsc.mit.model.UnitAssignHistoryView;
import com.ucsc.mit.model.UnitCloseReason;
import com.ucsc.mit.model.UnitMember;
import com.ucsc.mit.model.UnitMemberTxn;
import com.ucsc.mit.model.Vendor;
import com.ucsc.mit.model.VendorInformDetTxn;

@Service
@ManagedBean(name="unitIncidentService")
@SessionScoped
public class UnitIncidentService {
	private Date today = new Date();
	
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
	private UnitDAO unitDAO;
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
	private IncidentDetailViewDAO incidentDetailViewDAO;
	private UnitMemberDAO unitMemberDAO;
	private IncidentStatusDAO incidentStatusDAO;
	private TeamMemberViewDAO teamMemberViewDAO;
	private EmployeeDetaliViewDAO employeeDetaliViewDAO;
	private DependencyDAO dependencyDAO;
	private VendorDAO vendorDAO;
	private UnitAssignHistoryViewDAO unitAssignHistoryViewDAO;
	private VendorInformDetTxnDAO vendorInformDetTxnDAO;
	private IncidentUnitMemberViewDAO incidentUnitMemberViewDAO;
	private String typeName;
	private String subTypeName;
	private String priorityLevel;
	private String priorityId;
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
	private Date occuranceDate= today;
	private String title;
	private String affectedProcess;
	private String description;
	private String locationDetail;
	private String reportedBySno;
	private String reportedByName;
	private String aWorkingDays;
	private String aHours;
	private String aMinutes;
	private int selectedid;
	private String selectedStatus;
	private int incidentNo;
	List<Faq> similarSolutionList = new ArrayList<>();
	String impactUrCode=null;
	private String assignMember;
	private String incidentCat="A";
	private static Map<Integer,Object> unitMemberValue;
	private static Map<Integer,Object> incidentStatusValue;
	private static Map<Integer,Object> priorityValue;
	private static Map<Integer,Object> unitValue;
	private static Map<Integer,Object> unitCloseReasonValue;
	private static Map<Integer,Object> vendorValue;
	private Date responseDate= today;
	private Date vInformDate= today;
	private Date statusUpDate= today;
	private int pendingICount=0;
	private int pendingDCount=0;
	private int unitId;
	private String currentStatus;
	private String rootCause;
	private String actionTaken;
	
	private String depdPriority;
	private String depdUnit;
	private String dWorkingDays;
	private String dHours;
	private String dMinutes;
	private String depdDes;
	List<IncidentProgressView> progressList = null;
	private String  uRollbackReason;
	private String  iRollbackReason;
	private String  rollbackUnit;
	private int irtId;
	private int region_id;
	private int inc_location_id;
	
	private int incTypeId;
	private int incSubTypeId;
	private int incAffectedAreaId;
	private String incEmail;
	private String incPhone;
	
	private String vName;
	private String vEmail;
	private String vSubject;
	private String vContent;
	
	private String incidentCStatus ="I";
	private String incActionVisibility ="N";
	private String disabledAction ="N";
	private String visibleAction ="Y";
	List<UnitAssignHistoryView> unitAssignList = null;

	List<IncidentDetailView> incList=new ArrayList<IncidentDetailView>();
	
    private String updatTime = null;
    private String assignTime = null;
    private int remainTime = 0;
    private Date finishTime = null;
    private int targetTime = 0;
    private String tgtPeriod = null;
    private String remPeriod = null;
	public UnitIncidentService() {
		super();
		isNew="I";
		// TODO Auto-generated constructor stub
	}
	
	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public Date getvInformDate() {
		return vInformDate;
	}

	public void setvInformDate(Date vInformDate) {
		this.vInformDate = vInformDate;
	}

	public Date getStatusUpDate() {
		return statusUpDate;
	}

	public void setStatusUpDate(Date statusUpDate) {
		this.statusUpDate = statusUpDate;
	}

	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
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

	public String getLoggedUser() {
		HttpSession session = SessionUtils.getSession();
		if(session != null){
			loggedUser=(String) session.getAttribute("username"); 
		}
		return loggedUser;
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
	public FaqDAO getFaqDAO() {
		return faqDAO;
	}
	public void setFaqDAO(FaqDAO faqDAO) {
		this.faqDAO = faqDAO;
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
	public UnitMemberTxnDAO getUnitMemberTxnDAO() {
		return unitMemberTxnDAO;
	}
	public void setUnitMemberTxnDAO(UnitMemberTxnDAO unitMemberTxnDAO) {
		this.unitMemberTxnDAO = unitMemberTxnDAO;
	}
	public IncidentDetailViewDAO getIncidentDetailViewDAO() {
		return incidentDetailViewDAO;
	}
	public void setIncidentDetailViewDAO(IncidentDetailViewDAO incidentDetailViewDAO) {
		this.incidentDetailViewDAO = incidentDetailViewDAO;
	}
	
	public UnitMemberDAO getUnitMemberDAO() {
		return unitMemberDAO;
	}

	public void setUnitMemberDAO(UnitMemberDAO unitMemberDAO) {
		this.unitMemberDAO = unitMemberDAO;
	}

	public IncidentStatusDAO getIncidentStatusDAO() {
		return incidentStatusDAO;
	}

	public void setIncidentStatusDAO(IncidentStatusDAO incidentStatusDAO) {
		this.incidentStatusDAO = incidentStatusDAO;
	}

	public TeamMemberViewDAO getTeamMemberViewDAO() {
		return teamMemberViewDAO;
	}

	public void setTeamMemberViewDAO(TeamMemberViewDAO teamMemberViewDAO) {
		this.teamMemberViewDAO = teamMemberViewDAO;
	}

	public EmployeeDetaliViewDAO getEmployeeDetaliViewDAO() {
		return employeeDetaliViewDAO;
	}

	public void setEmployeeDetaliViewDAO(EmployeeDetaliViewDAO employeeDetaliViewDAO) {
		this.employeeDetaliViewDAO = employeeDetaliViewDAO;
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

	public UnitAssignHistoryViewDAO getUnitAssignHistoryViewDAO() {
		return unitAssignHistoryViewDAO;
	}

	public void setUnitAssignHistoryViewDAO(UnitAssignHistoryViewDAO unitAssignHistoryViewDAO) {
		this.unitAssignHistoryViewDAO = unitAssignHistoryViewDAO;
	}

	public VendorInformDetTxnDAO getVendorInformDetTxnDAO() {
		return vendorInformDetTxnDAO;
	}

	public void setVendorInformDetTxnDAO(VendorInformDetTxnDAO vendorInformDetTxnDAO) {
		this.vendorInformDetTxnDAO = vendorInformDetTxnDAO;
	}

	public IncidentUnitMemberViewDAO getIncidentUnitMemberViewDAO() {
		return incidentUnitMemberViewDAO;
	}

	public void setIncidentUnitMemberViewDAO(IncidentUnitMemberViewDAO incidentUnitMemberViewDAO) {
		this.incidentUnitMemberViewDAO = incidentUnitMemberViewDAO;
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

	

	public String getaWorkingDays() {
		return aWorkingDays;
	}

	public void setaWorkingDays(String aWorkingDays) {
		this.aWorkingDays = aWorkingDays;
	}

	public String getaHours() {
		return aHours;
	}

	public void setaHours(String aHours) {
		this.aHours = aHours;
	}

	public String getaMinutes() {
		return aMinutes;
	}

	public void setaMinutes(String aMinutes) {
		this.aMinutes = aMinutes;
	}

	public int getSelectedid() {
		return selectedid;
	}

	public void setSelectedid(int selectedid) {
		this.selectedid = selectedid;
	}

	public String getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	public int getIncidentNo() {
		return incidentNo;
	}

	public void setIncidentNo(int incidentNo) {
		this.incidentNo = incidentNo;
	}

	public int getIrtId() {
		return irtId;
	}

	public void setIrtId(int irtId) {
		this.irtId = irtId;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public int getInc_location_id() {
		return inc_location_id;
	}

	public void setInc_location_id(int inc_location_id) {
		this.inc_location_id = inc_location_id;
	}

	public String getRollbackUnit() {
		return rollbackUnit;
	}

	public void setRollbackUnit(String rollbackUnit) {
		this.rollbackUnit = rollbackUnit;
	}

	public List<Faq> getSimilarSolutionList() {
		return similarSolutionList;
	}

	public void setSimilarSolutionList(List<Faq> similarSolutionList) {
		this.similarSolutionList = similarSolutionList;
	}

	public String getImpactUrCode() {
		return impactUrCode;
	}

	public void setImpactUrCode(String impactUrCode) {
		this.impactUrCode = impactUrCode;
	}

	public static Map<Integer, Object> getUnitMemberValue() {
		return unitMemberValue;
	}

	public static void setUnitMemberValue(Map<Integer, Object> unitMemberValue) {
		UnitIncidentService.unitMemberValue = unitMemberValue;
	}

	public static Map<Integer, Object> getIncidentStatusValue() {
		return incidentStatusValue;
	}

	public static void setIncidentStatusValue(Map<Integer, Object> incidentStatusValue) {
		UnitIncidentService.incidentStatusValue = incidentStatusValue;
	}

	public static Map<Integer, Object> getPriorityValue() {
		return priorityValue;
	}

	public static void setPriorityValue(Map<Integer, Object> priorityValue) {
		UnitIncidentService.priorityValue = priorityValue;
	}

	public static Map<Integer, Object> getUnitValue() {
		return unitValue;
	}

	public static void setUnitValue(Map<Integer, Object> unitValue) {
		UnitIncidentService.unitValue = unitValue;
	}

	public String getAssignMember() {
		return assignMember;
	}

	public void setAssignMember(String assignMember) {
		this.assignMember = assignMember;
	}

	public String getIncidentCat() {
		return incidentCat;
	}

	public void setIncidentCat(String incidentCat) {
		this.incidentCat = incidentCat;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}
	

	public int getPendingICount() {
		return pendingICount;
	}

	public void setPendingICount(int pendingICount) {
		this.pendingICount = pendingICount;
	}

	public int getPendingDCount() {
		return pendingDCount;
	}

	public void setPendingDCount(int pendingDCount) {
		this.pendingDCount = pendingDCount;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getDepdPriority() {
		return depdPriority;
	}

	public void setDepdPriority(String depdPriority) {
		this.depdPriority = depdPriority;
	}

	public String getDepdUnit() {
		return depdUnit;
	}

	public void setDepdUnit(String depdUnit) {
		this.depdUnit = depdUnit;
	}

	public String getdWorkingDays() {
		return dWorkingDays;
	}

	public void setdWorkingDays(String dWorkingDays) {
		this.dWorkingDays = dWorkingDays;
	}

	public String getdHours() {
		return dHours;
	}

	public void setdHours(String dHours) {
		this.dHours = dHours;
	}

	public String getdMinutes() {
		return dMinutes;
	}

	public void setdMinutes(String dMinutes) {
		this.dMinutes = dMinutes;
	}

	public String getDepdDes() {
		return depdDes;
	}

	public void setDepdDes(String depdDes) {
		this.depdDes = depdDes;
	}

	public String getuRollbackReason() {
		return uRollbackReason;
	}

	public void setuRollbackReason(String uRollbackReason) {
		this.uRollbackReason = uRollbackReason;
	}

	public String getiRollbackReason() {
		return iRollbackReason;
	}

	public void setiRollbackReason(String iRollbackReason) {
		this.iRollbackReason = iRollbackReason;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvEmail() {
		return vEmail;
	}

	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}

	public String getvSubject() {
		return vSubject;
	}

	public void setvSubject(String vSubject) {
		this.vSubject = vSubject;
	}

	public String getvContent() {
		return vContent;
	}

	public void setvContent(String vContent) {
		this.vContent = vContent;
	}

	public static Map<Integer, Object> getUnitCloseReasonValue() {
		return unitCloseReasonValue;
	}

	public static void setUnitCloseReasonValue(Map<Integer, Object> unitCloseReasonValue) {
		UnitIncidentService.unitCloseReasonValue = unitCloseReasonValue;
	}

	public static Map<Integer, Object> getVendorValue() {
		return vendorValue;
	}

	public static void setVendorValue(Map<Integer, Object> vendorValue) {
		UnitIncidentService.vendorValue = vendorValue;
	}

	public String getIncidentCStatus() {
		return incidentCStatus;
	}

	public void setIncidentCStatus(String incidentCStatus) {
		this.incidentCStatus = incidentCStatus;
	}

	public String getIncActionVisibility() {
		return incActionVisibility;
	}

	public void setIncActionVisibility(String incActionVisibility) {
		this.incActionVisibility = incActionVisibility;
	}

	public String getDisabledAction() {
		return disabledAction;
	}

	public String getVisibleAction() {
		return visibleAction;
	}

	public void setVisibleAction(String visibleAction) {
		this.visibleAction = visibleAction;
	}

	public List<IncidentDetailView> getIncList() {
		return incList;
	}

	public void setIncList(List<IncidentDetailView> incList) {
		this.incList = incList;
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
	

	
	public Map<Integer,Object> getIncidentStatusValues() {
		incidentStatusValue = new LinkedHashMap<Integer,Object>();
		List<IncidentStatus> a= incidentStatusDAO.getIncidentStatusForIncidentAction();
		 for(IncidentStatus x:a){
			 incidentStatusValue.put(x.getId(), x.getStatus_des());
		 }
		 
	     return incidentStatusValue;
	} 
	
	public Map<Integer,Object> getPriorityLevelValues() {
		priorityValue = new LinkedHashMap<Integer,Object>();
		 List<Priority> a= priorotyDAO.getPriorityLevels();
		 for(Priority x:a){
			 priorityValue.put(x.getId(), x.getPriorityName());
		 }
		 
	     return priorityValue;
	}
	
	public  Map<Integer, Object> getUnitListValue() {
		unitValue = new LinkedHashMap<Integer,Object>();
		 List<Unit> a= unitDAO.listUnits();
		 for(Unit x:a){
			 unitValue.put(x.getId(), x.getUnitName());
		 }
		 
	    
		return unitValue;
	}
	public  Map<Integer, Object> getVendorListValue() {
		vendorValue = new LinkedHashMap<Integer,Object>();
		 List<Vendor> a= vendorDAO.listVendors();
		 for(Vendor x:a){
			 vendorValue.put(x.getVen_code(), x.getVen_name());
		 }
		 
	    
		return vendorValue;
	}
	public  Map<Integer, Object> getUnitCloseReasonListValue() {
		unitCloseReasonValue = new LinkedHashMap<Integer,Object>();
		 List<UnitCloseReason> a= unitCloseReasonDAO.getUnitCloseReasonList();
		 for(UnitCloseReason x:a){
			 unitCloseReasonValue.put(x.getId(), x.getReasonName());
		 }
		 
	    
		return unitCloseReasonValue;
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
	
	 public List<IncidentDetailView> listAllIncidents() {
		int unit_id=getUnitIdByUserID();
		incList.clear();
		//List<IncidentDetailView> incList=new ArrayList<IncidentDetailView>();
		if(incidentCat != null){
 			System.out.println(unit_id+"== loggedUser =="+loggedUser+" == value change =="+incidentCat);
 			if(incidentCat.equals("M")){
 				
 				incList= incidentDetailViewDAO.getIncidentDetailByAssignUser(loggedUser,unit_id);
 				
 			}else{
 				
 				incList= incidentDetailViewDAO.getIncidentDetailByUnit(unit_id);
 				
 			}
 			
 		}else{
 			
 			incList= incidentDetailViewDAO.getIncidentDetailByUnit(unit_id);
 			
 		}
		return incList;
		  
		  
	  }
	 
	 public void getIncidentDataByID(int id) throws Exception{
		// 	cancel();
		 assignMember=null;
		 closeReason=null;
		 workingDays=null;
		 hours=null;
		 minutes=null;
		 aWorkingDays=null;
		 aHours=null;
		 aMinutes=null;
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 List<IncidentDetailView> in=incidentDetailViewDAO.getIncidentDetailByIncidentNo(id);
		 
		 for(IncidentDetailView x:in){
			setTitle(x.getTitle()); 
			setAffectedProcess(x.getAfct_unit_process()); 
			setDescription(x.getDescription());
			
			setOccuranceDate(x.getOccurance_date());
			setPriorityLevel(x.getPriority_name());
			setTechAffect(x.getAfct_area_name());
			setLocation(x.getIncident_location());
			setLocationDetail(x.getInc_loc_details());
			setTypeName(x.getType_name());
			setSubTypeName(x.getSub_type_name());
			setUrgency(x.getUrgency());
			setImpactLevel(x.getImpact_level());
			setIncidentNo(id);
			setIrtId(x.getIrt_id());
			setInc_location_id(Integer.parseInt(x.getIncident_location_id()));
			priorityId=x.getPriority_id();
			origin=x.getOrigin();
			reportedBySno=x.getReported_by();
			setReportedByName(x.getReported_by());
			incTypeId = Integer.parseInt(x.getIncident_type());
			incSubTypeId = Integer.parseInt(x.getIncident_sub_type());
			incAffectedAreaId=Integer.parseInt(x.getTech_afct_area());
			incEmail=x.getEmail();
			incPhone=x.getPhone();
			reminder=x.getIrt_reminder();
			incidentNo=id;
			tgtPeriod = x.getTgt_period();
			remPeriod=x.getRem_period();
		
			targetTime =tgtPeriod!=null?Integer.parseInt(tgtPeriod):0; 
			 
			List<UnitMemberTxn> uMList=unitMemberTxnDAO.getUnitMemberTxnByIncidentNo(getIncidentNo());
			if(uMList.size()!=0){
				for(UnitMemberTxn b:uMList){
					assignTime=b.getAssignedDateTime()!=null? dateFormat.format(b.getAssignedDateTime()):null;
					updatTime =b.getUpdatedTime()!=null? dateFormat.format(b.getUpdatedTime()):null;
					getFinishTime();
					
					remainTime = getRemTime();
					setActualResTime();   
				}
			}
			if(x.getAssignee_mem_id() != null){
				List<Employee> emp=employeeDAO.getEmployeeByEmpId(x.getAssignee_mem_id());
				for(Employee d:emp){
					setAssignMember(Integer.toString(d.getId()));
					getFinishTime();
					remainTime = getRemTime();
					setActualResTime();
					if(x.getStatus() !=null){
						setDisabledAction(x.getStatus());					
						if(x.getStatus().equals("INITIAL")){
							incidentCStatus ="V";				
							visibleAction="N";
							incActionVisibility="N";
						}else if(x.getStatus().equals("PWU")){
							incidentCStatus ="V";
							visibleAction="N";
							incActionVisibility="N";
						}else{
							incidentCStatus ="I";					
							
							if(getLoggedUser().equals(x.getAssignee_mem_id())){
				        		incActionVisibility="Y";
				        		visibleAction="Y";
				        	}else{
				        		incActionVisibility="N";
				        		visibleAction="N";
				        	}
						}
						
					}
				}
			}else{
				if(x.getStatus() !=null){
					setDisabledAction(x.getStatus());
					
					if(x.getStatus().equals("INITIAL")){
						incidentCStatus ="V";				
						visibleAction="N";
						incActionVisibility="N";
					}else if(x.getStatus().equals("PWU")){
						incidentCStatus ="V";
						visibleAction="N";
						incActionVisibility="N";
					}else{
						incidentCStatus ="I";					
						visibleAction="Y";
						incActionVisibility="N";
					}
				}
				
			}
				
			
			System.out.println(getLoggedUser()+" == "+x.getAss_mem_name()+" == "+x.getAssignee_mem_id());
			
			List<IrtImpactUrgency> c=irtImpactUrgencyDAO.getImpactUrgencyCode(impactLevel, urgency);
			for(IrtImpactUrgency b:c){
				setWorkingDays(Integer.toString(b.getDays()));
				setHours(Integer.toString(b.getHours()));
				setMinutes(Integer.toString(b.getMinutes()));
				
				setdWorkingDays(Integer.toString(b.getDays()));
				setdHours(Integer.toString(b.getHours()));
				setdMinutes(Integer.toString(b.getMinutes()));
			}
		 }


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
			

			origin=null;
			updatTime = null;
		    remainTime = 0;
		    finishTime = null;
		    targetTime = 0;
		    tgtPeriod = null;
		    remPeriod = null;
		    
		    unitName=null;
		    assignMember=null;
		    pendingICount=0;
		    pendingDCount=0;
		    impactLevel=null;
		    urgency=null;
		    workingDays=null;
		    hours=null;
		    minutes=null;
		    aWorkingDays=null;
		    aHours=null;
		    aMinutes=null;
		    responseDate=today;
		    currentStatus=null;
		    statusUpDate=today;
		    rootCause=null;
		    actionTaken=null;
		    setIsNew("I");
	 }
	 
	 
	 public String dependency(){
		 
		 return "dependency";
	 }
	 
	 public void addDependecyForIncident(){
		 String message=null; 
		 try{
			 System.out.println(" incident no ==== "+getIncidentNo());
			Dependency dep=new Dependency();
			Employee emp=employeeDAO.getEmployeeById(Integer.parseInt(getAssignMember()));
		//	dep.setAssinged_member(emp.getEmpId());	
			dep.setCreated_by(getLoggedUser());	
			dep.setCreated_date(today);
			dep.setDays(Integer.parseInt(getdWorkingDays()));
		//	dep.setDepend_close_reason("");
			dep.setDependency_status("INITIAL");
			dep.setDescription(getDepdDes());
			dep.setHours(Integer.parseInt(getdHours()));
			dep.setIncident_id(getIncidentNo());
			dep.setMinutes(Integer.parseInt(getdMinutes()));
			dep.setModified_date(today);
			dep.setPriority_id(Integer.parseInt(getDepdPriority()));
			dep.setVisible_status("Y");
			dep.setUnit_id(Integer.parseInt(getDepdUnit()));
			
			dependencyDAO.addDependency(dep);
			message = "Dependency is added Successfully.";
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
			}catch(Exception ex){
			   	
				message = "Unable to add dependency.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
		   		
		   	}
		 	
		 
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
	    	System.out.println(" incident no pro ==== "+id);
	    	
	    	try{
	    		progressList=incidentProgressViewDAO.getIncidentProgressByIncidentNo(id);
	    	}catch(Exception ex){
			   	
	    		System.out.println(" error proh==== "+ex.getMessage());
		   	}
			return progressList;
	    }
	 
		 public List<IncidentProgressView> listIncidentStatus() {
			 
			 return progressList;
		 }
		 
	 
		 
	 	
	 	public void saveUnitIncident(){
			
			
	 		String message=null;
	 		UnitMemberTxn uMemTxn =new UnitMemberTxn();
			if(assignMember == null){
				message = "Select team member.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
			}else if(currentStatus == null){
				message = "Status can not be blank.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
			}else if(rootCause == null){
				message = "Root cause can not be blank.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
			}else if(actionTaken == null){
				message = "Action taken can not be blank.";
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
			}else{
				
				try{	
					int remTime=0;
					Date finishedTime=null;
			        if ("OH".equals(currentStatus)) {
			        	remTime=remainTime;
			           
			        } else {
			        	getFinishTime();
			            remainTime = getRemTime();
			            remTime=remainTime;
			            if ("RSD".equals(currentStatus)) {
			            	finishedTime=today;
			            }
			        }
					List<UnitMemberTxn> uMList=unitMemberTxnDAO.getUnitMemberTxnByIncidentNo(getIncidentNo());
					int x=uMList.size();
					getFinishTime();
					for(UnitMemberTxn v:uMList){
						
						uMemTxn.setIncidentID(getIncidentNo());
						uMemTxn.setCreatedBy(v.getCreatedBy());
						uMemTxn.setAssignUnitID(v.getAssignUnitID());
						uMemTxn.setAssignMemID(v.getAssignMemID());
						uMemTxn.setCreatedDate(v.getCreatedDate());
						uMemTxn.setAssignedDateTime(v.getAssignedDateTime());
						uMemTxn.setId(v.getId());
						uMemTxn.setStartedTime(v.getStartedTime());
						uMemTxn.setUpdatedBy(loggedUser);
						
						uMemTxn.setMemStatusId(currentStatus);
						uMemTxn.setActionTaken(actionTaken);
						uMemTxn.setRootCause(rootCause);
						uMemTxn.setFinishedTime(finishedTime);
						uMemTxn.setRemainTime(remTime);
						if ("RSD".equals(currentStatus)){
							uMemTxn.setUpdatedTime(finishedTime);
						}else{
							uMemTxn.setUpdatedTime(v.getStartedTime());
						}
						unitMemberTxnDAO.updateUnitMemberTxn(uMemTxn);
					
						message = "Incident action is saved Successfully.";
						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
					}
				}catch(Exception ex){
		    		message = "Incident action is NOT saved Successfully.";
		    		FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
		    		
		    	}
				setIsNew("I");
			    
		    	
		    	
		    	
				
			}
		
			
		}
	 
	 	public void assignToTeamMember(){
	 		String message=null;
	 		IncidentTxn incid=new IncidentTxn();
	 		UnitMemberTxn uMemTxn =new UnitMemberTxn();
	 		Notification notf=new Notification();
	 		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date nwStDate = null;
			 String nwStTime = null;
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
				
				      Date date = new Date();
				      nwStTime = dateFormat.format(date);
				      nwStDate = dateFormat.parse(nwStTime);

				    System.out.println(" -- assignToTeamMember --"+getAssignMember());
					List<UnitMemberTxn> uMList=unitMemberTxnDAO.getUnitMemberTxnByIncidentNo(getIncidentNo());
					int x=uMList.size();
					if(x==0){
						Employee emp=employeeDAO.getEmployeeById(Integer.parseInt(getAssignMember()));
						uMemTxn.setIncidentID(getIncidentNo());
						uMemTxn.setCreatedBy(getLoggedUser());
						uMemTxn.setAssignUnitID(unitName);
						uMemTxn.setAssignMemID(emp.getEmpId());
						uMemTxn.setMemStatusId("PWM");
						uMemTxn.setCreatedDate(nwStDate);
						uMemTxn.setStartedTime(nwStDate);
						uMemTxn.setAssignedDateTime(nwStDate);
						uMemTxn.setUpdatedTime(nwStDate);
						uMemTxn.setUpdatedBy(getLoggedUser());
						String targetPeriod=tgtPeriod!=null?tgtPeriod:"0";
						uMemTxn.setRemainTime(Integer.parseInt(targetPeriod));
						
						unitMemberTxnDAO.addToUnitMemberTxn(uMemTxn);
						incid.setId(getIncidentNo());
						incid.setStatus("PWM");
						incid.setTitle(getTitle());
						incid.setReportedBy(getReportedByName());
						incid.setPriorityId(Integer.parseInt(priorityId));
						incid.setIncLocationId(getInc_location_id());
						incid.setIncTypeId(incTypeId);
						incid.setIncSubTypeId(incSubTypeId);
						incid.setTechId(incAffectedAreaId);
						incid.setAtUnitProcess(getAffectedProcess());
						incid.setEmail(incEmail);
						incid.setDescription(getDescription());
						incid.setPhone(incPhone);
						incid.setIncLocDetail(getLocationDetail());
						incid.setOriginId(Integer.parseInt(origin));
						incid.setOccuranceDate(getOccuranceDate());
						incid.setCreatedBy(reportedBySno);
						incid.setCreatedDate(getOccuranceDate());
						incid.setModifiedDate(today);
						incid.setModifiedBy(getLoggedUser());
						incidentTxnDAO.updateIncident(incid);
						
						notf.setNotificationText("Incident "+ incidentNo +" is reassigend to : "+emp.getEmpId()+" in the "+unitName);
						notf.setModuleId(0);
						notf.setRefId(incidentNo);
						notf.setServiceNo(getLoggedUser());
						notf.setUserId(getLoggedUser());
						notf.setNotificationDate(new Date());
						notf.setNotifiTarget((emp.getEmpId()));
						notificationDAO.addNotification(notf);
						
						message = "Incident  is assigned Successfully.";
						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
					}else{
						
						message = "Incident  is already assigned.";
						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
					}
				}catch(Exception ex){
		    		message = "Incident  is NOT assigned Successfully.";
		    		FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
		    		
		    	}
				setIsNew("I");
			    
		    	
		    	
		    	
				
			}
		}
	 	
	 	public void rollbackToOtherUnit(){

			System.out.println(rollbackUnit+" -- rollbackToUnit --"+uRollbackReason);
			String message=null;
	 		//IncidentTxn txn=new IncidentTxn();
	 		IrtIncidentTxn irttxn=new IrtIncidentTxn();
	 		Notification notf=new Notification();
	 		
			try{
				
				if(rollbackUnit == null){
					message = "Rollback Unit name cannot be blank.";
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
				}else if(uRollbackReason == null){
					message = "Rollback reason can not be empty.";
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
				}else{
					//Unit ut=unitDAO.getUnitByCode(Integer.parseInt(unitName));
					IrtIncidentTxn irt=irtIncidentTxnDAO.getIRTIncidentById(getIrtId());
					irttxn.setId(getIrtId());
					irttxn.setUnitReassignReason(uRollbackReason);
					irttxn.setModifiedDate(today);
					irttxn.setAssignedUnit(rollbackUnit);
					irttxn.setReassignedBy(getLoggedUser());
					
					irttxn.setIncidentNo(getIncidentNo());
					irttxn.setIrtReminder(irt.getIrtReminder());
					irttxn.setImpactUrgCode(irt.getImpactUrgCode());
					irttxn.setCreatedBy(irt.getCreatedBy());
					irttxn.setRepeatingStatus(irt.getRepeatingStatus());
					irttxn.setCreatedDate(irt.getCreatedDate());
					irtIncidentTxnDAO.updateAssignIncidentToUnit(irttxn);
					
					
					
					int reassignUnitCode=Integer.parseInt(rollbackUnit);
					List<TeamMemberView> a= teamMemberViewDAO.getTeamMemberByUnitCode(reassignUnitCode);
					 for(TeamMemberView x:a){
						
						 	notf.setNotificationText("Incident "+ incidentNo +" is reassigend by : "+irttxn.getReassignedBy()+" in the "+unitName);
							notf.setModuleId(0);
							notf.setRefId(incidentNo);
							notf.setServiceNo(irttxn.getReassignedBy());
							notf.setUserId(getLoggedUser());
							notf.setNotificationDate(new Date());
							notf.setNotifiTarget((x.getEmp_id()));
							notificationDAO.addNotification(notf);
					 }
				
				
					 message = "Incident  is reassigned to unit Successfully.";
					 setIsNew("I");
					 FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
					 
					 listAllIncidents();
				}
			}catch(Exception ex){
	    		message = "Incident  is NOT reassigned to unit Successfully.";
	    		setIsNew("I");
	    		FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"", message));
	    		
				listAllIncidents();
	    		
	    	}
			
	    	
			
		}
	 	
	 	public void rollbackToIRT(){
	 		System.out.println(" -- rollbackToIRT --"+iRollbackReason);
	 		String message=null;
	 		IncidentTxn incid=new IncidentTxn();
	 		IrtIncidentTxn irttxn=new IrtIncidentTxn();
	 		Notification notf=new Notification();
	 		
			try{
			//	Unit ut=unitDAO.getUnitByCode(Integer.parseInt(unitName));
				IrtIncidentTxn irt=irtIncidentTxnDAO.getIRTIncidentById(getIrtId());
				
				int region_id=branchDAO.getRegionIdByBranchCode(getInc_location_id());
				irttxn.setId(getIrtId());
				irttxn.setUnitRollbackReason(iRollbackReason);
				irttxn.setModifiedDate(today);
				irttxn.setRollbackBy(getLoggedUser());
				irttxn.setAssignedUnit(irt.getAssignedUnit());
				irttxn.setIrtReminder(irt.getIrtReminder());
				irttxn.setImpactUrgCode(irt.getImpactUrgCode());
				irttxn.setCreatedBy(irt.getCreatedBy());
				irttxn.setRepeatingStatus(irt.getRepeatingStatus());
				irttxn.setIncidentNo(getIncidentNo());
				irtIncidentTxnDAO.updateAssignIncidentToUnit(irttxn);
				
				incid.setId(getIncidentNo());
				incid.setStatus("ROLLEDBACK");
				incid.setTitle(getTitle());
				incid.setReportedBy(getReportedByName());
				incid.setPriorityId(Integer.parseInt(priorityId));
				incid.setIncLocationId(getInc_location_id());
				incid.setIncTypeId(incTypeId);
				incid.setIncSubTypeId(incSubTypeId);
				incid.setTechId(incAffectedAreaId);
				incid.setAtUnitProcess(getAffectedProcess());
				incid.setEmail(incEmail);
				incid.setDescription(getDescription());
				incid.setPhone(incPhone);
				incid.setIncLocDetail(getLocationDetail());
				incid.setOriginId(Integer.parseInt(origin));
				incid.setOccuranceDate(getOccuranceDate());
				incid.setCreatedBy(reportedBySno);
				incid.setCreatedDate(getOccuranceDate());
				incid.setModifiedDate(today);
				incid.setModifiedBy(getLoggedUser());
				incidentTxnDAO.updateIncident(incid);
				
				List<EmployeeDetailView> irtList=employeeDetaliViewDAO.getIrtEmployeeByRegionId(region_id,"IRT_USER");
				for(EmployeeDetailView ir:irtList){
					notf.setNotificationText("Incident "+ incidentNo +" is rolled back by : "+irttxn.getRollbackBy()+" in the "+unitName);
					notf.setModuleId(0);
					notf.setRefId(incidentNo);
					notf.setServiceNo(irttxn.getRollbackBy());
					notf.setUserId(getLoggedUser());
					notf.setNotificationDate(new Date());
					notf.setNotifiTarget(Integer.toString(ir.getUser_id()));
					notificationDAO.addNotification(notf);
				}
				
				message = "Incident  is rollbacked  Successfully.";
			}catch(Exception ex){
	    		message = "Incident  is NOT rollbacked Successfully.";
	    		
	    	}
			setIsNew("I");
		    
	    	FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
		}
	 	
	 	public void closeIncident(){
			String message=null;
			System.out.println(incidentNo+" -- selected incident  --");
			try{
				
				Date closedDate= new Date();
				Notification notf=new Notification();
				IncidentTxn incid=new IncidentTxn();
				incid.setId(incidentNo);
				incid.setStatus("CBU");
				incid.setModifiedDate(closedDate);
				incid.setuCloseRId(closeReason);
				incid.setModifiedBy(getLoggedUser());
				incid.setTitle(getTitle());
				incid.setReportedBy(getReportedByName());
				incid.setPriorityId(Integer.parseInt(priorityId));
				incid.setIncLocationId(getInc_location_id());
				incid.setIncTypeId(incTypeId);
				incid.setIncSubTypeId(incSubTypeId);
				incid.setTechId(incAffectedAreaId);
				incid.setAtUnitProcess(getAffectedProcess());
				incid.setEmail(incEmail);
				incid.setDescription(getDescription());
				incid.setPhone(incPhone);
				incid.setIncLocDetail(getLocationDetail());
				incid.setOriginId(Integer.parseInt(origin));
				incid.setOccuranceDate(getOccuranceDate());
				incid.setCreatedBy(reportedBySno);
				incid.setCreatedDate(getOccuranceDate());
				
				notf.setNotificationDate(new Date());
				notf.setRefId(incidentNo);
				notf.setNotifiTarget(reportedBySno);
				notf.setNotificationText("Incident "+ incidentNo +"is closed at Unit level by :"+getLoggedUser());
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
	 	public void informToVendor(){
	 		String message=null;
			System.out.println(" -- informToVendor --");
			VendorInformDetTxn vi=new VendorInformDetTxn();
			try{
				vi.setIncidentNo(incidentNo);
				vi.setInformedBy(getLoggedUser());
				vi.setInformedDate(today);
				vi.setInformedUserLevel(getLoggedUserLevel());
				vi.setEmailBody(getvContent());
				vi.setSubject(getvSubject());
				vi.setVendorId(Integer.parseInt(getvName()));
				
				vendorInformDetTxnDAO.addVendorInformDetail(vi);
				
				System.out.println("SimpleEmail Start");
				
			    String smtpHostServer = "smtp.gmail.com";
			    String emailID = "iresha.nayani@gmail.com";
			    
			    Properties props = System.getProperties();
			 
			    props.put("mail.smtp.host", smtpHostServer);
			    props.put("mail.smtp.port", "587");
			    props.put("mail.smtp.auth", "true");
			    props.put("mail.smtp.starttls.enable", "true");
			    
			    Authenticator auth = new Authenticator() {
					//override the getPasswordAuthentication method
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("iresha.nayani@gmail.com", "Sigithi1989");
					}
				};
				Session session = Session.getInstance(props, auth);
			 //   Session session = Session.getInstance(props, null);
			    
			    EmailRequest.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
			
				message = "Incident  is informed Successfully.";
		    	}catch(Exception ex){
				   	
		    		message = "Incident  is NOT informed Successfully.";
			   	}
			
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"", message));
			
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
	 	public String setDisabledAction(String selectedStatus){
			
	        if ("RSLV".equals(selectedStatus) ||  "CBU".equals(selectedStatus)) {
	        		disabledAction="Y";
	            } else {
	            	disabledAction= "N";

	            }
			return disabledAction;
		}
	 	
	 	
	 	public void valuChangeForIncidentCategory(){
	 		listAllIncidents();	 		
	 	}
	 	
	    public void getFinishTime() {

	        int mnts = targetTime;
	        int secnds = 0;
	     
	        
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date assignedTime = null;
	        try {
	        	assignedTime = dateFormat.parse(assignTime);
	        } catch (ParseException e) {
	        }
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(assignedTime);
	        //            cal.add(Calendar.DATE, Dates);
	        //            cal.add(Calendar.HOUR_OF_DAY, hourrs);
	        cal.add(Calendar.MINUTE, mnts);
	        cal.add(Calendar.SECOND, secnds);
	       
	        // convert calendar to date
	        finishTime = cal.getTime();

	    }
	    
//	    public void getFinishTime() {
//
//	        int mnts = 0;
//	        int secnds = 0;
//
//	        mnts = remainTime / 60;
//	        secnds = remainTime % 60;
//	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	        Date updatedTime = null;
//	        try {
//	            updatedTime = dateFormat.parse(updatTime);
//	        } catch (ParseException e) {
//	        }
//	        Calendar cal = Calendar.getInstance();
//	        cal.setTime(updatedTime);
//	        //            cal.add(Calendar.DATE, Dates);
//	        //            cal.add(Calendar.HOUR_OF_DAY, hourrs);
//	        cal.add(Calendar.MINUTE, mnts);
//	        cal.add(Calendar.SECOND, secnds);
//
//	        // convert calendar to date
//	        finishTime = cal.getTime();
//
//	    }
	    public int getRemTime() {
	        long dif = 0;
	        int remTime = 0;

	        Date nwDate = null;
	        String nwTime = null;
	        int days = 0;
	        int hours = 0;
	        int min = 0;
	        int hrs = 0;
	        int mn = 0;
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        try {

	            Date date = new Date();
	            nwTime = dateFormat.format(date);
	            nwDate = dateFormat.parse(nwTime);

	            dif = finishTime.getTime() - nwDate.getTime();
	            remTime = (int) (dif / 1000);


	        } catch (Exception e) {
	           return 0;
	        }

	        return remTime;
	    }
	   
	    
	    public void setActualResTime(){
	    	
	        Date nowDate = null;
	        long difference = 0;
	        int seconds = 0;
	        int tseconds = 0;
	        int days = 0;
	        int hours = 0;
	        int min = 0;
	        int hrs = 0;
	        int mn = 0;
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	        try {


	            String nowTime = null;
	           

	            Date date = new Date();
	            nowTime = dateFormat.format(date);
	      
	            nowDate = dateFormat.parse(nowTime);

	            System.out.println(remainTime);
	            if ("RSD".equals(currentStatus) || "CD".equals(currentStatus)) {
	                if(remainTime < 0){
	                    seconds = (-1) * remainTime + targetTime;
	                }else{
	                    seconds = targetTime - remainTime;
	                }
	            }
	            else if ("OH".equals(currentStatus)) {
	                if(remainTime < 0){
	                    seconds = (-1) * remainTime + targetTime;
	                }else{
	                    seconds =  targetTime - remainTime;
	                }
	            }
	            else {
	                if (nowDate.compareTo(finishTime) > 0) {
	                    difference = (int) ((nowDate.getTime() - finishTime.getTime())/1000);

	                } else {
	                    difference = (int)((finishTime.getTime() - nowDate.getTime())/1000);

	                }
	                tseconds=targetTime*60;
	                seconds =tseconds - (int) difference;
	                
	                
	            }


	            days = seconds / (60 * 60 * 24);

	            hours = seconds % (60 * 60 * 24);
	            hrs = hours / (60 * 60);
	            min = hours % (60 * 60);
	            mn = min / 60;

	            System.out.println(days);
	            System.out.println(hrs);
	            System.out.println(mn);


	        } catch (ParseException e) {

	        }
	        aWorkingDays=Integer.toString(days);
	        aHours=Integer.toString(hrs);
	        aMinutes=Integer.toString(mn);
	    
	        

	    }
	  
}
