package com.microsys.app.config.loader;

import com.microsys.app.config.util.ConfigException;

public interface Loader<FT, RT> {

	RT getProperty(String propertyName, String filename) throws ConfigException;

}
