package com.spring.jpa.tutorial.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity(name = "Tag")
@Table(name = "tag")
public class Tag {
	@Id
    @GeneratedValue
    private Long id;
 
    @NaturalId
    private String name;
 
    @ManyToMany(mappedBy = "tags")
    private List<Post> posts = new ArrayList<>();
 
    public Tag() {}
 
    public Tag(String name) {
        this.name = name;
    }    
 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}
    
    
}
