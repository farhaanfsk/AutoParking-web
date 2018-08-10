package com.epam.autoparkingtest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.epam.autoparking.AutoParking;
import com.epam.exception.InvalidInputException;

public class AutoParkingTest {

	@Test
	public void mainTest() throws InvalidInputException, IOException {
		AutoParking park =new AutoParking();
		 StringBuilder input = new StringBuilder();
	     InputStream inputStream;
	     input.append("2\n");
	    
	     input.append("1\n");
	     input.append("AP07qw7777\n");
	     
	     input.append("1\n");
	     input.append("TS07qw7777\n");
	     
	     input.append("1\n");
	     input.append("AP19ty7777\n");
	     
	     input.append("2\n");
	     input.append("AP07qw7777\n");
	     input.append("1\n");
	     
	     input.append("1\n");
	     input.append("TS07qw7777\n");
	     
	     input.append("2\n");
	     input.append("TS07qw1234\n");
	     input.append("1\n");
	     
	     input.append("1\n");
	     input.append("AP19ty7777\n");
	     
	     input.append("1\n");
	     input.append("AP19pq7777\n");
	     
	     input.append("5");
	    // input.append("");
	     inputStream = new ByteArrayInputStream(input.toString().getBytes());
	     System.setIn(inputStream);
	     //String args[] = {"fsk", "12", "0"};
	    // AutoParking.main(args);
	}
}
