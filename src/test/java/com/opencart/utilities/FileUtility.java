package com.opencart.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	private Properties properties = new Properties();

	public void setProperty(String key, String value) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(
				System.getProperty("user.dir") + "//src//test//resources//config.properties");) {
			properties.setProperty(key, value);
			properties.store(fileOutputStream, "updated successfully");
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public String getProperty(String key) {
		try (FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config.properties");) {
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.getMessage();
		}
		return properties.getProperty(key);
	}
}
