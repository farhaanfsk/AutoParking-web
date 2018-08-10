package com.epam.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**.
 * @author Farhaan_Shaik
 *
 */
public class Validation {
	/**.
     * method for authenticating the login details
     * @param userName valid user id
     * @param password authenticated user password
     * @return boolean value is returned
     */
    public static boolean login(final String userName, final String password) {
        if (userName.equals("fsk") && password.equals("12")) {
            return true;
        } else {
            System.out.println("Invalid credentials");
            return false;
        }
    }
    /**.
     * method to validate car number
     * @param carNo car number
     * @return true if valid
     */
    public static boolean validCar(final String carNo) {
    	Pattern pattern = Pattern.compile("[A-Z][A-Z][0-9][0-9][A-Z][A-Z][0-9][0-9][0-9][0-9]");
    	Matcher match = pattern.matcher(carNo.toUpperCase());
    	return match.matches();
    }
}
