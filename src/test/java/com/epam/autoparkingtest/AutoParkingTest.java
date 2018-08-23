package com.epam.autoparkingtest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import com.epam.autoparking.AutoParking;
import com.epam.exception.InvalidInputException;


public class AutoParkingTest {
	/**.
	 * unit test for file initializatiion
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void fileInitTest() throws IOException, ClassNotFoundException, SQLException {
		AutoParking autoparking = new AutoParking();
		AutoParking spy = Mockito.spy(autoparking);
		Mockito.doNothing().when(spy).fileInit("", 0);
		spy.fileInit("1", 0);
		spy.fileInit("2", 2);
	}
	/**.
	 * unit testing for menu method
	 * @throws Exception 
	 */
	@Test
	public void menuTest() throws Exception {
		AutoParking autoparking = new AutoParking();
			assertEquals("vehicle parked at slot : 1", autoparking.menu("park", "qw21qw1212"));
		
		assertEquals("The vehicle is already parked !!", autoparking.menu("park", "qw21qw1212"));
		assertEquals("vehicle parked at slot : 2", autoparking.menu("park", "as12as1212"));
		assertEquals("All slots are full parking not available", autoparking.menu("park", "zx12ZX1212"));
	    assertEquals("Vehicle UnParked and out time is : " + new Date(), autoparking.menu("unpark", "qw21qw1212"));
	    assertEquals("Vehicle not available", autoparking.menu("unpark", "ap07qw7777"));
	    assertEquals("InvalidInput", autoparking.menu("park", "abcd"));
	    assertEquals("InvalidInput", autoparking.menu("unpark", "abcd"));
	    assertEquals("InvalidInput", autoparking.menu("12", "abcd"));
	    assertEquals("", autoparking.menu("logout", "abcd"));
	}
}
