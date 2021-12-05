package com.ucsc.mit.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ucsc.mit.common.ReportCommonUtils;
import com.ucsc.mit.common.ResourceUtil;
import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.BranchDAO;
import com.ucsc.mit.dao.EmployeeDAO;
import com.ucsc.mit.dao.FaqDAO;
import com.ucsc.mit.dao.IncidentDetailViewDAO;
import com.ucsc.mit.dao.IncidentProgressViewDAO;
import com.ucsc.mit.dao.IncidentStatusDAO;
import com.ucsc.mit.dao.IncidentSubTypeDAO;
import com.ucsc.mit.dao.IncidentTicketViewDAO;
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
import com.ucsc.mit.dao.ReportsDAO;
import com.ucsc.mit.dao.TeamMemPreformaceViewDAO;
import com.ucsc.mit.dao.TeamMemberViewDAO;
import com.ucsc.mit.dao.TechAffectedAreaDAO;
import com.ucsc.mit.dao.UnitCloseReasonDAO;
import com.ucsc.mit.dao.UnitDAO;
import com.ucsc.mit.dao.UnitMemberDAO;
import com.ucsc.mit.dao.UnitMemberTxnDAO;
import com.ucsc.mit.dao.UnitSummaryViewDAO;
import com.ucsc.mit.dao.VendorSummaryViewDAO;
import com.ucsc.mit.model.Branch;
import com.ucsc.mit.model.CloseIncidentSummaryReport;
import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.IncidentDetailView;
import com.ucsc.mit.model.IncidentProgressView;
import com.ucsc.mit.model.IncidentStatus;
import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.IncidentSummaryReport;
import com.ucsc.mit.model.IncidentTicketPrint;
import com.ucsc.mit.model.IncidentTicketView;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.IrtImpactLevel;
import com.ucsc.mit.model.IrtImpactUrgency;
import com.ucsc.mit.model.IrtUrgency;
import com.ucsc.mit.model.Priority;
import com.ucsc.mit.model.ReopenIncidentSummaryReport;
import com.ucsc.mit.model.Report;
import com.ucsc.mit.model.ResolveIncidentSummaryReport;
import com.ucsc.mit.model.TMPerformanceReport;
import com.ucsc.mit.model.TeamMemPreformaceView;
import com.ucsc.mit.model.TeamMemberView;
import com.ucsc.mit.model.Unit;
import com.ucsc.mit.model.UnitIncidentSummaryView;
import com.ucsc.mit.model.UnitSummaryReport;
import com.ucsc.mit.model.VendorSummaryReport;
import com.ucsc.mit.model.VendorSummaryView;

import net.sf.jasperreports.engine.JRException;

@Service
@ManagedBean(name="reportService")
@SessionScoped
public class ReportService {
	private Date today = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat(ResourceUtil.getresourceUtilParam("simple.date.format"));
	String currFormat = ResourceUtil.getresourceUtilParam("currency.format");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
	private String reportType="I";
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
	private ReportsDAO reportsDAO;
	
	private TeamMemPreformaceViewDAO teamMemPreformaceViewDAO;
	private VendorSummaryViewDAO vendorSummaryViewDAO;
	private UnitSummaryViewDAO unitSummaryViewDAO;
	private IncidentTicketViewDAO incidentTicketViewDAO;
	public Date dateFrom= today;
	public Date dateTo= today;

	public String reportName;
	public String unitName;
	public String teamMemberName;
	public String unitHead;
	public String incidentStatus;
	public String typeName;
	public String  urgency;
	public String  impactLevel;
	public String incidentLocation;
	public String subTypeName;
	private static Map<Integer,Object> unitMemberValue;
	private static Map<Integer,Object> incidentStatusValue;
	private static Map<Integer,Object> priorityValue;
	private static Map<Integer,Object> unitValue;
	private static Map<Integer,Object> reportNameValue;
	private static Map<Integer,Object> incidentTypeValue;
	private static Map<Integer,Object> incidentSubTypeValue= new LinkedHashMap<Integer,Object>();
	private static Map<Integer,Object> locationValue;
	private static Map<Integer,Object> impactLevelValue;
	private static Map<Integer,Object> urgencyValue;
	private static Map<Integer,Object> reportTypeValue;
	private String vendor;
	private String vendorProgress;
	private String reportTypeName;
	private String reportCategory;
	List<IncidentSummaryReport> allInSummarylist = new ArrayList<IncidentSummaryReport>();
	List<CloseIncidentSummaryReport> closeInSummarylist = new ArrayList<CloseIncidentSummaryReport>();
	List<ResolveIncidentSummaryReport> resInSummarylist = new ArrayList<ResolveIncidentSummaryReport>();
	List<ReopenIncidentSummaryReport> reopInSummarylist = new ArrayList<ReopenIncidentSummaryReport>();
	
