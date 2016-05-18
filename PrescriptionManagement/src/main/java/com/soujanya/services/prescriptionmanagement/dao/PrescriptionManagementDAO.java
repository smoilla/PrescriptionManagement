package com.soujanya.services.prescriptionmanagement.dao;

import java.util.List;

import com.soujanya.services.model.Prescription;

public interface PrescriptionManagementDAO {

	List<Prescription> findPrescrptions(String customerId);

}
