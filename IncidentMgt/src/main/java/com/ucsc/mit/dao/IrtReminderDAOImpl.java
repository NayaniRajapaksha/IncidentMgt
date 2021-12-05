package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.IrtReminder;

public class IrtReminderDAOImpl implements IrtReminderDAO {
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
	@Override
	public List<IrtReminder> listAllReminders() throws HibernateException{
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<IrtReminder> remList = session.createQuery("from IrtReminder").list();
	
		session.close();
		
		return remList;
	}

}
