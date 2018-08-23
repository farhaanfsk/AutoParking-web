package com.epam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.dbconnection.DBConnection;

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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
     */
    public static String login(final int userId, final String password) throws ClassNotFoundException, SQLException {
    	Connection con = DBConnection.Connect();
    	PreparedStatement stmt;
    	String result ="";
    	if (con!=null) {
    		stmt = con.prepareStatement("select * from autoparkingadmin");
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			System.out.println(rs.getInt(1) +"---"+rs.getString(2));
    			if(rs.getInt(1) == userId && rs.getString(2).equals(password)) {
    				result = rs.getString(3);
    				break;
    			} else {
    				result = "invalid";
    			}
    		}
    	}
    	return result;
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
