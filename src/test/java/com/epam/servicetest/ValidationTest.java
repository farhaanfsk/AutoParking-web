/**
 * 
 */
package com.epam.servicetest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.epam.service.Validation;

/**
 * @author Farhaan_Shaik
 *
 */
public class ValidationTest {
    /**.
     * testing the login credentials
     */
	@Test
	public void loginTest() {
		assertTrue(Validation.login("fsk", "12"));
    	assertFalse(Validation.login("abcd", "epam"));
    	assertFalse(Validation.login("1234", "qwerty"));
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
