package br.com.unicap.poo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static Connection conn;

    static Connection createConnection() {
    	try {
    		conn = DriverManager.getConnection("jdbc:sqlite:JTP.db");
    		return conn;
    	} 
    	catch (Exception e) {
        	System.out.println(e);
        	return null;
        }
    }
    
    public static Connection getConnection() {
    	return conn;
    }
    
    public static void closeConnection() {
        try {
            conn.close();
        } 
        catch (Exception e) {
        	System.out.println(e);
        }
    }
}