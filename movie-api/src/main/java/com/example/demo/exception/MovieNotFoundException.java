package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Custom Exception to handle any crashes (runtime errors) 
//When a movie does not exist in database
/**
 * ResponseStatus gives status codes like
 * 500-internal server error
 * 200-Ok
 * 404-Not found
 * 403-Forbidden and so on
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {
	
	/**
	 * For not getting any warnings
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor with custom message
	 * @param message
	 */
	public MovieNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * constructor with id
	 * @param id
	 */
	public MovieNotFoundException(Long id) {
		super("Movie not found with ID: "+ id);
	}
}
