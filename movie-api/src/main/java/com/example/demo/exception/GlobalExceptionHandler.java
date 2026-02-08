package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//Handle MovieNotFound Exception
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleMovieNotFound(
			MovieNotFoundException ex){
		Map<String, Object> error = new HashMap<>();
		error.put("timestamp", LocalDateTime.now().toString());
		error.put("status", 404);
		error.put("error", "Not Found");
		error.put("message", ex.getMessage());
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
	
	//Handle Validation Errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(
            MethodArgumentNotValidException ex) {
               
        // Collect all field errors
        Map<String, String> fieldErrors = new HashMap<>();
        
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
            System.out.println("  - " + error.getField() + ": " + error.getDefaultMessage());
        }
        
        // Build response
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", 400);
        response.put("error", "Validation Failed");
        response.put("message", "Invalid input data. Please check the errors.");
        response.put("errors", fieldErrors);
        
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
	
	//Handle all other Exceptions (Returns 500 Internal Server error)
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        System.out.println("Handling unexpected exception: " + ex.getMessage());
        ex.printStackTrace();
        
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now().toString());
        error.put("status", 500);
        error.put("error", "Internal Server Error");
        error.put("message", "An unexpected error occurred");
        
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }
	
	
}
