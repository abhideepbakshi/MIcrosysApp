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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.microsys.app.common.audit.BaseAuditEntity;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.model.entity.customtype.RecordStatusType;

/**
 * The persistent class for the mic_item database table.
 * 
 */
@Entity
@Table(name = "mic_item")
@NamedQuery(name = "MicItem.findAll", query = "SELECT m FROM MicItem m")
public class MicItem extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;

	@Column(name = "ITEM_DESC")
	private String itemDesc;

	@Column(name = "STATUS")
	@Type(type = RecordStatusType.USER_TYPE)
	private RecordStatusEnum status;

	@OneToMany(mappedBy="item", cascade = CascadeType.ALL)
	private List<MicSaleDetl> saleDetl;
	
	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public RecordStatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
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