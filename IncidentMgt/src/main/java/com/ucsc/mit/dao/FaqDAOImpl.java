package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ucsc.mit.model.Faq;
import com.ucsc.mit.model.UnitMember;

public class FaqDAOImpl implements FaqDAO {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
    
	@Override
	public void  addFaq(Faq v) throws HibernateException{
		
		
		 
		 	Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(v);
			tx.commit();
			session.close();
		 
		 
	   
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Faq> listFaqs() throws HibernateException {
		Session session = this.sessionFactory.openSession();
		List<Faq> faqList = session.createQuery("from Faq").list();
		session.close();
		
        return faqList;
	}

	@Override
	public void updateFaq(Faq v) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(v);
		session.flush();
		tx.commit();
		session.close();
	}

	@Override
	@Transactional
	public Faq getFaqByCode(int code) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Faq u = (Faq) session.load(Faq.class, code);
		session.close();
		
		return u;
	}

	@Override
	@Transactional
	public void deleteFaq(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Object persistentInstance = session.load(Faq.class, id);
		if (persistentInstance != null) {
		    session.delete(persistentInstance);
		}
		tx.commit();
		session.close();
		
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Faq> getFaqByIncidentType(String typeId, String subTypeId)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		
		List<Faq> mList = session.createQuery("from Faq where typeCode='"+typeId+"' and subTypeName='"+subTypeId+"' ").list();
		
		session.close();
		
		return mList;
	}

}
