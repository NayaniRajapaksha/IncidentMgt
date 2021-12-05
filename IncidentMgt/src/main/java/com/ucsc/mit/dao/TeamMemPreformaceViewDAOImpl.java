package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.IncidentDetailView;
import com.ucsc.mit.model.TeamMemPreformaceView;

public class TeamMemPreformaceViewDAOImpl implements TeamMemPreformaceViewDAO {
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<TeamMemPreformaceView> getTeamPerformanceReport(String assignMember, String unitId, String fromDate,
			String toDate) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		String query="from TeamMemPreformaceView where CREATED_DATE BETWEEN '"+fromDate+"' AND '"+toDate+"' ";
		if(assignMember!=null){
			query=query+"and NAME='"+assignMember+"' ";
		}
		if(unitId!=null){
			query=query+"and ASSIGNED_UNIT='"+unitId+"' ";
		}
		
		System.out.println(query);
		
		List<TeamMemPreformaceView> mList = session.createQuery(query).list();
		
		session.close();
		
		return mList;
	}

	
}
