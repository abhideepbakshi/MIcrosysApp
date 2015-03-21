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
 * The persistent class for the mic_sale database table.
 * 
 */
@Entity
@Table(name = "mic_sale")
@NamedQuery(name = "MicSale.findAll", query = "SELECT m FROM MicSale m")
public class MicSale extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SALE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long saleId;

	@Column(name = "GRAND_AMT")
	private double grandAmt;

	@OneToOne
	@JoinColumn(name = "PRF_INV_ID", referencedColumnName = "PRF_INV_ID")
	private MicPrfInv prfInvId;

	@Column(name = "ROUND_OFF")
	private double roundOff;

	@Column(name = "STATUS")
	@Type(type = RecordStatusType.USER_TYPE)
	private RecordStatusEnum status;

	@Column(name = "TAX_RATE")
	private double taxRate;

	@Column(name = "TOTAL_AMT")
	private double totalAmt;

	@OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
	private List<MicSaleDetl> saleDetl;

	public Long getSaleId() {
		return this.saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public double getGrandAmt() {
		return this.grandAmt;
	}

	public void setGrandAmt(double grandAmt) {
		this.grandAmt = grandAmt;
	}

	public MicPrfInv getPrfInvId() {
		return this.prfInvId;
	}

	public void setPrfInvId(MicPrfInv prfInvId) {
		this.prfInvId = prfInvId;
	}

	public double getRoundOff() {
		return this.roundOff;
	}

	public void setRoundOff(double roundOff) {
		this.roundOff = roundOff;
	}

	public RecordStatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	public double getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public double getTotalAmt() {
		return this.totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public List<MicSaleDetl> getSaleDetl() {
		return saleDetl;
	}

	public void setSaleDetl(List<MicSaleDetl> saleDetl) {
		this.saleDetl = saleDetl;
	}

	public void addSaleDetl(MicSaleDetl saleDetl) {

		if (this.saleDetl == null) {
			this.saleDetl = new ArrayList<MicSaleDetl>();
		}
		this.saleDetl.add(saleDetl);
	}

	public boolean removeSaleDetl(MicSaleDetl saleDetl) {
		if (this.saleDetl == null) {
			return this.saleDetl.remove(saleDetl);
		}

		return true;
	}

}