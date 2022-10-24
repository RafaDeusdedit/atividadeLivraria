package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	public Connection getconnection() {
	        
	try {
		DriverManager.getConnection("jdbc:mysql://localhost/bdlivraria?useTimezone=true&serverTimezone=UTC", "root", "142536Ra."); 
	}catch (SQLException e) {
		throw new RunTimeException();
	}
}}
