package com.spring.jpa.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.tutorial.dao.PersonDao;
import com.spring.jpa.tutorial.entity.Person;

@Service
public class PersonServiceImp implements PersonService {

   @Autowired
   private PersonDao userDao;

   @Transactional
   @Override
   public void add(Person person) {
      userDao.add(person);
   }

   @Transactional(readOnly = true)
   @Override
   public List<Person> listPersons() {
      return userDao.listPersons();
   }
   @Transactional
   @Override
   public Person findByPrimaryKey(Person person, Long primaryKey) {
	   return userDao.findByPrimaryKey(person, primaryKey);
   }

}
