package com.microsys.app.model.transformer.impl;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.model.dto.AddressDto;
import com.microsys.app.model.entity.MicAddress;

public class AddressTransformer extends BaseTransformer<AddressDto, MicAddress> {

	@Override
	public MicAddress syncToDomain(AddressDto dto, MicAddress domain) throws ApplicationException {
		domain.setAddrLineOne(dto.getAddrLineOne());
		domain.setAddrLineTwo(dto.getAddrLineTwo());
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
	protected void preDomainDeletion(MicAddress domain) throws ApplicationException {
			domain.setCompany(null);
			domain.setCustomer(null);
	}

	@Override
	public boolean similar(AddressDto dto, MicAddress domain){
		return (dto.getAddrLineOne().equals(domain.getAddrLineOne()) && dto.getAddrLineTwo().equals(domain.getAddrLineTwo())
				&& dto.getCityId() == domain.getCityId() && dto.getZipCode().equals(domain.getZipCode()));
	}

	
	

}




