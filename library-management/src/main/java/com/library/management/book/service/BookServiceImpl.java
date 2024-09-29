package com.library.management.book.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.management.dao.IBookRepository;
import com.library.management.dto.BookDto;
import com.library.management.entity.Book;
import com.library.management.exceptions.*;

@Component
public class BookServiceImpl implements BookService {
	@Autowired
	private IBookRepository iBookRepository;
	
	//Add New Book
	@Override
	public BookDto addBook(BookDto book) throws BookAlreadyExistException{
		List<String> bookNames = iBookRepository.findByName(book);
		for(String name:bookNames) {
			if(name.equals(book.getBookName())) {throw new BookAlreadyExistException();}
		}
		iBookRepository.save(dtoToEntity(book));
		return book;
	}
	//Get All books
	@Override
	public List<BookDto> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		Iterable<Book> list = iBookRepository.findAll();
		list.forEach(b -> bookList.add(b));
		
		List<BookDto> bookDtoList = new ArrayList<>();
		for(Book book: bookList) {
			bookDtoList.add(entityToDto(book));
		}
		return bookDtoList;
	}
	
	//Delete Book
	@Override
	public BookDto deleteBook(int bookId) throws BookIdNotFoundException {
		Optional<Book> optional = iBookRepository.findById(bookId);
		if(optional.isPresent()) {
			iBookRepository.deleteById(bookId);
			return entityToDto(optional.get());
		}else {
			throw new BookIdNotFoundException();
		}
	}
	
	//Find book by ID.
	@Override
	public BookDto findBookById(int bookId) throws BookIdNotFoundException {
		Optional<Book> optional = iBookRepository.findById(bookId);
		if(optional.isPresent()) {
			return entityToDto(optional.get());
		}else {
			throw new BookIdNotFoundException();
		}
	}
	
	//Update Book
	@Override
	public BookDto updateBook(int bookId, BookDto updatedDetails) throws BookIdNotFoundException {
		Optional<Book> optional = iBookRepository.findById(bookId);
		if(optional.isPresent()) {
			Book bookEntity = dtoToEntity(updatedDetails);
			bookEntity.setBookId(optional.get().getBookId());
			iBookRepository.save(bookEntity);
			return entityToDto(optional.get());
		}else {
			throw new BookIdNotFoundException();
		}
	}
	
	public Book dtoToEntity(BookDto book) {
		Book b = new Book();
		b.setBookId(book.getBookId());
		b.setBookName(book.getBookName());
		b.setAuthorName(book.getAuthorName());
		b.setDescription(book.getDescription());
		b.setCost(book.getCost());
		return b;
	}
	public BookDto entityToDto(Book book) {
		BookDto b = new BookDto();
		b.setBookId(book.getBookId());
		b.setBookName(book.getBookName());
		b.setAuthorName(book.getAuthorName());
		b.setDescription(book.getDescription());
		b.setCost(book.getCost());
		return b;
	}
	
}
