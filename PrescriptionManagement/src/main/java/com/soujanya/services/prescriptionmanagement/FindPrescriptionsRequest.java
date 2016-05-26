package com.soujanya.services.prescriptionmanagement;

import java.io.Serializable;

public class FindPrescriptionsRequest implements Serializable{

	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
