package com.galvanize.tmo.paspringstarter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookResponse {

	@JsonProperty("books")
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public static class Book {
		@JsonProperty("id")
		private int id;
		
		@JsonProperty("author")
		private String author;
		
		@JsonProperty("title")
		private String title;
		
		@JsonProperty("yearPublished")
		private int yearPublished;
		
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getYearPublished() {
			return yearPublished;
		}
		public void setYearPublished(int yearPublished) {
			this.yearPublished = yearPublished;
		}
	}
	
}
