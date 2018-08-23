package com.epam.dboperations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.epam.dbconnection.DBConnection;
public class DBWrite {
    public void dbParkWrite(int slotNo, String CarNo) throws SQLException, ClassNotFoundException{
    	  
    	Connection con = DBConnection.Connect();
    	PreparedStatement stmt;
    	if (con!=null) {
    		System.out.println("success");
    		stmt = con.prepareStatement("insert into vehicle values(?,?)");
    		stmt.setString(1, CarNo);
    		stmt.setString(2, "car");
    		stmt.executeUpdate();
    		String query = "update transaction set id = ?,status = ? ,vehicleNo = ?, inTime = ? where slotNo ="+slotNo;
    		stmt = con.prepareStatement(query);
    		stmt.setInt(1,121);
    		stmt.setString(2, "parked");
    		stmt.setString(3, CarNo);
    		java.util.Date today = new java.util.Date();
    		stmt.setTimestamp(4, new java.sql.Timestamp(today.getTime()));
    		stmt.executeUpdate();
    	}
    	con.close();
    }
    public void dbUnparkWrite(int slotNo, String CarNo) throws ClassNotFoundException, SQLException {
    	Connection con = DBConnection.Connect();
    	PreparedStatement stmt;
    	if (con!=null) {
    		
    		String query = "update transaction set id = ?,status = ? ,vehicleNo = ?, inTime = ? where slotNo ="+slotNo;
    		stmt = con.prepareStatement(query);
    		stmt.setInt(1,121);
    		stmt.setString(2, "empty");
    		stmt.setString(3, null);
    		stmt.setTimestamp(4, null);
    		stmt.executeUpdate();
    		stmt = con.prepareStatement("delete from vehicle where registrationNo = \'"+ CarNo+"\'");
    		stmt.executeUpdate();
    		
    	}
    	con.close();
    }
    public void dbInit(int slotSize) throws ClassNotFoundException, SQLException {
    	Connection con = DBConnection.Connect();
    	PreparedStatement stmt;
    	stmt = con.prepareStatement("delete from transaction");
		stmt.executeUpdate();
		stmt = con.prepareStatement("delete from vehicle");
		stmt.executeUpdate();

    		for(int iterator = 1; iterator <= slotSize; iterator++) {
        		stmt = con.prepareStatement("insert into transaction values(?,?,?,?,?)");
        		stmt.setInt(1, iterator);
        		stmt.setInt(2,121);
        		stmt.setString(3, "empty");
        		stmt.setString(4, null);
        		stmt.setTimestamp(5, null);
        		stmt.executeUpdate();
    		}
    	con.close();
    }
}

