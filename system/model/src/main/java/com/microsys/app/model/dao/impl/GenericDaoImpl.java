package com.microsys.app.model.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.aop.support.AopUtils;

import com.microsys.app.model.dao.IGenericDao;
import com.microsys.app.model.dao.IIdentityObject;

public abstract class GenericDaoImpl<E extends IIdentityObject<?>> implements IGenericDao<E> {

	@PersistenceContext
	private EntityManager entityManager;

	public E save(E entity) {

		if (entity.get() != null) {
			return entityManager.merge(entity);
		} else {
			entityManager.persist(entity);
			return entity;
		}

	}

	public void delete(E entity) {
		entityManager.remove(entity);
	}

	public void flush() {
		entityManager.flush();
	}

	public E find(long pk) {

			entityManager.find(getParameterizedClass(), pk);
		return null;
	}

	public E find(long pk, Class<? extends E> clazz) {
		return entityManager.find(clazz, pk);
	}

	public E find(Object pk, Class<? extends E> clazz) {
		return entityManager.find(clazz, pk);
	}

	public List<E> find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * In application runtime Spring will use JDK proxy classes and, <br/>
	 * for test execution Spring will use CGLIB proxy classes. <br/>
	 * In case of CGLIB extra super call is needed to get actual class parameter
	 * 
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	private Class<E> getParameterizedClass() {
		
		if (AopUtils.isCglibProxy(this)) {
			final ParameterizedType type = (ParameterizedType) this.getClass().getSuperclass().getGenericSuperclass();
			return (Class<E>) type.getActualTypeArguments()[0];
		}
		else {
			final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			return (Class<E>) type.getActualTypeArguments()[0];
		}
	}

}
