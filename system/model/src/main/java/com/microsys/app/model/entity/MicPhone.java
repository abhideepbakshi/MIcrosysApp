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
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.model.entity.customtype.RecordStatusType;

/**
 * The persistent class for the mic_phone database table.
 * 
 */
@Entity
@Table(name = "mic_phone")
@NamedQuery(name = "MicPhone.findAll", query = "SELECT m FROM MicPhone m")
public class MicPhone extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PHONE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int phoneId;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	@Column(name = "PHONE_TYPE")
	private String phoneType;

	@Column(name = "STATUS")
	@Type(type = RecordStatusType.USER_TYPE)
	private RecordStatusEnum status;

	private String type;

	/*@OneToOne(mappedBy = "custPhone")
	private MicCustomer customer;*/

	/*@OneToOne(mappedBy = "compPhone")
	private MicCompany company;*/

	public int getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public RecordStatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/*public MicCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(MicCustomer customer) {
		this.customer = customer;
	}*/

	/*public MicCompany getCompany() {
		return company;
	}

	public void setCompany(MicCompany company) {
		this.company = company;
	}*/

	public boolean equals(MicPhone obj) {
		return this.phoneId == obj.getPhoneId() ? true : false;
	}

}