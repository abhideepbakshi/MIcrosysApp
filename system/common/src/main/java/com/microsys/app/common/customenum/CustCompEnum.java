package com.microsys.app.common.customenum;

public enum CustCompEnum implements UiEnum {
	Company("Company", "COMP"),
	Customer("Customer", "CUST");

	private CustCompEnum(String uiCode, String dbCode) {
		this.dbCode = dbCode;
		this.uiCode = uiCode;
	}

	private String uiCode;
	private String dbCode;

	public String getUiCode() {
		return this.uiCode;
	}

	public String getDbCode() {
		return this.dbCode;
	}
	
	public static CustCompEnum getCustCompByUiCode(String uiCode) {
		CustCompEnum[] values = CustCompEnum.values();
		for (CustCompEnum status : values) {
			if (status.getUiCode().equals(uiCode)) {
				return status;
			}
		}

		return null;

	}
	
	public static CustCompEnum getCustCompByDBCode(String dbCode) {
		CustCompEnum[] values = CustCompEnum.values();
		for (CustCompEnum status : values) {
			if (status.getDbCode().equals(dbCode)) {
				return status;
			}
		}

		return null;

	}
	
	public boolean equals(CustCompEnum custComp) {
		return this.dbCode.equals(custComp.getDbCode());
	}

}
