package com.cg.fms.controller.advice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.cg.fms.exception.NoCustomerFoundException;

@ControllerAdvice
public class NoCustomerFoundAdvice {
	@ExceptionHandler(NoCustomerFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void exceptionHandlerMethod(NoCustomerFoundException ex)
	{
		System.out.println(ex.getMessage());
	}

}
