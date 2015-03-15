package com.microsys.app.model.transformer.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.common.exception.SystemException;
import com.microsys.app.common.util.CollectionUtils;
import com.microsys.app.model.transformer.ITransformer;

public abstract class BaseTransformer<DTO, DOMAIN> implements ITransformer<DTO, DOMAIN> {

	public final Collection<DOMAIN> syncToDomain(Collection<DTO> dtos, Collection<DOMAIN> domains) throws ApplicationException {

		final Set<DOMAIN> uniqueDomain = new LinkedHashSet<DOMAIN>();
		final Set<DTO> uniqueDtos = new LinkedHashSet<DTO>();

		if (CollectionUtils.isNotEmpty(dtos) && CollectionUtils.isNotEmpty(domains)) {
			uniqueDtos.addAll(dtos);
			uniqueDomain.addAll(domains);
			for (final DTO dto : uniqueDtos) {
				final DOMAIN domain = getDomainInstance();
				syncToDomain(dto, domain);
				uniqueDomain.add(domain);
			}

		} else if (CollectionUtils.isEmpty(dtos) && CollectionUtils.isNotEmpty(domains)) {
			for (DOMAIN domain : domains) {
				preDomainDeletion(domain);
			}
			uniqueDomain.addAll(domains);
		} else if (CollectionUtils.isNotEmpty(dtos) && CollectionUtils.isEmpty(domains)) {
			uniqueDtos.addAll(dtos);
			for (DTO dto : uniqueDtos) {
				final DOMAIN domain = getDomainInstance();
				syncToDomain(dto, domain);
				uniqueDomain.add(domain);
			}
		}

		return uniqueDomain;

	}

	public final Collection<DTO> syncToDto(Collection<DOMAIN> domains, Collection<DTO> dtos) throws ApplicationException {

		final Set<DOMAIN> uniqueDomain = new LinkedHashSet<DOMAIN>();
		final Set<DTO> uniqueDtos = new LinkedHashSet<DTO>();

		if (CollectionUtils.isNotEmpty(dtos) && CollectionUtils.isNotEmpty(domains)) {
			uniqueDtos.addAll(dtos);
			uniqueDomain.addAll(domains);
			for (final DOMAIN domain : uniqueDomain) {
				final DTO dto = getDtoInstance();
				syncToDto(domain, dto);
				uniqueDtos.add(dto);

			}
		} else if (CollectionUtils.isEmpty(dtos) && CollectionUtils.isNotEmpty(domains)) {
			for (DOMAIN domain : domains) {
				final DTO dto = getDtoInstance();
				syncToDto(domain, dto);
				uniqueDtos.add(dto);
			}
		}
		return uniqueDtos;

	}

	@SuppressWarnings({ "unchecked" })
	private DOMAIN getDomainInstance() throws SystemException {
		final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();

		final Class<DOMAIN> clazz = (Class<DOMAIN>) type.getActualTypeArguments()[1];
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private DTO getDtoInstance() throws SystemException {
		final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		final Class<DTO> clazz = (Class<DTO>) type.getActualTypeArguments()[0];
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public abstract DOMAIN syncToDomain(DTO dto, DOMAIN domain) throws ApplicationException;

	public abstract DTO syncToDto(DOMAIN domain, DTO dto) throws ApplicationException;

	protected abstract boolean preDomainDeletion(DOMAIN domain) throws ApplicationException;

}
