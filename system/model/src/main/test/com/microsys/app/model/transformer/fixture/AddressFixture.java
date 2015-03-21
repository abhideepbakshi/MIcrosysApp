package com.microsys.app.model.transformer.fixture;

import java.util.ArrayList;
import java.util.List;

import com.microsys.app.common.customenum.CustCompEnum;
import com.microsys.app.model.entity.MicAddress;

public class AddressFixture {

	public static List<MicAddress> createAddressList() {

		final List<MicAddress> l = new ArrayList<MicAddress>();
		for(int i = 0; i<4; i++ ){
			l.add(createAddress((new Integer(i)).toString()));
		}
		return l;
	}
	
	private static MicAddress createAddress(String value) {
		
		MicAddress micAddress = new MicAddress();
		micAddress.setAddrLineOne("Address "+value);
		micAddress.setAddrLineTwo("Address "+value);
		micAddress.setZipCode("743166");
		micAddress.setCityId(1);
		micAddress.setType(CustCompEnum.Customer);
		micAddress.setAddrId(Long.parseLong(value));
		return micAddress;
	}
	
}

