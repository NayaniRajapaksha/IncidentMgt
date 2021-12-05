package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.IncidentTicketView;

public class IncidentTicketViewDAOImpl implements IncidentTicketViewDAO{
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
    
	
	@Override
	public IncidentTicketView getIncidentTicketByIncidentNo (int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		IncidentTicketView u = (IncidentTicketView) session.load(IncidentTicketView.class, new Integer(id));
		session.close();
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentTicketView> getIncidentList(String dateFrom, String dateTo) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		String query="from IncidentTicketView where created_date BETWEEN '"+dateFrom+"' AND '"+dateTo+"' ";
		
		List<IncidentTicketView> mList = session.createQuery(query).list();
		
		session.close();
		
		return mList;
	}

}
