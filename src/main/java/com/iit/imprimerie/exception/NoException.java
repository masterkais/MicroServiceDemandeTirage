package com.iit.imprimerie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class NoException extends ApiBaseException{

	public NoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.OK;
	}

}
