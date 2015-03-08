package com.microsys.app.common.audit;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditListener.class)
public class BaseAuditEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Embedded
	private UpdateAudit updateAudit;

	public UpdateAudit getUpdateAudit() {
		return updateAudit;
	}

	public void setUpdateAudit(UpdateAudit updateAudit) {
		this.updateAudit = updateAudit;
	}
	
	
}
