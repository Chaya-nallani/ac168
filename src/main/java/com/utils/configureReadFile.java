package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configureReadFile {
	private Properties prop;
	/**This method used to load the config.properties file
	 * 
	 * @return Properties prop object 
	 */
	public Properties init_prop() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/test/resources/Config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
