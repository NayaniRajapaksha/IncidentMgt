package com.ucsc.mit.dao;

import java.util.List;

import com.ucsc.mit.model.Person;
 
public interface PersonDAO {
 
    public void addPerson(Person p);
    public List<Person> listPersons();
}