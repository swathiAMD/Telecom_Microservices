package com.example.telecommicroservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class TelecomMicroservicesException extends RuntimeException    {

	public TelecomMicroservicesException(String exception) {
	    super(exception);
	  }

}
