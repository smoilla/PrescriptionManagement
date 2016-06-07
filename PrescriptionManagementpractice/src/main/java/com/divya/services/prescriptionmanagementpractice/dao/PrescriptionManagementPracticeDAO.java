package com.divya.services.prescriptionmanagementpractice.dao;

import com.divya.services.prescriptionmanagementpractice.model.Prescription;
import java.lang.Exception;

public interface PrescriptionManagementPracticeDAO {

	Prescription[] findPrescriptions(String CustomerId) throws Exception;
	
}