	List<UnitSummaryReport> unitSummarylist = new ArrayList<UnitSummaryReport>();
	List<TMPerformanceReport> tmPerformancelist = new ArrayList<TMPerformanceReport>();
	List<VendorSummaryReport> vendorSummarylist = new ArrayList<VendorSummaryReport>();
	List<IncidentTicketPrint> incidentTicket = new ArrayList<IncidentTicketPrint>();
	
	List<IncidentTicketPrint> searchTicketlist = new ArrayList<IncidentTicketPrint>();
	public String getReportCategory() {
		return reportCategory;
	}
	public void setReportCategory(String reportCategory) {
		this.reportCategory = reportCategory;
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
	public void setLoggedUserLevel(String loggedUserLevel) {
		this.loggedUserLevel = loggedUserLevel;
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
	public ReportsDAO getReportsDAO() {
		return reportsDAO;
	}
	public void setReportsDAO(ReportsDAO reportsDAO) {
		this.reportsDAO = reportsDAO;
	}
	
	public TeamMemPreformaceViewDAO getTeamMemPreformaceViewDAO() {
		return teamMemPreformaceViewDAO;
	}
	public void setTeamMemPreformaceViewDAO(TeamMemPreformaceViewDAO teamMemPreformaceViewDAO) {
		this.teamMemPreformaceViewDAO = teamMemPreformaceViewDAO;
	}
	public VendorSummaryViewDAO getVendorSummaryViewDAO() {
		return vendorSummaryViewDAO;
	}
	public void setVendorSummaryViewDAO(VendorSummaryViewDAO vendorSummaryViewDAO) {
		this.vendorSummaryViewDAO = vendorSummaryViewDAO;
	}
	public UnitSummaryViewDAO getUnitSummaryViewDAO() {
		return unitSummaryViewDAO;
	}
	public void setUnitSummaryViewDAO(UnitSummaryViewDAO unitSummaryViewDAO) {
		this.unitSummaryViewDAO = unitSummaryViewDAO;
	}
	
	public IncidentTicketViewDAO getIncidentTicketViewDAO() {
		return incidentTicketViewDAO;
	}
	public void setIncidentTicketViewDAO(IncidentTicketViewDAO incidentTicketViewDAO) {
		this.incidentTicketViewDAO = incidentTicketViewDAO;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = new Date();
	}
	
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getTeamMemberName() {
		return teamMemberName;
	}
	public void setTeamMemberName(String teamMemberName) {
		this.teamMemberName = teamMemberName;
	}
	public String getUnitHead() {
		return unitHead;
	}
	public void setUnitHead(String unitHead) {
		this.unitHead = unitHead;
	}
	
	public String getIncidentStatus() {
		return incidentStatus;
	}
	public void setIncidentStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	public String getImpactLevel() {
		return impactLevel;
	}
	public void setImpactLevel(String impactLevel) {
		this.impactLevel = impactLevel;
	}
	
	public String getIncidentLocation() {
		return incidentLocation;
	}
	public void setIncidentLocation(String incidentLocation) {
		this.incidentLocation = incidentLocation;
	}
	public String getSubTypeName() {
		return subTypeName;
	}
	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}
	
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getVendorProgress() {
		return vendorProgress;
	}
	public void setVendorProgress(String vendorProgress) {
		this.vendorProgress = vendorProgress;
	}
	
	public static Map<Integer, Object> getIncidentSubTypeValue() {
		return incidentSubTypeValue;
	}
	public static void setIncidentSubTypeValue(Map<Integer, Object> incidentSubTypeValue) {
		ReportService.incidentSubTypeValue = incidentSubTypeValue;
	}
	
	public static Map<Integer, Object> getUnitMemberValue() {
		return unitMemberValue;
	}
	public static void setUnitMemberValue(Map<Integer, Object> unitMemberValue) {
		ReportService.unitMemberValue = unitMemberValue;
	}
	public Map<Integer,Object> getUnitMemberValues() {
		
		unitMemberValue = new LinkedHashMap<Integer,Object>();
		if(unitName != null){
		 unitMemberValue.clear();
		 int unitId=Integer.parseInt(unitName);
		 List<TeamMemberView> a= teamMemberViewDAO.getTeamMemberByUnitCode(unitId);
		 for(TeamMemberView x:a){
			 unitMemberValue.put(x.getId(), x.getTeam_m_name());
		 }
		}else{
			List<TeamMemberView> a= teamMemberViewDAO.getTeamMemberByUnitCode(1);
			 for(TeamMemberView x:a){
				 unitMemberValue.put(x.getId(), x.getTeam_m_name());
			 }
			
		}
	     return unitMemberValue;
	} 
	

	
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public Map<Integer,Object> getIncidentStatusValues() {
		incidentStatusValue = new LinkedHashMap<Integer,Object>();
		List<IncidentStatus> a= incidentStatusDAO.getAllIncidentStatus();
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
	
	public  Map<Integer, Object> getReportListValue() {
		reportNameValue = new LinkedHashMap<Integer,Object>();
		 List<Report> a= reportsDAO.getReportList();
		 for(Report x:a){
			 reportNameValue.put(x.getId(), x.getReportName());
		 }
		 
	    
		return reportNameValue;
	}
	
	public  Map<Integer, Object> getReportTypeListValue() {
		reportTypeValue = new LinkedHashMap<Integer,Object>();
		 
			 reportTypeValue.put(1, "All Incidents");
			 reportTypeValue.put(2, "Close Incidents");
			 reportTypeValue.put(3, "Resolve Incidents");
			 reportTypeValue.put(4, "Repoen Incidents");
		
	    
		return reportTypeValue;
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
		
		public  Map<Integer, Object> getImpactLevelValue() {
			impactLevelValue = new LinkedHashMap<Integer,Object>();
			 List<IrtImpactLevel> a= irtImpactLevelDAO.listAllIrtImpactLevels();
			 for(IrtImpactLevel x:a){
				 impactLevelValue.put(x.getId(), x.getImpactLvlName());
			 }
			 
		     
			return impactLevelValue;
		}
		
		public  Map<Integer, Object> getUrgencyValue() {
			urgencyValue = new LinkedHashMap<Integer,Object>();
			 List<IrtUrgency> a= irtUrgencyDAO.listAllUrgendyCodes();
			 for(IrtUrgency x:a){
				 urgencyValue.put(x.getId(), x.getUrgencyName());
			 }
			return urgencyValue;
		}
		
		public List<IncidentTicketPrint> getSearchTicketlist() {
			return searchTicketlist;
		}
		public void setSearchTicketlist(List<IncidentTicketPrint> searchTicketlist) {
			this.searchTicketlist = searchTicketlist;
		}
		public List<IncidentTicketPrint>  searchIncidentTicket(){
			System.out.println("  --  searchIncidentTicket  --");
			if(dateFrom != null && dateTo != null){
				String fromDate =convertDate(dateFrom);  
				String  toDate = convertDate(dateTo); 
				searchTicketlist.clear();
				IncidentTicketPrint sm=new IncidentTicketPrint();
				List<IncidentTicketView> adt=incidentTicketViewDAO.getIncidentList(fromDate, toDate);
				for(IncidentTicketView v:adt){
					sm= new IncidentTicketPrint(v.getIncident_number(), v.getTitle(), v.getCreated_date(), v.getOccured_date(), v.getBr_name(), v.getRep_emp_name());
					searchTicketlist.add(sm);
				}
				
				
			}
			return searchTicketlist;
			
		}
		
		public void valueChangeReportType(){
			if(reportName != null){
				
				if(reportName.equals("1")){
					setReportType("TP");
					setIsNew("I");
					//reportTypeName="adfTest";
					reportTypeName="Team_Member_Performance";
				}else if(reportName.equals("2")){
					setReportType("IS");
					reportTypeName="All_Incidents_Summary";			
					setIsNew("I");
				}else if(reportName.equals("3")){
					setReportType("VS");
					reportTypeName="Vendor_Summary";
					setIsNew("I");
				}else if(reportName.equals("4")){
					setReportType("US");
					reportTypeName="Incidents_Summary-Units";
					setIsNew("I");
				}else if(reportName.equals("5")){
					setReportType("IT");
					
					reportTypeName="Incidents_Ticket_detail";
					//reportTypeName="adfTest";
					setIsNew("N");
				}else{
					setReportType("I");
					reportTypeName=null;
					setIsNew("I");
				}
			}else{
				setReportType("I");
				setIsNew("I");
				reportTypeName=null;
			}
			resetValues();
			
		}
		
		public void valueChangeSummaryReportType(){
			if(reportName != null){
				if(reportName.equals("2")){
					if(reportCategory!=null){
						if(reportCategory.equals("1")){
							reportTypeName="All_Incidents_Summary";
						}else if(reportCategory.equals("2")){
							reportTypeName="Closed_Incidents_Summary";
						}else if(reportCategory.equals("3")){
							reportTypeName="Resolved_Incidents_Summary";
						}else if(reportCategory.equals("4")){
							reportTypeName="Reopened_Incidents_Summary";
						
						}else{
							reportTypeName="All_Incidents_Summary";
						}
					}
					
				}
				
			}
			
		}
		public String qurSubString(String reportType) {
			
			String wrc = "";
			String emp_id = null;
			String assignMember=null;
			String status_id = null;
			String status_code=null;
			String impact_id = null;
			String impact_code=null;
			String urgency_id = null;
			String urgency_code=null;
			String unit_id = null;
			String type_id=null;
			String sub_type_id = null;
			String loc_id=null;
			String ven_name = null;
			String fromDate = null;
			String toDate=null;
			switch (reportType) {
			case "All_Incidents_Summary":
				
				emp_id=teamMemberName!=null?(teamMemberName.isEmpty()?null:teamMemberName):null;
				
				if(emp_id !=null){
					TeamMemberView emp=teamMemberViewDAO.getTeamMemberById(Integer.parseInt(emp_id));
					assignMember=emp.getEmp_id();
				}
				status_id=incidentStatus!=null?(incidentStatus.isEmpty()?null:incidentStatus):null;
				
				
				if(status_id !=null){
					IncidentStatus st=incidentStatusDAO.getIncidentStatusById(Integer.parseInt(status_id));
					status_code=st.getStatus_code();
				}
				impact_id=impactLevel!=null?(impactLevel.isEmpty()?null:impactLevel):null;
			
				
				
				if(impact_id !=null){
					IrtImpactLevel im=irtImpactLevelDAO.getImpactLevelData(Integer.parseInt(impact_id));
					impact_code=im.getImpactLvlCode();
				}
				
				urgency_id=urgency!=null?(urgency.isEmpty()?null:urgency):null;
			
				
				
				if(urgency_id !=null){
					IrtUrgency im=irtUrgencyDAO.getUrgencyData(Integer.parseInt(urgency_id));
					urgency_code=im.getUrgencyCode();
				}
				
				
				
				 unit_id=unitName!=null?(unitName.isEmpty()?null:unitName):null;
				 type_id=typeName!=null?(typeName.isEmpty()?null:typeName):null;
				 sub_type_id=subTypeName!=null?(subTypeName.isEmpty()?null:subTypeName):null;
				 loc_id=incidentLocation!=null?(incidentLocation.isEmpty()?null:incidentLocation):null;
				 fromDate =convertDate(dateFrom);  
				 toDate = convertDate(dateTo); 
				List<IncidentDetailView> adt=incidentDetailViewDAO.getIncidentDetailForReport(assignMember, impact_code, urgency_code, status_code, unit_id, type_id, sub_type_id, loc_id,fromDate,toDate);
				
				
				
				IncidentSummaryReport sm=new IncidentSummaryReport();
				allInSummarylist.clear();
				for(IncidentDetailView v:adt){
					sm= new IncidentSummaryReport(v.getIncident_number(), v.getCreated_date(), v.getStatus_desc(), v.getImpact_level(), 
							v.getUrgency(), v.getType_name(), v.getSub_type_name(), v.getIncident_location(), v.getRem_name(), 
							v.getAss_mem_name(), v.getAssigned_unit(), v.getModified_date(), v.getReported_by(), v.getRep_emp_name(), v.getStatus());
					allInSummarylist.add(sm);
				}

				break;

			case "Closed_Incidents_Summary":
				emp_id=teamMemberName!=null?(teamMemberName.isEmpty()?null:teamMemberName):null;
				
				if(emp_id !=null){
					TeamMemberView emp=teamMemberViewDAO.getTeamMemberById(Integer.parseInt(emp_id));
					assignMember=emp.getEmp_id();
				}
				 status_id=incidentStatus!=null?(incidentStatus.isEmpty()?null:incidentStatus):null;
				
				
				if(status_id !=null){
					IncidentStatus st=incidentStatusDAO.getIncidentStatusById(Integer.parseInt(status_id));
					status_code=st.getStatus_code();
				}
				 impact_id=impactLevel!=null?(impactLevel.isEmpty()?null:impactLevel):null;
			
				
				if(impact_id !=null){
					IrtImpactLevel im=irtImpactLevelDAO.getImpactLevelData(Integer.parseInt(impact_id));
					impact_code=im.getImpactLvlCode();
				}
				
				urgency_id=urgency!=null?(urgency.isEmpty()?null:urgency):null;
			
				if(urgency_id !=null){
					IrtUrgency im=irtUrgencyDAO.getUrgencyData(Integer.parseInt(urgency_id));
					urgency_code=im.getUrgencyCode();
				}
				
				
				
				unit_id=unitName!=null?(unitName.isEmpty()?null:unitName):null;
				type_id=typeName!=null?(typeName.isEmpty()?null:typeName):null;
				sub_type_id=subTypeName!=null?(subTypeName.isEmpty()?null:subTypeName):null;
				loc_id=incidentLocation!=null?(incidentLocation.isEmpty()?null:incidentLocation):null;
				fromDate =convertDate(dateFrom);  
				toDate = convertDate(dateTo); 
				List<IncidentDetailView> cdt=incidentDetailViewDAO.getCloseIncidentDetailForReport(assignMember, impact_code, urgency_code, status_code, unit_id, type_id, sub_type_id, loc_id,fromDate,toDate);
				
				CloseIncidentSummaryReport cl=new CloseIncidentSummaryReport();
				closeInSummarylist.clear();
				String close_reason=null;
				for(IncidentDetailView v:cdt){
					close_reason=v.getIrt_close_reason()!=null?v.getIrt_close_reason():v.getUnit_close_reason();
					cl=new CloseIncidentSummaryReport(v.getIncident_number(),v.getCreated_date(),v.getModified_date(),v.getUnit_assign_date(),
							v.getUnit_name(), v.getImpact_level(),v.getUrgency(),v.getStatus_desc(),"test",v.getInc_status_modified_by(),close_reason);
					
					closeInSummarylist.add(cl);
				}
				break;

			case "Resolved_Incidents_Summary":
				emp_id=teamMemberName!=null?(teamMemberName.isEmpty()?null:teamMemberName):null;

				if(emp_id !=null){
					TeamMemberView emp=teamMemberViewDAO.getTeamMemberById(Integer.parseInt(emp_id));
					assignMember=emp.getEmp_id();
				}
				status_id=incidentStatus!=null?(incidentStatus.isEmpty()?null:incidentStatus):null;
				
				
				if(status_id !=null){
					IncidentStatus st=incidentStatusDAO.getIncidentStatusById(Integer.parseInt(status_id));
					status_code=st.getStatus_code();
				}
				impact_id=impactLevel!=null?(impactLevel.isEmpty()?null:impactLevel):null;
			
				if(impact_id!=null){
					IrtImpactLevel im=irtImpactLevelDAO.getImpactLevelData(Integer.parseInt(impact_id));
					impact_code=im.getImpactLvlCode();
				}
				
				urgency_id=urgency!=null?(urgency.isEmpty()?null:urgency):null;
			
				if(urgency_id !=null){
					IrtUrgency im=irtUrgencyDAO.getUrgencyData(Integer.parseInt(urgency_id));
					urgency_code=im.getUrgencyCode();
				}
				
				
				
				unit_id=unitName!=null?(unitName.isEmpty()?null:unitName):null;
				type_id=typeName!=null?(typeName.isEmpty()?null:typeName):null;
				sub_type_id=subTypeName!=null?(subTypeName.isEmpty()?null:subTypeName):null;
				loc_id=incidentLocation!=null?(incidentLocation.isEmpty()?null:incidentLocation):null;
				fromDate=convertDate(dateFrom);  
				toDate= convertDate(dateTo); 
				List<IncidentDetailView> redt=incidentDetailViewDAO.getResolveIncidentDetailForReport(assignMember, impact_code, urgency_code, status_code, unit_id, type_id, sub_type_id, loc_id,fromDate,toDate);
				
				
				
				ResolveIncidentSummaryReport res=new ResolveIncidentSummaryReport();
				resInSummarylist.clear();
				for(IncidentDetailView v:redt){
					res=new ResolveIncidentSummaryReport(v.getIncident_number(), v.getCreated_date(), v.getUnit_assign_date(), v.getFinish_time(),
							v.getUnit_name(), v.getAss_mem_name(), v.getImpact_level(), v.getUrgency(), v.getRoot_cause(), v.getAction_taken());
					
					resInSummarylist.add(res);
				}

				break;

			case "Reopened_Incidents_Summary":
				emp_id=teamMemberName!=null?(teamMemberName.isEmpty()?null:teamMemberName):null;
				if(emp_id !=null){
					TeamMemberView emp=teamMemberViewDAO.getTeamMemberById(Integer.parseInt(emp_id));
					assignMember=emp.getEmp_id();
				}
				status_id=incidentStatus!=null?(incidentStatus.isEmpty()?null:incidentStatus):null;
				
				if(status_id !=null){
					IncidentStatus st=incidentStatusDAO.getIncidentStatusById(Integer.parseInt(status_id));
					status_code=st.getStatus_code();
				}
				impact_id=impactLevel!=null?(impactLevel.isEmpty()?null:impactLevel):null;
			
				if(impact_id !=null){
					IrtImpactLevel im=irtImpactLevelDAO.getImpactLevelData(Integer.parseInt(impact_id));
					impact_code=im.getImpactLvlCode();
				}
				
				urgency_id=urgency!=null?(urgency.isEmpty()?null:urgency):null;
			
				if(urgency_id !=null){
					IrtUrgency im=irtUrgencyDAO.getUrgencyData(Integer.parseInt(urgency_id));
					urgency_code=im.getUrgencyCode();
				}
				
				
				
				unit_id=unitName!=null?(unitName.isEmpty()?null:unitName):null;
				type_id=typeName!=null?(typeName.isEmpty()?null:typeName):null;
				sub_type_id=subTypeName!=null?(subTypeName.isEmpty()?null:subTypeName):null;
				loc_id=incidentLocation!=null?(incidentLocation.isEmpty()?null:incidentLocation):null;
				fromDate=convertDate(dateFrom);  
				toDate= convertDate(dateTo); 
				List<IncidentDetailView> reopdt=incidentDetailViewDAO.getReopenIncidentDetailForReport(assignMember, impact_code, urgency_code, status_code, unit_id, type_id, sub_type_id, loc_id,fromDate,toDate);
				
				
				
				ReopenIncidentSummaryReport reop=new ReopenIncidentSummaryReport();
				reopInSummarylist.clear();
				for(IncidentDetailView v:reopdt){
					
					
					reop=new ReopenIncidentSummaryReport(v.getIncident_number(), v.getCreated_date(), v.getUnit_assign_date(), v.getSolved_in_time(),
							v.getModified_date(), v.getModified_date(), v.getUnit_name(), v.getImpact_level(), 
							v.getUrgency(), v.getInc_status_modified_by(), v.getStatus_desc(), v.getStatus_desc(), v.getStatus(),
							v.getInc_status_modified_by(), v.getReported_by(), "rEOPEN_REASON", v.getMem_status_desc()) ;
					reopInSummarylist.add(reop);
				}
				
				break;
			case "Incidents_Summary-Units":
				

				unit_id=unitName!=null?(unitName.isEmpty()?null:unitName):null;
				
				fromDate =convertDate(dateFrom);  
				toDate = convertDate(dateTo); 
				
				List<UnitIncidentSummaryView> us=unitSummaryViewDAO.getUnitSummaryReport(unit_id, fromDate, toDate);
				
				
				
				UnitSummaryReport usr=new UnitSummaryReport();
				unitSummarylist.clear();
				for(UnitIncidentSummaryView v:us){
					
					
					usr=new UnitSummaryReport(v.getINCIDENT_ID(), v.getUNIT_NAME(), v.getASSIGNED_UNIT_ID(), v.getStatus(), v.getSOLVED_IN_TIME(), v.getCreated_date());
					unitSummarylist.add(usr);
				}
				
				break;
			case "Team_Member_Performance":
				
				emp_id=teamMemberName!=null?(teamMemberName.isEmpty()?null:teamMemberName):null;
				assignMember=null;
				if(emp_id !=null){
					TeamMemberView emp=teamMemberViewDAO.getTeamMemberById(Integer.parseInt(emp_id));
					assignMember=emp.getEmp_id();
				}
				 unit_id=unitName!=null?(unitName.isEmpty()?null:unitName):null;
				
				fromDate =convertDate(dateFrom);  
				toDate = convertDate(dateTo); 
				
				List<TeamMemPreformaceView> tm=teamMemPreformaceViewDAO.getTeamPerformanceReport(assignMember, unit_id, fromDate, toDate);
				
				
				
				TMPerformanceReport tmr=new TMPerformanceReport();
				tmPerformancelist.clear();
				for(TeamMemPreformaceView v:tm){
					
					
					tmr=new TMPerformanceReport(v.getINCIDENT_NUMBER(), v.getNAME(), v.getUNIT_NAME(), v.getASSIGNED_UNIT(), v.getSTATUS(), v.getSOLVED_IN_TIME(),
							v.getCREATED_DATE(), v.getPENDING_COUNT(), v.getCOMPLETE_DEPENDENCY(), v.getCOLOSED_DEPENDENCY());
							
					tmPerformancelist.add(tmr);
				}
				
				break;
			case "Vendor_Summary":
				
				emp_id=teamMemberName!=null?(teamMemberName.isEmpty()?null:teamMemberName):null;
				assignMember=null;
				if(emp_id !=null){
					TeamMemberView emp=teamMemberViewDAO.getTeamMemberById(Integer.parseInt(emp_id));
					assignMember=emp.getEmp_id();
				}
				status_id=vendorProgress!=null?(vendorProgress.isEmpty()?null:vendorProgress):null;				
				if(status_id !=null){
					IncidentStatus st=incidentStatusDAO.getIncidentStatusById(Integer.parseInt(status_id));
					status_code=st.getStatus_code();
				}
				 unit_id=unitName!=null?(unitName.isEmpty()?null:unitName):null;
				 ven_name=vendor!=null?(vendor.isEmpty()?null:vendor):null;
				fromDate =convertDate(dateFrom);  
				toDate = convertDate(dateTo); 
				
				List<VendorSummaryView> vns=vendorSummaryViewDAO.getVendorSummaryReport(ven_name, status_code, fromDate, toDate);
				
			
				
				VendorSummaryReport vnr=new VendorSummaryReport();
				vendorSummarylist.clear();
				for(VendorSummaryView v:vns){
					
					
					vnr=new VendorSummaryReport(v.getINCIDENT_NUMBER(), v.getVEN_NAME(), v.getCONTACT_NO(), v.getStatus(),
							v.getEMAIL(), v.getCreated_date(), v.getINFORMED_BY(), v.getINFORMED_DATE(), v.getVENDOR_RESOLVE_DATE(), 
							v.getRESOLVE_DATE_UPDATED_BY(), v.getINFORMED_BY(), v.getLOCATION_ID());
							
					vendorSummarylist.add(vnr);
				}
				
				break;
			default:
				break;
			}
			return wrc;
		}
		
		public String convertDate(Date date){
			
//			String dateStr = "Mon Jun 18 00:00:00 IST 2012";
//			DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
//			Date date = (Date)formatter.parse(dateStr);
//			System.out.println(date);        

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			//String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +         cal.get(Calendar.YEAR);
			String formatedDate = cal.get(Calendar.YEAR)+ "-" +(cal.get(Calendar.MONTH) + 1)+ "-" + cal.get(Calendar.DATE) ;
			System.out.println("formatedDate : " + formatedDate);
			return formatedDate; 
		}
		public void printIncidentTicket(String rType, int incidentNo) {
			System.out.println(incidentNo+"  ---- incidentNo ---");
			if(incidentNo > 0){
			
				incidentTicket.clear();
				IncidentTicketPrint sm=new IncidentTicketPrint();
				IncidentTicketView v=incidentTicketViewDAO.getIncidentTicketByIncidentNo(incidentNo);
				
				sm= new IncidentTicketPrint(v.getIncident_number(), v.getPriority_id(), v.getTitle(), v.getReported_by(),
						v.getCreated_date(), v.getOrigin(), v.getAfct_unit_process(), v.getTech_afct_area(), 
						v.getMobile_phone(), v.getEmail(), v.getIncident_type(), v.getIncident_sub_type(),
						v.getIncident_location_id(), v.getIncident_location(), v.getDescription(),
						v.getStatus(), v.getM_origin(), v.getM_origin_name(), v.getM_priority_id(), v.getM_priority_name(),
						v.getM_afct_area(), v.getM_afct_name(), v.getM_type(), v.getM_type_name(), v.getM_sub_type(), 
						v.getM_sub_type_name(), v.getIrt_impact_urgency_code(), v.getAssigned_unit(),
						v.getIrt_reminder(), v.getUnit_rollback_reason(), v.getM_impact_urgency_code(), 
						v.getM_days(), v.getM_hours(), v.getM_minutes(), v.getM_urgency(), v.getM_impact_level(), v.getM_unit_code(),
						v.getM_unit_name(), v.getM_rem_code(), v.getM_rem_name(), v.getOccured_date(),
						v.getIrt_modified_date(), v.getAssignee_mem_id(), v.getRoot_cause(), v.getAction_taken(),
						v.getStarted_time(), v.getUpdated_time(), v.getMem_status_id(), v.getFinish_time(), 
						v.getSolved_in_time(), v.getRegion_id(), v.getTgt_period(), v.getRem_period(), v.getBranch_id(),
						v.getBr_name(), v.getBr_type_code(), v.getReg_name(), v.getAssign_mem_name(), v.getLoc_details(), 
						v.getRep_emp_name(), v.getUnit_close_reason_code(), v.getUnit_close_comment(), v.getIrt_close_comment());
																
				
				incidentTicket.add(sm);
				
				requestOutput("pdf", true);
				
			}
			
		}
		public String requestOutput(String rType, boolean print) {
		

		Map parameters = new HashMap();

	
		String wrc = qurSubString(reportTypeName);
		String query ="selct";
		parameters.put("allInSummaryList", allInSummarylist);
		parameters.put("closeInSummarylist", closeInSummarylist);
		parameters.put("resInSummarylist", resInSummarylist);
		parameters.put("reopInSummarylist", reopInSummarylist);
		parameters.put("unitSummarylist", unitSummarylist);
		parameters.put("vendorSummarylist", vendorSummarylist);
		parameters.put("tmPerformancelist", tmPerformancelist);
		parameters.put("incidentTicket", incidentTicket);
		parameters.put("LoginUser", loggedUser);
			if (dateFrom != null) {
			parameters.put("dateFrom", formatter.format(dateFrom));
		}

		if (dateTo != null) {
			parameters.put("dateTo", formatter.format(dateTo));
		}
		parameters.put("query", query);
		parameters.put("wrc", wrc);
		
		
		/*if (dateSingle != null) {
			parameters.put("dateSingle", formatter.format(dateSingle));
		}
		if (dateAcc != null) {
			parameters.put("dateAcc", formatter.format(dateAcc));
		}
		if (dateAuction != null) {
			parameters.put("dateAuction", formatter.format(dateAuction));
		}

		parameters.put("dateFormat", dateFormat);
		parameters.put("currencyFormat", currFormat);

		parameters.put("query", query);
		parameters.put("duration", duration);

		

		query_List = new ArrayList<String>();*/

		try {
			

			ReportCommonUtils.generateReports(reportTypeName, parameters,  rType, print);

		} catch (JRException | IOException e) {
			// TODO Auto-generated catch block
			// logger.error("Error Message!"+e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// logger.error("Error Message!"+e.getMessage());
			e.printStackTrace();
		}
		return "reports";
	}
	
		public void resetValues(){
			
			unitName=null;
			teamMemberName=null;
			unitHead=null;
			incidentStatus=null;
			impactLevel=null;
			urgency=null;
			typeName=null;
			subTypeName=null;
			incidentLocation=null;
			vendor=null;
			vendorProgress=null;
			reportCategory=null;
			dateFrom = today;
			dateTo =today;
			searchTicketlist.clear();
			
		}
		public void cancel(){
			reportName=null;
			setReportType("I");
			setIsNew("I");
			resetValues();
		}
		
}
