package com.softwelse.upload.config;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesConfig {

	private static final Properties properties = new Properties();

	static {
		try {
			InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("application.properties");
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> getAllowedExtension() {
		return Arrays.asList(properties.getProperty("file.upload.extension.allowed").split(","));
	}
}