package com.spring.jpa.tutorial.dao;

import com.spring.jpa.tutorial.entity.Post;

public interface PostDao {
	public void add(Post post);
	public Post find(Class<Post> post, Long id);
}
