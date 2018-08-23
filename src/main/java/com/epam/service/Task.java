package com.epam.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;

import com.epam.dboperations.DBLog;
//import com.epam.dboperations.DBWrite;
import com.epam.files.FileWrite;
import com.epam.files.LogWrite;
import com.epam.jpa.DBWrite;

/**
 * @author Farhaan_Shaik
 *
 */
public class Task {
    /**.
     * for storing vehicle and its slot details
     */
    private static HashMap<Integer, String> map;
    private DBWrite dbwrite = new DBWrite();
    public Task() {
    	
    }
    /**.
     * constructor for initialization
     * @param slotSize total no of slots
     * @throws SQLException 
     * @throws ClassNotFoundException 
      */
    public Task(final int slotSize) throws ClassNotFoundException, SQLException {
        map = new HashMap<Integer, String>(slotSize);
        for (int i = 1; i <= slotSize; i++) {
        	map.put(i, "empty");
        }
        dbwrite.dbInit(slotSize);
        }
    /**.
     * constructor to initialize the map
     * @param map hash map to store
     */
    public Task(final HashMap<Integer, String> map) {
    	this.map = map;
    }
    /**.
     * file writer class
     */
    private FileWrite writer = new FileWrite();
    private LogWrite log = new LogWrite();
    
    /**.
     * method for parking the car and allotting the slot number
     * @param carNo car registration number
     * @param slotSize total no of slots
     * @param slotCount sequence of slots
     * @return returns a result option
     * @throws IOException for files
     * @throws SQLException 
     * @throws Exception 
     */
    public String park(final String carNo, int slotSize, int slotCount) throws IOException, SQLException, Exception {
        String result = new String();
        if (map.containsValue(carNo)) {
            result = slotCount + "" + 3;
        }
        else if (map.containsValue("empty")) {
        	int slot = availableSlot(carNo);
            result =  slot+ "" + 1;
            dbwrite.dbParkWrite(slot, carNo);
            writer.write(map);
            DBLog.logPark(slot, carNo);
            log.write("Vehile = "+carNo + " Parked at Slot - "+ result.charAt(0));
            } else {
                 result = slotCount + "" + 2;
               }
        return result;
        }
	/**
	 * @param carNo car registration number
	 * @return result the key value
	 */
	public int availableSlot(final String carNo) {
		int result = 0;
		for (int key : map.keySet()) {
			if (map.get(key).equals("empty")) {
				map.put(key, carNo);
				System.out.println(key);
				result = key;
				break;
			}
		}
		return result;
	}
    /**.
     * method for unparking the vehicle and making the slot
     * available for other vehicle
     * @param carNo car registration number
     * @return boolean value if vehicle is parked or not
     * @throws IOException  foe files
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public boolean unPark(final String carNo) throws IOException, ClassNotFoundException, SQLException {
    	boolean result = false;
    	if (map.containsValue(carNo)) {
    		for (int key : map.keySet()) {
    			if (map.get(key).equals(carNo)) {
    				map.replace(key, "empty");
    				dbwrite.dbUnparkWrite(key,carNo);
    				DBLog.logUnPark(key, carNo);
    				break;
    			}
    		}
    		writer.write(map);
    		
    		log.write("Vehile = "+carNo + " successfully UnParked");
			result = true;
		} else {
			result = false;
		}
    	return result;
	}
    /**.
     * to display the hash map values
     */
    public HashMap<Integer, String> displayMap(){
    	return this.map;
    }
    
    
}
