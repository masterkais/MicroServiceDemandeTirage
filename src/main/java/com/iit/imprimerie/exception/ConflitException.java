package com.iit.imprimerie.exception;

import org.springframework.http.HttpStatus;

public class ConflitException extends ApiBaseException {

	public ConflitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
public HttpStatus getStatusCode() {
	return HttpStatus.CONFLICT;
}
}
