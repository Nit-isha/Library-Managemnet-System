package com.library.management.exceptions;

public class BookAlreadyExistException extends Exception {
	public BookAlreadyExistException() {}
	public BookAlreadyExistException(String msg) {
		super(msg);
	}
}
