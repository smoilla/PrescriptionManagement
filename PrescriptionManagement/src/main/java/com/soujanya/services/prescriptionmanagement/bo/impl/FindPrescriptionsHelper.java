package com.soujanya.services.prescriptionmanagement.bo.impl;

import com.soujanya.services.model.Prescription;
import com.soujanya.services.prescriptionmanagement.FindPrescriptionsRequest;
import com.soujanya.services.prescriptionmanagement.FindPrescriptionsResponse;

public class FindPrescriptionsHelper {

	public void validateRequest(FindPrescriptionsRequest request) throws Exception {
		if (request == null || request.getCustomerId() == null) {
			throw new Exception("Invalid Request: Customer ID is null");
		} else {
			if (request.getCustomerId().trim().length() == 0) {
				throw new Exception("Invalid Request: Customer ID is empty");
			}
		}
	}

	public FindPrescriptionsRequest preProcess(FindPrescriptionsRequest request) {
		return null;
	}

	public FindPrescriptionsResponse postProcess(FindPrescriptionsResponse response) {

		for (Prescription prescription : response.getPrescription()) {
			if (prescription.getIsEligible().equalsIgnoreCase("true")) {
				prescription.setNonEligibleReasonCode(null);
			}
		}
		return response;
	}

}
