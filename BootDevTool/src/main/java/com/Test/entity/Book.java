package com.Test.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Books")
public class Book {
	
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_Id")
	private int Id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	private String Title;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author =author;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Book(int id, Author author, String title) {
		super();
		Id = id;
		this.author=author;
		Title = title;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", Author=" + author + ", Title=" + Title + "]";
	}
	
	
	
		
	
	
	

}
