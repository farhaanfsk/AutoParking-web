/**
 * 
 */
package com.epam.files;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Farhaan_Shaik
 *
 */
public class LogWrite {
	public void write(String message) {
		Logger logger = Logger.getLogger("VehicleLog");
	    try {
	    	String url = "C:\\Users\\Farhaan_Shaik\\eclipse-workspace\\autoparking\\src\\main\\resources\\VehicleLog.txt";
			FileHandler fileHandler = new FileHandler(url, true);
		    logger.addHandler(fileHandler);
		    SimpleFormatter formatter = new SimpleFormatter();  
		    fileHandler.setFormatter(formatter);
		    logger.info(message);
	    } catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
    
}
