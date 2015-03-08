package com.microsys.app.model.dto.customer;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import com.microsys.app.model.dto.AddressDto;
import com.microsys.app.model.dto.EmailDto;
import com.microsys.app.model.dto.PhoneDto;

@JsonTypeName("Customer")
public class CustomerDto {

	@JsonProperty("CompanyName")
	private String compName;

	@JsonProperty("ContactPerson")
	private String contPerson;

	@JsonProperty("ContactPerson")
	private String custName;

	@JsonProperty("Address")
	private AddressDto address;

	@JsonProperty("Email")
	private EmailDto email;

	@JsonProperty("Phone")
	private PhoneDto phone;

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

	public String getCustName() {
		return custName;
	}

	@JsonIgnore
	public void setCustName(String custName) {
		this.custName = custName;
	}

	public AddressDto getAddress() {
		return address;
	}

	@JsonIgnore
	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public EmailDto getEmail() {
		return email;
	}

	@JsonIgnore
	public void setEmail(EmailDto email) {
		this.email = email;
	}

	public PhoneDto getPhone() {
		return phone;
	}

	@JsonIgnore
	public void setPhone(PhoneDto phone) {
		this.phone = phone;
	}

}
