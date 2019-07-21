package com.spring.jpa.tutorial.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import com.spring.jpa.tutorial.entity.Post;

@Repository
public class PostDaoImpl implements PostDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	@Override
	public void add(Post post) {
		em.persist(post);
	}
	
	@Override
	public	Post find(Class<Post> post, Long id) {
		return em.find(Post.class, id);
	}

}
