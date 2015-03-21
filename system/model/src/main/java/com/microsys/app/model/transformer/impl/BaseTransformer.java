package com.microsys.app.model.transformer.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.common.exception.SystemException;
import com.microsys.app.common.util.CollectionUtils;
import com.microsys.app.common.util.IMatcher;
import com.microsys.app.model.transformer.ITransformer;

public abstract class BaseTransformer<DTO, DOMAIN> implements ITransformer<DTO, DOMAIN> {

	public final Collection<DOMAIN> syncToDomain(Collection<DTO> dtos, Collection<DOMAIN> domains)
			throws ApplicationException {

		final Set<DOMAIN> insert = new LinkedHashSet<DOMAIN>();
		final Set<DOMAIN> delete = new LinkedHashSet<DOMAIN>();

		if (CollectionUtils.isNotEmpty(dtos) && CollectionUtils.isNotEmpty(domains)) {
			delete.addAll(domains);
			for (final DTO dto : dtos) {

				final DOMAIN find = CollectionUtils.find(delete, new IMatcher<DOMAIN>() {

					public boolean match(DOMAIN t) {
						return similar(dto, t);
					}

				});

				if (find != null) {
					delete.remove(find);
					syncToDomain(dto, find);
				} else {
					final DOMAIN domain = getDomainInstance();
					syncToDomain(dto, domain);
					insert.add(domain);
				}

			}

		} else if (CollectionUtils.isEmpty(dtos) && CollectionUtils.isNotEmpty(domains)) {
			/*
			 * for (DOMAIN domain : domains) { preDomainDeletion(domain); }
			 */
			delete.addAll(domains);
		} else if (CollectionUtils.isNotEmpty(dtos) && CollectionUtils.isEmpty(domains)) {
			for (DTO dto : dtos) {
				final DOMAIN domain = getDomainInstance();
				syncToDomain(dto, domain);
				insert.add(domain);
			}
		}

		for (DOMAIN domain : delete) {
			preDomainDeletion(domain);
		}
		if (domains != null) {
			domains.removeAll(delete);
			for (DOMAIN domain : insert) {
				if (!domains.contains(domain)) {
					domains.add(domain);
				}
			}
		}

		return domains;

	}

	public final Collection<DTO> syncToDto(Collection<DOMAIN> domains, Collection<DTO> dtos)
			throws ApplicationException {

		final Set<DTO> insert = new LinkedHashSet<DTO>();
		final Set<DTO> delete = new LinkedHashSet<DTO>();

		if (CollectionUtils.isNotEmpty(dtos) && CollectionUtils.isNotEmpty(domains)) {
			delete.addAll(dtos);
			for (final DOMAIN domain : domains) {
				final DTO find = CollectionUtils.find(delete, new IMatcher<DTO>() {

					public boolean match(DTO t){
						return similar(t, domain);
					}

				});
				if (find != null) {
					delete.remove(find);
					syncToDto(domain, find);
				} else {
					final DTO dto = getDtoInstance();
					syncToDto(domain, dto);
					insert.add(dto);
				}

			}
		} else if (CollectionUtils.isEmpty(dtos) && CollectionUtils.isNotEmpty(domains)) {
			for (DOMAIN domain : domains) {
				final DTO dto = getDtoInstance();
				syncToDto(domain, dto);
				insert.add(dto);
			}
		}

		dtos.removeAll(delete);
		dtos.addAll(insert);
		return dtos;

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

	protected abstract void preDomainDeletion(DOMAIN domain) throws ApplicationException;
	
	public abstract boolean similar(DTO dto, DOMAIN domain);

}
