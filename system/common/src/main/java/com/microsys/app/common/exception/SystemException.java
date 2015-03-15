package com.microsys.app.common.exception;

public class SystemException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String description;

	public SystemException(String description) {
		this(description, null);
	}
	
	public SystemException(Throwable cause){
		this(null, cause);
	}

	public SystemException(String description, Throwable cause) {
		super(description, cause);
		this.description = description;

	}

	public String getDescription() {
		return description;
	}
}
