package com.cg.fms.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.fms.exception.NoDataFoundException;




@ControllerAdvice
public class NoDataFoundAdvice {
	@ExceptionHandler(NoDataFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void exceptionHandlerMethod(NoDataFoundException ex) {
		System.out.println(ex.getMessage());
	}
}
