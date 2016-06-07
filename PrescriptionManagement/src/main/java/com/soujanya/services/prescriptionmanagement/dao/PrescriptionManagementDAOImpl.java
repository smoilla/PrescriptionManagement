package com.soujanya.services.prescriptionmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soujanya.services.model.Address;
import com.soujanya.services.model.Drug;
import com.soujanya.services.model.Prescriber;
import com.soujanya.services.model.Prescription;

public class PrescriptionManagementDAOImpl implements PrescriptionManagementDAO {

	@Override
	public Prescription[] findPrescrptions(String customerId) {

		Prescription[] prescriptionList = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prescription_mgmt", "root",
					"sreeramg143");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select distinct * from RXDETAILS INNER JOIN DRUG ON rxdetails.drug_id=drug.drug_id"
					+ " INNER JOIN PRESCRIBER on rxdetails.prescriber_id=prescriber.prescriber_id");
			
			
			/* select *,isEligible as "Yes",Reason_Code as "" from RXDETAILS INNER JOIN DRUG on RXDETAILS.drug_id=DRUG.drug_id where drug.specilaity="No"
			 * update isEligible as "No",Reason_Code as "Specialitydrug" from RXDETAILS INNER JOIN DRUG on RXDETAILS.drug_id=DRUG.drug_id where drug.specilaity="Yes"
			 * 
			 */
			
			
			
			

			/*ResultSet rs = stmt.executeQuery("select RX_NUMBER,LOCA_NUMBER from RXDETAILS where IS_ELIGIBLE=YES");
Resultset l=stmt.executeQuery("select * from drug where drug.speciality=No");
 * 
 * List l=stmt.executeQuery("select * from drug where drug.speciality=No");
 * 
 * String s=stmt.executeQuery("select drug_type from drug where drug_id=RXDETAILS.drug_id");
 * if (s.equals("NO")){
 * if (RXDETAILS.drug_id in l)
 *  RXDETAILS.is_eligible="yes";
 * else{
 * RXDETAILS.is_eligible="no";
 * reason_code="Speciality drug";}
 * 
 * 
 * 
 * for(int j=0;j<metaData.getColumnCount();j++){
 * if (RXDETAILS.drug_id in l)
 *  RXDETAILS.is_eligible="yes";
 * else{
 * RXDETAILS.is_eligible="no";
 * reason_code="Speciality drug";}
 * 
 * for(int j=0;j<metaData.getColumnCount();j++){
 * date refill_date;
 * refill_date=dateadd(day,supplydays,last_fill_date);
 * 
 * String last=Rxdetails.last_refill_date;
 * SimpleDateFormat=new SimpleDateFormat("mm/dd/yyyy");
 * Calendar c= Calendar.getInstance();
 * c.setTime(sdf.parse(last));
 * c.add(Calendar.DATE,RXDETAILS.supply_days);
 * refill_date=sdf.format(c.getTime());+
 * 
 * 
 * if refill_date<currentdate
 * RXDETAILS.is_eligible="yes";
 * else{
 * RXDETAILS.is_eligible="no";
 * reason_code="Insufficient time";}
 * 
 * 
 * }
		("select dateadd(day,supplydays,last_fill_date)from RXDETAILS");
			ResultSet rs = stmt.executeQuery("select RX_NUMBER,LOCA_NUMBER from RXDETAILS where ");*/
			
			List<Prescription> pList = new ArrayList<Prescription>();
			while (rs.next()) {
				Prescription prescription = new Prescription();
				prescription.setRxNumber(rs.getString("Rx_Number"));
				prescription.setLocaNumber(rs.getString("Loca_Number"));
				prescription.setDaysSupplyQuantity(rs.getString("Supply_Days"));
				prescription.setDosageQuantity(rs.getString("Dosage_Qty"));
				prescription.setFillingPharmacy(rs.getString("Filling_Pharmacy"));
				prescription.setDateOfService(rs.getString("service_date"));
				prescription.setLastFilllDate(rs.getString("last_fill_date"));
				Drug drug=new Drug();
				drug.setName(rs.getString("Drug_Name"));
				drug.setType(rs.getString("Type"));
				drug.setSpecialty(rs.getString("Speciality"));
				drug.setNdc(rs.getString("drug_id"));
				prescription.setDrug(drug);
				Prescriber prescriber=new Prescriber();
				prescriber.setFirstName(rs.getString("First_Name"));
				prescriber.setLastName(rs.getString("Last_Name"));
				prescriber.setLicenseNumber(rs.getString("License_Number"));
				prescriber.setId(rs.getString("Prescriber_Id"));
				
				Address address=new Address();
				address.setCity(rs.getString("City"));
				address.setLine1(rs.getString("Add_Line1"));
				address.setLine2(rs.getString("Add_Line2"));
				address.setState(rs.getString("State"));
				address.setZipCode(rs.getString("Zipcode"));
				
				prescriber.setWorkAddress(address);
				prescriber.setHomeAddress(address);
				prescription.setPrescriber(prescriber);
				pList.add(prescription);
			}
			
			prescriptionList = new Prescription[pList.size()];
			int i=0;
			for(Prescription p : pList) {
				prescriptionList[i] = p;
				i++;
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return prescriptionList;
	}

	public static void main(String[] args) {
		new PrescriptionManagementDAOImpl().findPrescrptions("123");
	}

}
