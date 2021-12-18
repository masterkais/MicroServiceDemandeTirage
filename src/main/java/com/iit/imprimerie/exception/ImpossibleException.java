package com.iit.imprimerie.exception;


	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public class ImpossibleException extends ApiBaseException {


	    public ImpossibleException(String message) {
	        super(message);
	    }

		@Override
		public HttpStatus getStatusCode() {
			// TODO Auto-generated method stub
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	
}