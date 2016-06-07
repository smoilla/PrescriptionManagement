package com.divya.services.prescriptionmanagementpractice.model;

public class Prescriber {
private String id;
private String firstName;
private String lastName;
private Address homeAddress;
private Address workAddress;
private String licenseNumber;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Address getHomeAddress() {
	return homeAddress;
}
public void setHomeAddress(Address homeAddress) {
	this.homeAddress = homeAddress;
}
public Address getWorkAddress() {
	return workAddress;
}
public void setWorkAddress(Address workAddress) {
	this.workAddress = workAddress;
}
public String getLicenseNumber() {
	return licenseNumber;
}
public void setLicenseNumber(String licenseNumber) {
	this.licenseNumber = licenseNumber;
}

}
