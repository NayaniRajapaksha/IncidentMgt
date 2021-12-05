package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.IrtImpactLevel;
import com.ucsc.mit.model.IrtImpactUrgency;
import com.ucsc.mit.model.IrtMember;

public class IrtImpactUrgencyDAOImpl implements IrtImpactUrgencyDAO{
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<IrtImpactUrgency> getImpactUrgencyCode(String impactLevel, String urgency)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		List<IrtImpactUrgency> mList = session.createQuery("from IrtImpactUrgency where urgency='"+urgency+"' and impactLevel='"+impactLevel+"'").list();
		
		session.close();
		
		return mList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IrtImpactUrgency> getDataByImpactUrgencyCode(String impUrgCode) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<IrtImpactUrgency> mList = session.createQuery("from IrtImpactUrgency where impUrgencyCode='"+impUrgCode+"'").list();
		
		session.close();
		
		return mList;
	}

	@Override
	public IrtImpactUrgency getIrtImpactUrgencyData(int id)throws HibernateException{
		Session session = this.sessionFactory.openSession();
		IrtImpactUrgency u = (IrtImpactUrgency) session.load(IrtImpactUrgency.class, id);
		session.close();
		
		return u;
	}

}
