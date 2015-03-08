package com.microsys.app.config.filetype;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.microsys.app.config.util.ConfigException;

public class PropertyFile implements Provider<Properties, String> {

	private final Properties propertyList = new Properties();

	public Properties initialize(InputStream file) throws ConfigException {

		try {
			propertyList.loadFromXML(file);
		} catch (InvalidPropertiesFormatException e) {
			throw new ConfigException("Fromat is not valid", e.getCause());
		} catch (FileNotFoundException e) {
			throw new ConfigException("File not found in destination folder", e.getCause());
		} catch (IOException e) {
			throw new ConfigException("Intruption during file reading", e.getCause());
		}
		return null;
	}

	public String getProperty(String property) {
		return propertyList.getProperty(property);
	}

}
