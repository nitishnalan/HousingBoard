package com.housingboard.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author nitish
 */
public class CreateConfigProperties {
	
	public static void main(String[] args) throws IOException{
		Properties properties = new Properties();
		properties.setProperty("project-name", "HousingBoard");
		
		properties.setProperty("preferences-1", "Parking Space Included");
		properties.setProperty("preferences-2", "Gender Inclusive");
		properties.setProperty("preferences-3", "Pets Allowed");
	
//		properties.setProperty("project-name", "HousingBoard");
//		properties.setProperty("project-name", "HousingBoard");
//		properties.setProperty("project-name", "HousingBoard");
//		properties.setProperty("project-name", "HousingBoard");
//		properties.setProperty("project-name", "HousingBoard");
//		properties.setProperty("project-name", "HousingBoard");
//		properties.setProperty("project-name", "HousingBoard");
		
		FileWriter writer = new FileWriter("config-properties");
		properties.store(writer, "Author: nitish");
		writer.close();
		
		Properties prop = new Properties();
		InputStream input = null;
		String filename = "config-properties";
		input = CreateConfigProperties.class.getClassLoader().getResourceAsStream(filename);
		if(input==null){
	            System.out.println("Sorry, unable to find " + filename);
		    return;
		}
		
		prop.load(input);
		
		System.out.println(prop.getProperty("preferences-1"));
        System.out.println(prop.getProperty("preferences-2"));
        System.out.println(prop.getProperty("preferences-3"));
	}
}
