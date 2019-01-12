package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DataBase {

	public Connection getConnection() {
		
		String connectionUrl = "jdbc:mysql://localhost:8889/job_advertisements";
		String username = "root";
		String password = "root";
		
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager
			.getConnection(connectionUrl, username, password);
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return connection;
		}

		System.out.println("Connection to database established.");
		return connection;
	}
}
