package com.ucsc.mit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ucsc.mit.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addPerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        logger.info("Person saved successfully, Person Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Person> personsList = session.createQuery("from Person").list();
        tx.commit();
        for(Person p : personsList){
            logger.info("Person List::"+p);
        }
        return personsList;
    }
 
}
