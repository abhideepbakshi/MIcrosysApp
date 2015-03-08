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
import com.microsys.app.model.entity.common.MicEmailComp;
import com.microsys.app.model.entity.common.MicPhoneComp;
import com.microsys.app.model.entity.customtype.RecordStatusType;

/**
 * The persistent class for the mic_company database table.
 * 
 */
@Entity
@Table(name = "mic_company")
@NamedQuery(name = "MicCompany.findAll", query = "SELECT m FROM MicCompany m")
public class MicCompany extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COMP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int compId;

	@Column(name = "COMP_NAME")
	private String compName;

	@Column(name = "CONT_PERSON")
	private String contPerson;

	@Column(name = "INV_FORMAT")
	private String invFormat;

	@Column(name = "OWNER_NAME")
	private String ownerName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDR_ID", referencedColumnName = "ADDR_ID", nullable = false)
	private MicAddress micAddress;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private List<MicEmailComp> compEmail;

	@OneToMany(mappedBy = "companyInv", cascade = CascadeType.ALL)
	private List<MicPrfInv> performaInv;

	@OneToMany(mappedBy = "companyPhone", cascade = CascadeType.ALL)
	private List<MicPhoneComp> compPhone;

	@Column(name = "STATUS")
	@Type(type = RecordStatusType.USER_TYPE)
	private RecordStatusEnum status;

	public int getCompId() {
		return this.compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
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

	public String getInvFormat() {
		return this.invFormat;
	}

	public void setInvFormat(String invFormat) {
		this.invFormat = invFormat;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public RecordStatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	public MicAddress getMicAddress() {
		return micAddress;
	}

	public void setMicAddress(MicAddress micAddress) {
		this.micAddress = micAddress;
	}

	public List<MicEmailComp> getCompEmail() {
		return compEmail;
	}

	public void setCompEmail(List<MicEmailComp> compEmail) {
		this.compEmail = compEmail;
	}

	public void addCompEmail(MicEmailComp email) {
		if (this.compEmail != null) {
			this.compEmail = new ArrayList<MicEmailComp>();
		}
		this.compEmail.add(email);
	}

	public boolean removeCompEmail(MicEmailComp email) {
		if (this.compEmail != null) {
			return this.compEmail.remove(email);
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

	public List<MicPhoneComp> getCompPhone() {
		return compPhone;
	}

	public void setCompPhone(List<MicPhoneComp> compPhone) {
		this.compPhone = compPhone;
	}

	public void addCompPhone(MicPhoneComp compPhone) {
		if (this.compPhone == null) {
			this.compPhone = new ArrayList<MicPhoneComp>();
		}
		this.compPhone.add(compPhone);
	}

	public boolean removeCompPhone(MicPhoneComp compPhone) {
		if (this.compPhone != null) {
			return this.compPhone.remove(compPhone);
		}

		return true;
	}

}