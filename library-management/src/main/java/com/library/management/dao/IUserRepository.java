package com.library.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.management.dto.BookDto;
import com.library.management.entity.Users;

@Repository
public interface IUserRepository extends CrudRepository<Users, Integer>{
	@Query(value = "select email from users", nativeQuery = true)
	List<String> getAllEmail();
}
