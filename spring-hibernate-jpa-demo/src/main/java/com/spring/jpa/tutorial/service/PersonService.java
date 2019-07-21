package com.spring.jpa.tutorial.service;

import java.util.List;

import com.spring.jpa.tutorial.entity.Person;

public interface PersonService {
    void add(Person person);
    List<Person> listPersons();
    Person findByPrimaryKey(Person person, Long primaryKey);
}
