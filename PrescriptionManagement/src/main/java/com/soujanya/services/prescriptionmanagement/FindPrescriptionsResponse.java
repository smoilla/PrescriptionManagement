package com.soujanya.services.prescriptionmanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.soujanya.services.model.Prescription;

public class FindPrescriptionsResponse implements Serializable{

	private Prescription[] prescriptions;

	public Prescription[] getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Prescription[] prescriptions) {
		this.prescriptions = prescriptions;
	}

}
