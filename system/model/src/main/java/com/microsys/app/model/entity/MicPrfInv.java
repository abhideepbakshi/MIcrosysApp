package com.microsys.app.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.microsys.app.common.audit.BaseAuditEntity;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.model.entity.customtype.RecordStatusType;

/**
 * The persistent class for the mic_prf_inv database table.
 * 
 */
@Entity
@Table(name = "mic_prf_inv")
@NamedQuery(name = "MicPrfInv.findAll", query = "SELECT m FROM MicPrfInv m")
public class MicPrfInv extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRF_INV_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long prfInvId;

	@ManyToOne
	@JoinColumn(name = "COMP_ID", referencedColumnName = "COMP_ID")
	private MicCompany companyInv;

	@ManyToOne
	@JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
	private MicCustomer customerInv;

	@Temporal(TemporalType.DATE)
	@Column(name = "INV_DATE")
	private Date invDate;

	@Column(name = "PRF_INV_NO")
	private String prfInvNo;

	@Column(name = "STATUS")
	@Type(type = RecordStatusType.USER_TYPE)
	private RecordStatusEnum status;

	@OneToOne(mappedBy = "prfInvId", cascade = CascadeType.ALL)
	private MicSale sale;

	public Long getPrfInvId() {
		return this.prfInvId;
	}

	public void setPrfInvId(Long prfInvId) {
		this.prfInvId = prfInvId;
	}

	public MicCompany getCompanyInv() {
		return this.companyInv;
	}

	public void setCompanyInv(MicCompany companyInv) {
		this.companyInv = companyInv;
	}

	public MicCustomer getCustomerInv() {
		return this.customerInv;
	}

	public void setCustomerInv(MicCustomer customerInv) {
		this.customerInv = customerInv;
	}

	public Date getInvDate() {
		return this.invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public String getPrfInvNo() {
		return this.prfInvNo;
	}

	public void setPrfInvNo(String prfInvNo) {
		this.prfInvNo = prfInvNo;
	}

	public RecordStatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	public MicSale getSale() {
		return sale;
	}

	public void setSale(MicSale sale) {
		this.sale = sale;
	}

	public boolean equals(MicPrfInv obj) {
		return this.prfInvId == obj.getPrfInvId() ? true : false;
	}
}