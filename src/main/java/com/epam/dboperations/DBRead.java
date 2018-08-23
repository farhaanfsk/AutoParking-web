package com.epam.dboperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.epam.dbconnection.DBConnection;

public class DBRead {
    public HashMap<Integer, String> read() throws ClassNotFoundException, SQLException {
    	HashMap<Integer, String> map = new HashMap<Integer, String>();
    	Connection con = DBConnection.Connect();
    	PreparedStatement stmt;
    	if (con!=null) {
    		stmt = con.prepareStatement("select slotNo,vehicleNo from transaction");
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			System.out.println(rs.getInt(1)+"---"+rs.getString(2));
    			if(rs.getString(2)==null) {
    				map.put(rs.getInt(1),"empty");
    			}else {
    				map.put(rs.getInt(1),rs.getString(2));
    			}
    		}
    	}
    	con.close();
    	return map;
    }
}
