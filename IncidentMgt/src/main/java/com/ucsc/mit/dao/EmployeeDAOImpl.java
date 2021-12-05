package com.ucsc.mit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ucsc.mit.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    protected Session getCurrentSession(){
    	return sessionFactory.getCurrentSession();	
    }
    
	@Override
	public List<Employee> getEmployeeByEmpId(String empId) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Employee> empList = session.createQuery("from Employee where empId='"+empId+"'").list();
	
		session.close();
		
		return empList;
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Employee u = (Employee) session.load(Employee.class, new Integer(id));
		session.close();
		return u;
	}

}
