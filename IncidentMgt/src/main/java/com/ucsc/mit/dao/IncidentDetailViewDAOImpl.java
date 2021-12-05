package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.IncidentDetailView;

public class IncidentDetailViewDAOImpl implements IncidentDetailViewDAO {

	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }
	    
	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentDetailView> getIncidentDetailByIncidentNo(int id)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		List<IncidentDetailView> mList = session.createQuery("from IncidentDetailView where incident_number='"+id+"'").list();
		
		session.close();
		
		return mList;
	}

	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentDetailView> getIncidentDetailByUnit(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<IncidentDetailView> mList = session.createQuery("from IncidentDetailView where assigned_unit='"+id+"' and status in ('PWU','PWM','RSLV','FBI','RBI','CBU','FIXED') ").list();
		
		session.close();
		
		return mList;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentDetailView> getAllIncidentDetail() throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<IncidentDetailView> mList = session.createQuery("from IncidentDetailView").list();
		
		session.close();
		
		return mList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentDetailView> getIncidentDetailByAssignUser(String userId,int unitId)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		
		List<IncidentDetailView> mList = session.createQuery("from IncidentDetailView where assignee_mem_id='"+userId+"' and assigned_unit='"+unitId+"' and status in ('PWU','PWM','RSLV','FBI','RBI','CBU','FIXED') ").list();
		
		session.close();
		
		return mList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentDetailView> getIncidentDetailForReport(String assignMember, String impactLevel, String urgency,
			String status, String unitId, String incTypeId, String subTypeId, String locId,String fromDate,String toDate)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		String query="from IncidentDetailView where assigned_unit='"+unitId+"' and created_date BETWEEN '"+fromDate+"' AND '"+toDate+"' ";
		if(assignMember!=null){
			query=query+"and assignee_mem_id='"+assignMember+"' ";
		}
		if(impactLevel!=null){
			query=query+"and impact_level='"+impactLevel+"' ";
		}
		if(urgency!=null){
			query=query+"and urgency='"+urgency+"' ";
		}
		if(status!=null){
			query=query+"and status='"+status+"' ";
		}
		if(incTypeId!=null){
			query=query+"and incident_type='"+incTypeId+"' ";
		}
		if(subTypeId!=null){
			query=query+"and incident_sub_type='"+subTypeId+"' ";
		}
		if(locId!=null){
			query=query+"and incident_location_id='"+locId+"' ";
		}
		System.out.println(query);
		//List<IncidentDetailView> mList = session.createQuery("from IncidentDetailView where assignee_mem_id='"+assignMember+"' and assigned_unit='"+unitId+"' and status='"+status+"' and incident_type='"+incTypeId+"' and incident_sub_type='"+subTypeId+"' and incident_location_id='"+locId+"' and impact_level='"+impactLevel+"' and urgency='"+urgency+"'").list();
		List<IncidentDetailView> mList = session.createQuery(query).list();
		
		session.close();
		
		return mList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentDetailView> getCloseIncidentDetailForReport(String assignMember, String impactLevel,
			String urgency, String status, String unitId, String incTypeId, String subTypeId, String locId,
			String fromDate, String toDate) throws HibernateException{
		
		Session session = this.sessionFactory.openSession();
		String query="from IncidentDetailView where status in ('CBE','CBI','CBU','Closed') and created_date BETWEEN '"+fromDate+"' AND '"+toDate+"' ";
		if(assignMember!=null){
			query=query+"and assignee_mem_id='"+assignMember+"' ";
		}
		if(impactLevel!=null){
			query=query+"and impact_level='"+impactLevel+"' ";
		}
		if(urgency!=null){
			query=query+"and urgency='"+urgency+"' ";
		}
		if(unitId!=null){
			query=query+"and assigned_unit='"+unitId+"' ";
		}
		if(incTypeId!=null){
			query=query+"and incident_type='"+incTypeId+"' ";
		}
		if(subTypeId!=null){
			query=query+"and incident_sub_type='"+subTypeId+"' ";
		}
		if(locId!=null){
			query=query+"and incident_location_id='"+locId+"' ";
		}
		System.out.println(query);
		//List<IncidentDetailView> mList = session.createQuery("from IncidentDetailView where assignee_mem_id='"+assignMember+"' and assigned_unit='"+unitId+"' and status='"+status+"' and incident_type='"+incTypeId+"' and incident_sub_type='"+subTypeId+"' and incident_location_id='"+locId+"' and impact_level='"+impactLevel+"' and urgency='"+urgency+"'").list();
		List<IncidentDetailView> mList = session.createQuery(query).list();
		
		session.close();
		
		return mList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentDetailView> getResolveIncidentDetailForReport(String assignMember, String impactLevel,
			String urgency, String status, String unitId, String incTypeId, String subTypeId, String locId,
			String fromDate, String toDate) throws HibernateException{
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		String query="from IncidentDetailView where status in ('RSD','RSLV') and created_date BETWEEN '"+fromDate+"' AND '"+toDate+"' ";
		if(assignMember!=null){
			query=query+"and assignee_mem_id='"+assignMember+"' ";
		}
		if(impactLevel!=null){
			query=query+"and impact_level='"+impactLevel+"' ";
		}
		if(urgency!=null){
			query=query+"and urgency='"+urgency+"' ";
		}
		if(unitId!=null){
			query=query+"and assigned_unit='"+unitId+"' ";
		}
		if(incTypeId!=null){
			query=query+"and incident_type='"+incTypeId+"' ";
		}
		if(subTypeId!=null){
			query=query+"and incident_sub_type='"+subTypeId+"' ";
		}
		if(locId!=null){
			query=query+"and incident_location_id='"+locId+"' ";
		}
		System.out.println(query);
		//List<IncidentDetailView> mList = session.createQuery("from IncidentDetailView where assignee_mem_id='"+assignMember+"' and assigned_unit='"+unitId+"' and status='"+status+"' and incident_type='"+incTypeId+"' and incident_sub_type='"+subTypeId+"' and incident_location_id='"+locId+"' and impact_level='"+impactLevel+"' and urgency='"+urgency+"'").list();
		List<IncidentDetailView> mList = session.createQuery(query).list();
		
		session.close();
		
		return mList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentDetailView> getReopenIncidentDetailForReport(String assignMember, String impactLevel,
			String urgency, String status, String unitId, String incTypeId, String subTypeId, String locId,
			String fromDate, String toDate) throws HibernateException {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		String query="from IncidentDetailView where status in ('RBE','RBI') and created_date BETWEEN '"+fromDate+"' AND '"+toDate+"' ";
		if(assignMember!=null){
			query=query+"and assignee_mem_id='"+assignMember+"' ";
		}
		if(impactLevel!=null){
			query=query+"and impact_level='"+impactLevel+"' ";
		}
		if(urgency!=null){
			query=query+"and urgency='"+urgency+"' ";
		}
		if(unitId!=null){
			query=query+"and assigned_unit='"+unitId+"' ";
		}
		if(incTypeId!=null){
			query=query+"and incident_type='"+incTypeId+"' ";
		}
		if(subTypeId!=null){
			query=query+"and incident_sub_type='"+subTypeId+"' ";
		}
		if(locId!=null){
			query=query+"and incident_location_id='"+locId+"' ";
		}
		System.out.println(query);
		//List<IncidentDetailView> mList = session.createQuery("from IncidentDetailView where assignee_mem_id='"+assignMember+"' and assigned_unit='"+unitId+"' and status='"+status+"' and incident_type='"+incTypeId+"' and incident_sub_type='"+subTypeId+"' and incident_location_id='"+locId+"' and impact_level='"+impactLevel+"' and urgency='"+urgency+"'").list();
		List<IncidentDetailView> mList = session.createQuery(query).list();
		
		session.close();
		
		return mList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncidentDetailView> getIncidentDetailByRegion(int regionId) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<IncidentDetailView> mList = session.createQuery("from IncidentDetailView where regional_id='"+regionId+"' and status in ('INITIAL','FBI','CBU','CBI','RBI','RBE','RSLV') ").list();
		
		session.close();
		
		return mList;
	}

}
