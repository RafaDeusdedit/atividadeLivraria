package servlets;

import java.sql.Connection;

public class livrariaDao {
	private Connection connection;
	
	public livrariaDao () {
		this.connection = new ConnectionFactory().getconnection();	}
	
}
