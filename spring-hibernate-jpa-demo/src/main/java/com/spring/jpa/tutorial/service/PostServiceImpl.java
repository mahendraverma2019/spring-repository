package com.spring.jpa.tutorial.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.tutorial.dao.PostDao;
import com.spring.jpa.tutorial.entity.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;
	
	@Transactional
	@Override
	public void add(Post post) {
		postDao.add(post);

	}
	
	@Transactional
	@Override
	public Post find(Class<Post> post, Long id) {
		return postDao.find(post, id);
	}

}
