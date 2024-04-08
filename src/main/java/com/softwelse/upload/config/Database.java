package com.softwelse.upload.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static Connection connection() throws SQLException {
		try {
			String url = DatabaseConfig.getDbUrl();
			String username = DatabaseConfig.getUsername();
			String password = DatabaseConfig.getPassword();

			return DriverManager.getConnection(url, username, password);

			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}