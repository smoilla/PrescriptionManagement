package com.soujanya.services.prescriptionmanagement.bo.impl;

import com.soujanya.services.prescriptionmanagement.FindPrescriptionsRequest;
import com.soujanya.services.prescriptionmanagement.FindPrescriptionsResponse;
import com.soujanya.services.prescriptionmanagement.bo.PrescriptionManagementBO;
import com.soujanya.services.prescriptionmanagement.dao.PrescriptionManagementDAO;

public class PrescriptionManagementBOImpl implements PrescriptionManagementBO {

	FindPrescriptionsHelper findPrescriptionsHelper;
	PrescriptionManagementDAO dao;

	@Override
	public FindPrescriptionsResponse findPrescrptions(FindPrescriptionsRequest request) throws Exception {
		FindPrescriptionsResponse response = new FindPrescriptionsResponse();
		findPrescriptionsHelper = new FindPrescriptionsHelper();

		// validate request
		findPrescriptionsHelper.validateRequest(request);

		response.setPrescription(dao.findPrescrptions(request.getCustomerId()));

		response = findPrescriptionsHelper.postProcess(response);
		return response;
	}

}
