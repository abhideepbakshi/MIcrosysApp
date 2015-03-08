package com.microsys.app.config.util;

public class ConfigException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;

	public ConfigException(String description) {
		this(description, null);
	}
	
	public ConfigException(Throwable cause){
		this(null, cause);
	}

	public ConfigException(String description, Throwable cause) {
		super(description, cause);
		this.description = description;

	}

	public String getDescription() {
		return description;
	}

}
