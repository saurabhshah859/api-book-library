package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.tmo.paspringstarter.model.BookRequest;
import com.galvanize.tmo.paspringstarter.model.BookResponse;
import com.galvanize.tmo.paspringstarter.model.BookResponse.Book;

@RestController
@RequestMapping("/api")
@Validated
public class LibraryController {
	
	private BookResponse bookResponse = new BookResponse();
	private List<Book> bookList = new ArrayList<>();
	
	@PostMapping(value = "/books")
	public ResponseEntity<Book> creatBook(@RequestBody @Valid BookRequest request){
		
		Book addBook = new Book();
		
		addBook.setId((bookResponse.getBooks() != null && !bookResponse.getBooks().isEmpty()) ? bookResponse.getBooks().size() + 1 : 1);
		addBook.setAuthor(request.getAuthor());
		addBook.setTitle(request.getTitle());
		addBook.setYearPublished(request.getYearPublished());
		
		bookList.add(addBook);
		bookResponse.setBooks(bookList);
		return new ResponseEntity<>(addBook, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/books")
	public ResponseEntity<BookResponse> getBookList(){
		if (bookResponse.getBooks() != null && !bookResponse.getBooks().isEmpty()) {
			Collections.sort(bookResponse.getBooks(), (o1, o2) -> (o1.getAuthor().compareTo(o2.getAuthor())));
		}
		return new ResponseEntity<>(bookResponse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/books")
	public ResponseEntity<Void> deleteBookList(){
		bookResponse = new BookResponse();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	
}
