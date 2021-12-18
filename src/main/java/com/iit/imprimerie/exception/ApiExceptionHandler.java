package com.iit.imprimerie.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.apache.tomcat.jni.Time;
import org.hibernate.type.ZonedDateTimeType;
import org.hibernate.type.descriptor.java.ZonedDateTimeJavaDescriptor;
import org.springframework.beans.propertyeditors.TimeZoneEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;

import io.swagger.annotations.Api;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ApiBaseException.class)
	public ResponseEntity<ApiException> handleApiException(ApiBaseException ex, WebRequest request){
		ApiException err=new ApiException(ex.getMessage(), ex.getStatusCode(),new Date(),request.getDescription(false));
		return new ResponseEntity<>(err,ex.getStatusCode());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ex.getBindingResult().getFieldError();
		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
	
	
}
