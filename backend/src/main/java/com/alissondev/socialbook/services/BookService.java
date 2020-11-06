package com.alissondev.socialbook.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alissondev.socialbook.dto.BookDTO;
import com.alissondev.socialbook.entities.Book;
import com.alissondev.socialbook.repositories.BookRepository;
import com.alissondev.socialbook.services.exceptions.DatabaseException;
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
		Book book = repository.findById(id).orElseThrow(() -> new NotFoundException("Unable to find entity with id " + id));
		return new BookDTO(book);
	}

	@Transactional
	public BookDTO insert(BookDTO dto) {
		
		Book entity = new Book();
		entity.setName(dto.getName());
		entity.setPublishing(dto.getPublishing());
		entity.setPublishingCompany(dto.getPublishingCompany());
		entity.setSummary(dto.getSummary());
		entity.setAuthor(dto.getAuthor());				
		entity = repository.save(entity);
		
		return new BookDTO(entity);
	}

	@Transactional
	public BookDTO update(Long id, BookDTO dto) {
		try {
			Book entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setPublishing(dto.getPublishing());
			entity.setPublishingCompany(dto.getPublishingCompany());
			entity.setSummary(dto.getSummary());
			entity.setAuthor(dto.getAuthor());
			entity = repository.save(entity);
			
			return new BookDTO(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new NotFoundException("Unable to find entity with id " + id);
		}				
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);	
		} 
		catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("No entity with id " + id + " exists!");		
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}		
	}
	
}
