package com.soujanya.services.prescriptionmanagement.bo;

import com.soujanya.services.prescriptionmanagement.FindPrescriptionsRequest;
import com.soujanya.services.prescriptionmanagement.FindPrescriptionsResponse;

public interface PrescriptionManagementBO {

	FindPrescriptionsResponse findPrescrptions(FindPrescriptionsRequest request) throws Exception;

}
