package com.cg.fms.controller.advice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.cg.fms.exception.InvalidCredentialsException;
@ControllerAdvice
public class InvalidCredentialsAdvice  {
	@ExceptionHandler(InvalidCredentialsException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public void exceptionHandlerMethod(InvalidCredentialsException  ex) {
		System.out.println(ex.getMessage());
	}
}