package com.microsys.app.model.dto;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import com.microsys.app.common.customenum.CustCompEnum;

@JsonTypeName("Phone")
public class PhoneDto {

	@JsonProperty("PhoneNo")
	private String phoneNo;

	@JsonProperty("PhoneType")
	private String phoneType;

	@JsonProperty("Type")
	private CustCompEnum type;

	private int hashValue;
	
	public String getPhoneNo() {
		return phoneNo;
	}

	@JsonIgnore
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPhoneType() {
		return phoneType;
	}

	@JsonIgnore
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public CustCompEnum getType() {
		return type;
	}

	@JsonIgnore
	public void setType(CustCompEnum type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		hashValue = phoneNo.hashCode() + type.getDbCode().hashCode();
		return hashValue;
	}
	
	@Override
	public boolean equals(Object obj) {
		return hashValue == ((PhoneDto)obj).hashCode() ? true : false;
	}
	
}
