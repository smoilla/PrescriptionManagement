package com.soujanya.services.prescriptionmanagement.bo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soujanya.services.prescriptionmanagement.FindPrescriptionsRequest;
import com.soujanya.services.prescriptionmanagement.FindPrescriptionsResponse;
import com.soujanya.services.prescriptionmanagement.bo.impl.PrescriptionManagementBOImpl;

@RestController
public class PrescriptionManagementService {

	@RequestMapping(name="/findPrescriptions", method = RequestMethod.POST, consumes="application/xml", produces = "application/xml")
	public FindPrescriptionsResponse findPrescrptions(@RequestBody FindPrescriptionsRequest request) throws Exception {
		PrescriptionManagementBO bo = new PrescriptionManagementBOImpl(); 
		return bo.findPrescrptions(request);
	}
}
