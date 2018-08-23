package com.epam.autoparking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import com.epam.dboperations.DBRead;
import com.epam.exception.InvalidInputException;
import com.epam.files.FileRead;
import com.epam.service.Task;
import com.epam.service.Validation;

/**.
 * main class for console operation
 * @author Farhaan_Shaik
 */
public class AutoParking {
	/**.
	 * static task object
	 */
	private static Task task;
	/**.
	 * static slot size
	 */
	private static int slotSize;
	/**.
	 * static slot count
	 */
	private static int slotCount = 1;
	/**.
	 * method for file initialization
	 * @param args argument
	 * @param slotSize max size of parking
	 * @throws IOException exception for file
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void fileInit(final String args, final int slotSize)
			throws IOException, ClassNotFoundException, SQLException {
		if (args.equals("1")) {
			//task = new Task(new FileRead().read());
			task = new Task(new DBRead().read());
		} else if (args.equals("2")) {
			this.slotSize = slotSize;
		    task = new Task(slotSize);
		}
	}
	/**.
	 * method to display menu
	 * @param option menu option
	 * @param carNo registration no
	 * @return output
	 * @throws Exception 
	 */
	public String menu(final String option, final String carNo)
			throws Exception {
		String result = "";
		switch (option) {
		    case "park":
		    	if (Validation.validCar(carNo)) {
		    		String value = parkDisplay(task, slotCount, carNo);
		    		slotCount = Integer.parseInt(value.charAt(value.length() - 1) + "");
		    		result = value.substring(0, value.length() - 1);
		    		} else {
		    		    result = new InvalidInputException().toString();
		    		}
		    	break;
		    case "unpark":
		    	if (Validation.validCar(carNo)) {
		            result = unparkDisplay(task, carNo);
		    	} else {
		    		result = new InvalidInputException().toString();
		    		}
		        break;
		    case "logout":
		    	
		        break;
		    default:
		    	result = new InvalidInputException().toString();
		    	}
		return result;
	}
	/**.
	 * displays the uparked car details
	 * @param task object of Task
	 * @param carNo car number
	 * @throws IOException file errors
	 * @return output value
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private static String unparkDisplay(final Task task, final String carNo)
			throws IOException, ClassNotFoundException, SQLException {
		String result = "";
		if (task.unPark(carNo)) {
			result = "Vehicle UnParked and out time is : " + new Date();
		} else {
			result = "Vehicle not available";
		}
		return result;
	}
	/**.
	 * @param task task class
	 * @param slotCount sequence
	 * @param carNo car number
	 * @return output value
	 * @throws Exception 
	 */
	private String parkDisplay(final Task task, int slotCount, final String carNo)
					throws Exception {
		String output = "";
		String result = task.park(carNo, slotSize, slotCount);
		    if (result.charAt(result.length() - 1) == '1') {
		       output = "vehicle parked at slot : " + result.substring(0, result.length() - 1);
		        slotCount++;
		   } else if (result.charAt(result.length() - 1) == '2') {
		       output = "All slots are full parking not available";
		    } else if (result.charAt(result.length() - 1) == '3') {
		        output = "The vehicle is already parked !!";
		        }
		return output + slotCount;
	}
}

