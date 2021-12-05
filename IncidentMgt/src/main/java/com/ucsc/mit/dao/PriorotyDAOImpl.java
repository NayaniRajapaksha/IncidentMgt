package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.Priority;

public class PriorotyDAOImpl implements PriorotyDAO {

	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }

		@SuppressWarnings("unchecked")
		@Override
		public List<Priority> getPriorityLevels() throws HibernateException {
			Session session = this.sessionFactory.openSession();
			List<Priority> reList = session.createQuery("from Priority order by displayOrder ").list();
			session.close();
			
			return reList;
		}

		@Override
		@Transactional
		public Priority getPrriorityById(int id) throws HibernateException {
			Session session = this.sessionFactory.openSession();
			Priority u = (Priority) session.load(Priority.class, id);
			session.close();
			
			return u;

		}
}
