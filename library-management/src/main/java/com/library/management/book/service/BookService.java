package com.library.management.book.service;

import java.util.List;

import com.library.management.dto.BookDto;
import com.library.management.exceptions.BookAlreadyExistException;
import com.library.management.exceptions.BookIdNotFoundException;

public interface BookService {
	BookDto addBook(BookDto book) throws BookAlreadyExistException;

	List<BookDto> getAllBooks();
	
	BookDto findBookById(int bookId) throws BookIdNotFoundException;
	
	BookDto deleteBook(int bookId) throws BookIdNotFoundException;
	
	BookDto updateBook(int bookId, BookDto updatedDetails) throws BookIdNotFoundException;
}
