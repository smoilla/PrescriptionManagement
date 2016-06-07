package com.divya.services.prescriptionmanagementpractice.bo;
import java.lang.Exception;
import com.divya.services.prescriptionmanagementpractice.FindPrescriptionsRequest;
import com.divya.services.prescriptionmanagementpractice.FindPrescriptionsResponse;

public interface PrescriptionManagementPracticeBO {

FindPrescriptionsResponse findPrescriptions(FindPrescriptionsRequest findPrescriptionsRequest)throws Exception;
//Notice that return type is the classname not the object name.
}
