package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.UnitIncidentSummaryView;

public class UnitSummaryViewDAOImpl implements UnitSummaryViewDAO{
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<UnitIncidentSummaryView> getUnitSummaryReport(String unitId, String fromDate, String toDate) {
		Session session = this.sessionFactory.openSession();
		String query="from UnitIncidentSummaryView where CREATED_DATE BETWEEN '"+fromDate+"' AND '"+toDate+"' ";
		
		if(unitId!=null){
			query=query+"and ASSIGNED_UNIT_ID='"+unitId+"' ";
		}
		
		System.out.println(query);
		
		List<UnitIncidentSummaryView> mList = session.createQuery(query).list();
		
		session.close();
		
		return mList;
	}
	

}
