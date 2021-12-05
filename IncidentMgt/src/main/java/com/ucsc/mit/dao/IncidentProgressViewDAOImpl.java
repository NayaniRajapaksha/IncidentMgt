package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.IncidentProgressView;

public class IncidentProgressViewDAOImpl implements IncidentProgressViewDAO{

	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }
	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentProgressView> getIncidentProgressByIncidentNo(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<IncidentProgressView> mList = session.createQuery("from IncidentProgressView where progStatusCode not in('INITIAL') and incidentNo='"+id+"'").list();
		
		session.close();
		
		return mList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentProgressView> getIncidentProgressByIncidentNoForEmp(int id) {
		Session session = this.sessionFactory.openSession();
		List<IncidentProgressView> mList = session.createQuery("from IncidentProgressView where progStatusCode not in('INITIAL') and incidentNo='"+id+"'").list();
		
		session.close();
		
		return mList;
	}

}
