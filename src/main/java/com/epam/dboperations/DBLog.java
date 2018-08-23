package com.epam.dboperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.epam.dbconnection.DBConnection;

public class DBLog {
    public static void logPark(final int slotNo,final String carNo) throws ClassNotFoundException, SQLException {
    	Connection con = DBConnection.Connect();
    	PreparedStatement stmt;
    	if (con!=null) {
    		String query = "insert into log values(?,?,?,?,?,?)";
    		stmt = con.prepareStatement(query);
    		stmt.setInt(1, slotNo);
    		stmt.setInt(2,121);
    		stmt.setString(3, carNo);
    		stmt.setString(4, "park");
    		java.util.Date today = new java.util.Date();
    		stmt.setTimestamp(5, new java.sql.Timestamp(today.getTime()));
    		stmt.setTimestamp(6, null);
    		stmt.executeUpdate();
    		
    	}
    	con.close();
    }
    public static void logUnPark(final int slotNo,final String carNo) throws ClassNotFoundException, SQLException {
    	Connection con = DBConnection.Connect();
    	PreparedStatement stmt;
    	if (con!=null) {
    		String query = "insert into log values(?,?,?,?,?,?)";
    		stmt = con.prepareStatement(query);
    		stmt.setInt(1, slotNo);
    		stmt.setInt(2,121);
    		stmt.setString(3, "empty");
    		stmt.setString(4, "UnPark");
    		java.util.Date today = new java.util.Date();
    		stmt.setTimestamp(6, new java.sql.Timestamp(today.getTime()));
    		stmt.setTimestamp(5, null);
    		stmt.executeUpdate();
    		
    	}
    	con.close();
    }
}
