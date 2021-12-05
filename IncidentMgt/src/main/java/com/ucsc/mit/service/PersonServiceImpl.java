package com.ucsc.mit.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucsc.mit.dao.PersonDAO;
import com.ucsc.mit.model.Person;

@Service
@ManagedBean(name="personService")
@SessionScoped
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;
	 
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
 
    @Override
    @Transactional
    public void addPerson(Person p) {
        this.personDAO.addPerson(p);
       
    }
 
    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }
 
}
