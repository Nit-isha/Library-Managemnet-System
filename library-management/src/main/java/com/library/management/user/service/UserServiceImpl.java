package com.library.management.user.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.library.management.dao.IUserRepository;
import com.library.management.dto.*;
import com.library.management.entity.*;
import com.library.management.exceptions.UserAlreadyExistException;

@Component
public class UserServiceImpl implements UserService{
	@Autowired
	private IUserRepository iUserRepository;

	@Override
	public UserDto addUser(UserDto user) throws UserAlreadyExistException{
		List<String> emails = iUserRepository.getAllEmail();
		for(String email: emails) {
			if(email.equals(user.getEmail())) {throw new UserAlreadyExistException();}
		}
		user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
		iUserRepository.save(dtoToEntity(user));
		return user;
	}
	
	public Users dtoToEntity(UserDto user) {
		Users u = new Users();
		u.setUserId(user.getUserId());
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPhone(user.getPhone());
		u.setPassword(user.getPassword());
		return u;
	}
	public UserDto entityToDto(Users user) {
		UserDto u = new UserDto();
		u.setUserId(user.getUserId());
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPhone(user.getPhone());
		u.setPassword(user.getPassword());
		return u;
	}
}
