package com.microsys.app.model.dto;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import com.microsys.app.common.customenum.CustCompEnum;

@JsonTypeName("Email")
public class EmailDto {

	@JsonProperty("EmailType")
	private String emailType;

	@JsonProperty("EmailDetl")
	private String emailDetl;

	@JsonProperty("Type")
	private CustCompEnum type;

	private int hashValue;

	public String getEmailType() {
		return emailType;
	}

	@JsonIgnore
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public String getEmailDetl() {
		return emailDetl;
	}

	@JsonIgnore
	public void setEmailDetl(String emailDetl) {
		this.emailDetl = emailDetl;
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
		hashValue = emailDetl.hashCode();
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		return hashValue == ((EmailDto) obj).hashCode() ? true : false;
	}

}
