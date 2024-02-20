package com.te.mms.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.te.mms.response.ErrorResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> handler(MethodArgumentTypeMismatchException exception) {
		return ResponseEntity.<ErrorResponse>ofNullable(
				ErrorResponse.builder().message(exception.getMessage() + " (BOLLYWOOD OR HOLLYWOOD IS CASE SENSITIVE)")
						.status(HttpStatus.BAD_REQUEST).timestamp(LocalDateTime.now()).build());
	}
}
