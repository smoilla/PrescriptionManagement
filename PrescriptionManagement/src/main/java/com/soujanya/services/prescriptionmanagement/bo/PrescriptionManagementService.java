package com.soujanya.services.prescriptionmanagement.bo;

import com.soujanya.services.prescriptionmanagement.FindPrescriptionsRequest;
import com.soujanya.services.prescriptionmanagement.FindPrescriptionsResponse;
import com.soujanya.services.prescriptionmanagement.bo.impl.PrescriptionManagementBOImpl;

public class PrescriptionManagementService {

	public FindPrescriptionsResponse findPrescrptions(FindPrescriptionsRequest request) throws Exception {
		PrescriptionManagementBO bo = new PrescriptionManagementBOImpl(); 
		return bo.findPrescrptions(request);
	}
}
