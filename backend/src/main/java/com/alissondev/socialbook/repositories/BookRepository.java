package com.alissondev.socialbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissondev.socialbook.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
