package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.VendorSummaryView;

public class VendorSummaryViewDAOImpl implements VendorSummaryViewDAO{
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<VendorSummaryView> getVendorSummaryReport( String ven_name,
			String progress, String fromDate, String toDate) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		String query="from VendorSummaryView where CREATED_DATE BETWEEN '"+fromDate+"' AND '"+toDate+"' ";
		
		
		if(ven_name!=null){
			query=query+"and VEN_NAME='"+ven_name+"' ";
		}
		if(progress!=null){
			query=query+"and STATUS='"+progress+"' ";
		}
		System.out.println(query);
		
		List<VendorSummaryView> mList = session.createQuery(query).list();
		
		session.close();
		
		return mList;
	}
}
