package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.IrtCloseReason;

class IrtCloseReasonDAOImpl implements IrtCloseReasonDAO{
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
	@Override
	public List<IrtCloseReason> listAllIrtCloseReason() throws HibernateException{
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<IrtCloseReason> cReasonList = session.createQuery("from IrtCloseReason").list();
	
		session.close();
		
		return cReasonList;
	}

}
