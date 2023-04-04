package br.com.emanoel.habilidades.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
		
	private static final long serialVersionUID =1L;
	private Date timesTamp;
	private String Details;
	private String Message;

	public ExceptionResponse(Date timesTamp, String details, String message) {
		super();
		this.timesTamp = timesTamp;
		Details = details;
		Message = message;
	}

	public Date getTimesTamp() {
		return timesTamp;
	}

	public void setTimesTamp(Date timesTamp) {
		this.timesTamp = timesTamp;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	

}
