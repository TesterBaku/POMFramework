package com.qa.hubspot.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {

	
	//Not integrated into framework
	//Connection to mysql database on local machine was established
	//All hardcoding should be removed, generic methods to be developed, to be integrated into framework
	public static void main(String[] args) {
		  
		String host = "localhost";
		String port = "3306";

		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", "root",
					"PASSWORD");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select* from Employeeinfo where name = \"sam\";");
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("location"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
	}

}
