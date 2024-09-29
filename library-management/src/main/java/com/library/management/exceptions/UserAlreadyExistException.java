package com.library.management.exceptions;

public class UserAlreadyExistException extends Exception {
	public UserAlreadyExistException(){}
	public UserAlreadyExistException(String msg){
		super(msg);
	}
}
