package com.softwelse.upload.config;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

	private static final Properties properties = new Properties();

	static {
		try {
			InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties");
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static String getDbUrl() {
		return properties.getProperty("db.url") + properties.getProperty("db.database");
	}

	public static String getUsername() {
		return properties.getProperty("db.username");
	}

	public static String getPassword() {
		return properties.getProperty("db.password");
	}
}