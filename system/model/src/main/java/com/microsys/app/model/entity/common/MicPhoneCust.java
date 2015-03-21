package com.microsys.app.model.entity.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import com.microsys.app.common.audit.BaseAuditEntity;
import com.microsys.app.common.customenum.CustCompEnum;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.model.entity.MicCustomer;
import com.microsys.app.model.entity.customtype.CustCompType;
import com.microsys.app.model.entity.customtype.RecordStatusType;

/**
 * The persistent class for the mic_phone database table.
 * 
 */
@Entity
@Table(name = "mic_phone")
@NamedQuery(name = "MicPhoneCust.findAll", query = "SELECT m FROM MicPhoneCust m")
public class MicPhoneCust extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PHONE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long phoneId;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	@Column(name = "PHONE_TYPE")
	private String phoneType;

	@Column(name = "STATUS")
	@Type(type = RecordStatusType.USER_TYPE)
	private RecordStatusEnum status;

	@Column(name = "TYPE")
	@Type(type = CustCompType.CUST_COMP)
	@Where(clause = "type = 'CUST'")
	private CustCompEnum type;

	@ManyToOne
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "CUST_ID")
	private MicCustomer customerPhone;

	public Long getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(Long phoneId) {
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

	public MicCustomer getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(MicCustomer customerPhone) {
		this.customerPhone = customerPhone;
	}

	public boolean equals(MicPhoneCust obj) {
		return this.phoneId == obj.getPhoneId() ? true : false;
	}

}