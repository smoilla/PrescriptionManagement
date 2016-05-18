package com.soujanya.services.prescriptionmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.soujanya.services.model.Prescription;

public class PrescriptionManagementDAOImpl implements PrescriptionManagementDAO {

	@Override
	public List<Prescription> findPrescrptions(String customerId) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prescription_mgmt", "root",
					"welcome123");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select RX_NUMBER,LOCA_NUMBER from RXDETAILS");

			java.sql.ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				System.out.print(metaData.getColumnName(i) + "  ");
			}

			System.out.println();
			while (rs.next())
				System.out.println(rs.getString("RX_NUMBER") + "  " + rs.getString("LOCA_NUMBER"));

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public static void main(String[] args) {
		new PrescriptionManagementDAOImpl().findPrescrptions("123");
	}

}
