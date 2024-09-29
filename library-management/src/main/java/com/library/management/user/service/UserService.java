package com.library.management.user.service;

import com.library.management.dto.UserDto;
import com.library.management.exceptions.UserAlreadyExistException;

public interface UserService {
	UserDto addUser(UserDto user) throws UserAlreadyExistException; 
}
