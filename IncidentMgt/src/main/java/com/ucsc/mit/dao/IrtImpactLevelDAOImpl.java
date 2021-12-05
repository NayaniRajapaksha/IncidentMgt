package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.IrtImpactLevel;
import com.ucsc.mit.model.IrtImpactUrgency;
import com.ucsc.mit.model.IrtUrgency;

public class IrtImpactLevelDAOImpl implements IrtImpactLevelDAO{

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
	@Override
	public List<IrtImpactLevel> listAllIrtImpactLevels() throws HibernateException {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<IrtImpactLevel> impList = session.createQuery("from IrtImpactLevel").list();
	
		session.close();
		
		return impList;
	}

	@Override
	@Transactional
	public IrtImpactLevel getImpactLevelData(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		IrtImpactLevel u = (IrtImpactLevel) session.load(IrtImpactLevel.class, id);
		session.close();
		
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IrtImpactLevel> getDataByImpactCode(String code) throws HibernateException {
		Session session = this.sessionFactory.openSession();
		List<IrtImpactLevel> mList = session.createQuery("from IrtImpactLevel where impactLvlCode='"+code+"'").list();
		
		session.close();
		
		return mList;
	}

}
