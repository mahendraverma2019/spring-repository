package com.spring.jpa.tutorial.dao;

import java.util.List;

import com.spring.jpa.tutorial.entity.Person;

public interface PersonDao {
   void add(Person person);
   List<Person> listPersons();
   Person findByPrimaryKey(Person person, Long primaryKey);
}
