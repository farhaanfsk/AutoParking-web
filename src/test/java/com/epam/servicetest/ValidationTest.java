/**
 * 
 */
package com.epam.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import com.epam.service.Validation;

/**
 * @author Farhaan_Shaik
 *
 */
public class ValidationTest {
    /**.
     * testing the login credentials
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
	@Test
	public void loginTest() throws ClassNotFoundException, SQLException {
		assertEquals("park",Validation.login(121, "admin"));
    	assertEquals("unpark",Validation.login(122, "admin2"));
    	assertEquals("display",Validation.login(123, "admin3"));
	}
	/**.
	 * testing if car number is valid or not
	 */
	@Test
	public void validCar() {
		assertTrue(Validation.validCar("TS07ey8570"));
		assertTrue(Validation.validCar("AP07pk8571"));
		assertTrue(Validation.validCar("ap07ey7777"));
		assertFalse(Validation.validCar("abc"));
	}

}
