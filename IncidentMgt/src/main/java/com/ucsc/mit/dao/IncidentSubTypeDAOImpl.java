package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.IncidentType;

public class IncidentSubTypeDAOImpl implements IncidentSubTypeDAO {
	private static final Logger logger = LoggerFactory.getLogger(IncidentSubTypeDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
    
    
	@Override
	public void addIncidentSubType(IncidentSubType t,Session session) throws HibernateException{
		
		session.save(t);
	
		
	}

	@Override
	public List<IncidentSubType> listIncidentSubTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateIncidentSubType(IncidentSubType t,Session session)throws HibernateException {
		
		if(t.getId() !=0){
			session.update(t);
		}else{
			session.save(t);
		}
		
		
	}

	@Override
	@Transactional
	public IncidentSubType getIncidentTypeSubById(int id) throws HibernateException {
		Session session = this.sessionFactory.openSession();
		IncidentSubType u = (IncidentSubType) session.load(IncidentSubType.class, id);
		session.close();
		
		return u;
	}

	@Override
	@Transactional
	public void deleteIncidentSubType(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Object persistentInstance = session.load(IncidentSubType.class, id);
		if (persistentInstance != null) {
		    session.delete(persistentInstance);
		}
		tx.commit();
		session.close();
		
	}

	@Override
	public int getLastId() throws HibernateException{
		Session session = this.sessionFactory.openSession();
		int lastId = (int) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult();
		session.close();
		return lastId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentSubType>  getIncidentTypeSubByType(String code) {
		
		
		Session session = this.sessionFactory.openSession();
		List<IncidentSubType> incSubList = session.createQuery("from IncidentSubType where incidentTypeCode='"+code+"'").list();
	
		session.close();
		
		return incSubList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentSubType> listIncidentSubTypesByTypeId(int id) {
		Session session = this.sessionFactory.openSession();
		List<IncidentSubType> incSubList = session.createQuery("from IncidentSubType where incidentTypeCode='"+id+"'").list();
	
		session.close();
		
		return incSubList;
	}

}
