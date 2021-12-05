package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.Employee;

public class LoginDAOImpl implements LoginDAO{
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@Override
	public boolean validate(String user, String password) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Employee> empList = session.createQuery("from Employee where empId='"+user+"' and pwd='"+password+"'").list();
	
		session.close();
		if(empList.size()>0){
			return true;
		}else{
			return false;
		}
		
		
	}
	
}
