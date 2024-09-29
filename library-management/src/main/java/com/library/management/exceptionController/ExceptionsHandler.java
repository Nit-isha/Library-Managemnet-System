package com.library.management.exceptionController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.library.management.exceptions.*;

@RestControllerAdvice
public class ExceptionsHandler {
	@ExceptionHandler(BookAlreadyExistException.class)
	public ResponseEntity<APIError> bookAlreadyExistException(Exception e){
		APIError error = new APIError("Book already exists in Database", 400);
		return new ResponseEntity<APIError>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BookIdNotFoundException.class)
	public ResponseEntity<APIError> bookIdNotFoundException(Exception e){
		APIError error = new APIError("Book ID doesn't exist", 400);
		return new ResponseEntity<APIError>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<APIError> userAlreadyExistException(Exception e){
		APIError error = new APIError("User already exists!", 400);
		return new ResponseEntity<APIError>(error, HttpStatus.BAD_REQUEST);
	}
	
}
