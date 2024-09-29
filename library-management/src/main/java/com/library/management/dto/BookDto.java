package com.library.management.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

@Data
@Getter
@Setter
public class BookDto {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String bookName;
	private String authorName;
	private String description;
	private double cost;
}
