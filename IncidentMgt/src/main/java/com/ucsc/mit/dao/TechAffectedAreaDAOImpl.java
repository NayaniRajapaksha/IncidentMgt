package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.TechAffectedArea;

public class TechAffectedAreaDAOImpl implements TechAffectedAreaDAO{

	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }

		@SuppressWarnings("unchecked")
		@Override
		public List<TechAffectedArea> getTechAffectedAreas() {
			Session session = this.sessionFactory.openSession();
			List<TechAffectedArea> reList = session.createQuery("from TechAffectedArea").list();
			session.close();
			
			return reList;
		}
}
