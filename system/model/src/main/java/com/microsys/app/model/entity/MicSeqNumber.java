package com.microsys.app.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.microsys.app.common.audit.BaseAuditEntity;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.model.entity.customtype.RecordStatusType;

/**
 * The persistent class for the mic_seq_number database table.
 * 
 */
@Entity
@Table(name = "mic_seq_number")
@NamedQuery(name = "MicSeqNumber.findAll", query = "SELECT m FROM MicSeqNumber m")
public class MicSeqNumber extends BaseAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SEQ_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seqId;

	@Column(name = "COMP_ID")
	private int compId;

	@Column(name = "INV_NO")
	private int invNo;

	@Column(name = "INV_YEAR")
	private String invYear;

	@Column(name = "STATUS")
	@Type(type = RecordStatusType.USER_TYPE)
	private RecordStatusEnum status;

	private int year;

	public MicSeqNumber() {
	}

	public Long getSeqId() {
		return this.seqId;
	}

	public void setSeqId(Long seqId) {
		this.seqId = seqId;
	}

	public int getCompId() {
		return this.compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public int getInvNo() {
		return this.invNo;
	}

	public void setInvNo(int invNo) {
		this.invNo = invNo;
	}

	public String getInvYear() {
		return this.invYear;
	}

	public void setInvYear(String invYear) {
		this.invYear = invYear;
	}

	public RecordStatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}