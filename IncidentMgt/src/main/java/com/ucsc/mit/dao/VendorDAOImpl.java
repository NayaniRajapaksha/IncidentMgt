package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.ucsc.mit.model.Vendor;

@Repository
public class VendorDAOImpl implements VendorDAO{

	private static final Logger logger = LoggerFactory.getLogger(VendorDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
    
    
	@Override
	public String addVendor(Vendor v) throws HibernateException{
		String outcome = null;
		
//			 Transaction tx=getCurrentSession().beginTransaction();
//			 getCurrentSession().save(v);
//			 tx.commit();
			 
			 	Session session = this.sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.save(v);
				tx.commit();
				session.close();
			 
			 
		     outcome = "success";
		
		return outcome;	 
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> listVendors()throws HibernateException {
		
		Session session = this.sessionFactory.openSession();
		List<Vendor> venList = session.createQuery("from Vendor").list();
		session.close();
		
        return venList;
	}

	@Override
	
	public String updateVendor(Vendor v) throws HibernateException{
			String outcome = null;
		
		
			
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(v);
			session.flush();
			tx.commit();
			session.close();

		    outcome = "success";
		  
		
		return outcome;	 
		
	}

	@Override
	@Transactional
	public Vendor getVendorByCode(int code) throws HibernateException{

		
		Session session = this.sessionFactory.openSession();
		Vendor u = (Vendor) session.load(Vendor.class, code);
		session.close();
		
		return u;
	}

}
