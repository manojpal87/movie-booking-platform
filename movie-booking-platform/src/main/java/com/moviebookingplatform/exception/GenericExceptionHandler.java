package com.moviebookingplatform.exception;

import java.time.LocalDate;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generic exception handler class. All exception can be handled here.
 * 
 * @author manojpal
 *
 */
@ControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, HttpRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getMessage(),
				request.getURI().getPath());

		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
