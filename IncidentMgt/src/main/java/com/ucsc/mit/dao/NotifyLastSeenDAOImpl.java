package com.ucsc.mit.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ucsc.mit.common.SessionUtils;
import com.ucsc.mit.model.NotifyLastSeen;
import com.ucsc.mit.model.UnitMember;

public class NotifyLastSeenDAOImpl implements NotifyLastSeenDAO{

private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@Override
	public void addSeenNotification(NotifyLastSeen n) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(n);
		tx.commit();
		session.close();
		
	}

	@Override
	public Date getLastSeenDateByUser(String userId)throws HibernateException {
		
		Session session = this.sessionFactory.openSession();
		String query="select max(lastSeenDate) from NotifyLastSeen where notifyUserId='"+userId+"'";
		Date lastSeenDate = (Date)session.createQuery(query).uniqueResult();	
		session.close();
		return lastSeenDate;
	}
}
