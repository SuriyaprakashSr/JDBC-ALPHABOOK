package Com.alphabook.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionObject {
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alpabook","root","root");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}

}
