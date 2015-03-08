package com.microsys.app.config.filetype;

import java.io.InputStream;

import com.microsys.app.config.util.ConfigException;

public interface Provider<F,RT> {

	public F initialize(InputStream file) throws ConfigException;
	
	public RT getProperty(String property) throws ConfigException;
}

