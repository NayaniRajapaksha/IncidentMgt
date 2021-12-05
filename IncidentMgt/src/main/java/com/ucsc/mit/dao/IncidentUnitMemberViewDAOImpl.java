package com.ucsc.mit.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.IncidentUnitMemberView;

public class IncidentUnitMemberViewDAOImpl implements IncidentUnitMemberViewDAO{
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@Override
	public IncidentUnitMemberView findTimeByIncidentNo(int incident_no) throws HibernateException {
		Session session = this.sessionFactory.openSession();
		IncidentUnitMemberView u = (IncidentUnitMemberView) session.load(Employee.class, new Integer(incident_no));
		session.close();
		return u;
	}
}
