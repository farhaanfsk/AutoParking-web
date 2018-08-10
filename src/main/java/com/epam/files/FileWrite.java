/**
 * 
 */
package com.epam.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author Farhaan_Shaik
 *
 */
public class FileWrite {
	/**.
	 * writes data into the file
	 * @param map writes using map
	 * @throws IOException exception
	 */
    public void write(final HashMap<Integer, String> map) throws IOException {
    	File file = new File("transaction.csv");
    	FileWriter fileW = new FileWriter(file);;
    	BufferedWriter writer = new BufferedWriter(fileW);
    	for(Entry<Integer, String> iterator : map.entrySet()) {
    		if(iterator.getValue().equals("empty")) {
    			writer.write(iterator.getValue()+","+iterator.getKey());
        	    writer.newLine();
        	    writer.flush();
    		} else {
    			writer.write(iterator.getValue()+","+iterator.getKey()+","+new Date());
        	    writer.newLine();
        	    writer.flush();
    		}
    	}
    	writer.close();
    	fileW.close();
    	
    }
    public static void logWrite(String data) throws IOException {
    	FileWriter fileW = new FileWriter("log.txt",true);
    	BufferedWriter writer = new BufferedWriter(fileW);
    	writer.write(data);
	    writer.newLine();
	    writer.flush();
	    writer.close();
    	fileW.close();
    }
}
