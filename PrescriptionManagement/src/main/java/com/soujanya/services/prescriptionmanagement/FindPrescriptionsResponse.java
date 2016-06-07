package com.soujanya.services.prescriptionmanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.soujanya.services.model.Prescription;

@XmlRootElement(name="findPrescriptionsResponse")
public class FindPrescriptionsResponse implements Serializable{

	private Prescription[] prescriptions;
private int numberOfPrescriptions;

	public int getNumberOfPrescriptions() {
	return numberOfPrescriptions;
}

public void setNumberOfPrescriptions(int numberOfPrescriptions) {
	this.numberOfPrescriptions = numberOfPrescriptions;
}

	public Prescription[] getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Prescription[] prescriptions) {
		this.prescriptions = prescriptions;
	}

}
