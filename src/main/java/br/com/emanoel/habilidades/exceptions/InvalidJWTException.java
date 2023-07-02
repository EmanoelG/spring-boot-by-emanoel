package br.com.emanoel.habilidades.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJWTException extends AuthenticationException {
    
	private static final long serialVersionUID =1L;
	public InvalidJWTException(String ex) {
		super(ex);
	}
	
	
}
