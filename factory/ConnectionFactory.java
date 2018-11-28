package br.com.unicap.poo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
    	try {
    		Connection c = DriverManager.getConnection("jdbc:sqlite:JTP.db");
    		return c;
    	} catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
    }
}