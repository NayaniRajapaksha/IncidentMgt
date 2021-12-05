package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.UnitAssignHistoryView;

public class UnitAssignHistoryViewDAOImpl implements UnitAssignHistoryViewDAO{

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<UnitAssignHistoryView> getUnitAssignHisByIncidentNo(int id)throws HibernateException  {
		Session session = this.sessionFactory.openSession();
		List<UnitAssignHistoryView> mList = session.createQuery("from UnitAssignHistoryView where incident_id='"+id+"' order by assignDate").list();
		
		session.close();
		
		return mList;
	}

}
