package com.microsys.app.common.util;

import com.microsys.app.common.exception.ApplicationException;

public interface IMatcher<T> {
	boolean match(T t);
}
