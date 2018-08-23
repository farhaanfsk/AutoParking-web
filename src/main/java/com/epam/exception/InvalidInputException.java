package com.epam.exception;
/**.
 * user exception class
 * @author Farhaan_Shaik
 *
 */
public class InvalidInputException extends Exception {
    /**.
     * method to display exception
     */
	@Override
	public String toString() {
		return "InvalidInput";
	}
}
