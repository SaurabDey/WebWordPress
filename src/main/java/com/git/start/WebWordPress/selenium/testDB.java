package com.git.start.WebWordPress.selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class testDB {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			Properties properties = new Properties();
			properties.setProperty("user", "root");
			properties.setProperty("password", "selenium");
			properties.setProperty("useSSL", "false");
			properties.setProperty("autoReconnect", "true");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", properties);

			System.out.println("Connected to database");

			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery("select * from employees where employeeNumber= 1076;");

			String[] dbVales = null;
			while (rs.next()) {

				String firstNameValue = rs.getString("firstName");
				String lastNameValue = rs.getString("lastName");
				System.out.println(firstNameValue);
				System.out.println(lastNameValue);
				dbVales = new String[2];
				dbVales[0] = firstNameValue;
				dbVales[1] = lastNameValue;

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			con.close();
		}

	}
}
