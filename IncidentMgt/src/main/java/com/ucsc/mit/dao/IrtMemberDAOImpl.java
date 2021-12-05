package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ucsc.mit.model.IrtMember;
import com.ucsc.mit.model.UnitMember;
@Repository
public class IrtMemberDAOImpl implements IrtMemberDAO{
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@Override
	public void addIrtMember(IrtMember u) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
		
	}

	@Override
	@Transactional
	public void deleteIrtMember(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Object persistentInstance = session.load(IrtMember.class, id);
		if (persistentInstance != null) {
		    session.delete(persistentInstance);
		}
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateIrtMember(IrtMember u) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(u.getId() !=0){
			session.update(u);	
		}else{
			session.save(u);
		}
		
		session.flush();
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IrtMember> listMembersByRegion(int regionId) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		List<IrtMember> mList = session.createQuery("from IrtMember where regionId='"+regionId+"'").list();
		
		session.close();
		
		return mList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IrtMember> getMemberByMemberID(int member_id)throws HibernateException {
		Session session = this.sessionFactory.openSession();
		List<IrtMember> mList = session.createQuery("from IrtMember where memberId='"+member_id+"'").list();
		
		session.close();
		
		return mList;
	}
}
