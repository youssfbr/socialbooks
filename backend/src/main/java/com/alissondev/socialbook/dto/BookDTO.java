package com.alissondev.socialbook.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alissondev.socialbook.entities.Book;
import com.alissondev.socialbook.entities.Comment;

public class BookDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;	
	private String name;
	private Date publishing;
	private String publishingCompany;
	private String summary;
	private List<Comment> comments;
	private String author;
	
	public BookDTO() {	
	}

	public BookDTO(Long id, String name, Date publishing, String publishingCompany, String summary,
			List<Comment> comments, String author) {
		this.id = id;
		this.name = name;
		this.publishing = publishing;
		this.publishingCompany = publishingCompany;
		this.summary = summary;
		this.comments = comments;
		this.author = author;
	}
	
	public BookDTO(Book entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.publishing = entity.getPublishing();
		this.publishingCompany = entity.getPublishingCompany();
		this.summary = entity.getSummary();
		this.comments = entity.getComments();
		this.author = entity.getAuthor();
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

	public Date getPublishing() {
		return publishing;
	}

	public void setPublishing(Date publishing) {
		this.publishing = publishing;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
