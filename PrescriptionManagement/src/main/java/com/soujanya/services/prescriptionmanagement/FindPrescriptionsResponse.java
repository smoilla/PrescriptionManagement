package com.soujanya.services.prescriptionmanagement;

import java.util.List;

import com.soujanya.services.model.Prescription;

public class FindPrescriptionsResponse {

	private List<Prescription> prescription;

	public List<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(List<Prescription> prescription) {
		this.prescription = prescription;
	}

}
