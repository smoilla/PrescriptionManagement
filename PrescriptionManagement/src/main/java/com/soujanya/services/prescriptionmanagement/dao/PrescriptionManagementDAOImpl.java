package com.soujanya.services.prescriptionmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			ResultSet rs = stmt.executeQuery("select * from RXDETAILS");
			
			
			
			
			
			
			
			
			
			
			
			
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
 * if s.equals("NO"){
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
			
			
			java.sql.ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				System.out.print(metaData.getColumnName(i) + "  ");
			}

			prescriptionList = new Prescription[20];
			int i=0;
			while (rs.next()) {
				Prescription prescription = new Prescription();
				prescription.setRxNumber(rs.getString("Rx_Number"));
				prescription.setLocaNumber(rs.getString("Loca_Number"));
				prescription.setDaysSupplyQuantity(rs.getString("Supply_Days"));
				prescription.setDosageQuantity(rs.getString("Dosage_Qty"));
				prescription.setFillingPharmacy(rs.getString("Filling_Pharmacy"));
				prescription.setDateOfService(rs.getString("service_date"));
				prescription.setLastFilllDate(rs.getString("last_fill_date"));
				prescriptionList[i] = (prescription);
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
