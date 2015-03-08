package com.microsys.app.model.dto.company;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import com.microsys.app.model.dto.AddressDto;
import com.microsys.app.model.dto.EmailDto;
import com.microsys.app.model.dto.PhoneDto;

@JsonTypeName("Customer")
public class CompanyDto {

	@JsonProperty("CompanyName")
	private String compName;

	@JsonProperty("ContactPerson")
	private String contPerson;

	@JsonProperty("OwnerName")
	private String ownerName;

	@JsonProperty("Address")
	private AddressDto address;

	@JsonProperty("Email")
	private List<EmailDto> email;

	@JsonProperty("Phone")
	private List<PhoneDto> phone;

	@JsonProperty("InvoiceFormat")
	private String invFormat;

	public String getCompName() {
		return compName;
	}

	@JsonIgnore
	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getContPerson() {
		return contPerson;
	}

	@JsonIgnore
	public void setContPerson(String contPerson) {
		this.contPerson = contPerson;
	}

	public String getOwnerName() {
		return ownerName;
	}

	@JsonIgnore
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public AddressDto getAddress() {
		return address;
	}

	@JsonIgnore
	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public List<EmailDto> getEmail() {
		return email;
	}

	@JsonIgnore
	public void setEmail(List<EmailDto> email) {
		this.email = email;
	}

	public List<PhoneDto> getPhone() {
		return phone;
	}

	@JsonIgnore
	public void setPhone(List<PhoneDto> phone) {
		this.phone = phone;
	}

	public String getInvFormat() {
		return invFormat;
	}

	@JsonIgnore
	public void setInvFormat(String invFormat) {
		this.invFormat = invFormat;
	}

}
