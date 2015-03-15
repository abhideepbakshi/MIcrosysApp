package com.microsys.app.model.dto;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import com.microsys.app.common.customenum.CustCompEnum;

@JsonTypeName("Address")
public class AddressDto {

	@JsonProperty("AddressLineOne")
	private String addrLineOne;

	@JsonProperty("AddressLineOne")
	private String addrLineTwo;

	@JsonProperty("City")
	private int cityId;

	@JsonProperty("Type")
	private CustCompEnum type;

	@JsonProperty("ZipCode")
	private String zipCode;
	
	private int hashValue = 0;

	public String getAddrLineOne() {
		return addrLineOne;
	}

	@JsonIgnore
	public void setAddrLineOne(String addrLineOne) {
		this.addrLineOne = addrLineOne;
	}

	public String getAddrLineTwo() {
		return addrLineTwo;
	}

	@JsonIgnore
	public void setAddrLineTwo(String addrLineTwo) {
		this.addrLineTwo = addrLineTwo;
	}

	public int getCityId() {
		return cityId;
	}

	@JsonIgnore
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public CustCompEnum getType() {
		return type;
	}

	@JsonIgnore
	public void setType(CustCompEnum type) {
		this.type = type;
	}

	public String getZipCode() {
		return zipCode;
	}

	@JsonIgnore
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public int hashCode() {
		hashValue = addrLineOne.hashCode() + addrLineTwo.hashCode() + zipCode.hashCode();
		return hashValue;
	}
	
	@Override
	public boolean equals(Object obj) {
		return hashValue == ((AddressDto)obj).hashCode() ? true : false;
	}
	
	
	
}
