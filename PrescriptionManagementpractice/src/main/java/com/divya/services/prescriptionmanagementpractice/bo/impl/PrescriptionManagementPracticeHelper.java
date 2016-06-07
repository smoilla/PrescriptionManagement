package com.divya.services.prescriptionmanagementpractice.bo.impl;
import java.lang.Exception;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.divya.services.prescriptionmanagementpractice.FindPrescriptionsRequest;
import com.divya.services.prescriptionmanagementpractice.FindPrescriptionsResponse;
import com.divya.services.prescriptionmanagementpractice.model.Prescription;
public class PrescriptionManagementPracticeHelper {

	public void validateRequest(FindPrescriptionsRequest request) throws Exception{
		
		if((request==null)||request.getCustomerId()==null)
			throw new Exception("Customer Id is null");
		else{
			if ((request.getCustomerId().trim().length())==0)
				throw new Exception("CustomerId is empty");
		}
		
		}
	
	public FindPrescriptionsRequest preProcessing(FindPrescriptionsRequest request){
	return null;	
	}
	
	public FindPrescriptionsResponse postprocessing(FindPrescriptionsResponse response){
		
						for(Prescription prescription:response.getPrescriptions()){
			 if(prescription != null && prescription.getDrug() != null && prescription.getDrug().getSpeciality() != null && prescription.getDrug().getSpeciality().equalsIgnoreCase("Yes")){
				prescription.setIsEligible("false");	
				prescription.setNonEligibleReasonCode("Speciality Drug");
				}
				
			 
			 String dateOfService = prescription.getDateOfService();
			 try {
				Date dateOfSer = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfService);
				int daysSupply = Integer.parseInt(prescription.getDaysSupplyQuantity());
				Calendar dateOfServiceCalendar = Calendar.getInstance();
				Calendar currDate = Calendar.getInstance();
				dateOfServiceCalendar.setTime(dateOfSer);
				dateOfServiceCalendar.add(Calendar.DATE, daysSupply + 10);
				if(currDate.after(dateOfServiceCalendar)) {
					prescription.setIsEligible("false");	
					prescription.setNonEligibleReasonCode("Insufficient Lead Time");
				}
				
			} catch (ParseException e) {
				System.out.println(e);
			}
			
		}
		response.setNumberOfPrescriptions(response.getPrescriptions().length);
		return response;
		
	}
	
}
