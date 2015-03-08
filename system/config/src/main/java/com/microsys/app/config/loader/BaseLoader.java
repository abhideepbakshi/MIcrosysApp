package com.microsys.app.config.loader;

import com.microsys.app.config.filetype.Provider;

public class BaseLoader {

	private Provider<?, ?> provider;

	public Provider<?, ?> getProvider() {
		return provider;
	}

	public void setProvider(Provider<?, ?> provider) {
		this.provider = provider;
	}

}
