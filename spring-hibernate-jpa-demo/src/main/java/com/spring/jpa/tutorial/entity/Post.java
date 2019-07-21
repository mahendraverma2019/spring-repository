package com.spring.jpa.tutorial.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Post")
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	private String title;
	/**
	 * Example of unidirectional one-to many, you use following conf @OneToMany(
	 * cascade = CascadeType.ALL, orphanRemoval = true )
	 *
	 * Issue with this approach is creation of extra table with 2 foreign keys, not
	 * very efficient, to remove this below strategy can be used
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	 * @JoinColumn(name = "post_id")
	 *
	 * Benefit of this strategy, only 2 tables are created, if you
	 * see first persist action happens before collections are
	 * handled, due to this updates happens later to update foreign
	 * keys, same logic applies when you perform delete, first
	 * update will happen and foreign key constraint will be
	 * removed and then delete will happen
	 * 
	 * Bidirectional One-To-Many, The best way to map a @OneToMany
	 * association is to rely on the @ManyToOne side to propagate
	 * all entity state changes
	 * 
	 * @OneToMany( mappedBy = "post", cascade = CascadeType.ALL,
	 *               orphanRemoval = true )
	 * 
	 * @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch =
	 *               FetchType.LAZY, optional = false)
	 */

	// For unidirectional one-to-many
	/*
	 * @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true )
	 */
	// For unidirectional one-to-many with join column
	/*
	 * @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	 * 
	 * @JoinColumn(name = "post_id")
	 */

	// For Bidirectional one-to-many
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostComment> comments = new ArrayList<>();

	// Unidirectional One-to-One
	@OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private PostDetails details;

	// ManyToMany example
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags = new ArrayList<>();

	public void addTag(Tag tag) {
		tags.add(tag);
		tag.getPosts().add(this);
	}

	public void removeTag(Tag tag) {
		tags.remove(tag);
		tag.getPosts().remove(this);
	}

	public Post() {
	}

	public Post(String title) {
		this.title = title;
	}

	public Post(Long id, String title, List<PostComment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PostComment> getComments() {
		return comments;
	}

	public void setComments(List<PostComment> comments) {
		this.comments = comments;
	}

	public void addComment(PostComment comment) {
		comments.add(comment);
		comment.setPost(this);
	}

	public void removeComment(PostComment comment) {
		comments.remove(comment);
		comment.setPost(null);
	}

	public void setDetails(PostDetails details) {
		if (details == null) {
			if (this.details != null) {
				this.details.setPost(null);
			}
		} else {
			details.setPost(this);
		}
		this.details = details;
	}

	public PostDetails getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", comments=" + comments + "]";
	}

}
