package com.divya.services.prescriptionmanagementpractice.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.divya.services.prescriptionmanagementpractice.model.*;



@SuppressWarnings("unused")
public class PrescriptionManagementPracticeDAOImpl implements PrescriptionManagementPracticeDAO {

	public Prescription[] findPrescriptions(String customerId){
		Prescription[] list1=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		//learn how to get the right parameters
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prescription_mgmt", "root","sreeramg143");
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select *,concat(Rx_Number,Loca_Number) as ndc from rxdetails INNER JOIN drug ON rxdetails.drug_id=drug.drug_id "+
		" INNER JOIN prescriber ON rxdetails.prescriber_id=prescriber.prescriber_id ");
		
		List<Prescription> list2=new ArrayList<Prescription>();
		int i=0;
		while(rs.next()){
	Prescription prescription=new Prescription();
	Prescriber prescriber=new Prescriber();
	Drug drug=new Drug();
	Address address=new Address();
	
	prescription.setRxNumber(rs.getString("Rx_Number"));
	prescription.setLocaNumber(rs.getString("Loca_Number"));
	prescription.setDaysSupplyQuantity(rs.getString("Supply_Days"));
	prescription.setDosageQuantity(rs.getString("Dosage_Qty"));
	prescription.setFillingPharmacy(rs.getString("Filling_Pharmacy"));
	prescription.setDateOfService(rs.getString("service_date"));
	
	drug.setName(rs.getString("Drug_Name"));
	drug.setType(rs.getString("Type"));
	drug.setSpeciality(rs.getString("Speciality"));
	drug.setNdc(rs.getString("drug_id"));
	prescription.setDrug(drug);
	

	prescriber.setFirstName(rs.getString("First_Name"));
	prescriber.setLastName(rs.getString("Last_Name"));
	prescriber.setLicenseNumber(rs.getString("License_Number"));
	prescriber.setId(rs.getString("Prescriber_Id"));
	
	
	address.setCity(rs.getString("City"));
	address.setLine1(rs.getString("Add_Line1"));
	address.setLine2(rs.getString("Add_Line2"));
	address.setState(rs.getString("State"));
	address.setZipcode(rs.getString("Zipcode"));
	prescriber.setHomeAddress(address);
	prescriber.setWorkAddress(address);

	prescription.setPrescriber(prescriber);
	
	list2.add(prescription);
	}
		list1=new Prescription[list2.size()];
		for(Prescription p:list2){
			list1[i]=p;
			i++;
		}
		
		con.close();
		
	}
	catch (Exception e){
		System.out.println(e);	}
		return list1;
	}
	
	public static void main(){
		new PrescriptionManagementPracticeDAOImpl().findPrescriptions("A1");
	}
	
}
