package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ucsc.mit.model.Branch;

@Repository
public class BranchDAOImpl implements BranchDAO{
	
	 	private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Branch> getAllRegionsAndDepartments() throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<Branch> reList = session.createQuery("from Branch where branchType in('REGION')").list();
		session.close();
		
		return reList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Branch> getAllLocations() throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<Branch> reList = session.createQuery("from Branch").list();
		session.close();
		
		return reList;
	}

	@Override
	@Transactional
	public int getRegionIdByBranchCode(int branch_code) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		int region_id = session.createQuery("from Branch where branchId='"+branch_code+"'").getFirstResult();
		session.close();
		
		return region_id;
	}
}
