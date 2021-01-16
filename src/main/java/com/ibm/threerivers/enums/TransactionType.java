package com.ibm.threerivers.enums;

public enum TransactionType {
	DEPOSIT("DEPOSIT"), WITHDRAW("WITHDRAW");

	private String value;

	TransactionType(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}
}
