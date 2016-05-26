package com.soujanya.services.prescriptionmanagement.dao;

import com.soujanya.services.model.Prescription;

public interface PrescriptionManagementDAO {

	Prescription[] findPrescrptions(String customerId);

}
