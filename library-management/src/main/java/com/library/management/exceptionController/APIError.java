package com.library.management.exceptionController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class APIError {
	private String msg;
	private int error;
}
