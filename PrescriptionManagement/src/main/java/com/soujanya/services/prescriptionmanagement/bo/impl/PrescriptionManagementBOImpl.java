package com.soujanya.services.prescriptionmanagement.bo.impl;

import com.soujanya.services.model.Prescription;
import com.soujanya.services.prescriptionmanagement.FindPrescriptionsRequest;
import com.soujanya.services.prescriptionmanagement.FindPrescriptionsResponse;
import com.soujanya.services.prescriptionmanagement.bo.PrescriptionManagementBO;
import com.soujanya.services.prescriptionmanagement.dao.PrescriptionManagementDAO;
import com.soujanya.services.prescriptionmanagement.dao.PrescriptionManagementDAOImpl;

public class PrescriptionManagementBOImpl implements PrescriptionManagementBO {

	FindPrescriptionsHelper findPrescriptionsHelper;
	PrescriptionManagementDAO dao;

	@Override
	public FindPrescriptionsResponse findPrescrptions(FindPrescriptionsRequest request) throws Exception {
		FindPrescriptionsResponse response = new FindPrescriptionsResponse();
		findPrescriptionsHelper = new FindPrescriptionsHelper();
		dao = new PrescriptionManagementDAOImpl();

		// validate request
		findPrescriptionsHelper.validateRequest(request);

		response.setPrescriptions(dao.findPrescrptions(request.getCustomerId()));

//		response = findPrescriptionsHelper.postProcess(response);
		return response;
	}

}
