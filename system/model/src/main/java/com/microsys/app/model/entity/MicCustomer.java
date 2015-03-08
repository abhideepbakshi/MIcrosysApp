package com.microsys.app.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.microsys.app.common.audit.BaseAuditEntity;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.model.entity.customtype.RecordStatusType;

/**
 * The persistent class for the mic_customer database table.
 * 
 */
@Entity
@Table(name = "mic_customer")
@NamedQuery(name = "MicCustomer.findAll", query = "SELECT m FROM MicCustomer m")
public class MicCustomer extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CUST_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;

	@Column(name = "COMP_NAME")
	private String compName;

	@Column(name = "CONT_PERSON")
	private String contPerson;

	@Column(name = "CUST_NAME")
	private String custName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDR_ID", referencedColumnName = "ADDR_ID", nullable = false)
	private MicAddress custAddress;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<MicEmailCust> custEmail;

	@OneToMany(mappedBy = "customerInv", cascade = CascadeType.ALL)
	private List<MicPrfInv> performaInv;
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "PHONE_ID", referencedColumnName = "PHONE_ID") private
	 * List<MicPhone> custPhone;
	 */

	@Type(type = RecordStatusType.USER_TYPE)
	@Column(name = "STATUS")
	private RecordStatusEnum status;

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getContPerson() {
		return this.contPerson;
	}

	public void setContPerson(String contPerson) {
		this.contPerson = contPerson;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public RecordStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	public MicAddress getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(MicAddress custAddress) {
		this.custAddress = custAddress;
	}

	public List<MicEmailCust> getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(List<MicEmailCust> custEmail) {
		this.custEmail = custEmail;
	}

	public void addCustEmail(MicEmailCust email) {
		if (this.custEmail == null) {
			this.custEmail = new ArrayList<MicEmailCust>();
		}

		this.custEmail.add(email);
	}

	public boolean removeEmail(MicEmailCust email) {
		if (this.custEmail != null) {
			return this.custEmail.remove(email);
		}

		return true;
	}

	public List<MicPrfInv> getPerformaInv() {
		return performaInv;
	}

	public void setPerformaInv(final List<MicPrfInv> performaInv) {
		this.performaInv = performaInv;
	}

	public void addPerformaInv(final MicPrfInv prfInv) {
		if (this.performaInv == null) {
			this.performaInv = new ArrayList<MicPrfInv>();
		}
		this.performaInv.add(prfInv);
	}

	public boolean removePerformaInv(final MicPrfInv prfInv) {
		if (this.performaInv == null) {
			return this.performaInv.remove(prfInv);
		}

		return true;
	}

	/*
	 * public List<MicPhone> getCustPhone() { return custPhone; }
	 * 
	 * public void setCustPhone(List<MicPhone> custPhone) { this.custPhone =
	 * custPhone; }
	 * 
	 * public void addCustPhone(MicPhone phone) { if (this.custPhone == null) {
	 * this.custPhone = new ArrayList<MicPhone>(); } this.custPhone.add(phone);
	 * }
	 * 
	 * public boolean removeCustPhone(MicPhone phone) { if (this.custPhone !=
	 * null) { return custPhone.remove(phone); }
	 * 
	 * return true; }
	 */

}