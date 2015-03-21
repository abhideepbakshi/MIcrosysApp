package com.microsys.app.model.transformer.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.common.util.CollectionUtils;
import com.microsys.app.model.dto.AddressDto;
import com.microsys.app.model.entity.MicAddress;
import com.microsys.app.model.transformer.fixture.AddressFixture;
import com.microsys.app.model.transformer.impl.AddressTransformer;

public class AddressTransformerTest {

	@Test
	public void testSyncToDto() throws ApplicationException {

		final List<AddressDto> addressDto = new ArrayList<AddressDto>();
		final List<MicAddress> createAddressList = AddressFixture.createAddressList();
		Assert.assertEquals(0, addressDto.size());

		final AddressTransformer addressTransformer = new AddressTransformer();
		Collection<AddressDto> syncToDto = addressTransformer.syncToDto(createAddressList, addressDto);
		System.out.println();

		Assert.assertEquals(4, syncToDto.size());
		Assert.assertEquals(4, addressDto.size());

		AddressDto first = CollectionUtils.first(syncToDto);
		first.setAddrLineOne("7 Kaibartya Para Road");

		Collection<MicAddress> syncToDomain2 = addressTransformer.syncToDomain(addressDto, createAddressList);
		Assert.assertEquals(4, syncToDomain2.size());
		
		boolean find = false;
		for(MicAddress addr : syncToDomain2){
			if(addr.getAddrLineOne().equals("7 Kaibartya Para Road")){
				find = true;
				break;
			}
		}
		
		Assert.assertTrue(find);
	}
	
	@Test
	public void testDisimilarDomain() throws ApplicationException {

		final List<AddressDto> addressDto = new ArrayList<AddressDto>();
		final List<MicAddress> createAddressList = AddressFixture.createAddressList();
		Assert.assertEquals(0, addressDto.size());

		final AddressTransformer addressTransformer = new AddressTransformer();
		final Collection<AddressDto> syncToDto = addressTransformer.syncToDto(createAddressList, addressDto);
		AddressDto first = CollectionUtils.first(syncToDto);
		first.setAddrLineOne("7 Kaibartya Para Road");
		first.setCityId(2);
		first.setZipCode("743166");
		final Collection<MicAddress> syncToDomain2 = addressTransformer.syncToDomain(addressDto, createAddressList);
		MicAddress first2 = CollectionUtils.first(syncToDomain2);
		
		final MicAddress first3 = CollectionUtils.first(createAddressList);
		Assert.assertTrue(first3 == first2);		
		
		
		
		
		
	}

}
