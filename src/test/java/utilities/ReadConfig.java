package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	public ReadConfig(){
		
		File src = new File("./Configuration/config.properties");
		
		try {
			properties = new Properties();
			FileInputStream inputStream = new FileInputStream(src);
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.println("Exception is: " + e.getMessage());
		}
		
		
	}
	
	public String getURL() {
		String baseURL = properties.getProperty("baseURL");
		return baseURL;
	}
	
	public String getChromePath() {
		String chromePath = properties.getProperty("chrome");
		return chromePath;
	}
	
	public String getFirefoxPath() {
		String firefoxPath = properties.getProperty("firefox");
		return firefoxPath;
	}
	
	public String getEmail() {
		String email = properties.getProperty("email");
		return email;
	}
	
	public String getPassword() {
		String password = properties.getProperty("password");
		return password;
	}

}
