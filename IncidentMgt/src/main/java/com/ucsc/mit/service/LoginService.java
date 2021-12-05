package com.ucsc.mit.service;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.dao.EmployeeDetaliViewDAO;
import com.ucsc.mit.dao.LoginDAO;
import com.ucsc.mit.model.EmployeeDetailView;
@Service
@ManagedBean(name="login")
@SessionScoped
public class LoginService {

	private String pwd;
	private String msg;
	private String user;
	private String userlevel;
	private int branchId;
	private int regionId;
	private String unitId;
	private String uname;
	private LoginDAO loginDAO;
	private EmployeeDetaliViewDAO employeeDetaliViewDAO;
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	public EmployeeDetaliViewDAO getEmployeeDetaliViewDAO() {
		return employeeDetaliViewDAO;
	}
	public void setEmployeeDetaliViewDAO(EmployeeDetaliViewDAO employeeDetaliViewDAO) {
		this.employeeDetaliViewDAO = employeeDetaliViewDAO;
	}
	
	public String getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}
	
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String validateUsernamePassword() {
		boolean valid = loginDAO.validate(user, pwd);
		if (valid) {
			EmployeeDetailView emp= employeeDetaliViewDAO.getUserLevel(Integer.parseInt(user));
			userlevel = emp.getEnterprise_group();
			branchId = emp.getBranch_id();
			unitId=emp.getUnit_id();
			uname=emp.getUnit_name();
			regionId =emp.getRegional_id();
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			session.setAttribute("userlevel", userlevel);
			session.setAttribute("branchId", branchId);
			session.setAttribute("unitId", unitId);
			session.setAttribute("uname", uname);
			session.setAttribute("regionId", regionId);
			return "home";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
	
	
}
