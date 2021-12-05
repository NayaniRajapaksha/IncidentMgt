package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.IncidentTxn;
import com.ucsc.mit.model.IrtImpactLevel;
import com.ucsc.mit.model.IrtUrgency;

public class IrtUrgencyDAOImpl implements IrtUrgencyDAO{

private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
	@Override
	public List<IrtUrgency> listAllUrgendyCodes() throws HibernateException{
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<IrtUrgency> urList = session.createQuery("from IrtUrgency").list();
	
		session.close();
		
		return urList;
	}

	@Override
	@Transactional
	public IrtUrgency getUrgencyData(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		IrtUrgency u = (IrtUrgency) session.load(IrtUrgency.class, id);
		session.close();
		
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IrtUrgency> getDataByUrgencyCode(String code) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<IrtUrgency> mList = session.createQuery("from IrtUrgency where urgencyCode='"+code+"'").list();
		
		session.close();
		
		return mList;
	}

}
