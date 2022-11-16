package main;
import java.sql.*;
import java.util.ArrayList;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		DBConnect myDBConnection = new DBConnect();

		//myDBConnection.testConnection();
		myDBConnection.retrieveData();

		ArrayList<String> woorden = myDBConnection.retrieveData();

		for(int i=0;i<woorden.size();i++)
		{
			System.out.println(woorden.get(i));
		}

	}
}
