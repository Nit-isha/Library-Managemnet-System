package com.library.management.exceptions;

public class BookIdNotFoundException extends Exception {
	public BookIdNotFoundException() {}
	public BookIdNotFoundException(String msg) {
		super(msg);
	}
}
