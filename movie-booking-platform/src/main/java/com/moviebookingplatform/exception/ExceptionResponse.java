package com.moviebookingplatform.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {

	private LocalDate date;
	private String errorMessage;
	private String path;
}
