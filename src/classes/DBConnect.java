package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnect {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String msAccDB;
	String sqlQuery;

	public DBConnect() {
		msAccDB = "jdbc:ucanaccess://src/resources/Woorden.accdb";	
		sqlQuery="select Woord from Woorden";
	}

	public void testConnection()
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

	public ArrayList<String> retrieveData()
	{
		ArrayList<String> woorden = new ArrayList<>();
		try{
			connection = DriverManager.getConnection(msAccDB);//Establishing Connection
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);

			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				woorden.add(resultSet.getString("Woord"));
			}
		}catch(Exception e){
			System.out.println("Error in connection");
		}
		return(woorden);
	}
}
