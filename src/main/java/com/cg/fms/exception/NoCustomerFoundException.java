package com.cg.fms.exception;

public class NoCustomerFoundException extends RuntimeException {
	 String message;
	  public NoCustomerFoundException(String message)
	  {
		  this.message=message;
	  }
	  
	  @Override
	  public String getMessage() {
		  return message;
	  }
}
