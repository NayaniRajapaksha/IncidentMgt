package com.ucsc.mit.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Service;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.EmployeeDAO;
import com.ucsc.mit.dao.IrtMemberDAO;
import com.ucsc.mit.dao.NotificationDAO;
import com.ucsc.mit.dao.NotifyLastSeenDAO;
import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.IncidentProgressView;
import com.ucsc.mit.model.IncidentStatus;
import com.ucsc.mit.model.IrtMember;
import com.ucsc.mit.model.Notification;
import com.ucsc.mit.model.NotifyLastSeen;

@Service
@ManagedBean(name="notificationService")
@SessionScoped
public class NotificationService {
	private EmployeeDAO employeeDAO;
	private NotificationDAO notificationDAO;
	private static Map<Integer,Object> notificationValue;
	List<Notification> notoficationList = null;
	private String loggedUser;
	private String loggedUserLevel;
	private int loggedUserBranchId;
	private String loggedUserUnitName;
	private String loggedUserUnitId;
	private NotifyLastSeenDAO notifyLastSeenDAO;
	private IrtMemberDAO irtMemberDAO;
	private Notification selectedNotification;
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


	public NotifyLastSeenDAO getNotifyLastSeenDAO() {
		return notifyLastSeenDAO;
	}


	public void setNotifyLastSeenDAO(NotifyLastSeenDAO notifyLastSeenDAO) {
		this.notifyLastSeenDAO = notifyLastSeenDAO;
	}


	


	public IrtMemberDAO getIrtMemberDAO() {
		return irtMemberDAO;
	}


	public void setIrtMemberDAO(IrtMemberDAO irtMemberDAO) {
		this.irtMemberDAO = irtMemberDAO;
	}


	public Notification getSelectedNotification() {
		return selectedNotification;
	}


	public void setSelectedNotification(Notification selectedNotification) {
		this.selectedNotification = selectedNotification;
	}


	public static Map<Integer, Object> getNotificationValue() {
		return notificationValue;
	}


	public static void setNotificationValue(Map<Integer, Object> notificationValue) {
		NotificationService.notificationValue = notificationValue;
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


	public List<Notification> viewNotifacationValues() {
		notoficationList = new ArrayList<Notification>();
		System.out.println(getLoggedUserLevel()+" == loggedUserLevel ==");
		System.out.println(getLoggedUser()+" == loggedUser ==");
		 String dynamicWhere =  null;
		if(getLoggedUser()!=null){
							
				if(getLoggedUserLevel()!=null){
					if("UNIT_MEMBER".equals(getLoggedUserLevel())){
				        
			            dynamicWhere = " notifiTarget ='" + loggedUserUnitId +"' or notifiTarget =  '" + loggedUser + "'  ";  
			        
			        
			        }else if("IRT_USER".equals(getLoggedUserLevel())){
			        	int region_id=0;
			        	List<Employee> emp=employeeDAO.getEmployeeByEmpId(getLoggedUser());
			        	for(Employee v:emp){
			        		List<IrtMember> irt=irtMemberDAO.getMemberByMemberID(v.getId());
			        		for(IrtMember b:irt){
			        			region_id=b.getRegionId();
			        		}
			        		
			        	}
			            dynamicWhere = " (notifiTarget ='" + region_id +"' or notifiTarget =  '" + loggedUser + "') "; 
			            
			        }else if("UNIT_HEAD".equals(getLoggedUserLevel())){
			            dynamicWhere = "(notifiTarget = '" +loggedUser+ "' or  notifiTarget ='" + loggedUserUnitId +"')";
			            
			        }else if("EMP_USER".equals(getLoggedUserLevel())){
			            dynamicWhere =  "(notifiTarget = '" +loggedUser+ "' or notifiTarget = '"+ loggedUserBranchId +"')"; 
			            
			        }else{
			            dynamicWhere =  " notifiTarget = '" +loggedUser+ "'";  
			        }
				}
			System.out.println(dynamicWhere+" = dynamicWhere = ");
			notoficationList.clear();
			Date lastSeenDate=notifyLastSeenDAO.getLastSeenDateByUser(getLoggedUser());
			notoficationList= notificationDAO.listNortificationByNotiftTarget(dynamicWhere,getLoggedUser(),lastSeenDate);

		}
	     return notoficationList;
	} 
	

	
	public void onRowSelect(SelectEvent selectEvent) {
		
		if(selectEvent != null){
			NotifyLastSeen n=new NotifyLastSeen();
			Notification notification = (Notification)selectEvent.getObject();
			
			n.setLastSeenDate(getLastSeenDate());
			n.setCreatedBy(getLoggedUser());
			n.setNotifyNo(Integer.toString(notification.getId()));
			n.setCreatedDate(new Date());
			n.setNotifyUserId(getLoggedUser());
			
			System.out.println(" == seen noti =="+notification.getNotificationText());
			notifyLastSeenDAO.addSeenNotification(n);
			viewNotifacationValues();
		}
   
    }
	
	public Date getLastSeenDate(){
		Date today = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = dateFormat.format(today);
		Date lastSeenDate = null;
		try {
			lastSeenDate = dateFormat.parse(nowTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastSeenDate;		
	}
}
