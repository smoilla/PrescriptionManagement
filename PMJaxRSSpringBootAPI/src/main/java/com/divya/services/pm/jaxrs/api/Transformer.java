package com.divya.services.pm.jaxrs.api;

import com.divya.services.pms.jaxb.ArrayOfPrescriptions;
import com.divya.services.prescriptionmanagementpractice.FindPrescriptionsRequest;
import com.divya.services.prescriptionmanagementpractice.FindPrescriptionsResponse;
import com.divya.services.prescriptionmanagementpractice.model.Prescription;

public class Transformer {

	public FindPrescriptionsRequest transformRequest(com.divya.services.pms.jaxb.FindPrescriptionsRequest request) {
		FindPrescriptionsRequest boRequest = new FindPrescriptionsRequest();
		boRequest.setCustomerId(request.getCustomerId());

		return boRequest;
	}


	public com.divya.services.pms.jaxb.FindPrescriptionsResponse transformResponse(FindPrescriptionsResponse boResponse) {
		com.divya.services.pms.jaxb.FindPrescriptionsResponse response = new com.divya.services.pms.jaxb.FindPrescriptionsResponse();
		response.setNumberOfPrescriptions(""+boResponse.getNumberOfPrescriptions());	
		ArrayOfPrescriptions prescriptions = new ArrayOfPrescriptions();

		if(boResponse != null && boResponse.getPrescriptions() != null) {
			for(Prescription pres : boResponse.getPrescriptions()) {
				com.divya.services.pms.jaxb.Prescription prescription = new com.divya.services.pms.jaxb.Prescription();
				prescription.setRxNumber(pres.getRxNumber());
				prescription.setLocaNumber(pres.getLocaNumber());
				prescription.setDateOfService(pres.getDateOfService());
				prescriptions.getPrescription().add(prescription);
			}
			response.setPrescriptions(prescriptions);	
		}
		return response;
	}
}
