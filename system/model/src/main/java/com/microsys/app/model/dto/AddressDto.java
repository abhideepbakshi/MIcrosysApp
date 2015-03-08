package com.microsys.app.model.dto;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

@JsonTypeName("Address")
public class AddressDto {

	@JsonProperty("AddressLineOne")
	private String addrLineOne;

	@JsonProperty("AddressLineOne")
	private String addrLineTwo;

	@JsonProperty("City")
	private int cityId;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("ZipCode")
	private String zipCode;

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

	public String getType() {
		return type;
	}

	@JsonIgnore
	public void setType(String type) {
		this.type = type;
	}

	public String getZipCode() {
		return zipCode;
	}

	@JsonIgnore
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
