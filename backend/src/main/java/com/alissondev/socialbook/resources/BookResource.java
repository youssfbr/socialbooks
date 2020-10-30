package com.alissondev.socialbook.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alissondev.socialbook.entities.Book;
import com.alissondev.socialbook.services.BookService;

@RestController
@RequestMapping("/books")
public class BookResource {
	
	@Autowired
	private BookService service;

	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
}
