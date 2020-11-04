package com.alissondev.socialbook.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alissondev.socialbook.dto.BookDTO;
import com.alissondev.socialbook.services.BookService;

@RestController
@RequestMapping("/books")
public class BookResource {
	
	@Autowired
	private BookService service;

	@GetMapping
	public ResponseEntity<List<BookDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<BookDTO> insert(@RequestBody BookDTO dto) {
		dto = service.insert(dto);	
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
}
