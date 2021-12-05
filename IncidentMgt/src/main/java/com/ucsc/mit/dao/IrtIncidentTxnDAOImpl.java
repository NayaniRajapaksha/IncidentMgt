package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ucsc.mit.model.IncidentTxn;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.IrtIncidentTxn;

public class IrtIncidentTxnDAOImpl implements IrtIncidentTxnDAO {

	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }

	@Override
	public void assignIncidentToUnit(IrtIncidentTxn t)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(t);			
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateAssignIncidentToUnit(IrtIncidentTxn t)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(t);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	@Transactional
	public int getRecordCount(int id) throws HibernateException{
		int y=0;
		if(id != 0){
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Object persistentInstance = session.load(IrtIncidentTxn.class, id);
			if (persistentInstance != null) {
			    y=1;
			}
			tx.commit();
			session.close();
		}
		return y;
	}

	@Override
	public IrtIncidentTxn getIRTIncidentById(int id)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		IrtIncidentTxn u = (IrtIncidentTxn) session.load(IrtIncidentTxn.class, id);
		session.close();
		
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IrtIncidentTxn> getIRTIncidentByIncidentNo(int incidentNo) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<IrtIncidentTxn> incList = session.createQuery("from IrtIncidentTxn where incidentNo='"+incidentNo+"'").list();
		session.close();
		
		 return incList;
	}

}
