package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ucsc.mit.model.Employee;
import com.ucsc.mit.model.IncidentStatus;

public class IncidentStatusDAOImpl implements IncidentStatusDAO {
	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	    protected Session getCurrentSession(){
	    	return sessionFactory.getCurrentSession();	
	    }

		@SuppressWarnings("unchecked")
		@Override
		public List<IncidentStatus> getIncidentStatusForIrt() throws HibernateException{
			Session session = this.sessionFactory.openSession();
			List<IncidentStatus> unitList = session.createQuery("from IncidentStatus where status_code in ('CBE','CBI','CBU','FBI','ROLLEDBACK') order by irt_seq").list();
			session.close();
			
			return unitList;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<IncidentStatus> getIncidentStatusForDependency() throws HibernateException{
			Session session = this.sessionFactory.openSession();
			List<IncidentStatus> unitList = session.createQuery("from IncidentStatus where status_code in ('CBE','CBI','CBU','FBI','ROLLEDBACK') order by dependency_seq").list();
			session.close();
			
			return unitList;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<IncidentStatus> getIncidentStatusForGRP() throws HibernateException{
			Session session = this.sessionFactory.openSession();
			List<IncidentStatus> unitList = session.createQuery("from IncidentStatus where status_code in ('PWI','PWU','ROLLEDBACK') order by grp_s_seq").list();
			session.close();
			
			return unitList;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<IncidentStatus> getIncidentStatusForIrtSecondSet() throws HibernateException{
			Session session = this.sessionFactory.openSession();
			List<IncidentStatus> unitList = session.createQuery("from IncidentStatus where status_code in ('INITIAL','PWU','RSLV','RBI','RBE') order by irt_seq").list();
			session.close();
			
			return unitList;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<IncidentStatus> getIncidentStatusForIncidentAction() throws HibernateException{
			Session session = this.sessionFactory.openSession();
			List<IncidentStatus> unitList = session.createQuery("from IncidentStatus where status_code in ('INP','OH','RSD')").list();
			session.close();
			
			return unitList;
		}

		@Override
		public IncidentStatus getIncidentStatusById(int id) throws HibernateException{
			Session session = this.sessionFactory.openSession();
			IncidentStatus u = (IncidentStatus) session.load(IncidentStatus.class, new Integer(id));
			session.close();
			return u;
		}

		@Override
		public List<IncidentStatus> getAllIncidentStatus() throws HibernateException{
			Session session = this.sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			List<IncidentStatus> unitList = session.createQuery("from IncidentStatus").list();
			session.close();
			
			return unitList;
		}
}
