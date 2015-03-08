package com.microsys.app.common.audit;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditListener {

	@PrePersist
	void onCreate(Object o) {

		if (o instanceof BaseAuditEntity) {
			final BaseAuditEntity entity = (BaseAuditEntity) o;

			final UpdateAudit updateAudit = new UpdateAudit();
			final CreateAudit createAudit = new CreateAudit();
			createAudit.setCreatedBy("Abhideep");
			createAudit.setCreatedDate(new Date());
			updateAudit.setCreateAudit(createAudit);
			entity.setUpdateAudit(updateAudit);
		}

	}

	@PreUpdate
	void onUpdate(Object o) {
		if (o instanceof BaseAuditEntity) {
			final BaseAuditEntity entity = (BaseAuditEntity) o;

			final UpdateAudit updateAudit = entity.getUpdateAudit();
			updateAudit.setUpdatedBy("Abhideep");
			updateAudit.setUpdatedDate(new Date());
			entity.setUpdateAudit(updateAudit);
		}
	}
}
