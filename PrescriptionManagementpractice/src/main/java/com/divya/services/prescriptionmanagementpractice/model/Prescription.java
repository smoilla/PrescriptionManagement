package com.divya.services.prescriptionmanagementpractice.model;

public class Prescription {
	private String rxNumber;
	private String locaNumber;
	private String dateOfService;
	private String daysSupplyQuantity;
	private String lastFilllDate;
	private String dosageQuantity;
	private String fillingPharmacy;
	private String enrollmentIndicator;
	private String isEligible;
	private String nonEligibleReasonCode;
	private Prescriber prescriber;
	private Drug drug;
	public String getRxNumber() {
		return rxNumber;
	}
	public void setRxNumber(String rxNumber) {
		this.rxNumber = rxNumber;
	}
	public String getLocaNumber() {
		return locaNumber;
	}
	public void setLocaNumber(String locaNumber) {
		this.locaNumber = locaNumber;
	}
	public String getDateOfService() {
		return dateOfService;
	}
	public void setDateOfService(String dateOfService) {
		this.dateOfService = dateOfService;
	}
	public String getDaysSupplyQuantity() {
		return daysSupplyQuantity;
	}
	public void setDaysSupplyQuantity(String daysSupplyQuantity) {
		this.daysSupplyQuantity = daysSupplyQuantity;
	}
	public String getLastFilllDate() {
		return lastFilllDate;
	}
	public void setLastFilllDate(String lastFilllDate) {
		this.lastFilllDate = lastFilllDate;
	}
	public String getDosageQuantity() {
		return dosageQuantity;
	}
	public void setDosageQuantity(String dosageQuantity) {
		this.dosageQuantity = dosageQuantity;
	}
	public String getFillingPharmacy() {
		return fillingPharmacy;
	}
	public void setFillingPharmacy(String fillingPharmacy) {
		this.fillingPharmacy = fillingPharmacy;
	}
	public String getEnrollmentIndicator() {
		return enrollmentIndicator;
	}
	public void setEnrollmentIndicator(String enrollmentIndicator) {
		this.enrollmentIndicator = enrollmentIndicator;
	}
	public String getIsEligible() {
		return isEligible;
	}
	public void setIsEligible(String isEligible) {
		this.isEligible = isEligible;
	}
	public String getNonEligibleReasonCode() {
		return nonEligibleReasonCode;
	}
	public void setNonEligibleReasonCode(String nonEligibleReasonCode) {
		this.nonEligibleReasonCode = nonEligibleReasonCode;
	}
	public Prescriber getPrescriber() {
		return prescriber;
	}
	public void setPrescriber(Prescriber prescriber) {
		this.prescriber = prescriber;
	}
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
}
