package com.bridgelabz.ServletJspApp2.controller;

import java.sql.*;

public class ImplementedConnectionProvider implements MYConnectionProvider {
	static Connection con = null;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception exc) {
			System.out.println(exc);
		}

		return con;

	}
}
