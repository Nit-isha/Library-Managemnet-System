package com.library.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.management.book.service.BookService;
import com.library.management.dto.BookDto;
import com.library.management.dto.UserDto;
import com.library.management.exceptions.*;
import com.library.management.user.service.UserService;

@RestController
public class Controller {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/books")
	public ResponseEntity<List<BookDto>> getAllBooks(){
		return new ResponseEntity<List<BookDto>>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@GetMapping(path="/books/{bookId}")
	public ResponseEntity<BookDto> findBookById(@PathVariable int bookId) throws BookIdNotFoundException{
		return new ResponseEntity<BookDto>(bookService.findBookById(bookId), HttpStatus.OK);
	}
	
	@PostMapping(path = "/addbook",produces = {"application/json","application/xml"},
			consumes = {"application/json","application/xml"})
	public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) throws BookAlreadyExistException{
		return new ResponseEntity<BookDto>(bookService.addBook(bookDto), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/books/delete/{bookId}",produces = {"application/json","application/xml"})
	public ResponseEntity<BookDto> deleteBook(@PathVariable int bookId) throws BookIdNotFoundException{
		return new ResponseEntity<BookDto>(bookService.deleteBook(bookId), HttpStatus.OK);
	}
	
	@PutMapping(path = "/updatebook/{bookId}",produces = {"application/json","application/xml"},
			consumes = {"application/json","application/xml"})
	public ResponseEntity<BookDto> updateBook(@PathVariable int bookId, @RequestBody BookDto updatedDetails) throws BookIdNotFoundException{
		return new ResponseEntity<BookDto>(bookService.updateBook(bookId, updatedDetails), HttpStatus.OK);
	}
	
	//USER
	@PostMapping(path = "/adduser",produces = {"application/json","application/xml"},
			consumes = {"application/json","application/xml"})
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) throws UserAlreadyExistException{
		return new ResponseEntity<UserDto>(userService.addUser(userDto), HttpStatus.OK);
	}
}
