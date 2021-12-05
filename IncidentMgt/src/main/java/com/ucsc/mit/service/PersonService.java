package com.ucsc.mit.service;

import java.util.List;

import com.ucsc.mit.model.Person;
 
public interface PersonService {
 
    public void addPerson(Person p);
    public List<Person> listPersons();
     
}