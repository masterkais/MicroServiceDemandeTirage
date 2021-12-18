package com.iit.imprimerie.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiException {
private final String message;
private final HttpStatus httpStatus;
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
private final Date timestamp;
private final String uri; 
public ApiException(String message, HttpStatus httpStatus, Date timestamp,String uri) {
	super();
	this.message = message;
	this.httpStatus = httpStatus;
	this.timestamp = timestamp;
	this.uri=uri;
}
public String getMessage() {
	return message;
}
public HttpStatus getHttpStatus() {
	return httpStatus;
}
public Date getTimestamp() {
	return timestamp;
}
public String getUri() {
	return uri;
}


}
