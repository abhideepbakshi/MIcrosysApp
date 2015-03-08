package com.microsys.app.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsys.app.config.filetype.PropertyFile;
import com.microsys.app.config.loader.PropertyLoader;
import com.microsys.app.config.util.ConfigException;

/**
 * 
 */
public class SystemConfig extends PropertyLoader<Properties, String, PropertyFile> {

	private final String SYSTEM_CONFIG_FILE = "system-configuration.xml";
	final Logger logger = LoggerFactory.getLogger(SystemConfig.class);

	public String getProperty(String property) throws ConfigException {
		logger.debug("In systemConfig");
		return getProperty(property, SYSTEM_CONFIG_FILE);
	}

}
