package database;

import java.sql.*;

public class ConnectToMySqlDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String connectionUrl = "jdbc:mysql://localhost:8889/job_advertisements";
		String username = "root";
		String password = "root";
		
		try {
			// 1. GET databse conenction
			Connection myConn = DriverManager.getConnection(connectionUrl, username, password);
			
			// 2. Create statement
			Statement stmt = myConn.createStatement();
			
			// 3. Execute SQL query
			String sql = "SELECT * FROM ADVERTISEMENTS";
			ResultSet result = stmt.executeQuery(sql);
			
			// 4. Process the result set
			while(result.next()) {
			    String title = result.getString("TITLE");
			    System.out.println(String.format(title));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
