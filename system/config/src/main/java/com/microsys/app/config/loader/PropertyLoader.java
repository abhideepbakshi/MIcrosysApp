package com.microsys.app.config.loader;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.microsys.app.config.CacheConfig;
import com.microsys.app.config.filetype.Provider;
import com.microsys.app.config.util.ConfigException;

public class PropertyLoader<FT, RT, F extends Provider<FT, RT>> implements Loader<Provider<FT, RT>, RT> {

	private final CacheConfig INSTANCE = CacheConfig.getInstance();

	@SuppressWarnings("unchecked")
	public RT getProperty(String propertyName, String filename) throws ConfigException {

		final BaseLoader cache = INSTANCE.getCache(filename);
		if (cache != null) {
			final Provider<?, ?> provider = cache.getProvider();
			return (RT) provider.getProperty(propertyName);
		}
		
		final Provider<FT, RT> load = (Provider<FT, RT>) loadProperty(filename);
		final RT propertyValue = load.getProperty(propertyName);
		final BaseLoader baseLoader = new BaseLoader();
		baseLoader.setProvider(load);
		INSTANCE.setData(filename, baseLoader);
		return propertyValue;

	}

	private Provider<FT, RT> loadProperty(String filename) throws ConfigException {

		final InputStream find = INSTANCE.getFile(filename);
		final Class<F> loadClass = getProvider();
		try {
			Provider<FT, RT> provider = (Provider<FT, RT>) loadClass.newInstance();
			provider.initialize(find);
			return provider;
		} catch (InstantiationException e) {
			throw new ConfigException(e.getCause());
		} catch (IllegalAccessException e) {
			throw new ConfigException(e.getCause());
		}

	}

	@SuppressWarnings("unchecked")
	private Class<F> getProvider() {
		final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		final Type[] actualTypeArguments = type.getActualTypeArguments();
		return (Class<F>) actualTypeArguments[2];
	}

}
