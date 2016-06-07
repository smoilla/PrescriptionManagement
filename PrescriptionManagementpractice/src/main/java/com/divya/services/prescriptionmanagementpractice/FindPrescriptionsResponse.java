package com.divya.services.prescriptionmanagementpractice;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.divya.services.prescriptionmanagementpractice.model.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="findPrescriptionsResponse")
public class FindPrescriptionsResponse implements Serializable{
	
private Prescription[] prescriptions;
private int numberOfPrescriptions;

public Prescription[] getPrescriptions() {
	return prescriptions;
}
public void setPrescriptions(Prescription[] prescriptions) {
	this.prescriptions = prescriptions;
}
public int getNumberOfPrescriptions() {
	return numberOfPrescriptions;
}
public void setNumberOfPrescriptions(int numberOfPrescriptions) {
	this.numberOfPrescriptions = numberOfPrescriptions;
}

}
