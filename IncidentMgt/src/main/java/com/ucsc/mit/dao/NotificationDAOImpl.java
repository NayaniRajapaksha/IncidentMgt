package com.ucsc.mit.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.model.Notification;

public class NotificationDAOImpl implements NotificationDAO{
	
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> listNortificationByIncidentTxn(int incidentNo) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<Notification> mList = session.createQuery("from Notification where id='"+incidentNo+"'").list();
		
		session.close();
		
		return mList;
	}

	@Override
	public void addNotification(Notification n)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(n);
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateNotification(Notification n) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(n);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> listNortificationByNotiftTarget(String dynamicWhere,String target,Date lastSeenDate)throws HibernateException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(dynamicWhere+" == dynamicWhere ==");
	
		

		Session session = this.sessionFactory.openSession();
		List<Notification> mList =null;

		if(lastSeenDate != null){
			mList = session.createQuery("from Notification where "+dynamicWhere+" and notificationDate >'"+dateFormat.format(lastSeenDate)+"'").list();
		}else{
			mList = session.createQuery("from Notification where notifiTarget='"+target+"'").list();
		}
	
		
		session.close();
		
		return mList;
	}



}
