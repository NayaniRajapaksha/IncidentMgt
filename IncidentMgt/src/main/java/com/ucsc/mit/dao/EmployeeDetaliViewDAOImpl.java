package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.EmployeeDetailView;
import com.ucsc.mit.model.Faq;

public class EmployeeDetaliViewDAOImpl implements EmployeeDetaliViewDAO {
	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDetailView> getIrtEmployeeByRegionId(int region_id,String groupId)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		List<EmployeeDetailView> mList = session.createQuery("from EmployeeDetailView where enterprise_group='"+groupId+"' and regional_id='"+region_id+"'").list();
		
		session.close();
		
		return mList;
	}

	@Override
	public EmployeeDetailView getUserLevel(int userId) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		EmployeeDetailView u = (EmployeeDetailView) session.load(EmployeeDetailView.class, userId);
		session.close();
		
		return u;
	}

}
