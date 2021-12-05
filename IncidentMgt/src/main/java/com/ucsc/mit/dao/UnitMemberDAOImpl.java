package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.IncidentType;
import com.ucsc.mit.model.UnitMember;

public class UnitMemberDAOImpl implements UnitMemberDAO{
	
	private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }
	@Override
	public void addMember(UnitMember u) throws HibernateException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<UnitMember> listMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(UnitMember u) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnitMember> getMemberByMemberId(int id) throws HibernateException {
		Session session = this.sessionFactory.openSession();
		
		List<UnitMember> mList = session.createQuery("from UnitMember where memberId='"+id+"'").list();
		
		session.close();
		
		return mList;
	}

	@Override
	public List<UnitMember> listMembersByUnit(int unitId) throws HibernateException {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UnitMember> mList = session.createQuery("from UnitMember where unitId='"+unitId+"'").list();
		
		session.close();
		
		return mList;
	}

	@Override
	public void deleteUnitMember(int id) throws HibernateException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Object persistentInstance = session.load(UnitMember.class, id);
		if (persistentInstance != null) {
		    session.delete(persistentInstance);
		}
		tx.commit();
		session.close();
		
	}



	

}
