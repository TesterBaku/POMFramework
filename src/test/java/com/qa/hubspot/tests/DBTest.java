package com.qa.hubspot.tests;

import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.Test;

import com.qa.hubspot.utils.DataBaseUtil;

public class DBTest {

	@Test
	public void dbTest() {

		try {
			List <String> rs = DataBaseUtil.executeQuery("select* from Employeeinfo where name = \"sam\";");
			System.out.println(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void dbTest_1() {
			String rs = DataBaseUtil.getValueFromQueryResult("select* from Employeeinfo where name = \"sam\";", "name");
			System.out.println(rs);
		}
	}


