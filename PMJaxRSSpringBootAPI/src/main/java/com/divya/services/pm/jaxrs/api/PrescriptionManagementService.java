package com.divya.services.pm.jaxrs.api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.divya.services.pms.jaxb.FindPrescriptionsRequest;
import com.divya.services.pms.jaxb.FindPrescriptionsResponse;
import com.divya.services.prescriptionmanagementpractice.bo.PrescriptionManagementPracticeBO;
import com.divya.services.prescriptionmanagementpractice.bo.impl.PrescriptionManagementPracticeBOImpl;


@RestController
public class PrescriptionManagementService {
	@RequestMapping(name="/findPrescriptions",method=RequestMethod.POST,consumes=MediaType.APPLICATION_XML_VALUE,produces=MediaType.APPLICATION_XML_VALUE)
public FindPrescriptionsResponse findPrescriptions(@RequestBody FindPrescriptionsRequest findPrescriptionsRequest)throws Exception{
	PrescriptionManagementPracticeBO bo=new PrescriptionManagementPracticeBOImpl();
	
	Transformer transformer = new Transformer();
	return transformer.transformResponse(bo.findPrescriptions(transformer.transformRequest(findPrescriptionsRequest)));
}
}
