package com.microsys.app.common.exception;

public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;

	public ApplicationException(String description) {
		this(description, null);
	}
	
	public ApplicationException(Throwable cause){
		this(null, cause);
	}

	public ApplicationException(String description, Throwable cause) {
		super(description, cause);
		this.description = description;

	}

	public String getDescription() {
		return description;
	}
}
