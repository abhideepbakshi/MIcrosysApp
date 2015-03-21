package com.microsys.app.model.entity;

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

import com.microsys.app.common.audit.BaseAuditEntity;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.model.entity.customtype.RecordStatusType;

/**
 * The persistent class for the mic_sale_detl database table.
 * 
 */
@Entity
@Table(name = "mic_sale_detl")
@NamedQuery(name = "MicSaleDetl.findAll", query = "SELECT m FROM MicSaleDetl m")
public class MicSaleDetl extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SALE_DETL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long saleDetlId;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
	private MicItem item;

	@Column(name = "ITEM_ORDR")
	private int itemOrdr;

	@Column(name = "ITEM_QNTY")
	private double itemQnty;

	@Column(name = "ITEM_RATE")
	private double itemRate;

	@ManyToOne
	@JoinColumn(name = "SALE_ID", referencedColumnName = "SALE_ID")
	private MicSale sale;

	@Column(name = "STATUS")
	@Type(type = RecordStatusType.USER_TYPE)
	private RecordStatusEnum status;

	public Long getSaleDetlId() {
		return this.saleDetlId;
	}

	public void setSaleDetlId(Long saleDetlId) {
		this.saleDetlId = saleDetlId;
	}

	public MicItem getItem() {
		return this.item;
	}

	public void setItem(MicItem item) {
		this.item = item;
	}

	public int getItemOrdr() {
		return this.itemOrdr;
	}

	public void setItemOrdr(int itemOrdr) {
		this.itemOrdr = itemOrdr;
	}

	public double getItemQnty() {
		return this.itemQnty;
	}

	public void setItemQnty(double itemQnty) {
		this.itemQnty = itemQnty;
	}

	public double getItemRate() {
		return this.itemRate;
	}

	public void setItemRate(double itemRate) {
		this.itemRate = itemRate;
	}

	public MicSale getSale() {
		return this.sale;
	}

	public void setSale(MicSale sale) {
		this.sale = sale;
	}

	public RecordStatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	public boolean equals(MicSaleDetl obj) {
		return this.saleDetlId == obj.getSaleDetlId() ? true : false;
	}

}