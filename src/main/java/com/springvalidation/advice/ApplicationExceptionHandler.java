package com.springvalidation.advice;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springvalidation.exception.UserNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	// teel to springboot whenever you are getting this
	// methodargumentnotvalidexception class as a error just redirect that request
	// to this particular method
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap<String, String>();
//		List<FieldError> list = new ArrayList()<>();
		exception.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
//	we are getting status 200 if we do not have that particular data in our database so to change it we are using INTERNAL_SERVER_ERROR (500)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handleBussinessException(UserNotFoundException exception){
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;
	}
}
