package com.microsys.app.model.transformer.impl;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.model.dto.AddressDto;
import com.microsys.app.model.entity.MicAddress;

public class AddressTransformer extends BaseTransformer<AddressDto, MicAddress> {

	@Override
	public MicAddress syncToDomain(AddressDto dto, MicAddress domain) throws ApplicationException {
		domain.setAddrLineOne(dto.getAddrLineOne());
		domain.setAddrLineOne(dto.getAddrLineTwo());
		domain.setCityId(dto.getCityId());
		domain.setZipCode(dto.getZipCode());
		domain.setType(dto.getType());
		return domain;
	}

	@Override
	public AddressDto syncToDto(MicAddress domain, AddressDto dto) throws ApplicationException {
			dto.setAddrLineOne(domain.getAddrLineOne());
			dto.setAddrLineTwo(domain.getAddrLineTwo());
			dto.setCityId(domain.getCityId());
			dto.setZipCode(domain.getZipCode());
			dto.setType(domain.getType());
			return dto;
	}

	@Override
	protected boolean preDomainDeletion(MicAddress domain) throws ApplicationException {
		return false;
	}

	

}




