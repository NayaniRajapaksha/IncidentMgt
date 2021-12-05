package com.ucsc.mit.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ucsc.mit.model.IncidentDetailView;
import com.ucsc.mit.model.IncidentSubType;
import com.ucsc.mit.model.IncidentTxn;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.IrtIncidentDetailView;

public class IncidentTxnDAOImpl implements IncidentTxnDAO{

	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }

		@SuppressWarnings("unchecked")
		@Override
		public List<IncidentTxn> listAllIncidents() throws HibernateException{
			Session session = this.sessionFactory.openSession();
			List<IncidentTxn> incList = session.createQuery("from IncidentTxn").list();
			session.close();
			
			 return incList;
		}

		@Override
		public void addIncident(IncidentTxn t) throws HibernateException{
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(t);			
			tx.commit();
			session.close();
			
		}

		@Override
		@Transactional
		public IncidentTxn getIncidentById(int id) throws HibernateException{
			Session session = this.sessionFactory.openSession();
			IncidentTxn u = (IncidentTxn) session.load(IncidentTxn.class, id);
			session.close();
			
			return u;
		}

		@Override
		@Transactional
		public void deleteIncident(int id) throws HibernateException{
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Object persistentInstance = session.load(IncidentTxn.class, id);
			if (persistentInstance != null) {
			    session.delete(persistentInstance);
			}
			tx.commit();
			session.close();
			
		}

		@Override
		public void updateIncident(IncidentTxn t) throws HibernateException{
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update("PWU", t);
			session.flush();
			tx.commit();
			session.close();
			
		}
		
		@Override
		@Transactional
		public void updateIncidentStatus(int id, String status)throws HibernateException {
			// TODO Auto-generated method stub
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.createQuery("Update IncidentTxn SET status ='"+status+"' WHERE  id = '"+id+"'");
			session.flush();
			tx.commit();
			session.close();
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<IrtIncidentDetailView> listAllIncidentsByRegion(int region_id)throws HibernateException {
			Session session = this.sessionFactory.openSession();
			List<IrtIncidentDetailView> mList = session.createQuery("from IrtIncidentDetailView where regional_id='"+region_id+"' and status in ('INITIAL','FBI','CBU','CBI','RBI','RBE','RSLV') ").list();
			
			session.close();
			
			return mList;
		}
}
