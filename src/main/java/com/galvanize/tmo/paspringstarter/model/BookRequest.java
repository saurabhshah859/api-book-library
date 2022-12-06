package com.galvanize.tmo.paspringstarter.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRequest {
	
	@JsonProperty("author")
	@NotNull(message = "author is mandatory.")
	private String author;
	
	@JsonProperty("title")
	@NotNull(message = "title is mandatory.")
	private String title;
	
	@JsonProperty("yearPublished")
	private int yearPublished;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
