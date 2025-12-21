package com.ou_solutions.users_service.controller.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(exception = UserServiceException.class)
	public ErrorResponse handleUserServiceException(UserServiceException ex)
	{
		ErrorResponse erresponse=ErrorResponse.create(ex, HttpStatusCode.valueOf(500), ex.getMessage());
		return erresponse;
	}
	
}
