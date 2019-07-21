package com.spring.jpa.tutorial;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jpa.tutorial.config.AppConfig;
import com.spring.jpa.tutorial.entity.Post;
import com.spring.jpa.tutorial.entity.PostComment;
import com.spring.jpa.tutorial.entity.PostDetails;
import com.spring.jpa.tutorial.entity.Tag;
import com.spring.jpa.tutorial.service.PostService;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		/*
		 * PersonService personService = context.getBean(PersonService.class);
		 * 
		 * // Add Persons personService.add(new Person("Sunil", "Bora",
		 * "suni.bora@example.com")); personService.add(new Person("David", "Miller",
		 * "david.miller@example.com")); personService.add(new Person("Sameer", "Singh",
		 * "sameer.singh@example.com")); personService.add(new Person("Paul", "Smith",
		 * "paul.smith@example.com"));
		 * 
		 * // Get Persons List<Person> persons = personService.listPersons(); for
		 * (Person person : persons) { System.out.println("Id = " + person.getId());
		 * System.out.println("First Name = " + person.getFirstName());
		 * System.out.println("Last Name = " + person.getLastName());
		 * System.out.println("Email = " + person.getEmail()); System.out.println(); }
		 * 
		 * // Find Person p = personService.findByPrimaryKey(new Person(), new Long(1));
		 * System.out.println(p.toString());
		 */

		Post post = new Post("First post");

		post.getComments().add(new PostComment("My first review"));
		post.getComments().add(new PostComment("My second review"));
		post.getComments().add(new PostComment("My third review"));
		PostDetails pd = new PostDetails();
		pd.setCreatedBy("Vlad Mihalcea");
		pd.setCreatedOn(new Date(System.nanoTime()));
		pd.setId(1L);
	//	pd.setPost(post);
		post.setDetails(pd);
		
		Tag tag1 = new Tag("Java");
		post.addTag(tag1);
		PostService postService = context.getBean(PostService.class);
		postService.add(post);
		
		Post post1 = postService.find( Post.class, 1L );
		PostComment comment1 = post1.getComments().get( 0 );
		post1.removeComment(comment1);
		postService.add(post1);
		context.close();
	}
}