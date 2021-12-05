package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.Report;

public class ReportsDAOImpl implements ReportsDAO{
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Report> getReportList() {
		Session session = this.sessionFactory.openSession();
		List<Report> reList = session.createQuery("from Report order by id ").list();
		session.close();
		
		return reList;
	}

	@Override
	@Transactional
	public Report getReportById(int id) {
		Session session = this.sessionFactory.openSession();
		Report u = (Report) session.load(Report.class, id);
		session.close();
		
		return u;

	}

}
