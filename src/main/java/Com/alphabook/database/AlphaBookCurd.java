package Com.alphabook.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlphaBookCurd {
	
	public void insertData(AlphaBookUser alphaBookUser) {
		
		Connection connection = ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into alphabookdatabase value(?,?,?,?,?,?,?)");
			preparedStatement.setString(1,alphaBookUser.getFirstName());
			preparedStatement.setString(2,alphaBookUser.getLastName());
			preparedStatement.setLong(3, alphaBookUser.getContactNumber());
			preparedStatement.setString(4, alphaBookUser.getGender());
			preparedStatement.setDate(5, alphaBookUser.getDate_of_birth());
			preparedStatement.setString(6,alphaBookUser.getUserName());
			preparedStatement.setString(7, alphaBookUser.getPassword());
			
			preparedStatement.executeUpdate();
			
			connection.close();
			System.out.println("dated inserted Suessfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteData(String userName) {
		Connection connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from alphabookdatabase where email=?");
			preparedStatement.setString(1,userName);
			
			preparedStatement.executeUpdate();
			
			
			System.out.println("Sucessfully deleted");
			
			connection.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void getData() {
		Connection connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from alphabookdatabase");
			
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getString(1));
				System.out.println(result.getString(2));
				System.out.println(result.getLong(3));
				System.out.println(result.getString(4));
				System.out.println(result.getDate(5));
				System.out.println(result.getString(6));
				System.out.println(result.getString(7));
				System.out.println("------------------");
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
}
	public void getDataByUserName(String userName) {
		Connection connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from alphabookdatabase where email=?");
			preparedStatement.setString(1, userName);
			
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getString(1));
				System.out.println(result.getString(2));
				System.out.println(result.getLong(3));
				System.out.println(result.getString(4));
				System.out.println(result.getDate(5));
				System.out.println(result.getString(6));
				System.out.println(result.getString(7));
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public void   Updatedatabase( String userName,String password) {
			Connection connection = ConnectionObject.getConnection();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("update alphabookdatabase set password=? where email=?");
				preparedStatement.setString(2, userName);
				preparedStatement.setString(1, password);
				
				 preparedStatement.executeUpdate();
				
				connection.close();
				System.out.println("update sucessfully");
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
}
		public boolean login(String userName ,String password) {
			
			Connection connection = ConnectionObject.getConnection();
			int count=3;
			boolean flag = true;
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("select * from alphabookdatabase  where email=?");
		    	preparedStatement.setString(1, userName);
		    	
		    	ResultSet result= preparedStatement.executeQuery();
		    	String pass="";
		    	String user="";
		    	
		    	while(result.next()) {
		    		result.getString(1);
		    		result.getString(2);
		    		result.getLong(3);
		    		result.getString(4);
		    		result.getDate(5);
		    		user=result.getString(6);
		    	 pass =	result.getString(7);
		    		
		    	}
		    	if(userName.equals(user)) {
		    		if(pass.equals(password)) {
		    		System.out.println("LOGIN SUCESSFULL");
		    		System.out.println("--------------------");
		    		return true;
		    		}
		    		else {
		    			System.out.println("INVALID PASSWORD ");
		    			
		    		}
		    		
		    	}
		    	else {
		    		System.out.println("****INVAILD USERNAME *****");
		    		System.out.println("PLEASE ENTER VALID USER ID");
		    	}
		       
		    	
		    	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
}
