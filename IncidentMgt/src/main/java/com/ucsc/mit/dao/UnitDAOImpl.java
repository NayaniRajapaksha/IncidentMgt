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

import com.ucsc.mit.model.Unit;

@Repository
public class UnitDAOImpl implements UnitDAO{

private static final Logger logger = LoggerFactory.getLogger(UnitDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Unit> listUnits() throws HibernateException{
		// TODO Auto-generated method stub
	
		Session session = this.sessionFactory.openSession();
		List<Unit> unitList = session.createQuery("from Unit").list();
		session.close();
		
		return unitList;
	}

	@Override
	public void save(Unit u) throws HibernateException {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(u);
		tx.commit();
		session.close();
	
	}

	@Override
	public void updateUnit(Unit u) throws HibernateException{
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(u);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	@Transactional
	public Unit getUnitByCode(int code) throws HibernateException{
		
		
		Session session = this.sessionFactory.openSession();
		Unit u = (Unit) session.load(Unit.class, new Integer(code));
		session.close();
		return u;
		
	}

	

}
