package com.alissondev.socialbook.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alissondev.socialbook.entities.Book;

@RestController
@RequestMapping("/books")
public class BookResource {

	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		
		List<Book> books = new ArrayList<>();
		books.add(new Book(1L, "Git - step by step"));
		books.add(new Book(2L, "Java forever"));
		
		return ResponseEntity.ok(books);
	}
}
