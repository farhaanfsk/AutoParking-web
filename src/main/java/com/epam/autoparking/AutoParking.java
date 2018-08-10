package com.epam.autoparking;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import com.epam.exception.InvalidInputException;
import com.epam.files.FileRead;
import com.epam.files.FileWrite;
import com.epam.service.Task;
import com.epam.service.Validation;

/**.
 * main class for console operation
 * @author Farhaan_Shaik
 */
public class AutoParking {
	/**.
     * @param args arguments
     * @throws InvalidInputException for invalid input
     * @throws IOException for files
     */
    public static void main(final String[] args) throws
    InvalidInputException, IOException {
        	//FileWrite.logWrite("\n\n---------New log--------"+ "-----\nuser:" + );
        	int slotSize = 0;
        	int slotCount = 1;
        	Task task ;
        	if (args[0].equals("1")) {
            	task = new Task(new FileRead().read());
            } else {
            	System.out.print("\nenter number of slots : ");
                task = new Task(slotSize);
            }            
            menu(slotSize, slotCount, task);
        
        }
	/**
	 * @param slotSize
	 * @param slotCount
	 * @param task
	 * @throws IOException
	 * @throws InvalidInputException
	 */
	private static void menu(int slotSize, int slotCount, Task task) throws IOException, InvalidInputException {
		boolean stop = true;
		while (stop) {
		    System.out.println("\nmenu\n1.Parking\n"
		    + "2.Unparking\n3.Logout\nEnter the option");
		    int option ;
		    String carNo = "";
		    switch (option) {
		    case 1:
		    	System.out.print("\nEnter the car number:\n");
		    	//carNo = sc.next();
		    	if (Validation.validCar(carNo)) {
		    		slotCount = parkDisplay(task,slotSize, slotCount, carNo);
		    		} else
		    		    throw new InvalidInputException();
		    	break;
		    case 2:
		    	System.out.print("\nEnter the car number:\n");
		    	//carNo = sc.next();
		    	if (Validation.validCar(carNo)) {
		    		System.out.print("Enter slot number : ");
		            int slotNo;
		            unparkDisplay(task, carNo, slotNo);
		    	} else {
		    		throw new InvalidInputException();
		    	}
		        break;
		    case 3:
		    	stop = false;
		        break;
		    default:
		    	throw new InvalidInputException();
		    }
		}
	}
	/**
	 * displays the uparked car details
	 * @param task object of Task
	 * @param logW log writer
	 * @param carNo car number
	 * @param slotNo slot number
	 * @throws IOException file errors
	 */
	private static void unparkDisplay(Task task, String carNo, int slotNo)
			throws IOException {
		if(task.unPark(carNo, slotNo)) {
			System.out.println("Vehicle UnParked and out "
		            + "time is : " + new Date());
		} else {
			System.out.println("Vehicle not available");
		}
	}
	/**.
	 * @param fileW file writer
	 * @param logW log writer
	 * @param task task class
	 * @param slot slot size
	 * @param slotCount sequence
	 * @param carNo car number
	 * @return slot count
	 * @throws IOException for files
	 */
	private static int parkDisplay(final Task task, final int slot,
			int slotCount, final String carNo)
					throws IOException {
		String result = task.park(carNo, slot, slotCount);
		    if (result.charAt(result.length() - 1) == '1') {
		        System.out.println("vehicle parked at slot : " + result.substring(0, result.length() - 1));
		        slotCount++;
		   } else if (result.charAt(result.length() - 1) == '2') {
		       System.out.println("All slots are full parking "
		        + "not available");
		    } else if (result.charAt(result.length() - 1) == '3') {
		            System.out.println("The vehicle is already parked !!");
		        }
		return slotCount;
	}
}
