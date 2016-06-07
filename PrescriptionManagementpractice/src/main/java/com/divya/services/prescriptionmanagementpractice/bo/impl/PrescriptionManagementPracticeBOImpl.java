package com.divya.services.prescriptionmanagementpractice.bo.impl;

import com.divya.services.prescriptionmanagementpractice.FindPrescriptionsRequest;
import com.divya.services.prescriptionmanagementpractice.FindPrescriptionsResponse;
import com.divya.services.prescriptionmanagementpractice.bo.PrescriptionManagementPracticeBO;
import com.divya.services.prescriptionmanagementpractice.dao.PrescriptionManagementPracticeDAO;
import com.divya.services.prescriptionmanagementpractice.dao.PrescriptionManagementPracticeDAOImpl;
import com.divya.services.prescriptionmanagementpractice.model.Prescription;

public class PrescriptionManagementPracticeBOImpl implements PrescriptionManagementPracticeBO {

	FindPrescriptionsResponse response;
	PrescriptionManagementPracticeDAO dao;
	PrescriptionManagementPracticeHelper helper;
	public FindPrescriptionsResponse findPrescriptions(FindPrescriptionsRequest request) throws Exception{
		helper=new PrescriptionManagementPracticeHelper();
		dao = new PrescriptionManagementPracticeDAOImpl();
		response = new FindPrescriptionsResponse();
		
		helper.validateRequest(request);
		
		response.setPrescriptions(dao.findPrescriptions(request.getCustomerId()));
		
		response=helper.postprocessing(response);
		
		return response;
	}
}
