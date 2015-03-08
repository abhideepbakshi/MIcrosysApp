package com.microsys.app.model.dto;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

@JsonTypeName("Email")
public class EmailDto {

	@JsonProperty("EmailType")
	private String emailType;

	@JsonProperty("EmailDetl")
	private String emailDetl;

	@JsonProperty("Type")
	private String type;
	
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

	public String getType() {
		return type;
	}

	@JsonIgnore
	public void setType(String type) {
		this.type = type;
	}
	
	

}
