package com.spring.jpa.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "PostComment")
@Table(name = "post_comment")
public class PostComment {
	@Id
    @GeneratedValue
    private Long id;
 
    private String review;

    //Bidirectional @OneToMany
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public PostComment() {
	}

	public PostComment(String review) {
		this.review = review;
	}
	
	public PostComment(Long id, String review) {
		this.id = id;
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostComment )) return false;
        return id != null && id.equals(((PostComment) o).getId());
    }
	
    @Override
    public int hashCode() {
        return 31*id.hashCode();
    }
    
	@Override
	public String toString() {
		return "PostComment [id=" + id + ", review=" + review + "]";
	}   
    
}
