package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.Faq;
import com.ucsc.mit.model.SimilarSolutionView;

public class SimilarSolutionDAOImpl implements SimilarSolutionDAO{
	
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<SimilarSolutionView> getSmByIncidentType(String typeId, String subTypeId) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		
		List<SimilarSolutionView> mList = session.createQuery("from SimilarSolutionView where typeCode='"+typeId+"' and subTypeName='"+subTypeId+"' ").list();
		
		session.close();
		
		return mList;
	}

}
