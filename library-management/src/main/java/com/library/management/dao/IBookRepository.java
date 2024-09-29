package com.library.management.dao;

import org.springframework.stereotype.Repository;

import com.library.management.dto.BookDto;
import com.library.management.entity.Book;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

@Repository
public interface IBookRepository extends CrudRepository<Book, Integer> {
	@Query(value = "select book_name from book", nativeQuery = true)
	List<String> findByName(BookDto book);

}
