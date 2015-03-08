package com.microsys.app.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.microsys.app.common.audit.BaseAuditEntity;
import com.microsys.app.common.customenum.CustCompEnum;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.model.entity.customtype.CustCompType;
import com.microsys.app.model.entity.customtype.RecordStatusType;

/**
 * The persistent class for the mic_address database table.
 * 
 */
@Entity
@Table(name = "mic_address")
@NamedQuery(name = "MicAddress.findAll", query = "SELECT m FROM MicAddress m")
public class MicAddress extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ADDR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addrId;

	@Column(name = "ADDR_LINE_ONE")
	private String addrLineOne;

	@Column(name = "ADDR_LINE_TWO")
	private String addrLineTwo;

	@Column(name = "CITY_ID")
	private int cityId;

	@Type(type = RecordStatusType.USER_TYPE)
	@Column(name = "STATUS")
	private RecordStatusEnum status;

	@Column(name = "TYPE")
	@Type(type = CustCompType.CUST_COMP)
	private CustCompEnum type;

	@Column(name = "ZIPCODE")
	private String zipCode;

	@OneToOne(mappedBy = "custAddress")
	private MicCustomer customer;

	@OneToOne(mappedBy = "micAddress")
	private MicCompany company;

	public int getAddrId() {
		return this.addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getAddrLineOne() {
		return this.addrLineOne;
	}

	public void setAddrLineOne(String addrLineOne) {
		this.addrLineOne = addrLineOne;
	}

	public String getAddrLineTwo() {
		return this.addrLineTwo;
	}

	public void setAddrLineTwo(String addrLineTwo) {
		this.addrLineTwo = addrLineTwo;
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public RecordStatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	public CustCompEnum getType() {
		return this.type;
	}

	public void setType(CustCompEnum type) {
		this.type = type;
	}

	public MicCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(MicCustomer customer) {
		this.customer = customer;
	}

	public boolean equals(MicAddress address) {
		return this.addrId == address.getAddrId();
	}

	public void removeCustomer() {
		this.customer = null;
	}

	public MicCompany getCompany() {
		return company;
	}

	public void setCompany(MicCompany company) {
		this.company = company;
	}

	public void removeCompany() {
		this.company = null;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}