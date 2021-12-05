package com.ucsc.mit.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ucsc.mit.model.Dependency;
import com.ucsc.mit.model.DependencyCloseReason;
import com.ucsc.mit.model.DependencyDetailView;
import com.ucsc.mit.model.DependencyStatus;
import com.ucsc.mit.model.IncidentTxn;

public class DependencyDAOImpl implements DependencyDAO{
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@Override
	public void addDependency(Dependency t) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(t);			
		tx.commit();
		session.close();
		
	}

	@Override
	public Dependency getDependencyById(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Dependency u = (Dependency) session.load(Dependency.class, id);
		session.close();
		
		return u;
	}

	@Override
	public List<Dependency> listDependencyForUnit(int id)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Dependency> incList = session.createQuery("from Dependency where unit_id='"+id+"'").list();
		session.close();
		
		 return incList;
	}

	@Override
	public List<DependencyDetailView> listDependencyFromViewForUnit(int id)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DependencyDetailView> incList = session.createQuery("from DependencyDetailView where unit_id='"+id+"'").list();
		session.close();
		
		 return incList;
	}

	@SuppressWarnings("unused")
	@Override
	public void updateAssignMember(int dep_id, String emp_id, String dep_status) throws HibernateException{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hqlUpdate = "update Dependency c set c.assinged_member = :emp_id , c.dependency_status = :dep_status where c.dependency_id = :dep_id";
		
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setString( "emp_id", emp_id )
		        .setString( "dep_status", dep_status )
		        .setInteger( "dep_id", dep_id )
		        .executeUpdate();
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DependencyStatus> listDependencyStatus() throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<DependencyStatus> incList = session.createQuery("from DependencyStatus").list();
		session.close();
		
		 return incList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DependencyCloseReason> listDependencyCloseReason() throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<DependencyCloseReason> incList = session.createQuery("from DependencyCloseReason").list();
		session.close();
		
		 return incList;
	}

	@SuppressWarnings("unused")
	@Override
	public void updateDependencyAction(int dep_id, Date statusTime, String dep_status, String action) throws HibernateException{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hqlUpdate = "update Dependency c set c.modified_date = :statusTime , c.dependency_status = :dep_status,c.resolved_des = :action where c.dependency_id = :dep_id";
		
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setDate( "statusTime", statusTime )
		        .setString( "dep_status", dep_status )
		        .setString( "action", action )
		        .setInteger( "dep_id", dep_id )
		        .executeUpdate();
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unused")
	@Override
	public void closeDependency(int dep_id, Date statusTime, String reason) throws HibernateException{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String dep_status="CD";
		String hqlUpdate = "update Dependency c set c.modified_date = :statusTime , c.dependency_status = :dep_status,c.depend_close_reason = :reason where c.dependency_id = :dep_id";
		
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setDate( "statusTime", statusTime )
		        .setString( "dep_status", dep_status )
		        .setString( "reason", reason )
		        .setInteger( "dep_id", dep_id )
		        .executeUpdate();
		tx.commit();
		session.close();
	}
	
	
}
