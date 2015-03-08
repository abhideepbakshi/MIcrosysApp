package com.microsys.app.config;

import java.util.Properties;

import com.microsys.app.config.filetype.PropertyFile;
import com.microsys.app.config.loader.PropertyLoader;
import com.microsys.app.config.util.ConfigException;

public class LogConfig extends PropertyLoader<Properties, String, PropertyFile> {

	private final static String LOGGER_CONFIG = "log-configuration.xml";

	public String getProperty(String property) throws ConfigException {

		return getProperty(property, LOGGER_CONFIG);

	}

}
