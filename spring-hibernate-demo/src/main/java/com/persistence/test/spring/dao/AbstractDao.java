package com.persistence.test.spring.dao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}
	
	public void merge(Object entity) {
		getSession().merge(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}
	
	public void save(Object entity) {
		getSession().save(entity);
	}
	
	public void update(Object entity) {
		getSession().update(entity);
	}
	
	public <T> Object load(Class<T> entityName,Serializable entity) {
		return getSession().load(entityName, entity);
	}
	
	public <T> Object get(Class<T> entityName,Serializable entity) {
		return getSession().get(entityName,entity);
	}
	
	public <T> IdentifierLoadAccess byId(Class<T> entityName) {
		return getSession().byId(entityName);
	}
	
	public <T> IdentifierLoadAccess byId(String entityName) {
		return getSession().byId(entityName);
	}
	
	public <T> Criteria createCriteria(Class<T> entityName) {
		return getSession().createCriteria(entityName);
	}
}
