package com.alissondev.socialbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alissondev.socialbook.entities.Book;
import com.alissondev.socialbook.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return repository.findAll();
	}
}
