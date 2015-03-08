package com.microsys.app.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.microsys.app.config.loader.BaseLoader;
import com.microsys.app.config.util.ConfigException;

public class CacheConfig {

	private final static String CONFIG_TYPE = "CONFIG_TYPE";
	private final static String CONFIG_ROOT = "CONFIG_ROOT";
	private final static String APP_ENV = "APP_ENV";
	private final static String APP_DOMAIN = "APP_DOMAIN";
	private final static String APP_MACHINE = "APP_MACHINE";

	private static final Map<String, BaseLoader> cache = new ConcurrentHashMap<String, BaseLoader>();
	private static final CacheConfig INSTANCE = new CacheConfig();

	private char seperator = '/';
	private String root;
	private String type;

	private CacheConfig() {
		this.type = System.getProperty(CONFIG_TYPE);
		final boolean workSpace = isWorkSpace();
		final String configBase = seperator + appendPath("Config", "payroll");
		this.root = workSpace ? configBase : System.getProperty(CONFIG_ROOT) + configBase;
		final String appEnv = System.getProperty(APP_ENV);
		final String appDomain = System.getProperty(APP_DOMAIN);
		final String appMachine = System.getProperty(APP_MACHINE);
		this.root = appEnv == null ? this.root : (appDomain == null ? (appendPath(this.root, appEnv.toLowerCase()))
				: (appMachine == null ? (appendPath(this.root, appEnv.toLowerCase(), appDomain.toLowerCase()))
						: (appendPath(this.root, appEnv.toLowerCase(), appDomain.toLowerCase(),
								appMachine.toLowerCase()))));
	}

	public boolean isWorkSpace() {
		return this.type == null || ("WorkSpace").equals(this.type);
	}

	public static CacheConfig getInstance() {
		return INSTANCE;
	}

	synchronized public BaseLoader getCache(String filename) {
		if (cache.containsKey(filename)) {
			return cache.get(filename);
		}
		return null;
	}

	synchronized public void setData(String filename, BaseLoader baseLoader) throws ConfigException {
		if (cache.containsKey(filename)) {
			throw new ConfigException("File allready exits");
		}

		cache.put(filename, baseLoader);
	}

	public InputStream getFile(String filename) throws ConfigException {

		final String appendPath = appendPath(root, filename);
		return searchFile(appendPath);

	}

	private InputStream searchFile(String filePath) throws ConfigException {

		if (INSTANCE.isWorkSpace()) {
			InputStream inputStream = this.getClass().getResourceAsStream(filePath);
			if (inputStream == null) {
				throw new ConfigException("File not found");
			}
			return inputStream;
		} else {
			final File file = new File(filePath);
			if (!file.exists()) {
				throw new ConfigException("File not found");
			}
			try {
				final InputStream inputStream = new FileInputStream(file);
				return inputStream;
			} catch (FileNotFoundException e) {
				throw new ConfigException("File not found", e);
			}

		}

	}

	private String appendPath(final String... path) {
		String location = null;
		if (path.length > 0) {
			location = path[0];
			for (int i = 1; i < path.length; i++) {
				if (!path[i].trim().equals("")) {
					location = location + seperator + path[i];
				}
			}
			return location;
		}

		return null;
	}

}
