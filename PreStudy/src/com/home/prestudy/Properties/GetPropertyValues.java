package com.home.prestudy.Properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class GetPropertyValues {
	
public void GetPropertyValues() {
		
	
	
	String result = "";	
	
		Properties prop = new Properties();
		
		String path = "src\\resources\\config.properties";
		
		try {
			
			prop.load(new FileReader(path));
			
			System.out.println(prop);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
}
}