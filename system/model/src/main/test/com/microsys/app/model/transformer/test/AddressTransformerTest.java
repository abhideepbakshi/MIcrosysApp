package com.microsys.app.model.transformer.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.model.dto.AddressDto;
import com.microsys.app.model.entity.MicAddress;
import com.microsys.app.model.transformer.fixture.AddressFixture;
import com.microsys.app.model.transformer.impl.AddressTransformer;

public class AddressTransformerTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testSyncToDto() throws ApplicationException{
		
		final List<AddressDto> addressDto = new ArrayList<AddressDto>();
		final List<MicAddress> createAddressList = AddressFixture.createAddressList();
		Assert.assertEquals(0, addressDto.size());
		
		final AddressTransformer addressTransformer = new AddressTransformer();
		Collection<AddressDto> syncToDto = addressTransformer.syncToDto(createAddressList, addressDto);
		System.out.println();
		
		Assert.assertEquals(4, syncToDto.size());
		Assert.assertEquals(4, addressDto.size());
		
		Collection<MicAddress> syncToDomain2 = addressTransformer.syncToDomain(addressDto, createAddressList);
		
		
	}

}
