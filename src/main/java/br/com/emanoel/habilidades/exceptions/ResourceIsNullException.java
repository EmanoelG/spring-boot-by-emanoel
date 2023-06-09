package br.com.emanoel.habilidades.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceIsNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceIsNullException() {
		super("Não é permitido persistir um objeto nullo !");
	}

}
