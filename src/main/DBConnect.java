package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String msAccDB;
	
	public DBConnect() {
		msAccDB = "jdbc:ucanaccess://src/main/resources/Woorden.accdb";	
	}
	
	public void createConnection()
	{
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); // Loading driver
		}
		catch(ClassNotFoundException cnfex) {
			System.out.println("Problem in JDBC driver");
			cnfex.printStackTrace();
		}

		try{
		connection = DriverManager.getConnection(msAccDB);//Establishing Connection
		System.out.println("Connected Successfully");
		}catch(Exception e){
			System.out.println("Error in connection");
		}
	}
	
	
}
