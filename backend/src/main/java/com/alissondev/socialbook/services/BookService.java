package com.alissondev.socialbook.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alissondev.socialbook.dto.BookDTO;
import com.alissondev.socialbook.entities.Book;
import com.alissondev.socialbook.repositories.BookRepository;
import com.alissondev.socialbook.services.exceptions.NotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	@Transactional(readOnly = true)
	public List<BookDTO> findAll() {		
		List<Book> list = repository.findAll();		
		return list.stream().map(x -> new BookDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public BookDTO findById(Long id) {
		Book book = repository.findById(id).orElseThrow(() -> new NotFoundException("Id " + id + " not found"));
		return new BookDTO(book);
	}

	@Transactional
	public BookDTO insert(BookDTO dto) {
		
		Book entity = new Book();
		entity.setName(dto.getName());
		entity.setPublishingCompany(dto.getPublishingCompany());
		entity.setAuthor(dto.getAuthor());				
		entity = repository.save(entity);
		
		return new BookDTO(entity);
	}
}
