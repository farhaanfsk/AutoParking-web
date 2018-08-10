package com.epam.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import com.epam.files.FileWrite;

/**
 * @author Farhaan_Shaik
 *
 */
public class Task {
    /**.
     * for storing vehicle and its slot details
     */
    private static HashMap<Integer, String> map;
    /**.
     * constructor for initialization
     * @param slotSize total no of slots
      */
    public Task(final int slotSize) {
        map = new HashMap<Integer, String>(slotSize);
        for(int i=1;i<=slotSize;i++) {
        	map.put(i, "empty");
        }
        }
    
    public Task(final HashMap<Integer, String> map) {
    	this.map = map;
    }
    /**.
     * file writer class
     */
    FileWrite write = new FileWrite();
    /**.
     * method for parking the car and allotting the slot number
     * @param carNo car registration number
     * @param slotSize total no of slots
     * @param slotCount sequence of slots
     * @return returns a integer option
     * @throws IOException 
     */
    public String park(final String carNo, int slotSize,int slotCount) throws IOException {
        String result = new String();
        if (map.containsValue(carNo)) {
            result = slotCount + "" + 3;
            }
        else if (map.containsValue("empty")) {
            result = availableSlot(carNo)+""+1;
            FileWrite.logWrite("car no: " + carNo + "\nSlot No: "+ result + "In Time: " + new Date());
            write.write(map);
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
     * @param slotNo the slot alloted to the vehicle
     * @return boolean value if vehicle is parked or not
     * @throws IOException 
     */ 
    public boolean unPark(final String carNo, final int slotNo) throws IOException {
    	boolean result = false;
    	if (map.containsValue(carNo) && map.get(slotNo).equals(carNo)) {
    		map.replace(slotNo, "empty");
            FileWrite.logWrite("car no: " + carNo + "\nSlot No: "+ slotNo + "Out Time: " + new Date());
    		write.write(map);
			result = true;
		} else {
			result = false;
		}
    	return result;
	}
}
