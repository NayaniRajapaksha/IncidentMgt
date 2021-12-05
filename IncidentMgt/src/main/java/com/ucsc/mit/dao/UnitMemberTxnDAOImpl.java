package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ucsc.mit.model.IrtUrgency;
import com.ucsc.mit.model.UnitMemberTxn;

public class UnitMemberTxnDAOImpl implements UnitMemberTxnDAO{
	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }
	@Override
	public void addToUnitMemberTxn(UnitMemberTxn t) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(t);			
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnitMemberTxn> getUnitMemberTxnByIncidentNo(int incidentNo)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		List<UnitMemberTxn> mList = session.createQuery("from UnitMemberTxn where incidentID='"+incidentNo+"'").list();
		
		session.close();
		
		return mList;
	}

	@Override
	@Transactional
	public UnitMemberTxn getUnitMemberTxnById(int id)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		UnitMemberTxn u = (UnitMemberTxn) session.load(UnitMemberTxn.class, id);
		session.close();
		
		return u;
	}

	@Override
	@Transactional
	public void updateUnitMemberTxn(UnitMemberTxn t)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(t);
		session.flush();
		tx.commit();
		session.close();
		
	}

}
