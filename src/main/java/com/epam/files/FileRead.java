package com.epam.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
/**.
 *
 * @author Farhaan_Shaik
 *
 */
public class FileRead {
	/**.
	 * method to read from file
	 * @return map with previous data
	 * @throws IOException if file not found
	 */
	public HashMap<Integer, String> read() throws IOException {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		String url = "C:\\Users\\Farhaan_Shaik\\eclipse-workspace\\autoparking\\src\\main\\resources\\transaction.csv";
		File file = new File(url);
    	FileReader fileR = new FileReader(file);
    	BufferedReader reader = new BufferedReader(fileR);
    	String line = "";
		while ((line = reader.readLine()) != null) {
			String[] temp = line.split(",");
				map.put(Integer.parseInt(temp[1]), temp[0]);
		}
		System.out.println(map);
		fileR.close();
		reader.close();
    	return map;
    }
}
