package com.ucsc.mit.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ucsc.mit.model.VendorInformDetTxn;

public class VendorInformDetTxnDAOImpl implements VendorInformDetTxnDAO{
	
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@Override
	public void addVendorInformDetail(VendorInformDetTxn t) throws HibernateException{
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(t);
		tx.commit();
		session.close();
	}

}
