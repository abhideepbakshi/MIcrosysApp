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
 * The persistent class for the mic_email database table.
 * 
 */
@Entity
@Table(name = "mic_email")
@NamedQuery(name = "MicEmailCust.findAll", query = "SELECT m FROM MicEmailCust m")
public class MicEmailCust extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "EMAIL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emailId;

	@Column(name = "EMAIL_DETL")
	private String emailDetl;

	@Column(name = "EMAIL_TYPE")
	private String emailType;

	@Column(name = "TYPE")
	@Type(type = CustCompType.CUST_COMP)
	@Where(clause = "type = 'CUST'")
	private CustCompEnum type;

	@Column(name = "STATUS")
	@Type(type = RecordStatusType.USER_TYPE)
	private RecordStatusEnum status;

	@ManyToOne
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "CUST_ID")
	private MicCustomer customer;

	public Long getEmailId() {
		return this.emailId;
	}

	public void setEmailId(Long emailId) {
		this.emailId = emailId;
	}

	public String getEmailDetl() {
		return this.emailDetl;
	}

	public void setEmailDetl(String emailDetl) {
		this.emailDetl = emailDetl;
	}

	public String getEmailType() {
		return this.emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public CustCompEnum getType() {
		return this.type;
	}

	public void setType(CustCompEnum type) {
		this.type = type;
	}

	public boolean equals(MicEmailCust email) {
		return this.emailId == email.getEmailId() ? true : false;
	}

	public RecordStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	public MicCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(MicCustomer customer) {
		this.customer = customer;
	}

	/*public MicCompany getCompany() {
		return company;
	}

	public void setCompany(MicCompany company) {
		this.company = company;
	}*/

}