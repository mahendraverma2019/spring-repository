package com.spring.jpa.tutorial.service;

import com.spring.jpa.tutorial.entity.Post;

public interface PostService {
	public void add(Post post);
	public Post find(Class<Post> class1, Long id);
}
