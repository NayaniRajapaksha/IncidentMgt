package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.Origin;

public class OriginDAOImpl implements OriginDAO{

	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }

		@SuppressWarnings("unchecked")
		@Override
		public List<Origin> getOriginData() {
			Session session = this.sessionFactory.openSession();
			List<Origin> reList = session.createQuery("from Origin").list();
			session.close();
			
			return reList;
		}
}
