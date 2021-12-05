package com.ucsc.mit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserGroupDAOImpl implements UserGroupDAO{
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
    
	@SuppressWarnings("unused")
	@Override
	public void getUpdateGroupByEmpId(String empId,String group_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hqlUpdate = "update UserGroupTxn c set c.ent_group_id = :group_id where c.user_id = :empId";
		
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setString( "group_id", group_id )
		        .setString( "empId", empId )
		        .executeUpdate();
		tx.commit();
		session.close();
		
	}

}
