package com.microsys.app.model.dao;

import java.util.List;

public interface IGenericDao<E extends IIdentityObject<?>> {

	E save(E entity);

	void delete(E entity);

	void flush();

	E find(long pk);

	E find(long pk, Class<? extends E> clazz);

	E find(Object pk, Class<? extends E> clazz);

	List<E> find();

}
