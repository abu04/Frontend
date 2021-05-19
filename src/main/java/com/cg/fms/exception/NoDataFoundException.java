package com.cg.fms.exception;

public class NoDataFoundException extends RuntimeException {
  String message;
  public NoDataFoundException(String message)
  {
	  this.message=message;
  }
  
  @Override
  public String getMessage() {
	  return message;
  }
}
