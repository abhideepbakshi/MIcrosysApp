package com.microsys.app.common.customenum;

public enum RecordStatusEnum implements UiEnum {

	Active("Active", "A"), InActive("Inactive", "D");

	private String uiCode;
	private String dbCode;

	private RecordStatusEnum(String uiCode, String dbCode) {
		this.dbCode = dbCode;
		this.uiCode = uiCode;
	}

	public String getUiCode() {
		return uiCode;
	}

	public String getDbCode() {
		return dbCode;
	}

	public static RecordStatusEnum getRecordStatusByUiCode(String uiCode) {
		RecordStatusEnum[] values = RecordStatusEnum.values();
		for (RecordStatusEnum status : values) {
			if (status.getUiCode().equals(uiCode)) {
				return status;
			}
		}

		return null;

	}
	
	public static RecordStatusEnum getRecordStatusByDBCode(String dbCode) {
		RecordStatusEnum[] values = RecordStatusEnum.values();
		for (RecordStatusEnum status : values) {
			if (status.getDbCode().equals(dbCode)) {
				return status;
			}
		}

		return null;

	}
	
	public boolean equals(RecordStatusEnum recordStatus) {
		return this.dbCode.equals(recordStatus.getDbCode());
	}
}
