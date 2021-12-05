package com.ucsc.mit.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.Vendor;

@Repository
public class IncidentTypeDAOImpl implements IncidentTypeDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(IncidentTypeDAOImpl.class);
	private IncidentSubTypeDAO incidentSubTypeDAO;
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
    
    
	public IncidentSubTypeDAO getIncidentSubTypeDAO() {
		return incidentSubTypeDAO;
	}

	public void setIncidentSubTypeDAO(IncidentSubTypeDAO incidentSubTypeDAO) {
		this.incidentSubTypeDAO = incidentSubTypeDAO;
	}

	@Override
	public void addIncidentType(IncidentType t) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(t);
		Set<IncidentSubType> set=t.getSubTypes(); 
		for(IncidentSubType st:set){
			incidentSubTypeDAO.addIncidentSubType(st,session);
		}						
		
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentType> listIncidentTypes()throws HibernateException {
		
		Session session = this.sessionFactory.openSession();
		List<IncidentType> incList = session.createQuery("from IncidentType").list();
		session.close();
		
		 return incList;
	}

	@Override
	public void updateIncidentType(IncidentType t) throws HibernateException{
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(t);
		Set<IncidentSubType> set=t.getSubTypes(); 
		for(IncidentSubType st:set){
			incidentSubTypeDAO.updateIncidentSubType(st, session);
		}
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	@Transactional
	public IncidentType getIncidentTypeById(int id)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		IncidentType u = (IncidentType) session.load(IncidentType.class, id);
		session.close();
		
		return u;
	}

	@Override
	@Transactional
	public void deleteIncidentType(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Object persistentInstance = session.load(IncidentType.class, id);
		if (persistentInstance != null) {
		    session.delete(persistentInstance);
		}
		tx.commit();
		session.close();
	}

	@Override
	@Transactional
	public int getLastId() throws HibernateException {
		Session session = this.sessionFactory.openSession();
		int lastId = (int) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult();
		session.close();
		return lastId;
	}

}
