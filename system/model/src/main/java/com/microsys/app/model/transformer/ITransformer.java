package com.microsys.app.model.transformer;

import java.util.Collection;

import com.microsys.app.common.exception.ApplicationException;

public interface ITransformer<DTO,DOMAIN> {

	Collection<DOMAIN> syncToDomain(Collection<DTO> dtos, Collection<DOMAIN> domains) throws ApplicationException;
	
	Collection<DTO> syncToDto(Collection<DOMAIN> domains, Collection<DTO> dtos) throws ApplicationException;
	
	
}

