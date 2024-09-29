package com.library.management.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
public class UserDto {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String email;
	private String phone;
	private String password;
}
