package com.qa.hubspot.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.openqa.selenium.By;

import com.qa.hubspot.base.BasePage;

public class DataBaseUtil {
	static Properties prop = BasePage.init_prop();
	
	private static String host;
	private static String port;
	private static String dbName;
	private static String user;
	private static String dbPassword;

	static Connection con = null;
	
	//Connection to mysql database on local machine was established
	//All hardcoding should be removed, generic methods to be developed, to be integrated into framework
	public static Connection setUpConnection (){
		  
		host = prop.getProperty("host");
		port = prop.getProperty("port");
		dbName = prop.getProperty("dbName");
		user = prop.getProperty("user");
		dbPassword = prop.getProperty("dbPassword");
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, user,
					dbPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 

		return con;
	}
	
	public static String getValueFromQueryResult(String query, String key) {
		
		String value = null;
		try {
			Statement s = setUpConnection().createStatement();
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				value = rs.getString(key);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	public static List executeQuery(String sqlQuery) throws SQLException {
        return getQueryRunner().query(setUpConnection(), sqlQuery, new MapListHandler());
        
    }

    protected static QueryRunner getQueryRunner() {
        return new QueryRunner();
    }

}
