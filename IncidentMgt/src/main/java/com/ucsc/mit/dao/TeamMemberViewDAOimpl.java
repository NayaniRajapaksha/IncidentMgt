package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.IrtImpactUrgency;
import com.ucsc.mit.model.TeamMemberView;

public class TeamMemberViewDAOimpl implements TeamMemberViewDAO{
	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }
	    
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamMemberView> getTeamMemberByUnitCode(int code) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<TeamMemberView> unitList = session.createQuery("from TeamMemberView where unit_id='"+code+"'").list();
		session.close();
		
		return unitList;
	}

	@Override
	public TeamMemberView getTeamMemberById(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		TeamMemberView u = (TeamMemberView) session.load(TeamMemberView.class, id);
		session.close();
		
		return u;
	}

}
