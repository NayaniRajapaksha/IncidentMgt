package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.Origin;
import com.ucsc.mit.model.UnitCloseReason;

public class UnitCloseReasonDAOImpl implements UnitCloseReasonDAO{
	
	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }

		@SuppressWarnings("unchecked")
		@Override
		public List<UnitCloseReason> getUnitCloseReasonList() {
			Session session = this.sessionFactory.openSession();
			List<UnitCloseReason> reList = session.createQuery("from UnitCloseReason").list();
			session.close();
			
			return reList;
		}

}
